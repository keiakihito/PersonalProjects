#ifndef  NODE_H
#define NODE_H

#include <iostream>
#include <iomanip>
#include <string>


template <typename ITEM_TYPE>
struct node
{
public:
    node(const ITEM_TYPE& item = ITEM_TYPE(), node* next = nullptr);

    template <typename T>
    friend std::ostream& operator <<(std::ostream& outs, const node<T> &printMe);

//    void to_string();
    ITEM_TYPE _item; //Data in the node
    node* _next; // Points to the next node head
};

//CTR
template <typename ITEM_TYPE>
node<ITEM_TYPE>:: node(const ITEM_TYPE& item, node* next): _item(item), _next(next){}

//Print nodes
template <typename T>
std::ostream& operator <<(std::ostream& outs, const node<T> &printMe){
    if(&printMe == nullptr){
        outs << "nullptr";
    }else{
        outs << printMe._item; // Store data in the node to the outs and return to see the data.
    }
    return outs;
}

#endif // NODE_H