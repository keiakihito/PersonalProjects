import java.util.ArrayList;
import java.util.Arrays;

public class ResizeableArrayBag<T> implements BagInterface<T>{
    private  T[] _bag;
    private int _numOfItems;
    private int _capacity;
    private static final int DEFAULT_CAPACITY = 5;


    //Default CTR, provide default capacity if the capacity is not provided.
    public ResizeableArrayBag(){this(DEFAULT_CAPACITY);}

    //Copy Constructor by ArrayList
    public ResizeableArrayBag(ArrayList<T> bagArr)
    {
        //bagArr.length equals to number of items in the array
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[(bagArr.size() * 2)];
        _bag = tempBag; //_bag references to Object array

        //The loop transfer elements of parameter to bag array index.
        for (int i = 0; i < bagArr.size(); i++){
            _bag[i] = bagArr.get(i);
        }

        _capacity = (bagArr.size() * 2);
        _numOfItems = bagArr.size();
    }

    public ResizeableArrayBag(int capacity) {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        _bag = tempBag; //_bag references to Object array
        _capacity = capacity; // Set maximum capacity
        _numOfItems = 0; // Initialize
    }

    @Override
    public int getCurrentSize() {return _numOfItems; }

    @Override
    public boolean isEmpty() {
        assert _numOfItems >= 0 : "Number of Items should be positive";
        return _numOfItems == 0;
    }

    /*Check the array is full or not.
    @return boolean
    * */
    public boolean isFull(){
        assert _numOfItems <= _capacity : "Number of Items never exceeds capacity";
        return _numOfItems == _capacity;
    }


    @Override
    public boolean add(T newEntry)
    {
        //Check current array capacity before adding item
        //If it is full make the capacity double, then add item to the array bag object.
        if(isFull())
        {
            doubleCapacity(); // Resize array capacity;
        }

        // Add the new item in the last index try not to make a hole in the array
        //Updating the number of size
        _bag[_numOfItems] = newEntry ;
        _numOfItems++;

        //Notify the new item was inserted successfully.
        return true;
    }

    //Random access to get an item by index
    public T getItem(int index)
    {
        T arrItem = _bag[index]; //Random access to get the item in the index
        return arrItem;
    }

    @Override
    public T remove()
    {
        T temp = null;

        //When the array bag is empty nothing returns
        if(!isEmpty())
        {
            //Set last index to avoid bug, and store last item to display which item was deleted
            int lastIdx = _numOfItems - 1;
            temp = _bag[lastIdx];

            // Erase the last item in the bag, and update the number of elements
            _bag[lastIdx] = null;
            _numOfItems--;
        }

        //Return which item was deleted
        return temp;
    }

    @Override
    public boolean remove(T newItem)
    {
        //Set last index to avoid bug
        boolean result = false;
        int lstIdx = _numOfItems - 1;

        //This loop traverse existing bag object to find target item to be deleted
        //Once it found the target it copies the last item and override the target item
        //Reduce costs moving all the elements next index after erasing the item because the order doesn't matter
        for (int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(newItem)){
                _bag[i] = _bag[lstIdx];
                _bag[lstIdx] = null;
                _numOfItems--;
                result = true;
                break; // Exist loop to erase only one item
            }
        }

        //This case is the target item was not found in the array bag object.
        return result;
    }

    @Override
    public void clear()
    {
        //The loop traverse each index and store null to initialize the bag object.
        for (int i = 0; i < _numOfItems; i++){
            _bag[i] = null;
        }

        // Initialize the number of items after clear method
        _numOfItems=0;
    }

    @Override
    public int getFrequencyOf(T item)
    {
        //Set counter
        int numOfFreq = 0;

        //The loop counting how many target items in the bag array object.
        for (int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(item)){
                numOfFreq++;
            }
        }

        //This should be the number of target items in the array bag object.
        return numOfFreq;
    }

    @Override
    public boolean contains(T item)
    {
        boolean result = false;

        //Once the loop find the item, it gets out the loop
        for(int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(item)){
                result = true;
                break;
            }
        }

        //This case is the target item was not in the array bag object.
        return result;
    }

    //Reallocate array when it is full of index with double capacity
    public void doubleCapacity()
    {
        //Calculate 2 times of current capacity and resize the original array
        //Elements are the same, and it is shallow copy
        //Update capacity size
        int newCapacity = 2 * _capacity;
        _bag = Arrays.copyOf(_bag, newCapacity);
        _capacity = newCapacity;
    }

    @Override
    public ArrayList<T> toArray()
    {
        //It makes a new array with the same elements of original bag array object
        //Deep copy array  transfer elements from the original array bag object.
        @SuppressWarnings("unchecked")
        ArrayList<T> copyArrayBag = new ArrayList<>(this._capacity);
        for (int i = 0; i < _numOfItems; i++){
            copyArrayBag.add(_bag[i]);
        }

        //The array contains the same data elements from the original bag object
        return copyArrayBag;
    }


    @Override
    public void printBag()
    {
        System.out.print("{ ");
        for(int i =0; i < _numOfItems; i++){
            System.out.print(_bag[i] + " ");
        }
        System.out.print("}\n");
    }

    @Override
    public String toString() {
        return "ResizeableArrayBag{" +
                "_bag=" + Arrays.toString(_bag) +
                ", _numOfItems=" + _numOfItems +
                ", _capacity=" + _capacity +
                '}';
    }


    @Override
    public BagInterface union(BagInterface bagObj)
    {
        ArrayList<T> cpyBagObj = this.toArray();

        //The loop traverses  the parameter object
        //Add to the union bag object to all the parameter elements to merge every element
        for (int i = 0; i < bagObj.getCurrentSize(); i++){
            cpyBagObj.add((T)bagObj.getItem(i));
        }

        // Make a deep copy of original object to add parameter object later
        // union bag should contain all the original object elements and parameter object elements
        BagInterface<T> unonBag = new ResizeableArrayBag<>(cpyBagObj) ;
        return unonBag;
    }


    @Override
    public BagInterface intersection(BagInterface bagObj)
    {
        // Make a deep copy of original object to manipulate
        //Eliminate elements later to get common elements between  the original object and parameter object
        ArrayList<T> intSecBagArr = new ArrayList<>() ; // To contain result
        ArrayList<T> cpyBagArr = this.toArray();
        T target =null; //Set walker

        //The loop traverses the parameter bag object
        //It reduces the element in copy object once the walker found  the same object if the parameter
        for (int i = 0; i < bagObj.getCurrentSize(); i++){
            target = (T)bagObj.getItem(i); // Walker traverse the parameter object
            if(cpyBagArr.contains(target)){ //The common element found
                intSecBagArr.add(target); // Add elements to the intersection bag which is we are looking for.
                cpyBagArr.remove(target); // the copy bag obj eliminates to pick up duplicated ones correctly
            }
        }

        //It should contain common elements between original bag object and parameter object
        //with duplication
        ResizeableArrayBag<T> intSecBag = new ResizeableArrayBag<>(intSecBagArr);
        return intSecBag;

    }


    @Override
    public BagInterface difference(BagInterface bagObj)
    {

        ArrayList<T> dffBagArr = this.toArray();
        T target =null; //Set walker

        //The loop traverses the parameter bag object
        //It reduces the element in copy object  once the walker found the same object
        for (int i = 0; i < bagObj.getCurrentSize(); i++){
            target = (T)bagObj.getItem(i); // Walker traverse the parameter object
            if(dffBagArr.contains(target)){ //The common element found
                dffBagArr.remove(target); // the copy bag obj eliminates to pick up duplicated ones correctly
            }
        }

        //It should contain elements eliminated parameter bag objects.
        //With duplication
        // Make a deep copy of original object to eliminate parameter object's elements with loop later
        BagInterface<T> dffBag = new ResizeableArrayBag<>(dffBagArr) ; // To contain result
        return dffBag;
    }



}// End of ResizableArrayBag
