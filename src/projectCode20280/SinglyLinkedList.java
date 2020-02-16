package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {

	private Node<E> head;
	private int size;

	//Constructor For Head & Size
	public SinglyLinkedList(Node<E> head, int size) {
		head = head;
		this.size = size;
	}

	private class Node<E> {
		private E element;
		private Node<E> next;

		public Node (E e, Node<E> n) {
			element = e;
			next = n;
		}

		//Accessor Methods
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }

		//Modifier Methods
		public void setNext(Node<E> n) { next = n; }

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int i, E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}	
	

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);   // Create & Link a New Node
		size++;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null); // Node will be the tail
		Node<E> last = head;

		if(last == null) {
			head = newest;
		} else {
			while (last.getNext()!=null) {  // Advance to the last node
				last = last.getNext();
			}
			last.setNext(newest);  // New Node After Existing Tail
		}
		size++;

		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
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
