// Maggie Xia
// APCS2 pd1
// HW26--The English Do Not Wait In Line for Soup or Anything Else; They “Queue Up”
// 2017-03-28

/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    int _counter;

    // default constructor creates an empty queue
    public LLQueue()
    { 
	_front = null;
	_end = null;
	_counter = 0;//for keeping track of the number of things in a collection
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	if ( _counter = 0 ) {//_end and _front both point to null
	    //if there is only one thing in a collection, it is both the front and end
	    _end = enQVal;
	    _front = enQVal;
	    _counter += 1;//update number of things in the collection
	}
	else {//non-empty queue
	    _end.setNext( enQVal );
	    _end = end.getNext();//moves _end pointer to new ending
	    _counter += 1;//update number of things in the collection
	}
    }//O(1) [because there are no loops...?]


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	if ( _counter = 1 ) {//only one thing to remove
	    T retQ = _front.getValue();//set thing to return
	    _front = null;
	    _end = null;
	    _counter -= 1;//update number of things in the collection
	    return retQ;
	}
	else {//non-empty queue
	    T retQ = _front.getValue();//set thing to return
	    _front = _front.getNext();//move _front pointer to next thing
	    _counter -= 1;//update number of things in the collection
	    return retQ;
	}
    
    }//O(1) [because there are no loops...?]


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	if ( _counter <= 1 ) {//nothing "next in queue"
	    System.out.println( "Peek-a-boo! Nothing to see :(" );//error message
	    return null;
	}
	else {//something "next in queue"
	    T retQ = _front.getNext().getValue();//set return value
	    return retQ;
	}
    }//O(1) [because there are no loops...?]


    public boolean isEmpty() 
    {
	return _counter == 0;//this is self explanatory
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    {
	String retStr = "";
	LLNode pointer = _front;//pointer to first thing
	for ( int i = 0; i < _counter; i++ ) {
	    retStr += " ";
	    retStr += pointer.getValue;//add thing to String
	    pointer = pointer.getNext();//move pointer to next thing
	}
	return retStr;    
    }//O(n)



    public static void main( String[] args ) {
	
	  Queue<String> LLQueuelJ = new LLQueue<String>();
	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");
	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...
	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
