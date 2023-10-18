/**
 File Name: BagListInterface.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The bagInterface is an abstraction of  the array bag and linked list bag data collection.
 Last update: 03/03/2023
 */


import java.util.ArrayList;

public interface BagListInterface<T> {



    /**gets the current number of items in the bag object.
     @return integer, the number of elementsin the bag*/
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
     @param newItem, removed item in the bag
     @return boolean, return true when the item was removed successfully.*/
    public boolean remove(T newItem);


    /**Remove all the items in the bag*/
    public void clear();


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




}// end BagInterface
