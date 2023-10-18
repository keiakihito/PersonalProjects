#include <iostream>

#include "_tests/_test_files/self_test.cpp"

using namespace std;
int main() {
    bool debug = 0;
    cout << boolalpha <<basic_test(debug) <<": basic_test finished. " <<  endl;
    cout << boolalpha <<CTR_test(debug) <<": CTR_test finished. " <<  endl;
    cout << boolalpha <<insert_test(debug) <<": insert_test finished. " <<  endl;
    cout << boolalpha <<copy_CTR_test(debug) <<": copy_CTR_test finished. " <<  endl;
    cout << boolalpha <<delete_node_test(debug) <<": copy_and_clear_test finished. " <<  endl;
    return 0;
}

/* Sample Run

list.empty(): true
[100] ->[1] ->[10] ->[nullptr]
[200] ->[2] ->[20] ->[100] ->[1] ->[10] ->[nullptr]
[300] ->[3] ->[30] ->[200] ->[2] ->[20] ->[100] ->[1] ->[10] ->[nullptr]
[400] ->[4] ->[40] ->[300] ->[3] ->[30] ->[200] ->[2] ->[20] ->[100] ->[1] ->[10] ->[nullptr]
[500] ->[5] ->[50] ->[400] ->[4] ->[40] ->[300] ->[3] ->[30] ->[200] ->[2] ->[20] ->[100] ->[1] ->[10] ->[nullptr]
found 4: 4
previous to 4: 400
deleted the prev: [500] ->[5] ->[50] ->[4] ->[40] ->[300] ->[3] ->[30] ->[200] ->[2] ->[20] ->[100] ->[1] ->[10] ->[nullptr]

iterating all the nodes: 
500 5 50 4 40 300 3 30 200 2 20 100 1 10 
list.empty(): false


-------- DONE ---------


true: basic_test finished. 
 == CTR_ test ==

listRfnce : [nullptr]


 == insert_head_ test ==

After insert_head
refList : listRfnce : [9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullptr]
to_string : _size : 10
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - - 
true: CTR_test finished. 


 == insert_head_ test ==

Creat an object with a default CTR
refList : [nullptr]
After insert_head
refList : listRfnce : [90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullptr]
to_string : _size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
 

== insert_before_ test ==

refList : [90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullptr]
After insert_before
refList : refList : [95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullptr]
to_string : _size : 20
[95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]


 == insert_after_ test ==

[nullptr]After insert_before
refList : refList : [90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullptr]
to_string : _size : 19
[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]


 == insert_sorted_ test ==

Creat an object with a default CTR
refListSrtd : [nullptr]
refLisSrtd : [0] ->[10] ->[20] ->[30] ->[40] ->[50] ->[60] ->[70] ->[80] ->[90] ->[100] ->[nullptr]
After insert_sorted
refListStr : [0] ->[5] ->[10] ->[15] ->[20] ->[25] ->[30] ->[35] ->[40] ->[45] ->[50] ->[55] ->[60] ->[65] ->[70] ->[75] ->[80] ->[85] ->[90] ->[95] ->[100] ->[105] ->[nullptr]
to_string : _size : 22
[0] ->[5] ->[10] ->[15] ->[20] ->[25] ->[30] ->[35] ->[40] ->[45] ->[50] ->[55] ->[60] ->[65] ->[70] ->[75] ->[80] ->[85] ->[90] ->[95] ->[100] ->[105] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - - 
true: insert_test finished. 


 == copy_CTR_ test ==

cpyList(refList) Copy CTR check: 
refList: _size : 10
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

cpyList : _size : 10
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]


Check deep copy or shallow copy
refList: _size : 10
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

cpyList : _size : 20
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]


 == operator_=_ test ==

cpyList : _size : 20
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
equalList : _size : 0
~~NO NODE ~~
eqlList = cpyList

cpyList : _size : 20
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
equalList : _size : 20
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
Check deep copy or shallow copy

cpyList : _size : 20
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
equalList : _size : 30
[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[9] ->[8] ->[7] ->[6] ->[5] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - - 
true: copy_CTR_test finished. 
 == Delete_test ==

refList : _size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
cpyList : _size : 20
[95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]
equalList : _size : 20
[95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]


~~Delete nodes cpyList, First round~~

Original refList :
_size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
cpyList : _size : 20
[95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]

After delete_node loop, cpyList : 
_size : 10
[95] ->[85] ->[75] ->[65] ->[55] ->[45] ->[35] ->[25] ->[15] ->[5] ->[nullPtr]


~~Delete node cpyList, Second round~~

Original refList :
_size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
Current cpyList: _size : 10
[95] ->[85] ->[75] ->[65] ->[55] ->[45] ->[35] ->[25] ->[15] ->[5] ->[nullPtr]

Original refList:
_size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]

After delete node loop, cpyList : 
_size : 0
~~NO NODE ~~


~~Delete node test equalList, Third round~~

Original refList:
_size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
equalList : _size : 20
[95] ->[90] ->[85] ->[80] ->[75] ->[70] ->[65] ->[60] ->[55] ->[50] ->[45] ->[40] ->[35] ->[30] ->[25] ->[20] ->[15] ->[10] ->[5] ->[0] ->[nullPtr]

After loop delete node, eqlList: 
_size : 0
~~NO NODE ~~

Original refList:
_size : 10
[90] ->[80] ->[70] ->[60] ->[50] ->[40] ->[30] ->[20] ->[10] ->[0] ->[nullPtr]
 - - - - - - - -DONE - - - - - - - - - - - - 
true: copy_and_clear_test finished. 
*/
