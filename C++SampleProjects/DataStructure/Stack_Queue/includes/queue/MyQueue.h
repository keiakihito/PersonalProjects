#ifndef  MYQUEUE_H
#define MYQUEUE_H

#include "../node/node.h"
#include "../linked_list_functions/linked_list_functions.h"

using namespace std;

template <typename T>
class Queue
{
public:
    class Iterator{
    public:
        friend class Queue; //give access to list to access _ptr
        inline Iterator():_ptr(nullptr){} //default ctor
        inline Iterator(node<T>* p):_ptr(p){} //Point Iterator to where  p is pointing to
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

    Queue();
    Queue(const Queue<T>& copyMe);
    ~Queue();
    Queue& operator=(const Queue<T>& RHS);
    bool empty();
    T front();
    T back();
    void push(T item);
    T pop();
    Iterator begin() const; //Iterator to the head node
    Iterator end() const; //Iterator to NULL
    void print_pointers();
    int size() const { return _size; }
    template<typename TT>
    friend ostream& operator << (ostream& outs, const Queue<TT>& printMe);
    void to_string(); //For debug

private:
    node<T>* _front;
    node<T>* _rear;
    int _size;
};



//Function body
template <typename T>
Queue<T>::Queue():_rear(nullptr), _front(nullptr), _size(0){ }

template <typename T>
Queue<T>::Queue(const Queue<T>& copyMe)
{
    _copy_list(_front, copyMe._front);
    _size = _get_size(copyMe._front);

    //Find the last node address
    node<T> *wkPtr = _front;
    while(wkPtr -> _next != nullptr){
        wkPtr = wkPtr -> _next;
    }
    //Set the new last node address to the _rear
    _rear = wkPtr;
}

template <typename T>
Queue<T>::~Queue()
{
    clear_list(_front);
}

template <typename T>
Queue<T>& Queue<T>::operator=(const Queue<T>& RHS)
{
    if(this== &RHS ){ return *this;} // The same object

    clear_list(_front); // Initialize existing node.
    _front = nullptr;
    _copy_list(_front, RHS._front); // Copy RHS to the existing node
    _size = _get_size(RHS._front);

    //Find the last node address
    node<T> *wkPtr = _front;
    while(wkPtr -> _next != nullptr){
        wkPtr = wkPtr -> _next;
    }
    //Set the new last node address to the _rear
    _rear = wkPtr;

    return *this;
}

template <typename T>
bool Queue<T>::empty()
{
    return ((_front == nullptr) && (_rear == nullptr));
}

template <typename T>
T Queue<T>::front()
{
    //When there is no node, display status and nothing returns.
    if (_front == nullptr) {cout << "Empty Queue "; return T();}

    T item = _front->_item;
    return item;
}

template <typename T>
T Queue<T>::back()
{
    //When there is no node, display status and nothing returns.
    if (_rear == nullptr) {cout << "Empty Queue "; return T();}

    T item = _rear->_item;
    return item;
}

template <typename T>
void Queue<T>::push(T item)
{
    //Make a new node to connects the existing nodes.
    node<T>* enqNode = new node<T>(item);

    //This is the case add the new node as a first node in the empty Queue
    if(_front == nullptr && _rear == nullptr){
        _front = enqNode;
        _rear= enqNode;
        _size++;
        return; // Terminate the void function
    }

    //Connects the new node with the rear node
    node<T>* wkPtr = _rear;
    wkPtr->_next= enqNode;
    //The new node becomes the new last node in the Queue
    _rear= enqNode;
    _size++; //Updates the number of nodes.
}

template <typename T>
T Queue<T>::pop()
{
    //When there is no nodes, it returns default value.
    if(_front == nullptr && _rear == nullptr) {return T(); }

    //Set deleted node with a pointer, pop deletes always the top node.
    node<T>* dltPtr = _front;
    //Set deleted valuse as a return value
    T dltedItem = _front->_item;
    //Updates the top new node to the next node.
    _front = _front->_next;

    //Isolate the top node from the other nodes and delete top node.
    dltPtr->_next = nullptr;
    delete dltPtr;
    dltPtr = nullptr;
    _size--; // Update the number of nodes after delete the node.

    //When there is no nodes after pop, set two pointers to nullptr
    if(_size == 0){
        _front = nullptr;
        _rear = nullptr;
    }

    return dltedItem;

}

template <typename T>
typename Queue<T>::Iterator Queue<T>::begin() const
{
    Iterator frn_tItr(_front);
    return frn_tItr;
} //Iterator to the head node

template <typename T>
typename Queue<T>::Iterator Queue<T>::end() const
{
    //Set walker
    node<T>* wkPtr = _rear;

    //Check nullptr address
    wkPtr = wkPtr->_next;

    //Return Iterator obj
    Iterator lst_Itr(wkPtr);
    return lst_Itr;
} //Iterator to NULL

template <typename T>
void Queue<T>::print_pointers()
{
    _print_list(_front);
}

//template <typename T>
//int size() const { return _size; }

template<typename TT>
ostream& operator << (ostream& outs, const Queue<TT>& printMe)
{
    node<TT> *wkPtr = printMe._front;
    outs << "Queue front : ";
    while(wkPtr != nullptr){
        outs << "[" << *wkPtr << "] ->";
        wkPtr = wkPtr -> _next;
    }
    outs << "[nullptr]";
    return outs;
}


//For debug
template <class T>
void Queue<T>::to_string(){
    cout <<"~~toString~~" << endl<<"*_front : " << *_front << ", *_rear : " << *_rear
         << ", _size : " << _size << endl;

    //Horizontal expression
    cout << "Queue front : ";
    print_pointers();

    //No node case exit toString.
    if(_front == nullptr) { return;}

    //Vertical expression.
    cout<< "\nTop to bottom" << endl;
    Iterator itr(this->begin());
    for (; itr != this->end(); itr++)
    {
        cout << "<" << *itr << "> " << endl;
    }
}
#endif// MYQUEUE_H