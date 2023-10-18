#include <iostream>
#include <iomanip>


#include "../../includes/node/node.h"
#include "../../includes/linked_list_functions/linked_list_functions.h"
#include "../../includes/list_sorted/list_sorted.h"

using namespace std;

bool basic_test(bool debug = false){
    List<int> list;
    cout << "list.empty(): " << boolalpha << list.empty() << endl;
    for (int i = 1; i < 6; i++)
    {
        list.insert(i);
        list.insert(i * 10);
        list.insert(i * 100);
        cout << list << endl;
    }
    List<int>::Iterator it = list.search(4);
    cout << "found 4: " << *it << endl;
    it = list.prev(it);
    cout << "previous to 4: " << *it << endl;
    list.Delete(it);
    cout << "deleted the prev: " << list << endl;
    cout << endl;
    cout << "iterating all the nodes: " << endl;
    for (it = list.begin(); it != list.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;
    cout << "list.empty(): " << boolalpha << list.empty() << endl;
    cout << "\n\n---------- D O N E ---------------\n\n"
         << endl;
    return true;
}

/*
build git:(master) ✗  😊 $> tree ../includes
../includes
├── linked_list_functions
│   └── linked_list_functions.h
├── list_sorted
│   └── list_sorted.h
└── node
    └── node.h
3 directories, 3 files
build git:(master) ✗  😊 $> ./bin/basic_test
----------running testA.cpp---------
[==========] Running 1 test from 1 test case.
[----------] Global test environment set-up.
[----------] 1 test from BASIC_TEST
[ RUN      ] BASIC_TEST.BasicTest
list.empty(): true
[1]-> [10]-> [100]-> |||
[1]-> [2]-> [10]-> [20]-> [100]-> [200]-> |||
[1]-> [2]-> [3]-> [10]-> [20]-> [30]-> [100]-> [200]-> [300]-> |||
[1]-> [2]-> [3]-> [4]-> [10]-> [20]-> [30]-> [40]-> [100]-> [200]-> [300]-> [400]-> |||
[1]-> [2]-> [3]-> [4]-> [5]-> [10]-> [20]-> [30]-> [40]-> [50]-> [100]-> [200]-> [300]-> [400]-> [500]-> |||
found 4: 4
previous to 4: 3
deleted the prev: [1]-> [2]-> [4]-> [5]-> [10]-> [20]-> [30]-> [40]-> [50]-> [100]-> [200]-> [300]-> [400]-> [500]-> |||
iterating all the nodes:
1 2 4 5 10 20 30 40 50 100 200 300 400 500
list.empty(): false
---------- D O N E ---------------
[       OK ] BASIC_TEST.BasicTest (0 ms)
[----------] 1 test from BASIC_TEST (0 ms total)
[----------] Global test environment tear-down
[==========] 1 test from 1 test case ran. (0 ms total)
[  PASSED  ] 1 test.
build git:(master) ✗  😊 $>
*/




bool test_operators(bool debug = false){
    cout <<"~~~~~Operators_test ~~~~~" << endl;
    node<int>* wkPtr = nullptr;
    node<int>testNode(4);
    wkPtr = &testNode;
    cout << "Make a node which has 4 and wkPtr point to the node,  *wkPtr : ";
    cout << *wkPtr << endl;

//    List<int>::Iterator it(wkPtr);
    List<int>::Iterator it = wkPtr;
    cout << "Iterator it points to the node with 4 and dereference ,  *it : ";
    cout <<  *it << endl;
//    it.to_string();

    List<int>::Iterator empt;

    cout << "\nIs_null?" << endl << "it with value 4 : " << it.is_null() << endl
         << "empt without anything : " <<empt.is_null() <<endl;

    cout << "\n!= test " << endl << "it != empty: " << boolalpha<<(it != empt);
    cout << "\n\n== test " << endl << "it == empty: " << boolalpha<<(it == empt);

    cout << "\n\n - - - - - - - - - Done - - - - - - - - - - - - - -\n\n";
    return true;
}




bool copy_CTR_test(bool debug = false){
    cout << "\n\n == copy_CTR_ test ==\n" << endl;
    List<int> refList;
//    node<int>* wkPtr;

    //Fill lists
    for (int i = 0; i < 10; i++){
        refList.insert(i);
    }

    List<int> cpyList(refList);
    cout << "cpyList(refList) Copy CTR check: "<<endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();

//    node<int>* wkPtr = &cpyList;
    List<int>::Iterator it = cpyList.begin();


    //Check deep copy or shallow copy
    for (int i = 9; i >= 0; i--){
        it = cpyList.insert_and_add(i);
    }


    cout <<endl <<"\nCheck deep copy or shallow copy" << endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();


    cout << "\n\n == operator_=_ test ==\n";
    List<int> eqlList;
    cout << endl<<"\ncpyList : ";
    cpyList.to_string();
    cout << "\nequalList : ";
    eqlList.to_string();

    eqlList = cpyList;

    cout << "eqlList = cpyList" << endl;
    cout << endl<<"cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();


    //Check deep copy or shallow copy
    for (int i = 0; i < 10; i++){
        eqlList.insert(i);
    }

    cout << "Check deep copy or shallow copy" << endl;
    cout << endl<<"cpyList : ";
    cpyList.to_string();
    cout << "equalList : ";
    eqlList.to_string();


    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}




bool insert_and_add_test(bool debug = false){
    cout << "\n\n == insert_and_add_test ==\n" << endl;
    List<int> refList;
//    node<int>* wkPtr;

    //Fill lists
    for (int i = 0; i < 10; i++){
        refList.insert(i);
    }

    List<int> cpyList(refList);
    cout << "Make 2 sorted lists: "<<endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();

//    node<int>* wkPtr = &cpyList;
    List<int>::Iterator it = cpyList.begin();


    cout << "\n\ncpyList adds the same value with insert_and_add: "<<endl;
    //Check deep copy or shallow copy
    for (int i = 9; i >= 0; i--){
        cout <<"Add [" << i << "] to cpyList. If it's duplicates, add it to the original value." << endl;
        it = cpyList.insert_and_add(i);
    }


    cout <<endl <<"\nCheck deep copy or shallow copy" << endl;
    cout << "refList: ";
    refList.to_string();
    cout << endl<<"cpyList : ";
    cpyList.to_string();



    cout <<" - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}

