// Maggie Xia
// APCS2 pd1
// HW28--Now Let’s Consider You Lot at Fake Terry’s
// 2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
    { 
	_front = null;
	_end = null;
	_size = 0;
    }


    public void enqueue( T enQVal ) 
    {
	LLNode q = new LLNode( enQVal, null );//instantiate new node
	if ( _size == 0 ) {//_end and _front both point to null
	    //if there is only one thing in a collection, it is both the front and end
	    _end = q;
	    _front = q;
	    _size += 1;//update number of things in the collection
	}
	else {//non-empty queue
	    _end.setNext( q );
	    _end = _end.getNext();//moves _end pointer to new ending
	    _size += 1;//update number of things in the collection
	}
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
	if ( _size == 1 ) {//only one thing to remove
	    T retQ = _front.getValue();//set thing to return
	    _front = null;
	    _end = null;
	    _size -= 1;//update number of things in the collection
	    return retQ;
	}
	else if ( _size == 0 ) {//nothing to remove
	    System.out.println( "Error! Nothing to remove!" );
	    return null;
	}
	else {//non-empty queue
	    sample();
	    T retQ = _front.getValue();//set thing to return
	    _front = _front.getNext();//move _front pointer to next thing
	    _size -= 1;//update number of things in the collection
	    return retQ;
	}
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * make circular and break circle at a random
     * point--using n 'getNext()'s
     ******************************************/
    public void sample () 
    {
	LLNode s = _end;
	_end.setNext( _front );
	int rand = (int) (Math.random() * _size);
	for ( int i = 0; i < rand; i++ ) {
	    s = s.getNext();
	}
	_end  = s;
	_front = s.getNext();
	_end.setNext( null );	
    }


    public boolean isEmpty() 
    { 
	return _size == 0;//this is self explanatory
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "";
	LLNode pointer = _front;//pointer to first thing
	for ( int i = 0; i < _size; i++ ) {
	    retStr += " ";
	    retStr += pointer.getValue();//add thing to String
	    pointer = pointer.getNext();//move pointer to next thing
	}
	return retStr;  
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
