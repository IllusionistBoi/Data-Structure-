import java.util.Iterator;

/**
 * Program written by Ronit Dahiya, 18204009
 * Implemented Singly Linked list using List ADT and
 * with an iterator too.
 **/
public class SinglyLinkedList<E> implements projectCode20280.List<E> {

	// Private variables
	// Head of the linked list;
	private Node<E> head;
	// Size of the linked list;
	private int size;

	// Constructor
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	// Node Class which represents a node in linked list
	private class Node<K> {
		private K element;
		private Node<K> next;

		// Constructor;
		public Node (K e, Node<K> n) {
			element = e;
			next = n;
		}

		//Accessor Methods
		public K getElement() { return element; }
		public Node<K> getNext() { return next; }

		//Modifier Methods
		public void setNext(Node<K> n) { next = n; }

	}

	/** Method to check if linked list is empty
	 *
	 * @return boolean
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/** Method to return element at index i in linked list.
	 *
	 * @param i - index (starting from index 0).
	 * @return element which is at index i
	 * @throws IndexOutOfBoundsException exception
	 */
	@Override
	public E get(int i) {
		int index = 0;
		Node<E> temp = head;

		if (size == 0){
			throw new ListEmptyException();
		}
		// Check whether index is out of size or not
		if (i < 0 || i > (size - 1)){
			throw new IndexOutOfBoundsException();
		}
		// Traversing to ith node at
		while(index != i) {
			temp = temp.getNext();
			index++;
		}

		return temp.getElement();
	}

	/**
	 * Method to add an element at index i
	 * @param i index
	 * @param e Element to be added
	*/
	@Override
	public void add(int i, E e) {
		int index = 0;
		Node<E> temp = head;
		Node<E> previous = null;
		// Check whether index is out of size or not
		if (i < 0 ||  i > (size - 1)) {
			throw new IndexOutOfBoundsException();
		}
		// Traversing to correct node at index i
		while(index != i) {
			previous = temp;
			temp = temp.getNext();
			index++;
		}
		// Inserting new element at correct position
		// When adding at the head
		if( previous == null ) {
			addFirst(e);
		} else {
			size++;
			Node<E> n = new Node<>(e, temp);
			previous.next = n;
		}
	}

	/**
	 * Method to remove element at index i
	 * @param i index
	 * @return Element being removed
	 */
	@Override
	public E remove(int i) {
		int index = 1;
		Node<E> temp = head;
		Node<E> previous = null;

		if (i < 0 || i > (size - 1)) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		while (index != i) {
			previous = temp;
			temp = temp.getNext();
			index++;
		}

		previous.setNext(temp.getNext());
		return temp.getElement();
	}

	/**
	 * Private class which implements Iterator class and
	 * is used as iterator for singly linked list.
	 */
	private class ListIterator implements Iterator<E> {
		// Private variable
		Node<E> curr;

		// Constructor
		public ListIterator() {
			curr = head;
		}
		// Overridden methods
		public boolean hasNext() {
			return curr.getNext() != null;
		}
		@Override
		public E next() {
			E res = curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	/**
	 * Method which returns iterator for linked list;
	 * @return new Iterator which is used for iterating linked list.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	/**
	 * Method that returns size of linked list
	 * @return int value
	 */
	@Override
	public int size() {
		return size;
	}


	/**
	 * Method which removes first element
	 * @return Removed element
	 * @throws ListEmptyException when linked list is empty
	 */
	@Override
	public E removeFirst() {
		if(size == 0)
			throw new ListEmptyException();
		Node<E> temp = head;
		head = head.getNext();
		size--;
		return temp.getElement();
	}

	/**
	 * Method which removes last element
	 * @return Removed element
	 * @throws ListEmptyException when linked list is empty
	 */
	@Override
	public E removeLast() {
		if(size == 0)
			throw new ListEmptyException();
		Node<E> temp = head;
		Node<E> previous = null;
		while(temp.getNext() != null) {
			previous = temp;
			temp = temp.getNext();
		}

		if(previous != null ) {
			previous.setNext(null);
		} else {
			head = previous;
		}
		size--;
		return temp.getElement();
	}

	/**
	 * Method which adds new element at first position
	 * @param e Element to be added
	 */
	@Override
	public void addFirst(E e) {
		head = new Node<>(e, head);   // Create & Link a New Node
		size++;
	}

	/**
	 * Method which adds new element at last position
	 * @param e Element to be added.
	 */
	@Override
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e, null);
		Node<E> temp = head;

		if(temp == null) {
			head = newNode;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		size++;
	}

	/**
	 * Method which provides string for viewing the linked list.
	 * @return String containing linked list information
	 */
	@Override
	public String toString() {
		Node<E> temp = head;
		StringBuilder resultBuilder = new StringBuilder();
		while(temp != null) {
			resultBuilder.append(temp.getElement()).append(" ");
			temp = temp.getNext();
		}
		String result = resultBuilder.toString();
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<>();
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
