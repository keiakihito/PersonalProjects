#ifndef  LIST_SIMPLE_H
#define LIST_SIMPLE_H

#include "../node/node.h"
#include "../linked_list_functions//linked_list_functions.h"

#include <iostream>
#include <iomanip>
#include <cassert>

using namespace std;

template <class ITEM_TYPE>
class List
{
public:
    List();

    //Big 3
    ~List();
    List(const List<ITEM_TYPE> &copyThis);
    List& operator =(const List& RHS);

    //inset i at the head of list
    node<ITEM_TYPE>* insert_head(ITEM_TYPE i);

    //insert i after iMarker
    node<ITEM_TYPE>* insert_after(ITEM_TYPE i, node<ITEM_TYPE>* iMarker);

    //insert i before iMarker
    node<ITEM_TYPE>* insert_before(ITEM_TYPE i, node<ITEM_TYPE>* iMarker);

    //insert i. Assume sorted list
    node<ITEM_TYPE>* insert_sorted(ITEM_TYPE i);


    //delete node pointed to by iMarker
    ITEM_TYPE Delete(node<ITEM_TYPE>* iMarker);


    //print the list
    void Print() const;

    //return pointer to node containing key. NULL if not there
    node<ITEM_TYPE>* search(const ITEM_TYPE &key);

    //get the previous node to iMarker
    node<ITEM_TYPE>* prev(node<ITEM_TYPE>* iMarker);

    //return the item at index
    ITEM_TYPE& operator[](int index);

    //return the head of the list
    node<ITEM_TYPE>* begin() const;

    node<ITEM_TYPE>* end() const;

    bool empty() const { return head == nullptr; }

    int size() const{ return _size; }

    //insertion operator for list
    template <class U>
    friend ostream& operator <<(ostream& outs, const List<U>& l);

    void to_string(); //For debug

private:
    node<ITEM_TYPE>* head;
    int _size;
};



//Function body
template <class ITEM_TYPE>
List<ITEM_TYPE>::List():head(nullptr),_size(0){ }

template <class ITEM_TYPE>
List<ITEM_TYPE>::~List(){
    clear_list(head);
}

template <class ITEM_TYPE>
List<ITEM_TYPE>::List(const List<ITEM_TYPE> &copyThis){

//    //This case RHS and LHS is the same object
//    if(head == &copyThis) { return this;}

//    head = new node<ITEM_TYPE>;
    _copy_list(head, copyThis.head);
    _size = _get_size(head);
}

template <class ITEM_TYPE>
List<ITEM_TYPE>& List<ITEM_TYPE>::operator =(const List& RHS){
    if(this== &RHS ){ return *this;} // The same object

    clear_list(head); // Initialize existing node.
    head = nullptr;
    _copy_list(head, RHS.head); // Copy RHS to the existing node
    _size = _get_size(RHS.head);

    return *this;
}

//inset i at the head of list
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::insert_head(ITEM_TYPE i){
    head = _insert_head(head, i);
    _size++;
    return head;
}

//insert i after iMarker
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::insert_after(ITEM_TYPE i, node<ITEM_TYPE>* iMarker){
    head = _insert_after(head, iMarker, i);
    _size++;
    return head;
}


//insert i before iMarker
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::insert_before(ITEM_TYPE i, node<ITEM_TYPE>* iMarker){
    head =  _insert_before(head, iMarker, i);
    _size++;
    return head;
}

//insert i. Assume sorted list
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::insert_sorted(ITEM_TYPE i){
    head =  _insert_sorted(head, i);
    _size++;
    return head;
}


//delete node pointed to by iMarker
template <class ITEM_TYPE>
ITEM_TYPE List<ITEM_TYPE>::Delete(node<ITEM_TYPE>* iMarker){

    if(iMarker == nullptr){ //This is the case delete_this is not in the linked list.
        return ITEM_TYPE();
    }

    ITEM_TYPE item = delete_node(head, iMarker);
    _size--; //Update _size;
    return item; //Return deleted item

}


//print the list
template <class ITEM_TYPE>
void List<ITEM_TYPE>::Print() const{
    _print_list(head);
}

//return pointer to node containing
//  key. NULL if not there
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::search(const ITEM_TYPE &key){
    return  _search_list(head, key); //head and the wkPtr points to the first node;
}

//get the previous node to iMarker
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::prev(node<ITEM_TYPE>* iMarker){
    return _previous_node(head, iMarker);
}

//return the item at index
template <class ITEM_TYPE>
ITEM_TYPE& List<ITEM_TYPE>::operator[](int index){
    assert(index < _size && "index should be less than the size");
    return _at(head, index);
}

//return the head of the list
template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::begin() const{
    return head;
}

template <class ITEM_TYPE>
node<ITEM_TYPE>* List<ITEM_TYPE>::end() const{
    node<ITEM_TYPE> *wkPtr = head;
    while(wkPtr != nullptr){
        wkPtr = wkPtr ->_next;
    }
    return wkPtr;
}

//template <class ITEM_TYPE>
//bool List<ITEM_TYPE>::empty() const { return head == nullptr; }

//template <class ITEM_TYPE>
//int List<ITEM_TYPE>::size() const{ return _size; }

//insertion operator for list
template <class U>
ostream& operator <<(ostream& outs, const List<U>& l){
    node<U>*wkPtr = l.head;
    while(wkPtr != nullptr){
        outs << "[" << *wkPtr << "] ->";
        wkPtr = wkPtr -> _next;
    }
    outs << "[nullptr]";
    return outs;
}

template <class ITEM_TYPE>
void List<ITEM_TYPE>::to_string(){
    cout << "_size : " << _size << endl;
    _print_list(head);
}


#endif // LIST_SIMPLE_H