import java.util.ArrayList;

public interface BagInterface<T> {

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


    public T getItem(int index);

    /**Remove one the last index of item in the bag, if the item is in the bag
     @return T item, removed items in the bag*/
    public T remove();


    /** Remove one specified item from this bag,
     @param newItem, removed item in the bag
     @return boolean, return true when the item was removed successfully.*/
    public boolean remove(T newItem);


    /**Remove all the imtes in the bag*/
    public void clear();


    /**
     @param item The items to find.
     @return  integer, the number of times anEntry appears in the bag.*/
    public int getFrequencyOf(T item);


    /**Tests whether this bag contains a given item
     @param item The items to find
     @return boolean, return ture if the bag has given item*/
    public  boolean contains(T item);


    /**Retrieves all items that are in this bag.
     @return A newly allocated array of all the entries in the bag. deep copied array
     NOTE: if the bag is empty, the returned array is empty.*/
    public ArrayList<T> toArray();

    /*Display items in the bag*/
    public void printBag();



    /** Make a deep copy of bag object from the source object
    //@param source bag object as an original object
    @return a  deep copy of parameter bag object
    */
//    public BagInterface copyBag(BagInterface source);
//    public BagInterface copyBag();



    /** Create a new bag object which contains original object items and parameter object items
     @param bagObj an object added to the copy of the original object
     @return new bag object with original and parameter object items
     */
    public BagInterface union(BagInterface bagObj);


    /** Create a new bag object which contains common elements between original object and parameter object
     @param bagObj an object which is compared to the original object
     @return new bag object
     */
    public BagInterface intersection(BagInterface bagObj);


    /** Create a new bag object which is eliminated by parameter's object item
     @param bagObj bag object eliminates original bag object items
     @return new bag object
     */
    public BagInterface difference(BagInterface bagObj);



}// end BagInterface
