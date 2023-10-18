
# Work Report

## Data Structure type: <ins> Stack&Queue </ins>


# Reflections:

- This project shows my implementation skill and understanding Stack and Queue data structure in C++.

# **output**
<pre>
<br/><br/><br/><br/>

==Basic Test==
stack.push(): 
Stack top : [0] ->[nullptr]
Stack top : [1] ->[0] ->[nullptr]
Stack top : [2] ->[1] ->[0] ->[nullptr]
Stack top : [3] ->[2] ->[1] ->[0] ->[nullptr]
Stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullptr]
top of stack: 4
pop stack: 4
Stack top : [3] ->[2] ->[1] ->[0] ->[nullptr]
size of the stack: 4
is stack empty? false
stack top to bottom: 
<3> 
<2> 
<1> 
<0> 



queue.push(): 
Queue front : [0] ->[nullptr]
Queue front : [0] ->[1] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[3] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullptr]
front of queue: 0
rear of queue: 4
pop queue: 0
Queue front : [1] ->[2] ->[3] ->[4] ->[nullptr]
size of the queue: 4
is queue empty? false
queue top to bottom: 
<1> 
<2> 
<3> 
<4> 


--------- D O N E ----------------


true: basic_test finished. 


 == Stack_copy_CTR_ test ==

stack.push(): 
Stack top : [0] ->[nullptr]
Stack top : [1] ->[0] ->[nullptr]
Stack top : [2] ->[1] ->[0] ->[nullptr]
Stack top : [3] ->[2] ->[1] ->[0] ->[nullptr]
Stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullptr]

~~Push 5 times~~
Ref Object
~~toString~~
*_top : 4, _size : 5
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 

Make copy object with a copy CTR. 
 Copy Object 
~~toString~~
*_top : 4, _size : 5
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 


Check deep copy or shallow copy
Ref Object
~~toString~~
*_top : 4, _size : 5
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 

Copy Object 
~~toString~~
*_top : 4, _size : 10
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 
<4> 
<3> 
<2> 
<1> 
<0> 


 == operator_=_ test ==


cpyList : stcEql = stcCpy

stcRef : ~~toString~~
*_top : 4, _size : 5
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 


stcCpy : ~~toString~~
*_top : 4, _size : 10
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 
<4> 
<3> 
<2> 
<1> 
<0> 

stcEql : ~~toString~~
*_top : 4, _size : 10
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 
<4> 
<3> 
<2> 
<1> 
<0> 

Check deep copy or shallow copy

stcRef : ~~toString~~
*_top : 4, _size : 5
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 


stcCpy : ~~toString~~
*_top : 4, _size : 10
stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[4] ->[3] ->[2] ->[1] ->[0] ->[nullPtr]

Top to bottom
<4> 
<3> 
<2> 
<1> 
<0> 
<4> 
<3> 
<2> 
<1> 
<0> 

stcEql : ~~toString~~
*_top : 0, _size : 1
stack top : [0] ->[nullPtr]

Top to bottom
<0> 




 == Queue_copy_CTR_ test ==

stack.push(): 

~~Push 5 times~~
Ref Object
~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 

Make copy object with a copy CTR. 
 
Ref Object
~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 

Copy Object 
~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 


Check deep copy or shallow copy
Ref Object
~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 

Copy Object 
~~toString~~
*_front : 0, *_rear : 4, _size : 10
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 
<0> 
<1> 
<2> 
<3> 
<4> 


 == operator_=_ test ==


cpyList : queEql = queCpy

queRef : ~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 


queCpy : ~~toString~~
*_front : 0, *_rear : 4, _size : 10
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 
<0> 
<1> 
<2> 
<3> 
<4> 

queEql : ~~toString~~
*_front : 0, *_rear : 4, _size : 10
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 
<0> 
<1> 
<2> 
<3> 
<4> 


Check deep copy or shallow copy

queRef : ~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 


queCpy : ~~toString~~
*_front : 0, *_rear : 4, _size : 10
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 
<0> 
<1> 
<2> 
<3> 
<4> 

queEql pop 9 times

queEql : ~~toString~~
*_front : 4, *_rear : 4, _size : 1
Queue front : [4] ->[nullPtr]

Top to bottom
<4> 


 - - - - - - - -DONE - - - - - - - - - - - - 


true: copy_CTR_test finished. 


 == stack_push_ test ==

~~push 5 times~~ 
Stack top : [0] ->[nullptr]
Stack top : [1] ->[0] ->[nullptr]
Stack top : [2] ->[1] ->[0] ->[nullptr]
Stack top : [3] ->[2] ->[1] ->[0] ->[nullptr]
Stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullptr]
top of stack: 4
Stack top : [4] ->[3] ->[2] ->[1] ->[0] ->[nullptr]


 == stack_pop_ test ==


pop stack 5 times; 
Stack top : [3] ->[2] ->[1] ->[0] ->[nullptr]
Stack top : [2] ->[1] ->[0] ->[nullptr]
Stack top : [1] ->[0] ->[nullptr]
Stack top : [0] ->[nullptr]
Stack top : [nullptr]

Empty stack calls pop function: 
Stack top : [nullptr]


 - - - - - - - -DONE - - - - - - - - - - - - 
true: stack_push_test finished. 


 == Queue_enqueue_ test ==

~~enqueue 5 times~~ 
Queue front : [0] ->[nullptr]
Queue front : [0] ->[1] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[3] ->[nullptr]
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullptr]

the first node of Queue: 0
the last node of Queue: 4
~~toString~~
*_front : 0, *_rear : 4, _size : 5
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullPtr]

Top to bottom
<0> 
<1> 
<2> 
<3> 
<4> 


 == Queue_dequeue_ test ==

Start Queue: 
Queue front : [0] ->[1] ->[2] ->[3] ->[4] ->[nullptr]

Dequeue 5 times; 
Queue front : [1] ->[2] ->[3] ->[4] ->[nullptr]
Queue front : [2] ->[3] ->[4] ->[nullptr]
Queue front : [3] ->[4] ->[nullptr]
Queue front : [4] ->[nullptr]
Queue front : [nullptr]

Empty queue calls pop function: 
Queue front : [nullptr]

the first node of Queue: Empty Queue 0
the last node of Queue: Empty Queue 0
~~toString~~
*_front : nullptr, *_rear : nullptr, _size : 0
Queue front : ~~NO NODE ~~


 - - - - - - - -DONE - - - - - - - - - - - - 
true: stack_push_test finished. 

 =========The Program has finished safely============
</pre>


<br/><br/>

# basic_test.cpp output:
<pre>
<br/><br/><br/><br/>
</pre>
# testB.cpp output:
<pre>
<br/><br/><br/><br/>
</pre>


