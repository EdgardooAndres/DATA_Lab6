package linkedLists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLDHDTListIterableL2F<E> extends DLDHDTList<E> 
implements Iterable<E> 
{
	public Iterator<E> iterator() {
		return new LLIteratorF2L<E>(this);
	}

	private static class LLIteratorF2L<E> 
	implements Iterator<E> 
	{ 
		private LinkedList<E> theList;   // the list to iterate over
		// ... other internal fields ...
		private Node<E> current; 
		private boolean hasMoreElements; 

		public LLIteratorF2L(LinkedList<E> list) {
			theList = list; 
			// ... initialize other internal fields ...
			if (theList.length() == 0) { 
				current = null; 
				hasMoreElements = false; 
			}
			else { 
				current = theList.getLastNode(); 
				hasMoreElements = true; 
			}
		}

		public boolean hasNext() {
			// Write the new code and substitute next statement ....
			return hasMoreElements; 
		}

		public E next() throws NoSuchElementException {
			// Write the new code and substitute next statement ...
			if(!hasMoreElements)
				throw new NoSuchElementException("The iterator has finished.");
			E etr = current.getElement();
			try{
				current = theList.getNodeBefore(current);
			}
			catch(NodeOutOfBoundsException e){
				current = null;
				hasMoreElements = false;
			}
			return etr;
		}

		public void remove() throws UnsupportedOperationException 
		{
			throw new UnsupportedOperationException("Remove is not implemented.");

			// If implemented, 
			// needs to verify that the previous operation executed on
			// this iterator object was the next() operation and that
			// it was successful. If this is not accomplished, then the
			// IllegalStateException is raised. Otherwise, the last
			// element that was accessed is removed... 
			// You may need to add other internal fields to keep track
			// if the last operation that was executed on this object
			// was the next operation and that it was successfull...

		}
	}

}
