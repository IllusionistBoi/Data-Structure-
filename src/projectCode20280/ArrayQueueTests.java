/*
 * Program written by Surabhi Agarwal, 17203535
 * To test the implemented ArrayQueue
 */
public class ArrayQueueTests {

	public static void main(String[] args) {
	testEmptyQueue();
	testEnqueue();
	testDequeue();
    testDequeueEmptyQueue();
    testFrontEmptyQueue();
    testEnqueueFullQueue();
    testQueuetoString();
    
	}
	/*
	 * Tests if queue is empty
	 */
	
	public static void testEmptyQueue() {
		
		Queue<String> queue = new ArrayQueue<String>();
		
		try {
			if(!queue.isEmpty()) {
				System.out.println("testEmptyQueue(): FAILURE");
				System.out.println("Expected queue to be empty");
			} else {
				System.out.println("testEmptyQueue(): SUCCESS");
			}
		} catch (RuntimeException e) {
	        System.out.println("testEmptyQueue(): MAJOR FAILURE");
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Tests Enqueue method and inserts and element to the queue
	 */
	
	public static void testEnqueue() {
	    Queue<String> queue = new ArrayQueue<String>();
	    queue.enqueue("A");
	
	    try {
	        if (!queue.front().equals("A")) {
	            System.out.println("testEnqueue(): FAILURE");
	            System.out.println("Expected A to be on front of the queue");
	        } else {
	            System.out.println("testEnqueue(): SUCCESS");
	        }
	    } catch (RuntimeException e) {
	        System.out.println("testEnqueue: MAJOR FAILURE");
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Tests Dequeue method and delete the element from the front of the queue
	 */
	
	public static void testDequeue() {
	    Queue<String> queue = new ArrayQueue<String>();
	
	    try {
	        String element = "A";
	        queue.enqueue(element);
	        if (element.equals(queue.dequeue())) {
	            System.out.println("testDequeue: SUCCESS");
	        } else {
	            System.out.println("testDequeue: FAILURE");
	            System.out.println("Expected A to be removed from the queue");
	        }
	    } catch (RuntimeException e) {
	        System.out.println("testDequeue: MAJOR FAILURE");
	        e.printStackTrace();
	    }
	}
	
	
	/*
	 * Tests if queue is able to dequeue an element from an empty queue
	 */
	
	public static void testDequeueEmptyQueue () {
		 Queue<String> queue = new ArrayQueue<String>();
	   try {
	       queue.dequeue();
	       System.out.println("testDequeueEmptyQueue: FAILURE");
	       System.out.println("Expected Exception was not thrown when queue.dequeue() is called on an empty queue");
	   } catch (QueueEmptyException e) {
	       System.out.println("testDequeueEmptyQueue(): SUCCESS");
	   }
	}
	
	/*
	 * Tests if queue is able to return the front element of an empty queue
	 */
	
	public static void testFrontEmptyQueue() {
		 Queue<String> queue = new ArrayQueue<String>();
	   try {
	       queue.front();
	       System.out.println("testFrontEmptyQueue(): FAILURE");
	       System.out.println("Expected Exception was not thrown when queue.front() is called on an empty queue");
	   } catch (QueueEmptyException e) {
	       System.out.println("testFrontEmptyQueue(): SUCCESS");
	   }
	}
	
	
	/*
	 * Tests if queue is able to insert element in a full queue
	 */
	
	public static void testEnqueueFullQueue() {
		Queue<String> queue = new ArrayQueue<String>(2);
	    queue.enqueue("A");
	    queue.enqueue("B");
	    try {
	        queue.enqueue("C");
	        System.out.println("testEnqueueFullQueue(): FAILURE");
	        System.out.println("Expected Exception was not thrown when queue.enqueue() is called on a full queue");
	    } catch (QueueFullException e) {
	        System.out.println("testEnqueueFullQueue(): SUCCESS");
	    }
	}
	
	/*
	 * Tests toString method to print the queue
	 */
	
	public static void testQueuetoString() {
		 Queue<String> queue = new ArrayQueue<String>();
		  queue.enqueue("A");
		  queue.enqueue("B");
		  queue.enqueue("C");
		  queue.enqueue("D");
		  
		  System.out.println("Queue after enqueueing: \n " + queue.toString());
		  
		  System.out.println("Queue size : " + queue.size());	
		  
		  queue.dequeue();
		  
		  System.out.println("Queue after dequeueing: \n" + queue.toString());
		  
		  queue.size();
		  
		  System.out.println("Queue size : " + queue.size());	  
		 
		
	}



}



