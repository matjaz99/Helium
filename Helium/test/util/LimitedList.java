package si.matjazcerkvenik.htmllib.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Special implementation of <code>ArrayList</code>, where number of elements is 
 * always constant. <code>LimitedList</code> is created with fixed number of 
 * elements. At the beginning all elements are set to <code>null</code>. Elements 
 * can be added or removed from the <code>LimitedList</code>, but size remains the 
 * same all the time. Removed elements are replaced with <code>null</code>. This 
 * prevents other elements to be shifted back and forth. The index of 
 * each element remains unchanged.
 * 
 * @author Matjaz Cerkvenik
 *
 * @param <E>
 */
public class LimitedList<E> {
		
	private List<E> list = null;
	
	private int maxSize = 0;
	private int pointer = 0;
	
	/**
	 * Create <code>LimitedList</code> with maximum number of elements.<br>
	 * If value is negative or zero, the size is set to 3 by default.
	 * @param size
	 */
	public LimitedList(int size) {
		if (size < 1) {
			size = 3;
		}
		maxSize = size;
		list = new ArrayList<E>();
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
	}
	
	/**
	 * Add new element to the list, starting from index 0. Once all 
	 * elements are added to the List, it is not possible to add any 
	 * new element. Instead <code>put()</code> method must be used 
	 * to replace existing element with new one. If element is not 
	 * inserted, -1 is returned.
	 * @param e
	 * @return index of inserted element
	 */
	public int add(E e) {
		if (pointer >= maxSize) {
			return -1;
		}
		list.set(pointer, e);
		return pointer++;
	}
	
	/**
	 * Put element at i-th position. If index is negative or greater than 
	 * the maximum allowed size of list, element is not inserted and 
	 * <code>false</code> is returned.
	 * @param index
	 * @param e
	 * @return true if element is successfully set
	 */
	public boolean put(int index, E e) {
		if (index > list.size() || index < 0) {
			return false;
		}
		list.set(index, e);
		return true;
	}
	
	/**
	 * Get element at i-th position. If index is negative or greater 
	 * than the maximum allowed size of list, <code>null</code> is returned.
	 * @param index
	 * @return element at i-th position
	 */
	public E get(int index) {
		if (index > list.size() - 1 || index < 0) {
			return null;
		}
		return list.get(index);
	}
	
	/**
	 * Remove and return element at i-th position. If index is negative 
	 * or greater than the maximum allowed size of list, <code>null</code> 
	 * is returned. Removed element is replaced with <code>null</code> value.
	 * @param index
	 * @return removed element at i-th position
	 */
	public E remove(int index) {
		if (index > list.size() || index < 0) {
			return null;
		}
		E e = list.get(index);
		put(index, null);
		return e;
	}
	
	/**
	 * Reset all elements in the list to <code>null</code>.<br>
	 * <code>add()</code> method can be called again to fill the list.
	 */
	public void clear() {
		for (int i = 0; i < list.size(); i++) {
			put(i, null);
		}
		pointer = 0;
	}
	
	/**
	 * Get size of the list.
	 * @return size
	 */
	public int size() {
		return list.size();
	}
	
}
