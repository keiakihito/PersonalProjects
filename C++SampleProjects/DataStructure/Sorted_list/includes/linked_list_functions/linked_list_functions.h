#ifndef  LINKEDLIST_FUNCTIONS_H
#define LINKEDLIST_FUNCTIONS_H

#include <iostream>
#include <iomanip>
#include <cassert>
#include <string>

#include "../node/node.h"


//~~~~~Linked List General Functions:~~~~~~
template <typename ITEM_TYPE>
void _print_list(node<ITEM_TYPE>* head){

    node<ITEM_TYPE>* wkPtr = head; //walker pointer to visit every node.

    //Empty node case
    if(wkPtr == nullptr){
        std:: cout << "~~NO NODE ~~" << std::endl;
    }
    else{
        while(wkPtr != nullptr){
            std:: cout << "[" << *wkPtr << "] ->";
            wkPtr = wkPtr->_next; // walker moves to next node to get the value.
        }
        std::cout <<"[nullPtr]" << std::endl; // End of node
    }

}

//recursive fun! :)
template <typename ITEM_TYPE>
void _print_list_backwards(node<ITEM_TYPE> *head){

}

//return ptr to key or NULL
template <typename ITEM_TYPE>
node<ITEM_TYPE>* _search_list(node<ITEM_TYPE>* head, ITEM_TYPE key){

    //This case is node node in the linkedList.
    if(head == nullptr) {return nullptr;}

    //Set walker
    node<ITEM_TYPE> *wkPtr = head;

    //Traverse nodes until  key is found or null
    while(wkPtr ->_item != key){
        wkPtr = wkPtr ->_next;
        //This  case key is not found.
        if(wkPtr == nullptr){ return nullptr; }
    }

    return wkPtr;
}


template <typename ITEM_TYPE>
node<ITEM_TYPE>* _insert_head(node<ITEM_TYPE> *&head, ITEM_TYPE insert_this){

    //Set up inserted node as a new node object
    node<ITEM_TYPE> *insertedfNord= new node<ITEM_TYPE>(insert_this);

    //Linked list has nodes
    insertedfNord->_next = head;
    head= insertedfNord;
    return head;
}

//insert after ptr
template <typename ITEM_TYPE>
node<ITEM_TYPE>* _insert_after(node<ITEM_TYPE>*& head, node<ITEM_TYPE> *after_this, ITEM_TYPE insert_this){
    assert(after_this != nullptr && "It is not allowed to insert node after nullptr");
    //Set up inserted node as a new node object
    node<ITEM_TYPE> *insertedfNord= new node<ITEM_TYPE>(insert_this);

    //This is the case empty linked list.
    if(head == nullptr){
        head = insertedfNord;
        insertedfNord->_next = nullptr;
        return head;
    }

    //Insert new item after the after_this node.
    insertedfNord ->_next = after_this ->_next;
    after_this->_next = insertedfNord;

    return head;
}

//insert before ptr
template <typename ITEM_TYPE>
node<ITEM_TYPE>* _insert_before(node<ITEM_TYPE>*& head, node<ITEM_TYPE>* before_this, ITEM_TYPE insert_this){

    //This is the case empty linked list.
    if(head == nullptr){
        //Set up inserted node as a new node object
        node<ITEM_TYPE> *insertedfNord= new node<ITEM_TYPE>(insert_this);
        head = insertedfNord;
        insertedfNord->_next = nullptr;
        return  head;
    }

    //The case is try to insert the item before the first node.
    if(before_this == head){
        _insert_head(head, insert_this);
    }
        //Insert new item before the indicated node.
    else{
        node<ITEM_TYPE>* prevNode = _previous_node(head, before_this);
        _insert_after(head, prevNode, insert_this);
    }

    return head;
}

//ptr to previous node
template <typename ITEM_TYPE>
node<ITEM_TYPE>* _previous_node(node<ITEM_TYPE>* head, node<ITEM_TYPE>* prev_to_this){
    assert(head != nullptr && "previous_nose, head should have at least 1 node to point to previous node");

    //This case is it asks the one node before the first node,
    //It returns nullptr as invalid situation.
    if(head == prev_to_this){return nullptr;}

    //Set walker
    node<ITEM_TYPE>* wkPtr = head;

    //Traverse every node until it hits the  one before before_this
    while(wkPtr ->_next!=prev_to_this){
        wkPtr = wkPtr->_next;
    }

    return wkPtr;
}

//delete, return item
template <typename ITEM_TYPE>
ITEM_TYPE delete_node(node<ITEM_TYPE>*&head, node<ITEM_TYPE>* delete_this){
    assert(delete_this != nullptr && "delete_this should exist in the linkedLIst");

    //This is the case linked list is empty
    if(head == nullptr){ return ITEM_TYPE();}

    //This the case that is only one node in the likedList
    if(head == delete_this){
        ITEM_TYPE dltedNdItem = delete_this->_item;
        head = delete_this->_next; //head akips deleted node to delete node.
        delete_this->_next = nullptr; // deleted node isolated the other nodes
        delete delete_this;
        return  dltedNdItem;
    }

    ITEM_TYPE dltedNdItem = delete_this->_item; // Get the value to make sure deleted correct node
    node<ITEM_TYPE>* preNode = _previous_node(head, delete_this); //Prep for delete
    preNode->_next = delete_this->_next; //Pre node connects to the node which is one after delete_this
    delete_this->_next = nullptr; // deleted node isolated the other nodes
    delete delete_this; // Delete node

    return dltedNdItem; //Return deleted item

}

//duplicate the list...
template <typename ITEM_TYPE>
node<ITEM_TYPE>* copy_list(node<ITEM_TYPE>* head){

    //Set new head as dest, thses copy should be deep copy
    node<ITEM_TYPE>* dest = nullptr;
    //Set walker to get value from the original linkedList
    node<ITEM_TYPE>* wkPtrSrc = head;
    //Copy the first node in the new linked list.
    _insert_head(dest, wkPtrSrc->_item);
    //Moveto the next node in the original linked list
    wkPtrSrc = wkPtrSrc->_next;
    //It tracks the first node in the new linked list to keep coping with  insert_after_function.
    node<ITEM_TYPE>* wkPtrDst = dest;


    //Get the value from the source list, make a new object and insert new linked list.
    while(wkPtrSrc != nullptr){
        _insert_after(dest, wkPtrDst, wkPtrSrc->_item);
        wkPtrSrc = wkPtrSrc->_next;
        wkPtrDst = wkPtrDst->_next;
    }

    return  dest;
}


//duplicate list and return the last node of the copy
//The dest node pretends as a copied node head
template <typename T>
node<T> * _copy_list(node<T>* &dest, node<T> *src){
    dest = copy_list(src);
    return dest; // Return head node in the copied linked list.
}


//delete all the nodes
template <typename ITEM_TYPE>
void clear_list(node<ITEM_TYPE>*& head){
    //Walker points to the secibd node to delete
    node<ITEM_TYPE> *wkPtr = head;

    while(wkPtr != nullptr){
        // head points to the second node , which becomes the first node after delete.
        delete_node(head,wkPtr);
        // walker points to the second node again until one node is left
        wkPtr = head;
    }

}

//_item at this position
template <typename ITEM_TYPE>
ITEM_TYPE& at(node<ITEM_TYPE>* head, int pos){
    ITEM_TYPE temp;
    node<ITEM_TYPE>* wkPtr = head;
    for(int i = 0; i < pos; i++){
        wkPtr = wkPtr->_next;
        //        If item was not found return nullptr;
        assert(wkPtr != nullptr && " at funtion, position cannot exceed the size of the linkedlist");
    }
    //Get the item in the idex of the linkedlist.
    temp = wkPtr->_item;

    return temp;
}

//. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .
//      Sorted List Routines. order: 0: ascending, order: other: descending
//                              Assume a Sorted List
//. . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . . .

template <typename ITEM_TYPE> //Insert
node<ITEM_TYPE>* _insert_sorted(node<ITEM_TYPE>* &head, ITEM_TYPE item, bool ascending=true){

    //Linked list is empty and insert item
    if(head == nullptr){
        _insert_head(head, item);
        return head;
    }

    //Find the one node before item should be inserted, then insert item .
    node<ITEM_TYPE>* wkPtr = _where_this_goes(head, item);

    //wkPtr is null, this case item is inserted as a new first node before the old first node.
    if(wkPtr == nullptr){
        _insert_head(head,item);
    }else{
        _insert_after(head, wkPtr, item);
    }

    return head;

}

////insert or add if a dup
//template <typename ITEM_TYPE>
//node<ITEM_TYPE>* _insert_sorted_and_add(node<ITEM_TYPE>* &head, ITEM_TYPE item, bool ascending=true){
//    return head;
//
//}

//node after which this item goes order: 0 ascending
template <typename ITEM_TYPE>
node<ITEM_TYPE>* _where_this_goes(node<ITEM_TYPE>* head, ITEM_TYPE item, bool ascending=true){

    //Linkedlist is empyt
    if(head == nullptr){return nullptr;}
    node<ITEM_TYPE>* wkPtrPre = head;
    //Item  will be inserted before the first node.
    if(wkPtrPre->_item >= item){return nullptr;}
    //Set walker and follower to compare the item.
    node<ITEM_TYPE>* wkPtrPos = wkPtrPre ->_next;

    //WkPtrPos compare the item.
    //When item is smaller than WkPtrPos, it return the one node before.
    while(wkPtrPos != nullptr && wkPtrPos-> _item <= item){
        wkPtrPos = wkPtrPos ->_next;
        wkPtrPre = wkPtrPre ->_next;
    }

    return wkPtrPre;
}

////Last Node in the list
//template <typename ITEM_TYPE>         //never use this function.
//node<ITEM_TYPE>* last_node(node<ITEM_TYPE>* head){
//
//}

template <typename ITEM_TYPE>
int _get_size(node<ITEM_TYPE>* head){
    int sizeOfLnkList = 0;
    node<ITEM_TYPE>* wkPtr = head;
    //Counting nodes until walker hits nullptr
    while(wkPtr != nullptr){
        sizeOfLnkList++;
        wkPtr = wkPtr->_next;
    }
    return sizeOfLnkList;
}

//template<typename ITEM_TYPE>
//void node<ITEM_TYPE>::to_string(){
//    std::cout << "_item : " << _item << "*_next : " << *_next << std::endl;
//}

#endif // LINKEDLIST_FUNCTIONS_H