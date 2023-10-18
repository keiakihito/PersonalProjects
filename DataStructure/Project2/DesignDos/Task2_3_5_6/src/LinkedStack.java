/**
 File Name: LinkedStack.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class realizes the linked list stack data collection.
 It handles the linked list objects to convert infix notation to post fix notation.
 Last update: 03/17/2023
 */

//import java.util.Stack;
//import java.util.Scanner;

public class LinkedStack <T>implements StackInterface<T>
{
    private Node _head;


    public LinkedStack()
    {
        _head = null;
    }
    @Override
    public void push(T newEntry)
    {
        //Create temporary pointer points to  avoid losing all the nodes
        //Create new node with new entry, then link the new head in front of the old first node
        //Lastly _head points to the new Node, which becomes the new first node.
        Node tempHead = _head;
        Node newNode = new Node (newEntry);
        newNode.set_next(tempHead);
        _head = newNode; // _head points to the new first node
    }

    @Override
    public T pop()
    {
        if(isEmpty()) {return null;}
        //Store the top item to return and user can see which item is popped
        //Make a walker to point to the second node
        //Now walker connects to the _head, and became as a new top node
        //Garbage collector deleted the old first node
        T topItm = getPeek();
        Node wkPtr = _head;
        wkPtr = wkPtr.get_next();
        _head = wkPtr;

        return topItm; // Deleted item
    }

    @Override
    public T getPeek()
    {
        if (isEmpty()){return null;}
        return _head.get_data();
    }

    @Override
    public boolean isEmpty()
    {
        return _head == null;
    }

    @Override
    public void clear()
    {
        _head = null;
    }


    public String toString() {
        System.out.print("\ntoString : ");
        Node wkPtr = _head; // Set walker reference to traverse all nodes.
        while(wkPtr != null){
            System.out.print("[");
            System.out.print(wkPtr.get_data());
            System.out.print("]->");
            wkPtr = wkPtr.get_next();
        }
        System.out.print("[^]");
        return "";
    }

    public void printStack()
    {
        System.out.println("\n ~~~Stack representation~~~");
        if (isEmpty()){
            System.out.println("~~No Nodes~~");
        }else{
            Node wkPtr = _head;

            while(wkPtr != null){
                System.out.print("<");
                System.out.print(wkPtr.get_data());
                System.out.println(">");
                wkPtr = wkPtr.get_next();
            }
        }

    }

    /**
     Convert  in fix notation, to convert to post fix notation
     @Param String  infix notation
     @Return LinkedStack post fix notation
     */
    public LinkedStack<T> convertToPostfix(String inFix){
        LinkedStack<T> pstFix = new LinkedStack<>();
        LinkedStack<T> opStack = new LinkedStack<>();

        this.iteration(inFix, pstFix, opStack);
        this.postIteration(pstFix, opStack);

        return pstFix;
    }

    /**
     Convert  in fix notation, to convert to post fix notation
     @Param String  infix notation, LinkedStack post fix, LikedStack operator stack
     */
    public void iteration(String inFix, LinkedStack<T> pstFix, LinkedStack<T> opStack)
    {
        //Convert inFix string  to scanner token to extract operand and operator
        Character wlkr;

        for (int idx = 0; idx < inFix.length(); idx++){
            wlkr = inFix.charAt(idx);
            if (wlkr.equals(' ')){continue;} //Skip ' ', space
            if (this.isVariable(wlkr)){
                caseOfAlpha(wlkr,pstFix);
            } else if (isPower(wlkr)) {
                caseOfPower(wlkr,opStack);
            } else if (isOperator(wlkr)) {
                caseOfOperator(wlkr,pstFix,opStack);
            } else if (isLeftParenthesis(wlkr)) {
                caseOfLeftParenthesis(wlkr,opStack);
            } else if (isRightParenthesis(wlkr)) {
                caseOfRightParenthesis(pstFix, opStack);
            }else{
                System.out.println(wlkr +  "\n\n!!Error unexpected character!!\n\n");
                break; // ignore unexpected character
            }
        }
    }

    /**
     Convert  in fix notation, to convert to post fix notation
     @Param LinkedStack  post fix notation stack, LinkedStack operator stack
     @Return LinkedStack post fix notation
     */
    public LinkedStack<T> postIteration(LinkedStack<T>pstFix, LinkedStack<T> opStack)
    {
        /*
         Check operator stack is empty or not
         Set loop
            Get peek from operator stack and set it as a top operator
            Pop opeartor stack
            Push top operator to the post fix stack
         when the operator stack is empty get out of the loop
         */
        Character topOprtr = ' ';
        while(!opStack.isEmpty()){
            topOprtr = (Character) opStack.getPeek();
            opStack.pop();
            pstFix.push((T)topOprtr);
        }

        return pstFix;
    }

    /**
    Check given string is variable or operator
    @Param String walker, LinkedStack postfix stack
    @return boolean
    */
    public boolean isVariable(Character wlkr)
    {
        //Check the given string is in the range of regular expression or not
        return (Character.isAlphabetic(wlkr) || Character.isDigit(wlkr));
    }

    /**
     Add variable to post fix stack  to represent post fix notation
     @Param String walker, LinkedStack postfix stack
     */
    public void caseOfAlpha(Character wlkr, LinkedStack<T> pstFix)
    {
        pstFix.push((T) wlkr);
    }

    /**
     Check given string is ^ or operator
     @Param String walker, LinkedStack postfix stack
     @return boolean
     */
    public boolean isPower(Character wlkr)
    {
        return (wlkr.equals('^'));
    }

    /**
     Add "^" to post fix stack  to represent post fix notation
     @Param String walker, LinkedStack postfix stack
     */
    public void caseOfPower(Character wlkr, LinkedStack<T>opStack)
    {
        opStack.push((T) wlkr);
    }

    /**
     Check the walker token is one of the basic operators or not
     @Param Character walker token
     @Return boolean
     */
    public boolean isOperator(Character wlkr){
        return (wlkr.equals('+') || wlkr.equals('-') || wlkr.equals('*') || wlkr.equals('/'));
    }

    /**
     Compare the walker token and peek of operator stack and decides when the walker token goes to operator stack
     @Param Character walker token, LinkedStack post fix, LinkedStack operator stack
     */
    public void caseOfOperator(Character wlkr, LinkedStack<T> pstFix, LinkedStack<T> opStack)
    {
        /*
        Check the operator stack is empty or not
        Set loop
            get peek from operator stack
            give value to walker and peek
            compare the values
                if(walker <= peek from operator stack)
                    peek is pushed to post fix stack
                    Pop operator stack
                else
                    exit loop
        After the loop, it pushes the walker to operator stack.
        */
        boolean isWeak = true;
        int wlkrVal = 0;
        int opVal = 0;
        while(!opStack.isEmpty() && isWeak)
        {
            wlkrVal = this.giveValue(wlkr);
            opVal = this.giveValue((Character)opStack.getPeek());
            if(this.isWeaker(wlkrVal,opVal)){
                pstFix.push(opStack.getPeek());
                opStack.pop();
            }else{
                isWeak = false;
            }
        }
        opStack.push((T)wlkr);
    }

    /**
    Give a corresponding value to the walker token
     @Param Character walker token
     @Return int value of opeartor
     */
    public int giveValue(Character wlkr)
    {
        //Assign corresponding value to each operator to compare priority later
        int valOfOprtr = 0;

        if (wlkr.equals('(') || wlkr.equals(')')){
            valOfOprtr = 0;
        } else if (wlkr.equals('+') || wlkr.equals('-')) {
            valOfOprtr = 1;
        } else if (wlkr.equals('*') || wlkr.equals('/')) {
            valOfOprtr = 2;
        } else if (wlkr.equals('^')) {
            valOfOprtr = 3;
        } else{ //This is the case of error
            valOfOprtr = -1;
        }

        //The value is used for comparison operators
        return valOfOprtr;
    }

    /**
     Check the walker token is weaker compared to the peek of the stack operator
     @Param int walker value, int stack operator value
     @Return boolean
     */
    public boolean isWeaker(int wlkrVal, int stackOpVal)
    {
        return (wlkrVal <= stackOpVal);
    }

    /**
     Check given string is ( or operator
     @Param String walker, LinkedStack postfix stack
     @return boolean
     */
    public boolean isLeftParenthesis(Character wlkr)
    {
        return (wlkr.equals('('));
    }

    /**
     Add "(" to post fix stack  to represent post fix notation
     @Param String walker, LinkedStack postfix stack
     */
    public void caseOfLeftParenthesis(Character wlkr, LinkedStack<T> opStack)
    {
        opStack.push((T) wlkr);
    }

    /**
     Check given string is ) or operator
     @Param String walker, LinkedStack postfix stack
     @return boolean
     */
    public boolean isRightParenthesis(Character wlkr){
        return (wlkr.equals(')'));
    }

    /**
     The method pushes operator to the post fix stack
     @Param LinkedStack postfix stack. LinkedStack operator stack
     */
    public void caseOfRightParenthesis(LinkedStack<T> pstStack, LinkedStack<T> opStack)
    {
        /**
         Get peek from operator stack, set it as a  top operator
         Pop it from operator stack
         Check top operator is "(" or not.
            if not, append top operator to post fix operator
            Get peek from operator stack and set it as a new top operator
            Back to loop until it finds "(" in the operator stack
         */
        Character topOprtr = (Character) opStack.getPeek();
        opStack.pop();
        while (!topOprtr.equals('(')) {
            pstStack.push((T)topOprtr);
            topOprtr = (Character) opStack.getPeek();
            opStack.pop();
        }

    }



    //Inner class
    private class Node
    {
        private T _data;
        private  Node _next;

        //Default CTR
        Node()
        {
            _data = null;
            _next = null;
        }

        Node(T _dataItem)
        {
            _data = _dataItem;
            _next = null;
        }

        //Getter and Setter
        public T get_data() { return _data; }
        public void set_data(T item) { this._data = item;}
        public Node get_next() { return _next; }
        public void set_next(Node nextNode) {_next = nextNode; }

        @Override
        public String toString() {
            return "Node{" + "_data=" + _data + ", _next=" + _next + '}';
        }
    } // End of Node class



}//End of LinkedStack class
