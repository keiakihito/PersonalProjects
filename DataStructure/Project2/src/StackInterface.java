/** An interface for the ADT stack.
 File Name: StackInterface.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The StackInterface is an abstraction of  the array stack and linked sack of data collection.
 Last update: 03/17/2023
 */


public interface StackInterface<T> {

    /** Adds a new entry to the top of this stack.
     @param newEntry An object to be added to the stack. */
    public void push(T newEntry);

    /** Removes and returns this stack's top entry.
     @return The object at the top of the stack.
     */
    public T pop();

    /** Retrieves this stack's top entry.
     @return The object at the top of the stack.
     */
    public T getPeek();

    /** Detects whether this stack is empty. @return True if the stack is empty. */
    public boolean isEmpty();

    /** Removes all entries from this stack. */
    public void clear();

} // end StackInterface
