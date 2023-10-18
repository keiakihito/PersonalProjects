#ifndef  LIST_SORTED_H
#define LIST_SORTED_H

using namespace std;

template <class T>
class List
{
public:
    class Iterator{
    public:
        friend class List;//give access to list to access _ptr
        inline Iterator(): _ptr (nullptr){} //default ctor
        inline Iterator(node<T>* p): _ptr(p){}//Point Iterator to where p is pointing to
        inline T &operator*(){return _ptr ->_item;}//dereference operator
        inline T *operator->(){return _ptr ->_next;}//member access operator
        inline bool is_null(){return _ptr == nullptr;}//true if _ptr is NULL
        //true if left != right
        inline friend bool operator !=(const Iterator& left, const Iterator& right){
            //left and right both nullptr case
            if((left._ptr == nullptr)&&(right._ptr == nullptr)) {return false;}
            return &left != &right;
        }
        //true if left == right
        inline friend bool operator ==(const Iterator& left, const Iterator& right){
            //left and right both nullptr case
            if((left._ptr == nullptr)&&(right._ptr == nullptr)) {return true;}
            return &left == &right;
        }
        inline Iterator& operator++(){ return _ptr =  _ptr->_next;}//member operator: ++it; or ++it = new_value
        inline friend Iterator operator++(Iterator& it, int unused){ return it._ptr =  it._ptr->_next;}//friend operator: it++
    private:
        node<T>* _ptr; //pointer being encapsulated
    };

    List(bool order=true, bool unique=false);     //CTOR: default args
    ~List();     //BIG 3:
    List(const List<T> &copyThis);
    List& operator =(const List& RHS);

    Iterator insert(const T& i);     //Insert i
    Iterator insert_and_add(const T& i);    //Insert i
    T Delete(List<T>::Iterator iMarker);     //delete node at marker
    void Print() const;
    Iterator search(const T &key) const;    //return Iterator to node [key]
    Iterator prev(Iterator iMarker);    //previous node: marker
    const T& operator[](int index) const;    //const version of the operator [ ]
    T& operator[](int index);    //return item at index
    Iterator begin() const;    //Iterator to head node
    Iterator end() const;    //Iterator to NULL
    Iterator last_node() const;    //Iterator to last node
    bool empty() const { return _head_ptr == nullptr; }
    template <class U> //Note template arg U
    friend ostream& operator <<(ostream& outs, const List<U>& l);
    int size() const { return _size; }
    void to_string(); //For debug

private:
    node<T>* _head_ptr;
    bool _order;
    bool _unique;
    int _size;
};





//Function body
template <class T>
List<T>::List(bool order, bool unique):_head_ptr(nullptr), _size(0){};     //CTOR: default args

//BIG 3:
template <class T>
List<T>::~List(){
    clear_list(_head_ptr);
}

template <class T>
List<T>::List(const List<T> &copyThis){
    _copy_list(_head_ptr, copyThis._head_ptr);
    _size = _get_size(copyThis._head_ptr);
}

template <class T>
List<T>& List<T>::operator =(const List& RHS){
    if(this== &RHS ){ return *this;} // The same object

    clear_list(_head_ptr); // Initialize existing node.
    _head_ptr = nullptr;
    _copy_list(_head_ptr, RHS._head_ptr); // Copy RHS to the existing node
    _size = _get_size(RHS._head_ptr);

    return *this;
}

//Insert i
template <class T>
typename  List<T>::Iterator List<T>::insert(const T& i){
    _head_ptr = _insert_sorted(_head_ptr, i);
    _size++;
    return _head_ptr;
}

//Insert i

// When the marker from _where_this_goes points to
// a node with the same _item as the item being inserted,
// the item will be added to the existing _item
//EX. Adding 4 to the existing 4 in the list (and getting an 8)
template <class T>
typename List<T>::Iterator List<T>::insert_and_add(const T& i){
    //Linked list is empty and insert item
    if(_head_ptr == nullptr){
        _insert_head(_head_ptr, i);
        return _head_ptr;
    }

    node<int> *wkPtr = _where_this_goes(_head_ptr, i);
    //Check the first node value equals to i.
    if(wkPtr == nullptr) {wkPtr = _head_ptr;}

    //Compare the node value and item i, decides it adds exising node or not.
    if(wkPtr->_item == i){
        wkPtr->_item +=  i; //item will be added to the existing node.
    }else{
        _head_ptr = _insert_sorted(_head_ptr, i);
        _size++;
    }


    return _head_ptr;
}

//delete node at marker
template <class T>
T List<T>::Delete(List<T>::Iterator iMarker){

    //This is the case delete_this is not in the linked list.
    if(iMarker == nullptr){ return T (); }

    T item = delete_node(_head_ptr, iMarker._ptr);
    _size--; //Update _size;
    return item; //Return deleted item
}

template <class T>
void List<T>::Print() const{
    _print_list(_head_ptr);
}

//return Iterator to node [key]
template <class T>
typename  List<T>::Iterator List<T>::search(const T &key) const{
    return  _search_list(_head_ptr, key); //head and the wkPtr points to the first node;
}

//previous node: marker
template <class T>
typename  List<T>::Iterator List<T>::prev(List<T>::Iterator iMarker){
    return _previous_node(_head_ptr, iMarker._ptr);
}

//const version of the operator [ ]
template <class T>
const T& List<T>::operator[](int index) const{
    assert(index < _size && "index should be less than the size");
    return _at(_head_ptr, index);
}

//return item at index
template <class T>
T& List<T>::operator[](int index){
    assert(index < _size && "index should be less than the size");
    return _at(_head_ptr, index);
}


//Iterator to head node
template <class T>
typename  List<T>::Iterator List<T>::begin() const{
    List<T>:: Iterator wkPtr = _head_ptr;
    return wkPtr;
}

//Iterator to NULL
template <class T>
typename List<T>::Iterator List<T>::end() const{
//    return nullIterator;
    node<T>* wkPtr = _head_ptr; // Set walker to traverse
    //Traverse node until nullptr
    while(wkPtr != nullptr){
        wkPtr = wkPtr ->_next;
    }
    List<T>::Iterator endNode = wkPtr;
    return endNode;
}

//Iterator to last node
template <class  T>
typename List<T>::Iterator List<T>::last_node() const{
    node<T>* wkPtr = _head_ptr; // Set walker to traverse
    //Traverse node until last node
    while(wkPtr->_next != nullptr){
        wkPtr = wkPtr ->_next;
    }
    List<T>::Iterator endNode = wkPtr; //Create Iterator obj with walker as a return value
    return endNode;
}

//template <class T>
//bool List<T>::empty() const { return _head_ptr == nullptr; }

template <class U> //Note template arg U
ostream& operator <<(ostream& outs, const List<U>& l){
    node<U>*wkPtr = l._head_ptr;
    while(wkPtr != nullptr){
        outs << "[" << *wkPtr << "] ->";
        wkPtr = wkPtr -> _next;
    }
    outs << "[nullptr]";
    return outs;
}

//int size() const { return _size; }

//For debug
template <class T>
void List<T>::to_string(){
    cout <<"\n~~toString~~" << endl<<"*_head_ptr : " << *_head_ptr << endl
         << "_size : " << _size << endl;
    Print();
}

#endif //LIST_SORTED_H

