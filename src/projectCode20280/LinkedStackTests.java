/*
 * Program written by Surabhi Agarwal, 17203535
 * To test the implemented LinkedStack
 */

public class LinkedStackTests {

	public static void main(String[] args) {
    testEmptyStack();
	testPushStack();
	testPopStack();
	testPopEmptyStack();
	testTopEmptyStack();
    testQueuetoString();
    
	}
	/*
	 * Tests if stack is empty.
	 */
	
	public static void testEmptyStack() {
		Stack<String> stack = new LinkedStack<String>();
		
		try {
			if(!stack.isEmpty()) {
				System.out.println(" testEmptyStack(): FAILURE");
				System.out.println("Expected stack to be empty");
			} else {
				System.out.println("testEmptyStack(): SUCCESS");
			}
		} catch (RuntimeException e) {
	        System.out.println("testEmptyStack(): MAJOR FAILURE");
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Tests if calling the push method on the stack pushes an element into the linked stack.
	 */
	
	public static void testPushStack() {
		Stack<String> stack = new LinkedStack<String>();
		
	    stack.push("A");
	
		    try {
		        if (!stack.pop().equals("A")) {
		            System.out.println("testPushStack(): FAILURE");
		            System.out.println("Expected A to be on front of the stack");
		        } else {
		            System.out.println("testPushStack(): SUCCESS");
		        }
		    } catch (RuntimeException e) {
		        System.out.println("testPushStack(): MAJOR FAILURE");
		        e.printStackTrace();
		    }
	}
	

	/*
	 * Tests if stack is able to pop element from a non empty stack.
	 */
	
	 public static void testPopStack() {
		 Stack<String> stack = new LinkedStack<String>(); 

	        try {
	            String element = "A";
	            stack.push(element);
	            if (element.equals(stack.pop())) {
	                System.out.println("testPopStack(): SUCCESS");
	            } else {
	                System.out.println("testPopStack(): FAILURE");
	                System.out.println("Expected A to be popped from the stack");
	            }
	        } catch (RuntimeException e) {
	            System.out.println("testPopStack(): MAJOR FAILURE");
	            e.printStackTrace();
	        }
	    }

	
	/*
	 * Tests if stack is able to pop element from an empty stack or not.
	 */
	
    public static void testPopEmptyStack() {
    	Stack<String> stack = new LinkedStack<String>();
    	
	        try {
	            stack.pop();
	            System.out.println("testPopEmptyStack(): FAILURE");
	            System.out.println("Expected Exception was not thrown when stack.pop() is called on an empty stack");
	        } catch (StackEmptyException e) {
	            System.out.println("testPopEmptyStack(): SUCCESS");
	        }
    }

    /*
	 * Tests if stack is able to return the top element from an empty stack or not.
	 */
    
    public static void testTopEmptyStack() {
    	Stack<String> stack = new LinkedStack<String>();
    	
	        try {
	            stack.peek();
	            System.out.println("testTopEmptyStack(): FAILURE");
	            System.out.println("Expected Exception was not thrown when stack.top() is called on an empty stack");
	        } catch (StackEmptyException e) {
	            System.out.println("testTopEmptyStack(): SUCCESS");
	        }
    }

    /*
	 * Tests toString method to print the contents of the stack
	 */
    
	
	public static void testQueuetoString() {
		
		Stack<String> stack = new LinkedStack<String>();
		  stack.push("A");
		  stack.push("B");
		  stack.push("C");
		  stack.push("D");
		  
		  System.out.println("Stack after pushing: \n " + stack.toString());
		  
		  System.out.println("Stack size : " + stack.size());
		  
		  stack.pop();
		  
		  System.out.println("Stack after popping element: \n" + stack.toString());
		  
		  stack.size();
		  
		  System.out.println("Stack size : " + stack.size());	  
		 
		
	}



}



