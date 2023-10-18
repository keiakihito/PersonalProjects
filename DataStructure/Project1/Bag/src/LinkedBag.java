import java.util.ArrayList;

public class LinkedBag<T> implements BagInterface<T>{
    private Node _head;
    private  int _numOfNodes;


    public LinkedBag() {
        _head = null;
        _numOfNodes = 0;
    }

    //Copy Constructor with Array List
    public  LinkedBag(ArrayList<T> arrBag)
    {
        //Create the first node from array first index item
        //Link _head and  the first node
        Node fNode = new Node(arrBag.get(0));
        _head = fNode;
        Node wkPtr = _head;

        //The loop traverses parameter array
        //Create new node with array element
        //The walker connects each node until the end of array.
        int arrIdx = 1;
        while(arrIdx < arrBag.size()){
            Node nodeObg = new Node(arrBag.get(arrIdx));
            wkPtr.set_next(nodeObg);
            wkPtr = wkPtr.get_next();
            arrIdx++;
        }

        _numOfNodes = arrBag.size();
    }

    @Override
    public int getCurrentSize()
    {
        Node wkRfnc = _head; //Set walker
        int counter = 0; // The result of counting of elements

        while(wkRfnc != null){
            counter++;
            wkRfnc = wkRfnc.get_next();
        }

        return counter; // number of nodes in the linked list
    }

    @Override
    public boolean isEmpty() { return _numOfNodes == 0; }

    @Override
    public boolean add(T newEntry)
    {
        Node tempHead = _head; // Backup the _head address avoid losing all the nodes
        Node newNode = new Node (newEntry);
        newNode.set_next(tempHead); //Link the new head to the old first  node
        _head = newNode; // _head points to the new first node
        _numOfNodes++;
        return true;
    }

    @Override
    //Never use this method for the linkedLIst
    public T getItem(int index)
    {
        T temp = null;
        return temp;
    }
    @Override
    public T remove()
    {
        T dltItem = null;

        //The linked list has some node delete the first node
        if(_head != null){
            Node wkPtr = _head; // Set walker
            dltItem = _head._data; // Store the deleted item to return
            wkPtr = wkPtr.get_next(); // walker references to the next node
            _head = wkPtr; // _head updates the walkder address, the second node becomes the first node.
            _numOfNodes--; //update the number of items
        }

        //Deleted item to notify it to the user
        return dltItem;
    }

    @Override
    public boolean remove(T target)
    {
        //Text version
        boolean result = false;
        Node tgtNode = search(target); // Check item whether te item exists or not.

        //Replace first node item in the target node, which eliminates the target data
        //Remove first node because the Item order doesn't matter
        if (tgtNode != null)
        {
            tgtNode.set_data(_head.get_data()); // Eliminate the target with replacing
            this.remove(); // remove the first node after replacing
            result = true;
        }

        return result; // Result whether elimination has been done or not.
    }

    @Override
    public void clear()
    {
        _head = null; // Unlink all the nodes with head
        _numOfNodes = 0;
    }

    @Override
    public int getFrequencyOf(T item)
    {
        Node wkPtr = _head; //Set walker
        int counter = 0;

        //The loop traverse linked list and increment count,
        //when it finds the target data in the linked list
        while(wkPtr != null){
            if(wkPtr.get_data().equals(item)){
                counter++;
            }
            wkPtr = wkPtr.get_next();
        }

        return counter; // number of nodes in the linked list
    }

    @Override
    public boolean contains(T item)
    {
        boolean result = false;
        Node wkPtr = _head; //Set walker
        int counter = 0;

        //The loop traverse linked list and increment count,
        //when it finds the target data in the linked list
        while(wkPtr != null){
            if(wkPtr.get_data().equals(item)){
                return true; // Target is found in the linked list and return true
            }
            wkPtr = wkPtr.get_next();
        }

        return result; // whether the item was found or not
    }

    public Node search (T target)
    {
        boolean found = false;
        Node wkPtr = _head; // Set up walker

        //The walker traverse in the linkedBag
        //Once it founds the target item, the walker tells the target item address.
        while(!found && (wkPtr != null)){
            if(target.equals(wkPtr.get_data())){
                found = true;
            }else{
                wkPtr = wkPtr.get_next(); // Shift to the next node.
            }
        }

        return wkPtr; //The walker tells the target item address
    }
    @Override
    public ArrayList<T> toArray()
    {
        ArrayList<T> cpyArry = new ArrayList<>();
        Node wkPtr = _head;

        //Walker traverse each node in the linked list
        //Store data to the created array
        while(wkPtr != null){
            cpyArry.add( wkPtr.get_data());
            wkPtr = wkPtr.get_next();
        }

        return  cpyArry;
    }


    @Override
    public void printBag()
    {
        Node wkRfnc = _head; // Set walker reference to traverse all nodes.
        while(wkRfnc != null){
            System.out.print("[");
            System.out.print(wkRfnc.get_data());
            System.out.print("]->");
            wkRfnc = wkRfnc.get_next();
        }
        System.out.print("[null]");
    }

    @Override
    public String toString(){
        System.out.print("\ntoString: {");
        printBag();
        return ", _numOfNodes= " + _numOfNodes + '}';
    }

    //Insert the new item to the last node
    public void addLast(T newItem)
    {
        Node wkPtr = _head; //Set up walker

        //This case is the node is inserted as a first node
        //Just call add method and exit the method
        if(wkPtr == null){
            this.add(newItem);
            return;
        }

        //Create new node with a parameter, insert after the last node
        Node newLastNode = new Node(newItem);
        wkPtr = this.getLast(); // The walker points to the last node address
        wkPtr.set_next(newLastNode); // The new last node connects the linked list
        _numOfNodes++;

    }

    //Return the fist node address
    public Node getFIrst() { return _head;}

    //Get the last address of node
    public Node getLast()
    {
        if(_head == null) {return null;} //This is the case the linked bag doesn't have any node
        Node wkPtr = _head; // Set walker to traverse the object

        //Walker traverse until it hits the last node
        while(wkPtr.get_next() != null){
            wkPtr= wkPtr.get_next();
        }

        return wkPtr; // Return the last node address
    }



    @Override
    public BagInterface union(BagInterface bagObj)
    {
        //Copy bag object elements to add original bag object elements to this array
        // Set walker  travers original linked bag object
        ArrayList<T> cpyUnonBag = bagObj.toArray();
        Node wkPtr = _head;

        //The loop traverses the original object
        //Add each element  in the original object to the union bag object until walker hits the last node
        while(wkPtr!= null){
            cpyUnonBag.add(wkPtr.get_data());
            wkPtr = wkPtr.get_next();
        }

        // Make a deep copy of the parameter  object to add original Node data later
        // union bag should contain all the original object elements and parameter object elements
        BagInterface<T> unonBag = new LinkedBag<>(cpyUnonBag) ;
        return unonBag;
    }


    @Override
    public BagInterface intersection(BagInterface bagObj)
    {
        //Eliminate elements later to get common elements between  the original object and parameter object
        ArrayList<T> intSecBagArr = new ArrayList<>() ; // To contain result
        ArrayList<T> cpyBag = bagObj.toArray();
        Node wkPtr = _head; //Set walker
        T target = null;

        //The loop traverses the original liked bag object
        //When it finds target, the target is added intersection arraylist
        //The element in the copy bag array will be removed
        while(wkPtr != null){
            target = wkPtr.get_data();
            if (cpyBag.contains(target)){
                intSecBagArr.add(target);
                cpyBag.remove(target);
            }
            wkPtr = wkPtr.get_next();
        }

        //It should contain common elements between original bag object and parameter object with duplication
        // Make a deep copy of original object to manipulate
        BagInterface<T> intSecBag = new LinkedBag<>(intSecBagArr) ; // To contain result
        return intSecBag;
    }



    @Override
    public BagInterface difference(BagInterface bagObj)
    {
        // Make a deep copy of original object to eliminate parameter object's elements with loop later
        ArrayList<T> dffBagArr = this.toArray(); // To contain result
        ArrayList<T> parmObj = bagObj.toArray(); // To contain result
        T target = null;

        //The loop traverses the parameter bag object
        //It reduces the element in copy object  once the walker found the same object
        for (int i = 0; i < bagObj.getCurrentSize(); i++){
            target = parmObj.get(i); // Walker traverse the parameter object
            if(dffBagArr.contains(target)){ //The common element found
                dffBagArr.remove(target); // the copy bag obj eliminates to pick up duplicated ones correctly
            }
        }

        //It should contain elements eliminated parameter bag objects with duplication
        BagInterface<T> dffBag = new LinkedBag<>(dffBagArr) ; // To contain result
        return dffBag;
    }



    //Inner class
    private class Node
    {
        private T _data;
        private  Node _next;

        //Default CTR
        Node()
        {
            _data = null;
            _next = null;
        }

        Node(T _dataItem)
        {
            _data = _dataItem;
            _next = null;
        }

        //Getter and Setter
        public T get_data() { return _data; }
        public void set_data(T item) { this._data = item;}
        public Node get_next() { return _next; }
        public void set_next(Node nextNode) {_next = nextNode; }

        @Override
        public String toString() {
            return "Node{" + "_data=" + _data + ", _next=" + _next + '}';
        }
    } // End of Node class



} // End of LinkedBag class
