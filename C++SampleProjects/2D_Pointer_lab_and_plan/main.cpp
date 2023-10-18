#include <iostream>
#include <iomanip>

#include "includes/lab/lab.h"
#include "includes/plane/plane.h"
#include "includes/two_d_functions/two_d_functions.h"

#include "_tests/_test_files/self_test.cpp"

using namespace std;

int main(int argv, char** argc) {
    bool debug = 1;
    cout << "\n\n"
         << endl;

    cout << boolalpha <<  basic_test_two_d_array(debug)  << ": test_operators() ************" ;
//    cout << boolalpha <<  basic_test_first_three(debug)  << ": basic_test_first_three ************" ;
//    cout << boolalpha <<  allocation_read_write_test(debug)  << ": allocation_read_write_test ************" ;
    cout << boolalpha <<  basic_test_lab(debug)  << ": basic_test_lab ************" ;
    cout << boolalpha <<  basic_test_plane(debug)  << ": basic_test_plane ************" ;


    cout << "\n\n\n=====================" << endl;
    return 0;
}


/*Sample Run*

row size( 1/4), col size(4) { -1 -1 -1 -1 }
row size( 2/4), col size(5) { -1 -1 -1 -1 -1 }
row size( 3/4), col size(3) { -1 -1 -1 }
row size( 4/4), col size(6) { -1 -1 -1 -1 -1 -1 }

row size( 1/4), col size(4) { -1 -1 -1 3 }
row size( 2/4), col size(5) { -1 -1 -1 -1 14 }
row size( 3/4), col size(3) { -1 -1 -1 }
row size( 4/4), col size(6) { -1 31 -1 -1 -1 -1 }

[0][3]: 3
[1][4]: 14
[3][1]: 31
[3][4]: 34

found 31 at: [3][1]
td[3][4] is a valid location.
td[13][4] is NOT a valid location.
td[3][14] is NOT a valid location.
---- end test two d functions ----------
true: test_operators() ************

----- basic_test_lab():
stations: size: 5, { 3, 4, 5, 1, 3 }
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 0 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 0 }
================ test login() =====================

logging in lab: <<lab<<, station <<station<<:
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 2121 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 0 }

logging in lab: <<lab<<, station <<station<<:
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 2121 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 4242 }

logging in lab: <<lab<<, station <<station<<:
login() correctly refused to log in a new user into an already occupied station
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 2121 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 4242 }
================ test login() =====================

logging out user : 6666
logout() correctly refused to log out a user who was not logged in.
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 2121 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 4242 }

logging out user: 4242
row size( 1/5), col size(3) { 0 0 0 }
row size( 2/5), col size(4) { 0 0 0 0 }
row size( 3/5), col size(5) { 0 2121 0 0 0 }
row size( 4/5), col size(1) { 0 }
row size( 5/5), col size(3) { 0 0 0 }

Deallocating two-d array 'labs'


---------- D O N E ----------
true: basic_test_lab ************print array:
size: 7, { 4, 4, 4, 4, 4, 4, 4 }
Print 2D array:
row size( 1/7), col size(4) { false false false false }
row size( 2/7), col size(4) { false false false false }
row size( 3/7), col size(4) { false false false false }
row size( 4/7), col size(4) { false false false false }
row size( 5/7), col size(4) { false false false false }
row size( 6/7), col size(4) { false false false false }
row size( 7/7), col size(4) { false false false false }
row [ 1] X X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X X X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X X


============ test reserve() =======================

reserved 1A([0][0]
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X X X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X X

reserved 4C([3][2]
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X C X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X X

reserved 7D([6][3]
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X C X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X D

reserved 7D([6][3]
   reserve() correctly refused to reserve an already occupied seat.
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X C X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X D


============ test cancel() =======================

cancelled 4D([3][3]
   cancel() correctly refused to cancel unoccupied seat.
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X C X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X D

cancelled 4C([3][2]
row [ 1] A X X X
row [ 2] X X X X
row [ 3] X X X X
row [ 4] X X X X
row [ 5] X X X X
row [ 6] X X X X
row [ 7] X X X D

Deallocating two-d array 'plane'


---------- D O N E ----------
true: basic_test_plane ************
 */