
/*
 * Program written by Surabhi Agarwal, 17203535
 * To implement a Linked list implementation of a stack in java
 * Implementing Stack ADT methods
 * Implementing Stack Exceptions
 * Implementing Node class: nested
 */


public class LinkedStack<T> implements Stack<T>  {
    public static class Node<T> { //Nested node class
        private T element;
        private Node<T> next;

        /*
         * Constructor for the Node class
         */
        
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    //Node top of the stack
    private Node<T> top;
    //size of the stack
    private int size;

    /*
     * Default constructor for the linked stack
     */
    public LinkedStack() {
        top = null;
        size = 0;
    }

    /*
     * 1. Push(): Method to push element into the stack
     * 
     */
    public void push(T element) {
        Node<T> node = new Node<T>(element, null);
        if (top == null)
            top = node;
        else {
          
        	node.next = top;
        	top = node;
        }
        size++;
    }

    /*
     * 2. Pop(): Method to pop an element from the stack
     * 
     */
    
    public T pop() {
        if (top == null) throw new StackEmptyException();
        Node<T> temp = top;
        top = top.next;
        temp.next=null;
        size--;
        return temp.element;
    }
    
    /*
     * 3. Peek(): Method to return the top element of the stack
     * 
     */

    public T peek() {
       if (top == null) throw new StackEmptyException();
        return top.element;
    }

    /*
     * 4. isEmpty(): Method to return a boolean if stack is empty
     * 
     */
    
    public boolean isEmpty() {
        return size == 0;
        
    }
    
    /*
     * 5. Size(): Method to return the size of the stack
     * 
     */

    public int size() {
        return size;
    }
    
    /*
     * 6. toString(): Method to print the contents of the stack
     * 
     */
    
    public String toString() {
    	StringBuffer stack = new StringBuffer();
    	Node<T> temp = top; 
       for(int i=0; i< size; i++) {
            stack.append(" ").append(temp.element);
            temp = temp.next;
        }
        return stack.toString();
    }
    	
    	
    
}


