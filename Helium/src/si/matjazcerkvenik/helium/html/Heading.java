package si.matjazcerkvenik.helium.html;

import si.matjazcerkvenik.helium.HtmlElement;

/**
 * HTML heading element <code>&lt;h1&gt;&lt;/h1&gt;</code>. The level 
 * of heading element is configurable in range from 1 to 6. Default is 
 * 1. If level is set out of range (1-6), level 1 will be used.
 * 
 * @author Matjaz Cerkvenik
 *
 */
public class Heading extends HtmlElement {
	
	private int level = 1;
	
	/**
	 * Construct empty <code>&lt;h*&gt;&lt;/h*&gt;</code> element where 
	 * * is value in range from 1 to 6.
	 */
	public Heading(int level) {
		setLevel(level);
	}
	
	/**
	 * Construct <code>&lt;h*&gt;text&lt;/h*&gt;</code> element with some text 
	 * inside and where * is value in range from 1 to 6.
	 */
	public Heading(int level, String text) {
		setLevel(level);
		addElement(new StringElement(text));
	}
	
	@Override
	public String getName() {
		return "h" + level;
	}

	/**
	 * Get level of Heading element in range 1-6.
	 * @return level
	 */
	public int getLevel() {
		return level;
	}

	/** 
	 * Set heading level in range from 1-6.<br>
	 * Level 1 will be used if value is out of range.
	 * @param level
	 */
	public void setLevel(int level) {
		if (level < 1 || level > 6) {
			return;
		}
		this.level = level;
	}
	
}
