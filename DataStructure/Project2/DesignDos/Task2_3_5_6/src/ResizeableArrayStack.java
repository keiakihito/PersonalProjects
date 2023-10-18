/**
 File Name: ResizeableArrayStack.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class realizes the Resizeable array stack data collection.
 It handles the resizeable array objects to evaluate post fix notation and get result..
 Last update: 04/3/2023
 */

import java.util.Arrays;


public class ResizeableArrayStack<T> implements StackInterface<T>
{
    private  T[] _stack;
    private int _capacity; //Max number of elements
    private int _topIdx; // Index of top entry
    private static final int DEFAULT_CAPACITY = 5;

    //Default CTR, provide default capacity if the capacity is not provided.
    public ResizeableArrayStack(){this(DEFAULT_CAPACITY);}

    public ResizeableArrayStack(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[initialCapacity];
        _stack = tempStack; //_bag references to Object array
        _topIdx = -1; // -1 means no item in the array
        _capacity = initialCapacity; // Set maximum capacity
    }

    @Override
    public void push(T newEntry)
    {
        //When the stack is full, resize the array.
        if(isFull()){
            doubleCapacity();
        }
        _stack[_topIdx + 1] = newEntry;
        _topIdx++;
    }

    @Override
    public T pop() {

        //When the stack doesn't have any entry, it does not do anything
        if(isEmpty()){return null;}

        //Get the last index item and store return element
        //After store returning data, replace with null to erase the item
        //Make sure the current top index.
        T dltdItem = _stack[_topIdx];
        _stack[_topIdx] = null;
        _topIdx--;

        return dltdItem;
    }

    @Override
    public T getPeek()
    {
        //When the stack is empty no return
        //It return the last index item as a top of the stack
        if(isEmpty()) {return null;}

        return _stack[_topIdx];
    }

    @Override
    public boolean isEmpty() {
        return _topIdx == -1;
    }

    @Override
    public void clear()
    {
        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (_topIdx > -1)
        {
            _stack[_topIdx] = null;
            _topIdx--;
        }

        assert _topIdx == -1: "After the clear() method, top index should be -1";
    }

    /**
    Check the array capacity is full or not.
    @Return boolean
    */
    public boolean isFull()
    {
        //top index + 1 equals to the number of elements in array
        //Ex capacity : 5, top index 4 means the last available space is taken, which is full
        return (_capacity == _topIdx+1);
    }


    /**
     Reallocate array when it is full of index with double capacity
     */
    public void doubleCapacity()
    {
        //Calculate 2 times of current capacity and resize the original array
        //Elements are the same, and it is shallow copy
        //Update capacity size
        int newCapacity = 2 * _capacity;
        _stack = Arrays.copyOf(_stack, newCapacity);
        _capacity = newCapacity;
    }

    @Override
    public String toString() {
        return "ResizeableArrayStack{" +
                "_stack=" + Arrays.toString(_stack) +
                ", _capacity=" + _capacity +
                ", _topIdx=" + _topIdx +
                '}';
    }

    public void printStack()
    {
        if(isEmpty())
        {
            System.out.println("<null>");
        }else{
            for (int i = _topIdx; i >= 0; i--){
                System.out.print("<");
                System.out.print(_stack[i]);
                System.out.print(">\n");
            }
        }
    }
    /**
     Evaluate post fix notation, and calculate to get the result
     @Param String post fix notation
     @Return int calculation result
     */
    public int evaluatePostfix(String pstFix)
    {
        /*
        Convert inFix string  to scanner token to extract operand and operator
        loop until the scanner walker  reaches the end of the inFix string
        if the walker is an operator push operand to valStack
        if the walker is an operand call the caseOfOperand
        else ignore the exception, and continue iterates
        */
        ResizeableArrayStack<Integer> valStack = new ResizeableArrayStack<>();

//        //Convert inFix string  to scanner token to extract operand and operator
//        Scanner pstFixTkn = new Scanner(pstFix);
        Character wlkr = ' ';
        int variable = 0;
        int result = 0;

        //loop until the walker reaches the end of the postFix string
        //if the walker is an operator push corresponding operand to valStack
        //if the walker is an operand call the caseOfOperand
        //else ignore the exception, and continue iterates

        for (int i = 0; i < pstFix.length(); i++ ){
            wlkr = pstFix.charAt(i);
            //Case of integer
            if(isCharacter(wlkr)) {
                variable = convertCharacter(wlkr); //Convert integer to corresponding value
                valStack.push(variable); //Store integer to value stack for later calculation
            }
            //Case of operator
            else if (isOperator(wlkr)){
                    caseOfOperator(wlkr,valStack);
            }else{
                    //Ignore exception
                    continue;
            }
        }

        //Get peek of the value stack as a calculation result and return as integer value
        result = valStack.getPeek();
        valStack.pop();
        assert valStack.isEmpty() : "After calculation, there should be only one variable as a result";
        return result;
    } // end of evaluatePostfix


    /**
     Check the given walker token is one of the basic operators or not
     @Param Character walker token
     @Return boolean
     */
    public boolean isOperator(Character wlkr){
        return (wlkr.equals('+') || wlkr.equals('-') || wlkr.equals('*') || wlkr.equals('/') || wlkr.equals('^'));
    }

    /**
     Check the given walker token is one of given variable
     @Param Character walker token
     @Return boolean
     */
    public boolean isCharacter(Character wlkr){
        return (wlkr.equals('a') || wlkr.equals('b') || wlkr.equals('c') || wlkr.equals('d') || wlkr.equals('e'));
    }

    /**
     Convert the given walker token to corresponding integers
     @Param Character walker token
     @Return integer
     */
    public int convertCharacter(Character wlkr){
        int convertInt = 0;

        if(wlkr.equals('a')){ convertInt = 2; return convertInt;}
        if(wlkr.equals('b')){ convertInt = 3; return convertInt;}
        if(wlkr.equals('c')){ convertInt = 4; return convertInt;}
        if(wlkr.equals('d')){ convertInt = 5; return convertInt;}
        if(wlkr.equals('e')){ convertInt = 6; return convertInt;}

        else{convertInt = 0; } // Ignore error case;

        return convertInt;
    }


    /**
     The method pops two operand from value stack and calculate with a operator token
     @Param Character  operator, ResizeableArrayStack value stack
     */
    public void caseOfOperator(Character oprtr, ResizeableArrayStack<Integer> valStack)
    {
        /*
        Get peek from valStack, Store peek to oprnd2 and PopValStack.
        Get peek from valStack, Store peek to oprnd1, and PopValStack
        Calculate oprnd1 and oprnd2 with wlkr
        Push result to valStack
         */

        int oprnd2 = (int)valStack.getPeek();
        valStack.pop();
        int oprnd1 = (int)valStack.getPeek();
        valStack.pop();

        valCalculate(oprnd1, oprnd2, oprtr, valStack);

    }

    /**
     The method receives two operands and calculate with an operator token.
     After calculation, the result is pushed to the value stack
     @Param String operator, ResizeableArrayStack value stack
     */
    public void valCalculate(int oprnd1, int oprnd2, Character oprtr, ResizeableArrayStack<Integer> valStack)
    {
        /*
        Get peek from valStack, Store peek to oprnd2 and PopValStack.
        Get peek from valStack, Store peek to oprnd1, and PopValStack
        Calculate oprnd1 and oprnd2 with wlkr
        Push result to valStack
         */

        int result = 0;

        if(oprtr.equals('+')){
            result = oprnd1 + oprnd2;}
        else {}
        if(oprtr.equals('-')){
            result = oprnd1 - oprnd2;}
        else {}
        if(oprtr.equals('*')){
            result = oprnd1 * oprnd2;}
        else {}
        if(oprtr.equals('/')){
            result = oprnd1 / oprnd2;}
        else {}
        if(oprtr.equals('^')){
            result = 1;
            for (int power = oprnd2; power != 0; power--) {
                result = result * oprnd1;
            }
        }
        else {}

        //Store calculation result to valStack
        valStack.push(result);
    }


} // End of ResizeableArrayStack
