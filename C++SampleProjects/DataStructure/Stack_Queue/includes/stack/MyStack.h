#ifndef  MYSTACK_H
#define MYSTACK_H

#include "../node/node.h"
#include "../linked_list_functions/linked_list_functions.h"

using namespace std;

template <typename T>
class Stack{
public:
    class Iterator{
    public:
        friend class Stack; //give access to list to access _ptr
        inline Iterator(){_ptr = NULL;} //default ctor
        inline Iterator(node<T>* p){_ptr =p;} //Point Iterator to where  p is pointing to
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

    Stack();
    Stack(const Stack<T>& copyMe);
    ~Stack();
    Stack<T>& operator=(const Stack<T>& RHS);
    T top();
    bool empty();
    void push(T item);
    T pop();
    template<typename TT>
    friend ostream& operator<<(ostream& outs,const Stack<TT>& printMe);
    Iterator begin() const;  //Iterator to the head node
    Iterator end() const;  //Iterator to NULL
    int size() const { return _size; }
    void to_string(); //For debug

private:
    node<T>* _top;
    int _size;
};





//Function body
template <typename T>
Stack<T>:: Stack():_top(nullptr), _size(0){}

template <typename T>
Stack<T>:: Stack(const Stack<T>& copyMe)
{
    _copy_list(_top, copyMe._top);
    _size = _get_size(copyMe._top);
}

template <typename T>
Stack<T>:: ~Stack()
{
    clear_list(_top);
}

template <typename T>
Stack<T>& Stack<T>:: operator=(const Stack<T>& RHS)
{
    if(this== &RHS ){ return *this;} // The same object

    clear_list(_top); // Initialize existing node.
    _top = nullptr;
    _copy_list(_top, RHS._top); // Copy RHS to the existing node
    _size = _get_size(RHS._top);

    return *this;
}

template <typename T>
T Stack<T>:: top()
{
    //When there is no node, display status and nothing returns.
    if (_top == nullptr) {cout << "Empty Stack "; return T();}

    T topItem = _top ->_item;
    return topItem;
}

template <typename T>
bool Stack<T>:: empty(){
    return (_top == nullptr);
}

template <typename T>
void Stack<T>:: push(T item)
{
    //Set up inserted node as a top node object
    node<T> *insertedfNord= new node<T>(item);

    //This is the case stack is empty and add the first node.
    if(_top== nullptr){
        insertedfNord->_next = nullptr;
    }else{
        //Stack list has nodes already and update top node pointer
        insertedfNord->_next = _top;
    }

    //Update the top node pointer
    _top= insertedfNord;

    _size++;
}

template <typename T>
T Stack<T>:: pop()
{
    //When there is no nodes, it returns default value.
    if(_top == nullptr) {return T(); }

    //Set deleted node with a pointer, pop deletes always the top node.
    node<T>* dltPtr = _top;
    //Set deleted valuse as a return value
    T dltedItem = _top->_item;
    //Updates the top new node to the next node.
    _top = _top->_next;

    //Isolate top node from the other nodes and delete top node.
    dltPtr->_next = nullptr;
    delete dltPtr;
    dltPtr = nullptr;
    _size--; // Update the number of nodes after delete the node.

    return dltedItem;
}

template<typename TT>
ostream& operator<<(ostream& outs,const Stack<TT>& printMe)
{
    node<TT> *wkPtr = printMe._top;
    outs << "Stack top : ";
    while(wkPtr != nullptr){
        outs << "[" << *wkPtr << "] ->";
        wkPtr = wkPtr -> _next;
    }
    outs << "[nullptr]";
    return outs;
}

template <typename T>
typename Stack<T>:: Iterator Stack<T>:: begin() const
{
    Iterator tp_Itr(_top);
    return tp_Itr;
}  //Iterator to the head node

template <typename T>
typename Stack<T>:: Iterator Stack<T>:: end() const{
    //Set walker
    node<T>* wkPtr = _top;

    //Traverse every node until it hits the last node in~ the stack
    while(wkPtr != nullptr){
        wkPtr = wkPtr->_next;
    }
    //Return Iterator obj
    Iterator lst_Itr(wkPtr);
    return lst_Itr;
}  //Iterator to NULL

//template <typename T>
//int size() const { return _size; }

//For debug
template <class T>
void Stack<T>:: to_string(){
    cout <<"~~toString~~" << endl<<"*_top : " << *_top
         << ", _size : " << _size << endl;

    //Horizontal expression
    cout << "stack top : ";
    _print_list(_top);

    //No node case exit toString.
    if(_top == nullptr) { return;}


    //Vertical expression
    cout<< "\nTop to bottom" << endl;
    Iterator itr(this->begin());
    for (; itr != this->end(); itr++)
    {
        cout << "<" << *itr << "> " << endl;
    }
}

#endif // MYSTACK_H