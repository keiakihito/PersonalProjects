import java.util.Arrays;

/**
 A class of bags whose imtes are stored in a fixed size array.
 */

public class ArrayBag <T> implements BagInterface<T>
{
    private final T[] _bag;
    private static final int DEFAULT_CAPACITY =25;
    private int _numOfItems;

    private int _capacity;

    //Default CTR
    public ArrayBag(){this(DEFAULT_CAPACITY);}

    public ArrayBag(int capacity)
    {
        @SuppressWarnings("unchecked")
        T[] tembBag = (T[]) new Object[capacity];
        _bag = tembBag; //_bag references to Object array
        _capacity = capacity; // Set maximum capacity
        _numOfItems = 0; // Initialize
    }

    @Override
    public int getCurrentSize() {
        return _numOfItems;
    }

    @Override
    public boolean isEmpty() {
        assert _numOfItems >= 0 : "Number of Items never become negative";
        return _numOfItems == 0;
    }

    @Override
    public boolean isFull(){
        assert _numOfItems <= _capacity : "Number of Items never exceeds capacity";
        return _numOfItems == _capacity;
    }

    @Override
    public boolean add(T newEntry)
    {
        if(isFull()){ return false;}
        _bag[_numOfItems] = newEntry ; // Add the new item in the last index
        _numOfItems++; // Update the number of items in the bag
        return true;
    }

    @Override
    public T remove()
    {
        int lastIdx = _numOfItems - 1; //Avoiding bug
        T temp = _bag[lastIdx]; // Store last item to display which item was deleted
        _bag[lastIdx] = null; // Erase the last item in the bag
        _numOfItems--; // Updated the number of elements
        return temp;
    }

    @Override
    public boolean remove(T anEntry)
    {
        boolean result = false;
        int lstIdx = _numOfItems - 1;

        for (int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(anEntry)){
                //Swap the last item and target item
                //Reduce costs moving all the elements next index after erasing the item
                _bag[i] = _bag[lstIdx];
                _bag[lstIdx] = null;
                _numOfItems--; // Update the number of items
                result = true;
                break; // Exist loop to erase only one item
            }
        }

        return result;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < _numOfItems; i++){
            _bag[i] = null;
        }
        _numOfItems=0; // Initialize after clear method
    }

    @Override
    public int getFrequencyOf(T anEntry)
    {
        int numOfFreq = 0;
        for (int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(anEntry)){
                numOfFreq++;
            }
        }
        return numOfFreq;
    }

    @Override
    public boolean contains(T anEntry)
    {
        boolean result = false;
        //Once the loop find the item, it gets out the loop
        for(int i = 0; i < _numOfItems; i++){
            if(_bag[i].equals(anEntry)){
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] copyArrayBag = (T[]) new Object[_numOfItems];
        for (int i = 0; i < _numOfItems; i++){
            copyArrayBag[i] = _bag[i];
        }

//        for (T s: copyArrayBag){
//            System.out.println(s);
//        }
        return copyArrayBag;
    }

    @Override
    public String toString() {
        return "ArrayBag{" +
                "_bag=" + Arrays.toString(_bag) +
                ", _numOfItems=" + _numOfItems +
                '}';
    }
}
