package si.matjazcerkvenik.helium.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import si.matjazcerkvenik.helium.ServerStart;
import si.matjazcerkvenik.helium.exceptions.NullInputException;
import si.matjazcerkvenik.simplelogger.SimpleLogger;

//RFC1945 and RFC2068
//http://www.w3.org/Protocols/rfc2616/rfc2616.html
public class ConnectionHandler implements Runnable {
	
	private Socket socket = null;
	
	private InputStream in = null;
	private BufferedReader dataIn = null;
	private PrintWriter out = null;
	private BufferedOutputStream dataOut = null;
	
	private SimpleLogger logger = ServerStart.getLogger();
	private Connection conn = null;
	
	public ConnectionHandler(Socket socket) {
		this.socket = socket;
		conn = new Connection();
	}
	
	@Override
	public void run() {
		
		try {
			in = socket.getInputStream();
			dataIn = new BufferedReader(new InputStreamReader(in));
			out = new PrintWriter(socket.getOutputStream());
			dataOut = new BufferedOutputStream(socket.getOutputStream());
			
			String input = this.dataIn.readLine();
			
			if (input == null) {
				throw new NullInputException();
			}
			
			List<String> inputLines = new ArrayList<String>();
			inputLines.add(input);
			while (input.trim().length() > 0) {
				input = this.dataIn.readLine();
				inputLines.add(input);
			}
			
			conn.setInput(inputLines);
			
			App.addToConnectionQueue(conn);
			
			conn.process();
			
			Response r = conn.getResponse();
			
			byte[] buffer = r.getData();
			
			if (buffer != null && buffer.length > 0) {
				// write to socket
				out.println("HTTP/1.0 " + r.getErrorCode() + " "
						+ HttpErrorCodes.getError(r.getErrorCode()));
				out.println("Server: Helium HTTP Server 1.0");
				out.println("Date: " + new Date());
				out.println("Content-type: " + r.getContentType());
				out.println(); // blank line between headers and content
				out.flush();
				dataOut.write(buffer, 0, buffer.length); // write file
				dataOut.flush(); // flush binary output stream buffer
			}
			
			App.updateQueue(conn);
			
			
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (NullInputException e) {
			logger.error("NullInputException: " + e.getMessage());
		} finally {

			if (in != null) close(in);
			if (out != null) {
				close(out);
				close(dataOut);
			}
			close(socket);

			logger.trace("Connection closed.");
		}
		
		
		
	}
	
	public void close(Object stream) {
		if (stream == null)
			return;

		try {
			if (stream instanceof Reader) {
				((Reader) stream).close();
			} else if (stream instanceof Writer) {
				((Writer) stream).close();
			} else if (stream instanceof InputStream) {
				((InputStream) stream).close();
			} else if (stream instanceof OutputStream) {
				((OutputStream) stream).close();
			} else if (stream instanceof Socket) {
				((Socket) stream).close();
			} else {
				logger.warn("Unable to close object: " + stream);
			}
		} catch (Exception e) {
			logger.warn("Error closing stream: " + e);
		}
	}
	
}
