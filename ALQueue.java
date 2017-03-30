// Maggie Xia
// APCS2 pd1
// HW27--...Nor Do Aussies
// 2017-03-29

/*****************************************************
 * class ALQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.NoSuchElementException;
import java.lang.RuntimeException;
import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

    private ArrayList<T> queue = new ArrayList<T>();
    T _front;
    T _end;

    // default constructor creates an empty queue
    public ALQueue()
    { 
	_front = queue.get(0);
	_end = queue.get( queue.size() - 1 );	
    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
	queue.add( enQVal );
    }//O(?)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    {
	//error
	if ( queue.size() == 0 ) {//nothing to remove
	    System.out.println( "Error! Nothing to remove!" );
	    return null;
	}

	T ret = _front;//set thing to return
	ArrayList<T> copy = new ArrayList<T>( queue.size() - 1);
	for ( int i = 1; i < copy.size(); i++ ) {//copy the ArrayList excluding removed thing
	    copy.set( i - 1, queue.get(i) );
	}
	queue = copy;//update queue
	return ret;
    
    /*
      if ( _counter == 1 ) {//only one thing to remove
      T retQ = _front.getValue();//set thing to return
      _front = null;
      _end = null;
      _counter -= 1;//update number of things in the collection
      return retQ;
      }
      else if ( _counter == 0 ) {//nothing to remove
      System.out.println( "Error! Nothing to remove!" );
      return null;
      }
      else {//non-empty queue
      T retQ = _front.getValue();//set thing to return
      _front = _front.getNext();//move _front pointer to next thing
      _counter -= 1;//update number of things in the collection
      return retQ;
      }
    */
    
    }//O(?)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
	//error
	if ( queue.size() <= 1 ) {//nothing "next in queue"
	    System.out.println( "Peek-a-boo! Nothing to see :(" );//error message
	    return null;
	}
	
	T ret = queue.get(1);//next thing is at index 1
	return ret;
    
    /*
      if ( _counter <= 1 ) {//nothing "next in queue"
      System.out.println( "Peek-a-boo! Nothing to see :(" );//error message
      return null;
      }
      else {//something "next in queue"
      T retQ = _front.getNext().getValue();//set return value
      return retQ;
      }
    */
    }//O(?)


    public boolean isEmpty() 
    {
	return queue.size() == 0;//this is self explanatory
    }//O(?)


    // print each node, separated by spaces
    public String toString() 
    {
	String ret = "";
	for ( int i = 0; i < queue.size(); i++ ) {//traverse
	    ret += " ";
	    ret += queue.get(i);//add to String
	}
	return ret;
   	
	/*
	  String retStr = "";
	  ArrayList() pointer = _front;//pointer to first thing
	  for ( int i = 0; i < _counter; i++ ) {
	  retStr += " ";
	  retStr += pointer.getValue();//add thing to String
	  pointer = pointer.getNext();//move pointer to next thing
	  }
	  return retStr;    
	*/
    }//O(?)



    public static void main( String[] args ) {
	
	Queue<String> ALQueuelJ = new ALQueue<String>();
	System.out.println("\nnow enqueuing thrice..."); 
	ALQueuelJ.enqueue("James");
	ALQueuelJ.enqueue("Todd");
	ALQueuelJ.enqueue("Smith");
	System.out.println("\nnow testing toString()..."); 
	System.out.println( ALQueuelJ ); //for testing toString()...
	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( ALQueuelJ.dequeue() );
	System.out.println( ALQueuelJ.dequeue() );
	System.out.println( ALQueuelJ.dequeue() );
	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( ALQueuelJ.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class ALQueue
