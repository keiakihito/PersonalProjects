#include "two_d_functions.h"
#include <cassert>
#include <iomanip>
#include <iostream>
using namespace std;

int array_size(int* sizes){
    assert(*sizes != -1 && "The given array should be at least one element");
    int* wkPtr = sizes;
    int arrSize = 0;
    bool loop = true;
    while(loop){
        arrSize++;
        wkPtr++;
        if(*wkPtr == -1){
            loop = false;
        }
    }
    return arrSize;
}

void print_array(int* a){
    int* wkPtr = a;
    int  size = array_size(a);
    cout << "size: " << size << ", { ";
    for ( int i = 0 ;  i  < size; i++ ){
        cout << *wkPtr;
        if(i != size -1){
            cout << ", ";
        }else{
            cout << " }";
        }
        wkPtr++;
    }
}

bool index_is_valid(int* sizes, int row, int col)
{
    assert(row >= 0 && "row index should be more than zero");
    //How I can check row size without double pointer.

    //Get the number of row
    int rowSize = array_size(sizes);
    //Argument row is supposed to smaller than row size otherwise out of bound.
    if(rowSize <= row){
        return false;
    }

    //Set walker
    int* wkPtr = sizes;

    //Increment
    wkPtr += row;
    int colSize = *wkPtr;
    //Argument col is  supposed to smaller than column  size otherwise out of bound.
    if(colSize <= col){
        return false;
    }
    return true;
}

