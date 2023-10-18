public interface BagInterface<T> {


    /** Print all nodes in the linked Bag
     */
    public void printList();


    /**gets the current number of items in the bag object.
     @return integer, the number of elemens in the bag*/
    public int getCurrentSize();


    /** Check is bag object empty or not
     @ return boolean, return true when it is empty bag*/
    public boolean isEmpty();


    /** Add a new item to this bag
     @param newEntry an item to be added as a new item in the bag object
     @return boolean, return true if the new Entry is added successfully.*/
    public boolean add(T newEntry);


    /**Remove one the last index of item in the bag, if the item is in the bag
     @return T item, removed items in the bag*/
    public T remove();


    /** Remove one specified item from this bag,
     @param anEntry, removed item in the bag
     @return boolean, return true when the item was removed successfully.*/
    public boolean remove(T anEntry);


    /**Remove all the imtes in the bag*/
    public void clear();


    /**
     @param anEntry The items to find.
     @return  integer, the number of times anEntry appears in the bag.*/
    public int getFrequencyOf(T anEntry);


    /**Tests whether this bag contains a given item
     @param anEntry The items to find
     @return boolean, return ture if the bag has given item*/
    public  boolean contains(T anEntry);

    /**Retrieves all items that are in this bag.
     @return A newly allocated array of all the entries in the bag. deep copied array
     NOTE: if the bag is empty, the returned array is empty.*/
    public T[] toArray();

}// end BagInterface
