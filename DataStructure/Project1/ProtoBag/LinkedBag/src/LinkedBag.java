public class LinkedBag<T> implements BagInterface<T>
{
    private Node _head;
    private  int _numOfNodes;

    public LinkedBag()
    {
        _head = null;
        _numOfNodes = 0;
    }

    @Override
    public void printList()
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
    public int getCurrentSize()
    {
        Node wkRfnc = _head;
        int counter = 0;
        while(wkRfnc != null){
            counter++;
            wkRfnc = wkRfnc.get_next();
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {return ~_numOfNodes == 0 ;}

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
    public T remove()
    {
        T dltItem = null;
        if(_head != null){
            Node wkPtr = _head; // Set walker
            dltItem = _head._data; // Store the deleted item to return
            wkPtr = wkPtr.get_next(); // walker references to the next node
            _head = wkPtr; // _head updates the walkder address, the second node becomes the first node.
            _numOfNodes--; //update the number of items
        }
        return dltItem;
    }

    @Override
    public boolean remove(T target)
    {
        boolean result = false;

        /*
        //My version
        Node tgtNode = search(target);
        Node wkPtr = _head; // Set front walker to check target node
        if(tgtNode == null) {return false;}

        //Target is the first node
        if(tgtNode == wkPtr) {
            remove();
            result = true;
        }else {
            //Target is somewhere in the linked list
            //This loop is looking for a node before the target node
            while(wkPtr.get_next() != tgtNode){
                wkPtr = wkPtr.get_next();
            }
            wkPtr.set_next(tgtNode.get_next()); // The walker connects to the one after the target node, skip the target node
            tgtNode.set_next(null); // Deleted node sets null, which doesn't reference anything before it is deleted
            _numOfNodes--;
            result = true;
        }
        */



        //Text version
        Node tgtNode = search(target);
        if (tgtNode != null)
        {
            //Replace first node item in the target node
            tgtNode.set_data(_head.get_data());
            //Remove first node, target item is deleted anyway
            //Item order doesn't matter
            Node dltNode = _head;
            _head = _head.get_next();
            dltNode.set_next(null); // The deleted note separated from the inked list before it is deleted
            result = true;
        }

        return result;
    }

    @Override
    public void clear()
    {
        Node wkPtr = _head;
        while(wkPtr != null)
        {
            remove();
            wkPtr = wkPtr.get_next();
        }
        _numOfNodes = 0;

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry)
    {

        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public String toString() {
        System.out.print("\ntoString: {");
        printList();
        return ", _numOfNodes= " + _numOfNodes + '}';
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
        public void set_data(T _data) { this._data = _data;}
        public Node get_next() { return _next; }
        public void set_next(Node nextNode) {_next = nextNode; }

        @Override
        public String toString() {
            return "Node{" + "_data=" + _data + ", _next=" + _next + '}';
        }
    }
}
