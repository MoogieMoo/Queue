/*****************************************************
 * interface Deque
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/


public interface Deque<Quasar> {

    public void addFirst( Quasar x );
    public void offerFirst( Quasar x );
    public void addLast( Quasar x );
    public boolean offerLast( Quasar x );
    public Quasar removeFirst();	
    public Quasar pollFirst();
    public Quasar removeLast();
    public Quasar pollLast();	
    public Quasar getFirst();
    public Quasar peekFirst();	
    public Quasar getLast();	
    public Quasar peekLast();


}//end interface Deque                                                                                           
