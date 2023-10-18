import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizeableArrayStackTest {
    @org.junit.jupiter.api.Test
    void stub_Test() {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        Character cha = ' ';
        testStack.push(1);
        testStack.push(2);
        testStack.pop();
        testStack.getPeek();
        testStack.isEmpty();
        testStack.isFull();
        testStack.doubleCapacity();
//        testStack.caseOfInteger("1", testStack);
        testStack.isOperator(cha);
//        testStack.caseOfOperator(cha, testStack);
        testStack.valCalculate(1, 2, cha, testStack);
        System.out.println("~~~~Stub_TEST passed ~~~~");

    }

    @org.junit.jupiter.api.Test
    void push()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);

        System.out.println(testStack.toString());
        testStack.printStack();
    }

    @org.junit.jupiter.api.Test
    void pop()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);

        System.out.println(testStack.toString());
        testStack.printStack();

        testStack.pop();
        testStack.pop();

        System.out.println(testStack.toString());
        testStack.printStack();
    }

    @org.junit.jupiter.api.Test
    void getPeek()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);

        System.out.println(testStack.toString());
        testStack.printStack();

        Integer strPeek = testStack.getPeek();
        System.out.print("Current peek : ");
        System.out.println(strPeek);
        testStack.pop();

        strPeek = testStack.getPeek();
        System.out.print("Current peek : ");
        System.out.println(strPeek);
        testStack.pop();

    }

    @org.junit.jupiter.api.Test
    void isEmpty()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);

        System.out.println(testStack.toString());
        testStack.printStack();
        assertEquals(testStack.isEmpty(), false);

        testStack.pop();
        testStack.pop();

        System.out.println(testStack.toString());
        testStack.printStack();
        assertEquals(testStack.isEmpty(), true);

    }

    @org.junit.jupiter.api.Test
    void clear()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);

        System.out.println(testStack.toString());
        testStack.printStack();

        testStack.clear();
        assertEquals(testStack.isEmpty(), true);
        System.out.println(testStack.toString());
    }

    @org.junit.jupiter.api.Test
    void isFull()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);

        assertEquals(testStack.isFull(), true);
        System.out.println(testStack.toString());

        testStack.push(6);
        assertEquals(testStack.isFull(), false);
        System.out.println(testStack.toString());

    }

    @org.junit.jupiter.api.Test
    void doubleCapacity()
    {
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);

        assertEquals(testStack.isFull(), true);
        System.out.println(testStack.toString());

        testStack.push(6);
        assertEquals(testStack.isFull(), false);
        System.out.println(testStack.toString());
    }

//    @Test
//    void caseOfInteger()
//    {
//        System.out.println("~~~ caseOfInteger_Test ~~~~~\n\n");
//
//        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
//
//        System.out.println("Add 5");
//        testStack.caseOfInteger("5", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//        System.out.println("\nAdd 6");
//        testStack.caseOfInteger("6", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//        System.out.println("\nAdd 7");
//        testStack.caseOfInteger("7", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//        System.out.println("\nAdd 8");
//        testStack.caseOfInteger("8", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//        System.out.println("\nAdd 9");
//        testStack.caseOfInteger("9", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//        System.out.println("\nAdd 10");
//        testStack.caseOfInteger("10", testStack);
//        System.out.println(testStack.toString());
//        testStack.printStack();
//
//
//        System.out.println("\n\n~~~ caseOfInteger_Test ~~~~~");
//
//    }

    @Test
    void isOperator()
    {
        System.out.println("~~~ isOperator_Test ~~~~~\n\n");
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        Character wklr = '+';
        assertEquals(testStack.isOperator(wklr), true);

        wklr ='-';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='*';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='+';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='^';
        assertEquals(testStack.isOperator(wklr), true);

        wklr = '8';
        assertEquals(testStack.isOperator(wklr), false);
        wklr = '&';
        assertEquals(testStack.isOperator(wklr), false);
        wklr = ')';
        assertEquals(testStack.isOperator(wklr), false);

        System.out.println("~~~ isOperator_Test passed~~~~~\n\n");
    }

    @Test
    void isCharacter() {

        System.out.println("~~~ isCharacter_Test ~~~~~\n\n");
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        Character wklr = '+';
        assertEquals(testStack.isCharacter(wklr), false);

        wklr ='a';
        assertEquals(testStack.isCharacter(wklr), true);

        wklr ='*';
        assertEquals(testStack.isCharacter(wklr), false);

        wklr ='b';
        assertEquals(testStack.isCharacter(wklr), true);

        wklr ='-';
        assertEquals(testStack.isCharacter(wklr), false);

        wklr ='c';
        assertEquals(testStack.isCharacter(wklr), true);

        wklr ='^';
        assertEquals(testStack.isCharacter(wklr), false);

        wklr ='d';
        assertEquals(testStack.isCharacter(wklr), true);

        wklr ='^';
        assertEquals(testStack.isCharacter(wklr), false);

        wklr ='e';
        assertEquals(testStack.isCharacter(wklr), true);

        System.out.println("~~~ isCharacter_Test passed~~~~~\n\n");

    }

    @Test
    void convertCharacter()
    {

        System.out.println("~~~ convertCharacter_Test ~~~~~\n\n");
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        Character wlkr = 'a';
        int convertInt = 0;
        convertInt = testStack.convertCharacter(wlkr);
        assertEquals(convertInt, 2);

        wlkr = 'b';
        convertInt = 0;
        convertInt = testStack.convertCharacter(wlkr);
        assertEquals(convertInt, 3);

        wlkr = 'c';
        convertInt = 0;
        convertInt = testStack.convertCharacter(wlkr);
        assertEquals(convertInt, 4);


        wlkr = 'd';
        convertInt = 0;
        convertInt = testStack.convertCharacter(wlkr);
        assertEquals(convertInt, 5);

        wlkr = 'e';
        convertInt = 0;
        convertInt = testStack.convertCharacter(wlkr);
        assertEquals(convertInt, 6);

        System.out.println("~~~ convertCharacter_Test passed~~~~~\n\n");

    }

    @Test
    void caseOfOperator()
    {
        System.out.println("~~~ caseOfOperator_Test ~~~~~\n\n");

        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();

        //Addition
        System.out.println(" - - - - - (+) calculation test - - - - -");
        Character oprtr = '+';

        System.out.println("\n2 + 4 and expected 6");
        testStack.push(2);
        testStack.push(4);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 6);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n -2 + 4 and expected 2");
        testStack.push(-2);
        testStack.push(4);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n 4  + (-2) and expected 2");
        testStack.push(4);
        testStack.push(-2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n -4  + (-2) and expected -6");
        testStack.push(-4);
        testStack.push(-2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -6);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        //Subtraction
        System.out.println("\n\n - - - - - (- ) calculation test - - - - -");
        oprtr = '-';

        System.out.println("\n2 - 4 and expected -2");
        testStack.push(2);
        testStack.push(4);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();


        System.out.println("\n-5 - (-8) and expected 3");
        testStack.push(-5);
        testStack.push(-8);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 3);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 - (-5) and expected -3");
        testStack.push(-8);
        testStack.push(-5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -3);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 - 5 and expected -13");
        testStack.push(-8);
        testStack.push(5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -13);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();





        //Multiplication
        System.out.println("\n\n - - - - - ( * ) calculation test - - - - -");
        oprtr = '*';

        System.out.println("\n2 * 4 and expected 8");
        testStack.push(2);
        testStack.push(4);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 8);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n-5 * (-8) and expected 40");
        testStack.push(-5);
        testStack.push(-8);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 * (-5) and expected 40");
        testStack.push(-8);
        testStack.push(-5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 * 5 and expected -40");
        testStack.push(-8);
        testStack.push(5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();




        //Division
        System.out.println("\n\n - - - - - ( / ) calculation test - - - - -");
        oprtr = '/';

        System.out.println("\n2 / 4 and expected 0");
        testStack.push(2);
        testStack.push(4);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 0);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n 4 / 2 and expected 2");
        testStack.push(4);
        testStack.push(2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n-5  / (-8) and expected 0");
        testStack.push(-5);
        testStack.push(-8);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 0);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 /  (-5) and expected 1");
        testStack.push(-8);
        testStack.push(-5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), 1);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 / 5 and expected -1");
        testStack.push(-8);
        testStack.push(5);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.caseOfOperator(oprtr,testStack);
        assertEquals(testStack.getPeek(), -1);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n\n~~~ caseOfOperator_Test passed~~~~~");
    }



    @Test
    void valCalculate()
    {
        System.out.println("~~~ valCalculate_Test ~~~~~\n\n");
        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();

        //Addition
        System.out.println(" - - - - - (+) calculation test - - - - -");
        Character oprtr = '+';
        System.out.println("\n2 + 4 and expected 6");
        testStack.valCalculate(2,4, oprtr,testStack);
        assertEquals(testStack.getPeek(), 6);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n -2 + 4 and expected 2");
        testStack.valCalculate(-2,4, oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n 4  + (-2) and expected 2");
        testStack.valCalculate(4,-2, oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n -4  + (-2) and expected -6");
        testStack.valCalculate(-4,-2, oprtr,testStack);
        assertEquals(testStack.getPeek(), -6);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();


        //Subtraction
        System.out.println("\n\n - - - - - (- ) calculation test - - - - -");
        oprtr = '-';
        System.out.println("\n2 - 4 and expected -2");
        testStack.valCalculate(2,4, oprtr,testStack);
        assertEquals(testStack.getPeek(), -2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n-5 - (-8) and expected 3");
        testStack.valCalculate(-5,-8, oprtr,testStack);
        assertEquals(testStack.getPeek(), 3);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 - (-5) and expected -3");
        testStack.valCalculate(-8,-5, oprtr,testStack);
        assertEquals(testStack.getPeek(), -3);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 - 5 and expected -13");
        testStack.valCalculate(-8,5, oprtr,testStack);
        assertEquals(testStack.getPeek(), -13);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();



        //Multiplication
        System.out.println("\n\n - - - - - ( * ) calculation test - - - - -");
        oprtr = '*';
        System.out.println("\n2 * 4 and expected 8");
        testStack.valCalculate(2,4, oprtr,testStack);
        assertEquals(testStack.getPeek(), 8);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n-5 * (-8) and expected 40");
        testStack.valCalculate(-5,-8, oprtr,testStack);
        assertEquals(testStack.getPeek(), 40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 * (-5) and expected 40");
        testStack.valCalculate(-8,-5, oprtr,testStack);
        assertEquals(testStack.getPeek(), 40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 * 5 and expected -40");
        testStack.valCalculate(-8,5, oprtr,testStack);
        assertEquals(testStack.getPeek(), -40);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        //Division
        System.out.println("\n\n - - - - - ( / ) calculation test - - - - -");
        oprtr = '/';
        System.out.println("\n2 / 4 and expected 0");
        testStack.valCalculate(2,4, oprtr,testStack);
        assertEquals(testStack.getPeek(), 0);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n 4 / 2 and expected 2");
        testStack.valCalculate(4,2, oprtr,testStack);
        assertEquals(testStack.getPeek(), 2);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n-5  / (-8) and expected 0");
        testStack.valCalculate(-5,-8, oprtr,testStack);
        assertEquals(testStack.getPeek(), 0);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 /  (-5) and expected 1");
        testStack.valCalculate(-8,-5, oprtr,testStack);
        assertEquals(testStack.getPeek(), 1);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n - 8 * 5 and expected -1");
        testStack.valCalculate(-8,5, oprtr,testStack);
        assertEquals(testStack.getPeek(), -1);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();


        System.out.println(" - - - - - (^) calculation test - - - - -");
        oprtr = '^';
        System.out.println("\n4 ^ 2 and expected 6");
        testStack.valCalculate(4,2, oprtr,testStack);
        assertEquals(testStack.getPeek(), 16);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n2 ^ 10 and expected 6");
        testStack.valCalculate(2,10, oprtr,testStack);
        assertEquals(testStack.getPeek(), 1024);
        System.out.println(testStack.toString());
        testStack.printStack();
        testStack.clear();

        System.out.println("\n\n~~~ valCalculate_Test passed~~~~~");
    }

    @Test
    void evaluatePostfix_Test()
    {
        System.out.println("~~~ evaluatePostfix_Test~~~~~\n\n");

        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        int result = 0;

        String pstFix = "ab*ca-/de*+";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: 33");
        assertEquals(result, 33);
        System.out.println("Actual answer : "+ result);


        pstFix = "ae+bd-/";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -4");
        assertEquals(result, -4);
        System.out.println("Actual answer : "+ result);


        pstFix = "abc*d*-";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -58");
        assertEquals(result, -58);
        System.out.println("Actual answer : "+ result);

        pstFix = "abc-/d* ";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -10");
        assertEquals(result, -10);
        System.out.println("Actual answer : "+ result);


        pstFix = "ebca^*+d-";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: 49");
        assertEquals(result, 49);
        System.out.println("Actual answer : "+ result);


        System.out.println("\n\n~~~evaluatePostfix_Test passed~~~~~");


    }


}