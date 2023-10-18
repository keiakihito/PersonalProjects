#ifndef TWO_D_FUNCTIONS_H
#define TWO_D_FUNCTIONS_H

#include <cassert>
#include <iomanip>
#include <iostream>

using namespace std;



int array_size(int* sizes);
void print_array(int* a);
bool index_is_valid(int* sizes, int row, int col);



//To call: int** p = allocate_twod<int>(sizes_array)

template <class T>
T** allocate_twod(int* sizes);

template <class T>
T** deallocate_twod(T** twod, int size);

template <class T>
T read_twod(T** twod, int row, int col);

template <class T>
void write_twod(T** twod, int row, int col, const T& item);

template <class T>
T& get_twod(T** twod, int row, int col);

template<class T>
void init_twod(T** twod, int* sizes, T init_item = T());

template<class T>
bool search_twod(T** twod, int* sizes, const T& key, int& row, int& col);

//return a pointer to the item if found, nullptr if not found:
//                                                 (Ms. Barskhian)
template<class T>
T* search_twod(T** twod, int* sizes, const T& key);

template <class T>
ostream& print_twod(T** twod, int* sizes, ostream& outs = cout);



//Template functions implementation
template <class T>
T** allocate_twod(int* sizes){

    bool debug = 0;

    int rowSize = array_size(sizes);
    rowSize++; //For nullPtr in the end of row;
    if(debug){
        cout << "rowSize including -1 is : " << rowSize << endl;
    }

    //Allocate row and set walker
    T**  dblPtr = new T*[rowSize];
    T** rwWkPtr = dblPtr;

    //Set walker to get the number of column
    int* sizesWkPtr =sizes;
    for(int i = 0; i < rowSize; i++){
        //Allocate column element with the number of sizes value
        int colSize = *sizesWkPtr;
        *rwWkPtr = new T[colSize];
        if (debug){
            cout << "Allocate row [" << i << "], col size : " <<  *sizesWkPtr << endl;
        }
        rwWkPtr++;
        sizesWkPtr++;

        //Set the last row index with nullptr
        if (i+1 == rowSize -1){
            rwWkPtr++;
            *rwWkPtr = nullptr;
            if (debug){
                cout << "Allocate row [" << i +1  << "], col size : nullptr"  << endl;
            }
            //Get out of for loop after assign nullptr in the last index.
            i++;
        }
    }

    return dblPtr;
}

template <class T>
T** deallocate_twod(T** twod, int size){

    bool debug = 0;

    //Allocate row and set walker
    T** rwWkPtr = twod;

    for(int i = 0; i < size; i++){
        //deallocate free space which row pointer points to
        delete[] *rwWkPtr;
        *rwWkPtr = nullptr;
        if (debug){
            cout << "Deallocate row [" << i << "]"<< endl;
        }
        rwWkPtr++;
    }

    //Assign nullptr after deallocate all the row pointer dynamic array
    delete[] twod;
    twod = nullptr;
    return twod;
}

template <class T>
T read_twod(T** twod, int row, int col){
    T element = T();
    //Points to the first row index 0 [0][0]
    T** rwWkPtr = twod;

    //Move row
    rwWkPtr += row;
    //Set columns walker
    T* colWkPtr = *rwWkPtr;
    colWkPtr += col;
    element = *colWkPtr;

    return element;
}

template <class T>
void write_twod(T** twod, int row, int col, const T& item){

    //Points to the first row index 0 [0][0]
    T** rwWkPtr = twod;

    //Move row
    rwWkPtr += row;
    //Set columns walker
    T* colWkPtr = *rwWkPtr;
    //Move columns
    colWkPtr += col;
    *colWkPtr = item;

}

template <class T>
T& get_twod(T** twod, int row, int col){

    //Points to the first row index 0 [0][0]
    T** rwWkPtr = twod;

    //Move row
    rwWkPtr += row;
    //Set columns walker
    T* colWkPtr = *rwWkPtr;
    colWkPtr += col;

    //Return address of the value in the specified index
    return *colWkPtr;
}

template<class T>
void init_twod(T** twod, int* sizes, T init_item){

    bool debug = 0;

    int rowSize = array_size(sizes);
    if(debug){
        cout << "rowSize : " << rowSize << endl;
    }

    //Allocate row and set walker
    T** rwWkPtr = twod;

    //Set walker to get the number of column
    int* sizesWkPtr =sizes;
    for(int i = 0; i < rowSize; i++){
        //set wakler to traverse colums
        int colSize = *sizesWkPtr;
        T* clWkPtr = *rwWkPtr;
        //Iterate column space
        for(int j = 0; j < colSize; j++){
            *clWkPtr = init_item;
            if(debug){
                cout << "Fill value to [" << i <<"]" << "[" << j <<"]"<<endl;
            }
            //Move to next column
            clWkPtr++;
        }
        //Get the next column size
        sizesWkPtr++;
        //Move to the next row
        rwWkPtr++;
    }

}

template<class T>
bool search_twod(T** twod, int* sizes, const T& key, int& row, int& col){

    bool debug = 0;
    if (debug) {
        cout << " Key (" <<key<<")"<< endl;
    }
    int rowSize = array_size(sizes);

    //Allocate row and set walker
    T** rwWkPtr = twod;

    //Set walker to get the number of column
    int* sizesWkPtr =sizes;
    for(int i = 0; i < rowSize; i++) {
        //set wakler to traverse colums
        int colSize = *sizesWkPtr;
        int *clWkPtr = *rwWkPtr;
        //Iterate column space
        for (int j = 0; j < colSize; j++) {
            if(*clWkPtr == key){
                row = i;
                col = j;
                return true;
            }

            if (debug) {
                cout << "[" << i << "]" << "[" << j << "]" << ", val (" <<*clWkPtr <<")"<< endl;
            }
            //Move to next column
            clWkPtr++;
        }
        //Get the next column size
        sizesWkPtr++;
        //Move to the next row
        rwWkPtr++;
    }
    return false;
}

//return a pointer to the item if found, nullptr if not found:
//                                                 (Ms. Barskhian)
template<class T>
T* search_twod(T** twod, int* sizes, const T& key){

    bool debug = 0;
    if (debug) {
        cout << " Key (" <<key<<")"<< endl;
    }
    int rowSize = array_size(sizes);

    //Allocate row and set walker
    T** rwWkPtr = twod;

    //Set walker to get the number of column
    int* sizesWkPtr =sizes;
    for(int i = 0; i < rowSize; i++) {
        //set wakler to traverse colums
        int colSize = *sizesWkPtr;
        int *clWkPtr = *rwWkPtr;
        //Iterate column space
        for (int j = 0; j < colSize; j++) {
            if(*clWkPtr == key){
                return clWkPtr;
            }

            if (debug) {
                cout << "[" << i << "]" << "[" << j << "]" << ", val (" <<*clWkPtr <<")"<< endl;
            }
            //Move to next column
            clWkPtr++;
        }
        //Get the next column size
        sizesWkPtr++;
        //Move to the next row
        rwWkPtr++;
    }

    //Key was not found.
    return nullptr;
}

template <class T>
ostream& print_twod(T** twod, int* sizes, ostream& outs){
    bool debug = 0;

    int rowSize = array_size(sizes);
    if(debug){
        cout << "rowSize : " << rowSize << endl;
    }

    //Allocate row and set walker
    T** rwWkPtr = twod;

    //Set walker to get the number of column
    int* sizesWkPtr =sizes;
    for(int i = 0; i < rowSize; i++){
        //set wakler to traverse colums
        int colSize = *sizesWkPtr;
        T* clWkPtr = *rwWkPtr;
        //Iterate column space
        outs << "row size( " << i +1 << "/" <<rowSize<< "), " << "col size(" << colSize  << ")";
        outs << " { ";
        for(int j = 0; j < colSize; j++){
            outs << *clWkPtr << " ";
            if(debug){
                cout << "\nGet value of  [" << i <<"]" << "[" << j <<"]"<< *clWkPtr;
            }
            //Move to next column
            clWkPtr++;
        }
        //end of the column
        outs << "}" << endl;
        //Get the next column size
        sizesWkPtr++;
        //Move to the next row
        rwWkPtr++;
    }
    return outs;
}


#endif //TWO_D_FUNCTIONS.H