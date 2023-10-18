#include "lab.h"
#include <cassert>
#include <iomanip>
#include <iostream>

#include"../two_d_functions/two_d_functions.h"

using namespace std;

int **init_lab(int* stations){

    bool debug = 0;

    int rowSize = array_size(stations);
    rowSize++; //For nullPtr in the end of row;
    if(debug){
        cout << "rowSize including -1 is : " << rowSize << endl;
    }

    //Allocate row and set walker
    int**  dblPtr = new int*[rowSize];
    int** rwWkPtr = dblPtr;

    //Set walker to get the number of column
    int* sizesWkPtr =stations;
    for(int i = 0; i < rowSize; i++){
        //Allocate column element with the number of sizes value
        int colSize = *sizesWkPtr;
        *rwWkPtr = new int[colSize];
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


bool login(int** labs, int lab, int station, int id){
    //lab is already occupied, then return false.
    if(read_twod(labs, lab, station) != 0){
        return false;
    }else{
        //The new user log in
        write_twod(labs, lab, station, id);
    }
    return true;
}


bool logout(int** labs, int* sizes, int id){
    int* labPtr = search_twod(labs, sizes, id);
    //No user is in the lab, then return false.
    if(labPtr== nullptr){
        return false;
    }else{
        //The user log out and put initial value.
        *labPtr= 0;
    }
    return true;
}
