/**
 * A thread-safe blocking queue of Objects.
 * This was written and used before Java introduced generics.
 * The java.util.concurrent package makes this class obsolete.
 *
 * @version 1.0
 * @author  Peter Cappello
 */

package edu.ucsb.cs.jicos.utilities;

import edu.ucsb.cs.jicos.foundation.*;
import java.util.LinkedList;

public final class Qu extends LinkedList implements Q
{
    /** Add an object to the queue.
     * @param object The object to be added to the queue.
     * @return true (as per the general contract of Collection.add).
     * @throws IllegalArgumentException, if argument is null.
     */
    @Override
    public synchronized boolean add( Object object ) 
    {
        super.add( object );
        if ( object == null )
        {
            throw new IllegalArgumentException();
        }
        
        // Was the queue empty immediately prior to this add?
        if ( size() == 1 )
        {
            notify(); 
        }
        return true;
    }
    
    /** Get the object at the head of the queue.
     * @return the object at the head of the queue.
     */    
    public synchronized Object get() { return getFirst(); }
    
    /** Remove an object according to the FIFO discipline.
     * @return the removed object.
     */
    @Override
    public synchronized Object remove()
    { 
        while ( isEmpty() )
        {                                 
            try 
            {
                wait(); 
            } 
            catch ( InterruptedException ignore ){}                     
        }
        assert ! isEmpty();
        return removeFirst();
    }
    
    /** Is the queue empty?
     * @return true if and only if the queue is empty.
     */    
    @Override
    public synchronized boolean isEmpty() { return super.isEmpty(); }
    
    /** Returns a String representation of the object.
     * @return a String representation of the object.
     */    
    @Override
    public String toString() { return getClass() + ": " + super.toString(); }
}
