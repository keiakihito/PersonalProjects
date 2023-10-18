#include <iostream>
#include <iomanip>

#include "_tests/_test_files/self_test.cpp"

using namespace std;

int main(int argv, char** argc) {
    bool debug = 0;
    cout << boolalpha <<basic_test(debug) <<": basic_test finished. " <<  endl;
    cout << boolalpha <<test_operators(debug) <<": basic_test finished. " <<  endl;
    cout << boolalpha <<copy_CTR_test(debug) <<": copy_CTR_test finished. " <<  endl;
    cout << boolalpha <<insert_and_add_test(debug) <<": insert_and_add_test finished. " <<  endl;

    cout << "\n =========The Program has finished safely============" << endl;
    return 0;
}

/*Sample Run
==basic_test==
list.empty(): true
[1] ->[10] ->[100] ->[nullptr]
[1] ->[2] ->[10] ->[20] ->[100] ->[200] ->[nullptr]
[1] ->[2] ->[3] ->[10] ->[20] ->[30] ->[100] ->[200] ->[300] ->[nullptr]
[1] ->[2] ->[3] ->[4] ->[10] ->[20] ->[30] ->[40] ->[100] ->[200] ->[300] ->[400] ->[nullptr]
[1] ->[2] ->[3] ->[4] ->[5] ->[10] ->[20] ->[30] ->[40] ->[50] ->[100] ->[200] ->[300] ->[400] ->[500] ->[nullptr]
found 4: 4
previous to 4: 3
deleted the prev: [1] ->[2] ->[4] ->[5] ->[10] ->[20] ->[30] ->[40] ->[50] ->[100] ->[200] ->[300] ->[400] ->[500] ->[nullptr]

iterating all the nodes:
1 2 4 5 10 20 30 40 50 100 200 300 400 500
list.empty(): false


---------- D O N E ---------------


true: basic_test finished.
~~~~~Operators_test ~~~~~
Make a node which has 4 and wkPtr point to the node,  *wkPtr : 4
Iterator it points to the node with 4 and dereference ,  *it : 4

Is_null?
it with value 4 : false
empt without anything : true

!= test
it != empty: true

== test
it == empty: false

 - - - - - - - - - Done - - - - - - - - - - - - - -

true: basic_test finished.


 == copy_CTR_ test ==

cpyList(refList) Copy CTR check:
refList:
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]


Check deep copy or shallow copy
refList:
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]


 == operator_=_ test ==


cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]

equalList :
~~toString~~
*_head_ptr : nullptr
_size : 0
~~NO NODE ~~
eqlList = cpyList

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]
equalList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]
Check deep copy or shallow copy

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]
equalList :
~~toString~~
*_head_ptr : 0
_size : 20
[0] ->[0] ->[1] ->[2] ->[2] ->[3] ->[4] ->[4] ->[5] ->[6] ->[6] ->[7] ->[8] ->[8] ->[9] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - -
true: copy_CTR_test finished.


 == insert_and_add_test ==

Make 2 sorted lists:
refList:
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]


cpyList adds the same value with insert_and_add:
Add [9] to cpyList. If it's duplicates, add it to the original value.
Add [8] to cpyList. If it's duplicates, add it to the original value.
Add [7] to cpyList. If it's duplicates, add it to the original value.
Add [6] to cpyList. If it's duplicates, add it to the original value.
Add [5] to cpyList. If it's duplicates, add it to the original value.
Add [4] to cpyList. If it's duplicates, add it to the original value.
Add [3] to cpyList. If it's duplicates, add it to the original value.
Add [2] to cpyList. If it's duplicates, add it to the original value.
Add [1] to cpyList. If it's duplicates, add it to the original value.
Add [0] to cpyList. If it's duplicates, add it to the original value.


Check deep copy or shallow copy
refList:
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[1] ->[2] ->[3] ->[4] ->[5] ->[6] ->[7] ->[8] ->[9] ->[nullPtr]

cpyList :
~~toString~~
*_head_ptr : 0
_size : 10
[0] ->[2] ->[4] ->[6] ->[8] ->[10] ->[12] ->[14] ->[16] ->[18] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - -
true: insert_and_add_test finished.

 =========The Program has finished safely============
*/