#include "plane.h"
#include <cassert>
#include <iomanip>
#include <iostream>

#include "../two_d_functions/two_d_functions.h"

//Make size int array
const int ROW_SIZE = 7;
const int CLM_SIZE = 4;


bool **init_plane(){
    bool debug = 1;

    //+1 is for -1
    int* sizes = new int [ROW_SIZE + 1];
    //Set walker
    int* rwWkPtr = sizes;

    for(int i = 0; i < ROW_SIZE; i++){
        *rwWkPtr = CLM_SIZE;
        rwWkPtr++;
    }

    //End of row
    *rwWkPtr = -1;

    if(debug){
        cout << "print array: " << endl;
        print_array(sizes);
        cout << endl;
    }

    //Create plane sheet
    bool** dblPtr = allocate_twod<bool>(sizes);
    //Initialize seat with default as default
    init_twod(dblPtr, sizes, false);

    if(debug){
        cout << "Print 2D array: " <<endl;
        print_twod(dblPtr, sizes);
    }

    delete[] sizes;
    return dblPtr;
}


bool reserve(bool **plane, int row, int seat){
    assert(row <= ROW_SIZE && "row is smaller than ROW_SIZE");
    assert(seat <= CLM_SIZE && "seat is smaller than COL_SIZE");
    bool debug = 0;
    bool isSuccess = false;
    //Check the seat is reserved or not.
    bool is_reserved = read_twod(plane, row, seat);

    if(debug){
        cout << "is_ reserved : " << boolalpha<<is_reserved << endl;
    }

    //When the seat is empty make it reserved
    if(is_reserved == false){
        get_twod(plane, row, seat) = true;
        isSuccess = true;
    }

    return isSuccess;
}

bool cancel(bool** plane, int row, int seat){
    assert(row <= ROW_SIZE && "row is smaller than ROW_SIZE");
    assert(seat <= CLM_SIZE && "seat is smaller than COL_SIZE");
    bool debug = 0;
    bool isSuccess = false;
    //Check the seat is reserved or not.
    bool is_reserved = read_twod(plane, row, seat);

    if(debug){
        cout << "is_ reserved : " << boolalpha<<is_reserved << endl;
    }

    //When the seat is reserved make it cancel
    if(is_reserved){
        get_twod(plane, row, seat) = false;
        isSuccess = true;
    }

    return isSuccess;
}

void print_plane(bool **plane){
    bool debug = 0;

    //Set rwo walker
    bool** rwWkPtr = plane;

    for(int i = 0; i < ROW_SIZE; i++){
        //set walker to traverse columns
        bool* clWkPtr = *rwWkPtr;
        //Iterate column space
        cout << "row [ " << i +1 << "] ";

        for(int j = 0; j < CLM_SIZE; j++){
            if(*clWkPtr == false){
                cout << "X ";
            }else{
                cout << char('A' + j) << " ";
            }
            if(debug){
                cout << "\nGet value of  [" << i <<"]" << "[" << j <<"]"<< *clWkPtr;
            }
            //Move to next column
            clWkPtr++;
        }
        cout << endl;
        //Move to the next row
        rwWkPtr++;
    }
}