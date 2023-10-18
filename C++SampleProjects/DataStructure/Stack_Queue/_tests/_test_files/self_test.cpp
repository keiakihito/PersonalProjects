#include <iostream>
#include <iomanip>


#include "../../includes/node/node.h"
#include "../../includes/linked_list_functions/linked_list_functions.h"
#include "../../includes/queue/MyQueue.h"
#include "../../includes/stack/MyStack.h"

using namespace std;

bool basic_test(bool debug = false)
{
    Stack<int> s;
    Queue<int> q;
    cout << "stack.push(): " << endl;
    for (int i = 0; i < 5; i++)
    {
        s.push(i);
        cout << s << endl;
    }
    cout << "top of stack: " << s.top() << endl;
    cout << "pop stack: " << s.pop() << endl;
    cout << s << endl;
    cout << "size of the stack: " << s.size() << endl;
    cout << "is stack empty? " << boolalpha << s.empty() << endl;
    Stack<int>::Iterator s_it = s.begin();
    cout << "stack top to bottom: " << endl;
    for (; s_it != s.end(); s_it++)
    {
        cout << "<" << *s_it << "> " << endl;
    }
    cout << "\n\n" << endl;

    cout << "queue.push(): " << endl;
    for (int i = 0; i < 5; i++)
    {
        q.push(i);
        cout << q << endl;
    }
    cout << "front of queue: " << q.front() << endl;
    cout << "rear of queue: " << q.back() << endl;
    cout << "pop queue: " << q.pop() << endl;
    cout << q << endl;
    cout << "size of the queue: " << q.size() << endl;
    cout << "is queue empty? " << boolalpha << q.empty() << endl;
    Queue<int>::Iterator q_it = q.begin();
    cout << "queue top to bottom: " << endl;
    for (; q_it != q.end(); q_it++)
    {
        cout << "<" << *q_it << "> " << endl;
    }

    cout << "\n\n--------- D O N E ----------------\n\n" << endl;
    return true;
}

/*
build git:(master) ✗  😊 $> tree ../includes
../includes
├── linked_list_functions
│   └── linked_list_functions.h
├── node
│   ├── bogus.txt
│   └── node.h
├── queue
│   ├── MyQueue.h
└── stack
    └── MyStack.h
4 directories, 5 files
build git:(master) ✗  😊 $> ./bin/basic_test
----------running testA.cpp---------
[==========] Running 1 test from 1 test case.
[----------] Global test environment set-up.
[----------] 1 test from ITERATED_LIST
[ RUN      ] ITERATED_LIST.TestInsertHead
stack.push():
Stack:Head->[0]-> |||
Stack:Head->[1]-> [0]-> |||
Stack:Head->[2]-> [1]-> [0]-> |||
Stack:Head->[3]-> [2]-> [1]-> [0]-> |||
Stack:Head->[4]-> [3]-> [2]-> [1]-> [0]-> |||
top of stack: 4
pop stack: 4
Stack:Head->[3]-> [2]-> [1]-> [0]-> |||
size of the stack: 4
is stack empty? false
stack top to bottom:
<3>
<2>
<1>
<0>
queue.push():
Queue:Head->[0]-> |||
Queue:Head->[0]-> [1]-> |||
Queue:Head->[0]-> [1]-> [2]-> |||
Queue:Head->[0]-> [1]-> [2]-> [3]-> |||
Queue:Head->[0]-> [1]-> [2]-> [3]-> [4]-> |||
front of queue: 0
rear of queue: 4
pop queue: 0
Queue:Head->[1]-> [2]-> [3]-> [4]-> |||
size of the queue: 4
is queue empty? false
queue top to bottom:
<1>
<2>
<3>
<4>
--------- D O N E ----------------
[       OK ] ITERATED_LIST.TestInsertHead (0 ms)
[----------] 1 test from ITERATED_LIST (0 ms total)
[----------] Global test environment tear-down
[==========] 1 test from 1 test case ran. (0 ms total)
[  PASSED  ] 1 test.
build git:(master) ✗  😊 $>
*/


bool big_three_test(bool debug = false)
{
    cout << "\n\n == Stack_copy_CTR_ test ==\n" << endl;
    Stack<int> stcRef;
    Stack<int>::Iterator stc_Itr = nullptr;


    //Fill lists
    cout << "stack.push(): " << endl;
    for (int i = 0; i < 5; i++)
    {
        stcRef.push(i);
        cout << stcRef << endl;
    }

    cout << "\n~~Push 5 times~~"<< endl;

    cout << "Ref Object"<< endl;
    stcRef.to_string();

    cout << "\nMake copy object with a copy CTR. \n ";
    Stack<int> stcCpy(stcRef);
    cout << "Copy Object " <<endl;
    stcCpy.to_string();


    //Check deep copy or shallow copy
    for (int i = 0; i <5; i++){
        stcCpy.push(i);
    }


    cout <<endl <<"\nCheck deep copy or shallow copy" << endl;
    cout << "Ref Object"<< endl;
    stcRef.to_string();

    cout << "\nCopy Object " <<endl;
    stcCpy.to_string();


    cout << "\n\n == operator_=_ test ==\n";
    Stack<int> stcEql;
    cout << endl<<"\ncpyList : ";

    stcEql = stcCpy;

    cout << "stcEql = stcCpy" << endl;

    cout << "\nstcRef : ";
    stcRef.to_string();

    cout << endl<<"\nstcCpy : ";
    stcCpy.to_string();

    cout << "\nstcEql : ";
    stcEql.to_string();


    //Check deep copy or shallow copy
    for (int i = 0; i < 9; i++){
        stcEql.pop();
    }

    cout << "\nCheck deep copy or shallow copy" << endl;
    cout << "\nstcRef : ";
    stcRef.to_string();

    cout << endl<<"\nstcCpy : ";
    stcCpy.to_string();


    cout << "\nstcEql : ";
    stcEql.to_string();




    //Queue test
    cout << "\n\n\n\n == Queue_copy_CTR_ test ==\n" << endl;
    Queue<int> queRef;
    Queue<int>::Iterator que_itr = nullptr;

    //Fill lists
    cout << "stack.push(): " << endl;
    for (int i = 0; i < 5; i++)
    {
        queRef.push(i);
    }

    cout << "\n~~Push 5 times~~"<< endl;
    cout << "Ref Object"<< endl;
    queRef.to_string();


    cout << "\nMake copy object with a copy CTR. \n ";
    Queue<int> queCpy(queRef);
    cout << "\nRef Object"<< endl;
    queRef.to_string();


    cout << "\nCopy Object " <<endl;
    queCpy.to_string();


    //Check deep copy or shallow copy
    for (int i = 0; i <5; i++)
    {
        queCpy.push(i);
    }


    cout <<endl <<"\nCheck deep copy or shallow copy" << endl;
    cout << "Ref Object"<< endl;
    queRef.to_string();

    cout << "\nCopy Object " <<endl;
    queCpy.to_string();




    cout << "\n\n == operator_=_ test ==\n";
    Queue<int> queEql;
    cout << endl<<"\ncpyList : ";

    queEql = queCpy;

    cout << "queEql = queCpy" << endl;

    cout << "\nqueRef : ";
    queRef.to_string();

    cout << endl<<"\nqueCpy : ";
    queCpy.to_string();

    cout << "\nqueEql : ";
    queEql.to_string();




    //Check deep copy or shallow copy
    for (int i = 0; i < 9; i++)
    {
        queEql.pop();
    }

    cout << "\n\nCheck deep copy or shallow copy" << endl;
    cout << "\nqueRef : ";
    queRef.to_string();

    cout << endl<<"\nqueCpy : ";
    queCpy.to_string();

    cout << "\nqueEql pop 9 times" << endl;
    cout << "\nqueEql : ";
    queEql.to_string();



    cout <<"\n\n - - - - - - - -DONE - - - - - - - - - - - - \n\n" << endl;
    return true;
}


bool stack_push_pop_test(bool debug = false)
{
    cout << "\n\n == stack_push_ test ==\n" << endl;
    Stack<int> s;

    //Fill lists
    cout << "~~push 5 times~~ " << endl;
    for (int i = 0; i < 5; i++)
    {
        s.push(i);
        cout << s << endl;
    }
    cout << "top of stack: " << s.top() << endl;
    cout << s << endl;

    cout << "\n\n == stack_pop_ test ==\n" << endl;
    cout << "\npop stack 5 times; " << endl;
    for (int i = 0; i < 5; ++i) {
        s.pop();
        cout << s << endl;
    }

    cout << "\nEmpty stack calls pop function: " << endl;
    s.pop();
    cout << s << endl;


    cout <<endl<<"\n - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}


bool queue_enqueue_and_dequeue_test(bool debug = false)
{
    cout << "\n\n == Queue_enqueue_ test ==\n" << endl;
    Queue<int> q;

    //Fill lists
    cout << "~~enqueue 5 times~~ " << endl;
    for (int i = 0; i < 5; i++){
        q.push(i);
        cout << q << endl;
    }
    cout << "\nthe first node of Queue: " << q.front() << endl;
    cout << "the last node of Queue: " << q.back() << endl;
    q.to_string();

    cout << "\n\n == Queue_dequeue_ test ==\n" << endl;
    cout <<"Start Queue: " << endl;
    cout << q << endl;
    cout << "\nDequeue 5 times; " << endl;
    for (int i = 0; i < 5; ++i) {
        q.pop();
        cout << q << endl;
    }

    cout << "\nEmpty queue calls pop function: " << endl;
    q.pop();
    cout << q << endl;

    cout << "\nthe first node of Queue: " << q.front() << endl;
    cout << "the last node of Queue: " << q.back() << endl;
    q.to_string();

    cout <<endl<<"\n - - - - - - - -DONE - - - - - - - - - - - - " << endl;
    return true;
}



