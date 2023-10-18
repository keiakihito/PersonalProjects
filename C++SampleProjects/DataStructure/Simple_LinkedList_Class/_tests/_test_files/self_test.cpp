#include <cmath>
#include <iostream>
#include <iomanip>
#include <set>
#include <vector>
#include <list>

#include"../../includes/linked_list_functions/linked_list_functions.h"
#include"../../includes/list_simple/list_simple.h"
#include"../../includes/node/node.h"

using namespace std;

bool basic_test(bool debug = false){

    List<int> list;
    node<int> *marker;
    cout << "list.empty(): " << boolalpha << list.empty() << endl;
    for (int i = 1; i < 6; i++)
    {
        list.insert_head(i);
        list.insert_after(i * 10, list.begin());
        list.insert_before(i * 100, list.begin());
        cout << list << endl;
//        list.to_string();
    }
    marker = list.search(4);
    cout << "found 4: " << *marker << endl;
    marker = list.prev(marker);
    cout << "previous to 4: " << *marker << endl;
    list.Delete(marker);
    cout << "deleted the prev: " << list << endl;
    cout << endl;
    cout << "iterating all the nodes: " << endl;
//    list.to_string();
    for (marker = list.begin(); marker != list.end(); marker=marker->_next)
    {
        cout << *marker << " ";
    }
    cout << endl;
    cout << "list.empty(): " << boolalpha << list.empty() << endl;


    cout << "\n\n-------- DONE ---------\n\n" << endl;
    return true;
}

bool CTR_test(bool debug = false){
    cout << " == CTR_ test ==\n" << endl;
    List<int> refList;
//    node<int>* wkPtr;
    cout << "listRfnce : " << refList <<endl;

    cout << "\n\n == insert_head_ test ==\n" << endl;
    for (int i = 0; i < 10; i++){
        refList.insert_head(i);
//        refList.to_string();
    }
    cout << "After insert_head"<<endl<<"refList : ";
    cout << "listRfnce : " << refList <<endl;
    cout << "to_string : ";
    refList.to_string();


//    cout << "\n\n == operator_=_ test ==\n" << endl;
//    List<int> eqlList;
//    cout << "equalList : ";
//    eqlList.to_string();
//    cout << endl<<"cpyList : ";
//    cpyList.to_string();
//
//    eqlList = cpyList;
//
//    cout << "After = operator,   cpyList == equalList ? : " << endl;
//    cout << "cpyList : ";
//    cpyList.to_string();
//    cout << "eqlList : ";
//    eqlList.to_string();
//

    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}

bool copy_CTR_test(bool debug = false){
    cout << "\n\n == copy_CTR_ test ==\n" << endl;
    List<int> refList;
//    node<int>* wkPtr;

    //Fill lists
    for (int i = 0; i < 10; i++){
        refList.insert_head(i);
    }

    List<int> cpyList(refList);
    cout << "cpyList(refList) Copy CTR check: "<<endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();

    //Check deep copy or shallow copy
    for (int i = 0; i < 10; i++){
        cpyList.insert_head(i);
    }
    cout <<endl <<"\nCheck deep copy or shallow copy" << endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();


    cout << "\n\n == operator_=_ test ==\n";
    List<int> eqlList;
    cout << endl<<"cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();

    eqlList = cpyList;

    cout << "eqlList = cpyList" << endl;
    cout << endl<<"cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();


    //Check deep copy or shallow copy
    for (int i = 0; i < 10; i++){
        eqlList.insert_head(i);
    }

    cout << "Check deep copy or shallow copy" << endl;
    cout << endl<<"cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();


    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}


bool insert_test(bool debug = false){

    cout << "\n\n == insert_head_ test ==\n" << endl;
    List<int> refListBfr;
    node<int>* wkPtr;
    cout<<"Creat an object with a default CTR" << endl;
    cout << "refList : " << refListBfr <<endl;
    for (int i = 0; i < 10; i++){
        refListBfr.insert_head(i*10);
    }

    cout << "After insert_head"<<endl<<"refList : ";
    cout << "listRfnce : " << refListBfr <<endl;
    cout << "to_string : ";
    refListBfr.to_string();

//    //Search test is well done
//    //Comment out for testing other functions
//    cout << "\n\n == Search_ test ==\n" << endl;
//
//    refList.to_string();
//
//    for(int i = 0; i < 100; i++){
//        wkPtr = refList.search(i);
//        if(wkPtr != nullptr){
//            cout << "Key [" << i << "] found at " << wkPtr << endl;
//        }else{
//            cout << "Key [" << i << "] is not found" << endl;
//        }
//    }





    cout << " \n\n== insert_before_ test ==\n" << endl;
    cout << "refList : " << refListBfr <<endl;

    //Copy constructor copied by refferece??
//    List<int> cpyList(refList);

    //= operator works
//    List<int> cpyList;
//    cpyList = refList;
//    cout << "cpyList = refList" << endl;
//    cout << "cpyList: "<<cpyList;
//
//
    int key;
    for (int i = 0; i < 100; i++) {
        wkPtr = refListBfr.search(i);
        if(wkPtr != nullptr){
            key = i + 5;
            refListBfr.insert_before(key, wkPtr);
            i = key; // Skip duplicate value to inset
        }
        if(debug){
            refListBfr.to_string();
        }
    }

    cout << "After insert_before"<<endl<<"refList : ";
    cout << "refList : " << refListBfr <<endl;
    cout << "to_string : ";
    refListBfr.to_string();




    cout << endl<<"\n == insert_after_ test ==\n" << endl;
    List<int> refListAft;
    cout << refListAft;
////    cout<<"Creat an object with a default CTR" << endl;
////    cout << "refListAft : " << refListAft <<endl;
////    for (int i = 0; i < 10; i++){
////        refListAft.insert_head(i*10);
////    }
////
    for (int i = 0; i < 10; i++){
        refListAft.insert_head(i*10);
    }

    for (int i = 1; i < 100; i++) {
        wkPtr = refListAft.search(i);
        if(wkPtr != nullptr){
            key = i  - 5;
            refListAft.insert_after(key, wkPtr);
//            i = key; // Skip duplicate value to inset
//            cout << "i :  " << endl;
        }
        if(debug){
            refListAft.to_string();
        }
    }

    cout << "After insert_before"<<endl<<"refList : ";
    cout << "refList : " << refListAft <<endl;
    cout << "to_string : ";
    refListAft.to_string();
//
//    cout << "After insert_after"<<endl<<"refListAft : ";
//    cout << "refListAft : " << refListAft <<endl;
//    cout << "to_string : ";
//    refListAft.to_string();
//
//    cout << " - - - After insert_after - - - "<<endl<<"eqlList : ";
//    eqlList.to_string();
//
//    cout << "refList : ";
//    refList.to_string();

    cout << "\n\n == insert_sorted_ test ==\n" << endl;
    List<int> refListSrtd;
    cout<<"Creat an object with a default CTR" << endl;
    cout << "refListSrtd : " << refListSrtd <<endl;
    for (int i = 10; i >= 0; i--){
        refListSrtd.insert_head(i*10);
    }

    cout << "refLisSrtd : " << refListSrtd <<endl;
    for (int i = 0; i <= 10; i++) {
        key = i * 10 + 5;
        refListSrtd.insert_sorted(key);

    }

    cout << "After insert_sorted"<<endl;
    cout << "refListStr : " << refListSrtd <<endl;
    cout << "to_string : ";
    refListSrtd.to_string();


    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}

bool delete_node_test(bool debug = false){
    cout << " == Delete_test ==\n" << endl;

    List<int> refList;
    node<int>* wkPtr;

    for (int i = 0; i < 10; i++){
        refList.insert_head(i*10);
    }

    //= operator works
    List<int> cpyList;
    cpyList = refList;

    int key;
    for (int i = 0; i < 10; i++) {
        wkPtr = cpyList.search(i*10);
        if(debug){
            _print_list(wkPtr);
        }
        key = i *10 + 5;
        cpyList.insert_before(key, wkPtr);
        if(debug){
            cpyList.to_string();
        }
    }

    List<int> eqlList;
    eqlList = refList;

    for (int i = 1; i < 11; i++) {
        wkPtr = eqlList.search(i*10);
        if(wkPtr != nullptr){
            key = (i-1) *10 + 5;
            eqlList.insert_after(key, wkPtr);
        }
        if(debug){
            eqlList.to_string();
        }
    }

    eqlList.insert_head(95);


    cout << "refList : ";
    refList.to_string();
    cout << "cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();


    key = 0;
    int dltedItem = 0;

    cout << "\n\n~~Delete nodes cpyList, First round~~" << endl;
    cout << "\nOriginal refList :" <<endl;
    refList.to_string();
    cout << "cpyList : ";
    cpyList.to_string();


    for(int i = 0; i < 10; i++){
        key = i * 10;
        wkPtr =cpyList.search(key);
        if(debug){
//            _print_list(wkPtr);
            cout << "Key : " << key << endl;
            cout << "Key is found : "<<*wkPtr << endl;
        }

        dltedItem = cpyList.Delete(wkPtr);
        if(debug){
            cout << "Deleted item: " <<  dltedItem << endl;
        }
        if(debug){
            cout << "After deleted : " << endl;
            cpyList.to_string();
        }
    }



    cout << "\nAfter delete_node loop, cpyList : " << endl;
    cpyList.to_string();

    cout << "\n\n~~Delete node cpyList, Second round~~" << endl;
    cout << "\nOriginal refList :" <<endl;
    refList.to_string();
    cout << "Current cpyList: ";
    cpyList.to_string();

    for(int i = 0; i < 10; i++){
        key = i * 10 + 5;
        wkPtr =cpyList.search(key);
        if(debug){
//            _print_list(wkPtr);
            cout << "Key : " << key << endl;
            cout << "Key is found : "<<*wkPtr << endl;
        }

        dltedItem = cpyList.Delete(wkPtr);
        if(debug){
            cout << "Deleted item: " <<  dltedItem << endl;
        }
        if(debug){
            cout << "After deleted : " << endl;
            cpyList.to_string();
        }
    }
    cout << "\nOriginal refList:" <<endl;
    refList.to_string();

    cout << "\nAfter delete node loop, cpyList : " << endl;
    cpyList.to_string();





    cout << "\n\n~~Delete node test equalList, Third round~~" << endl;
    cout << "\nOriginal refList:" <<endl;
    refList.to_string();
    cout << "equalList : ";
    eqlList.to_string();

    for(int i = 0;  i < 100; i++){
        key = i;
        wkPtr =eqlList.search(key);
        dltedItem = eqlList.Delete(wkPtr);
    }

//    wkPtr =eqlList.search(90);
//    dltedItem = eqlList.Delete(wkPtr);
//
    cout << "\nAfter loop delete node, eqlList: " << endl;
    eqlList.to_string();

    cout << "\nOriginal refList:" <<endl;
    refList.to_string();


//    wkPtr =eqlList.search(0);
//    dltedItem = eqlList.Delete(wkPtr);
//
//    cout << "\nAfter loop, eqlList: " << endl;
//    eqlList.to_string();
//
//    cout << "\nOriginal refList:" <<endl;
//    refList.to_string();
//

    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}



