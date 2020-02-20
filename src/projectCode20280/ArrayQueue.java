
/*
 * Program written by Surabhi Agarwal, 17203535
 * To implement an Array based queue using Circular Array in java
 * Implementing Queue ADT methods
 * Implementing Queue Exceptions
 */

public class ArrayQueue<E> implements Queue<E>{
	
	private E[] circularArray; //array used 
	private int size; //size of the queue
	
	private int rear;  //end of the queue
	private int front; //front of the queue
	
	/*
	 * A default constructor call having size 10
	 */
	public ArrayQueue(){
		this(10);
	}
    
	/*
	 * A parameterized constructor 
	 */
	public ArrayQueue(int capacity) {
		circularArray = (E[]) new Object[capacity];
		size = 0;
		front = -1;
		rear = -1;
	}

	/*
	 * 1. Enqueue() :  Method to insert an element in the ArrayQueue
	 */
	@Override
	public void enqueue(E element) {
		
		if(size == circularArray.length) throw new QueueFullException();
		
		else {
			rear = (rear + 1)% circularArray.length;
			circularArray[rear] = element;
			size++;
			
			if(front == -1) {
				front = rear;
			}
		}
		
	}
	
	/*
	 * 2. Dequeue() :  Method to delete an element from the ArrayQueue
	 */

	@Override
	public E dequeue() {
		E toDelete;
		
		if(isEmpty()) throw new QueueEmptyException();
		
		else {
			toDelete = circularArray[front];
			circularArray[front] = null;
			front = (front + 1)% circularArray.length;
			
		}
		
		return toDelete;
		
	}

	/*
	 * 3. Front() : Method to return the first element of the ArrayQueue
	 */
	
	@Override
	public E front() {
		
		if(isEmpty()) throw new QueueEmptyException();
		
		return circularArray[front];
	}
	
	/*
	 * 4. Size() :Method to return the size of the ArrayQueue
	 */

	@Override
	public int size() {
		
		return size;
	}
	
	/*
	 * 5. isEmpty() :Method to return a boolean when Queue is full/empty
	 */

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}
	
	/*
	 * 6. toString() :Method to display the Queue 
	 */
	
	public String toString() {
		StringBuffer newQueue = new StringBuffer();
		newQueue.append(size).append(" / ").append(circularArray.length).append(" :");
		newQueue.append("*** Queue is appended as follows ***: \n");
		for(int i=0; i<size ; i++) {
			
			newQueue.append(" ").append(circularArray[i]);
		}
		
		return newQueue.toString();
	}
	
	
	
}