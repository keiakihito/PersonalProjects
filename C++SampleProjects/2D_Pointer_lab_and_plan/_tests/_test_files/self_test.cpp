#include <cmath>
#include <iostream>
#include <iomanip>
#include <set>
#include <vector>
#include <list>

#include "../../includes/lab/lab.h"
#include "../../includes/plane/plane.h"
#include "../../includes/two_d_functions/two_d_functions.h"

using namespace std;

bool basic_test_two_d_array(bool debug = false){

    int sizes[] = {4,5,3,6,-1};
    int **td = allocate_twod<int>(sizes);
    init_twod(td, sizes, -1);
    print_twod(td, sizes);
    write_twod(td, 0, 3, 3);
    write_twod(td, 1, 4, 14);
    write_twod(td, 3, 1, 31);
    cout << endl;
    print_twod(td, sizes);

    cout << endl;
    cout << "[0][3]: " << read_twod(td, 0, 3)<<endl;
    cout << "[1][4]: " << read_twod(td, 1, 4)<<endl;
    cout << "[3][1]: " << read_twod(td, 3, 1)<<endl;
    get_twod(td, 3, 4)= 34;
    cout << "[3][4]: "<<get_twod(td, 3, 4) << endl;
    int row, col;
    bool found = search_twod(td, sizes, 31, row, col);
    if (found){
        cout << "\nfound 31 at: [" << row << "][" << col << "]" << endl;
    }

    bool valid;
    row = 3;
    col = 4;
    valid = index_is_valid(sizes, row, col);
    if (valid){
        cout << "td[" << row << "][" << col << "] is a valid location." << endl;
    }
    else{
        cout << "td[" << row << "][" << col << "] is NOT a valid location." << endl;
    }

    row = 13;
    col = 4;
    valid = index_is_valid(sizes, row, col);
    if (valid){
        cout << "td[" << row << "][" << col << "] is a valid location." << endl;
    }
    else{
        cout << "td[" << row << "][" << col << "] is NOT a valid location." << endl;
    }

    row = 3;
    col = 14;
    valid = index_is_valid(sizes, row, col);
    if (valid){
        cout << "td[" << row << "][" << col << "] is a valid location." << endl;
    }
    else{
        cout << "td[" << row << "][" << col << "] is NOT a valid location." << endl;
    }

    td = deallocate_twod(td, 4); //4 rows

    cout << "---- end test two d functions ----------" << endl;
    return true;
}

bool basic_test_lab(bool debug = false){
    int stations[] = {3,4,5,1,3,-1};
    if (debug){
        cout << "\n\n----- basic_test_lab(): " << endl;
        cout << "stations: ";
        print_array(stations);
        cout << endl;
    }

    int** labs = init_lab(stations);
    print_twod(labs, stations);
    int lab; //row
    int station; //colmun
    int id; //key
    cout << "================ test login() =====================" << endl;

    lab = 2;
    station = 1;
    id = 2121;
    cout << "\nlogging in lab: <<lab<<, station <<station<<: " << endl;
    login(labs, lab, station, id);
    print_twod(labs, stations);

    lab = 4;
    station = 2;
    id = 4242;
    cout << "\nlogging in lab: <<lab<<, station <<station<<: " << endl;
    login(labs, lab, station, id);
    print_twod(labs, stations);

    lab = 4;
    station = 2;
    id = 6666;
    cout << "\nlogging in lab: <<lab<<, station <<station<<: " << endl;
    if(login(labs, lab, station, id)){
        cout << "FAILED: logged in (" << id << ") into an occupied  station" << endl;
    }
    else{
        cout << "login() correctly refused to log in a new user into "
             <<"an already occupied station" << endl;
    }
    print_twod(labs, stations);

    cout << "================ test login() =====================" << endl;

    id = 6666;
    cout << "\nlogging out user : "<<id << endl;
    if(logout(labs, stations, id)){
        cout << "FAILED: logged out (" << id << ") who was not logged in!" << endl;
    }
    else{
        cout << "logout() correctly refused to log out a user who was not logged in." << endl;
    }
    print_twod(labs, stations);

    id = 4242;
    cout << "\nlogging out user: "<<id << endl;
    logout(labs, stations, id);
    print_twod(labs, stations);

    cout << "\nDeallocating two-d array 'labs' " << endl;
    int size = array_size(stations);
    labs = deallocate_twod(labs, size);
    cout << "\n\n---------- D O N E ----------" << endl;
    return true;
}


bool basic_test_plane(bool debug = false){

    bool** plane = init_plane();
    print_plane(plane);
    int row;
    int seat;
    cout << "\n\n============ test reserve() =======================" << endl;
    row  = 0;
    seat = 0;
    cout << "\nreserved "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    reserve(plane, row, seat);
    print_plane(plane);

    row  = 3;
    seat = 2;
    cout << "\nreserved "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    reserve(plane, row, seat);
    print_plane(plane);

    row  = 6;
    seat = 3;
    cout << "\nreserved "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    reserve(plane, row, seat);
    print_plane(plane);

    row  = 6;
    seat = 3;
    cout << "\nreserved "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    if(reserve(plane, row, seat)){
        cout << "  FAIL: this seat was occupied!" << endl;
    }
    else{
        cout<<"   reserve() correctly refused to reserve an already occupied seat."<<endl;
    }
    print_plane(plane);


    cout << "\n\n============ test cancel() =======================" << endl;
    row = 3;
    seat = 3;
    cout << "\ncancelled "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    if(cancel(plane, row, seat)){
        cout << "  FAIL: this seat was not occupied, but canceled!" << endl;
    }
    else{
        cout<<"   cancel() correctly refused to cancel unoccupied seat."<<endl;
    }
    print_plane(plane);

    row  = 3;
    seat = 2;
    cout << "\ncancelled "<<row+1<<char('A'+seat)<< "(["<<row<<"]["<<seat<<"]" << endl;
    cancel(plane, row, seat);
    print_plane(plane);

    cout << "\nDeallocating two-d array 'plane' " << endl;
    plane = deallocate_twod(plane, 7);
    cout << "\n\n---------- D O N E ----------" << endl;
    return true;
    return true;
}

bool basic_test_first_three(bool debug = false) {

    cout << "\n\n----------first_three_functions_test ----------------" << endl;

    int* sizes = new int [5];
    int* wkPtr = sizes;
    *wkPtr = 4; wkPtr++;
    *wkPtr = 5; wkPtr++;
    *wkPtr = 3; wkPtr++;
    *wkPtr = 6; wkPtr++;
    *wkPtr = -1;

    cout << "print_array : ";
    print_array(sizes);

    int arrSize = array_size(sizes);
    cout << "\narray_size: size is (" << arrSize << ")" << endl;

    cout << "\n\nindex_is_valid" << endl;

    cout << "[0][0] : supposed to true"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 0, 0);

    cout << endl<<"\n[0][3] : supposed to true"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 0, 3);

    cout << endl<<"\n[0][4] : supposed to false"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 0, 4);

    cout << endl<<"\n[1][4] : supposed to true"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 1, 4);

    cout << endl<<"\n[1][5] : supposed to false"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 1, 5);

    cout << endl<<"\n[2][2] : supposed to true"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 2, 2);

    cout << endl<<"\n[2][3] : supposed to false"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 2, 3);

    cout << endl<<"\n[3][5] : supposed to true"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 3, 5);

    cout << endl<<"\n[3][6] : supposed to false"<< endl;
    cout << "result : "<<boolalpha<<index_is_valid(sizes, 3, 6);

    delete[] sizes;

    cout << "\n\n----------end of the test ----------------" << endl;
    return  true;
}

bool allocation_read_write_test(bool debug = false) {

    cout << "\n\n----------allocation_read_write_test ----------------" << endl;
    int* sizes = new int [5];
    int* wkPtr = sizes;
    *wkPtr = 4; wkPtr++;
    *wkPtr = 5; wkPtr++;
    *wkPtr = 3; wkPtr++;
    *wkPtr = 6; wkPtr++;
    *wkPtr = -1;

    cout << "print_array : ";
    print_array(sizes);

    int arrSize = array_size(sizes);
    cout << "\narray_size: size is (" << arrSize << ")" << endl;



    int** dblPtr = allocate_twod<int>(sizes);

    //init
    cout<< "\n==init_twod==\n";
    init_twod(dblPtr, sizes, 0);

    cout<< "\n==print_twod==\n";
    print_twod(dblPtr,sizes);


    cout <<"\n==write_twod==\n";
    int item = 5;
    cout<< "\nInsert 5 item [0][0]"<<endl;
    write_twod(dblPtr, 0,0, 5);
    print_twod(dblPtr,sizes);

    cout<< "\nInsert 5 item [3][5]"<<endl;
    write_twod(dblPtr, 3,5, 5);
    print_twod(dblPtr,sizes);

//Read test
    cout <<endl<<"\n==read_twod==\n";
    cout<< "\nRead item [0][0]"<<endl;
    int result = read_twod(dblPtr, 0,0);
    cout << "Supposed to 5,  result :" << result<< endl;

    cout<< "\nRead 5 item [3][5]"<<endl;
    result = read_twod(dblPtr, 3,5);
    cout << "Supposed to 5,  result :" << result << endl << endl;



    //Search_test
    cout <<endl<<"\n==search_twod==\n";
    cout<< "\nInsert 31 item [2][2]"<<endl;
    write_twod(dblPtr, 2,2, 31);
    print_twod(dblPtr,sizes);

    cout<< "\nInsert 29 item [3][4]"<<endl;
    write_twod(dblPtr, 3,4, 29);
    print_twod(dblPtr,sizes);

    cout << "print_array : ";
    print_array(sizes);

    int row = 0;
    int col = 0;
    bool found = search_twod(dblPtr, sizes, 31, row, col);
    if (found){
        cout << "\nfound 31 at: [" << row << "][" << col << "]" << endl;
        cout << "supposed to [2][2]"<< endl;
    }

    found = search_twod(dblPtr, sizes, 29, row, col);
    if (found){
        cout << "\nfound 29 at: [" << row << "][" << col << "]" << endl;
        cout << "supposed to [3][4]\n"<< endl;
    }

    //Deallocate
    dblPtr = deallocate_twod(dblPtr, 4);
    delete[] sizes;
    delete[] dblPtr;

    cout << "\n\n----------end of the test ----------------" << endl;
    return true;
}
