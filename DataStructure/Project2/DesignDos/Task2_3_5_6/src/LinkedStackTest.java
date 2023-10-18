import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    void stub_Test(){

        System.out.println("~~~~ Stub_Test ~~~~~~~~\n\n");

        Character wlkr = ' ';
        LinkedStack testLkdList = new LinkedStack<>();
        LinkedStack pstFix = new LinkedStack<>();
        LinkedStack opStack = new LinkedStack<>();

        testLkdList.convertToPostfix(" ");
        testLkdList.iteration("", pstFix, opStack);
        testLkdList.postIteration(pstFix,opStack);
        testLkdList.isVariable(wlkr);
        testLkdList.caseOfAlpha(wlkr, pstFix);
        testLkdList.isPower(wlkr);
        testLkdList.caseOfPower(wlkr, pstFix);
        testLkdList.isOperator(wlkr);
        testLkdList.caseOfOperator(wlkr, pstFix,opStack);
        testLkdList.giveValue(wlkr);
        testLkdList.isWeaker(1, 2);
        testLkdList.isLeftParenthesis(wlkr);
        testLkdList.caseOfLeftParenthesis(wlkr, opStack);
        testLkdList.isRightParenthesis(wlkr);
        testLkdList.caseOfRightParenthesis(pstFix,opStack);


        System.out.println("\n\n~~~~ Stub_Test passed~~~~~~~~");



    }

    @Test
    void convertToPostfix()
    {

        System.out.println("~~~~ convertToPostfix_Test~~~~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFix = new LinkedStack<>();
        LinkedStack<String> opStack = new LinkedStack<>();

        String inFix = "a * b / (c - a) + d * e";
        String expected = "a b * c a - / d e * +";
//        testLkdStack.iteration(inFix, pstFix, opStack);
//        pstFix = testLkdStack.postIteration(pstFix,opStack);
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("Infix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
//        pstFix.printStack();
        pstFix.clear();
        opStack.clear();


        inFix = "(a + b) / (c - d)";
        expected = "a b + C d - /";
//        testLkdStack.iteration(inFix, pstFix, opStack);
//        pstFix = testLkdStack.postIteration(pstFix,opStack);
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
//        pstFix.printStack();
        pstFix.clear();
        opStack.clear();

        inFix = "a / (b - c) * d";
        expected = "a b c - / d *";
//        testLkdStack.iteration(inFix, pstFix, opStack);
//        pstFix = testLkdStack.postIteration(pstFix,opStack);
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
//        pstFix.printStack();
        pstFix.clear();
        opStack.clear();

        inFix = "a - (b/(c-d)*e+f)^g";
        expected = "a b c d - / e * f + g ^ -";
//        testLkdStack.iteration(inFix, pstFix, opStack);
//        pstFix = testLkdStack.postIteration(pstFix,opStack);
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
//        pstFix.printStack();
        pstFix.clear();
        opStack.clear();


        inFix = "(a - b * c) / (d * e ^ f * g +h)";
        expected = "a b c * - d e f ^ * g * h + /";
//        testLkdStack.iteration(inFix, pstFix, opStack);
//        pstFix = testLkdStack.postIteration(pstFix,opStack);
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();


        System.out.println("\n\n~~~~ convertToPostfix_Test passed~~~~~~~~");


    }

    @Test
    void iteration()
    {
        System.out.println("~~~~ iteration_Test~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFix = new LinkedStack<>();
        LinkedStack<String> opStack = new LinkedStack<>();

        String inFix = "a * b / (c - a) + d * e";

        testLkdStack.iteration(inFix, pstFix, opStack);

        System.out.println(inFix);

        System.out.println(pstFix.toString());
        pstFix.printStack();
        System.out.println(opStack.toString());
        opStack.printStack();

        System.out.println("\n\n~~~~ iteration_Test passed~~~~~");
    }

    @Test
    void postIteration()
    {

        System.out.println("~~~~ postIteration~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFix = new LinkedStack<>();
        LinkedStack<String> opStack = new LinkedStack<>();

        String inFix = "a * b / (c - a) + d * e";

        testLkdStack.iteration(inFix, pstFix, opStack);

        System.out.println(inFix);

        System.out.println(pstFix.toString());
        pstFix.printStack();
        System.out.println(opStack.toString());
        opStack.printStack();

        pstFix = testLkdStack.postIteration(pstFix,opStack);

        System.out.println(pstFix.toString());
        pstFix.printStack();

        System.out.println("\n\n~~~~ postIteration passed~~~~~");
    }

    @Test
    void isAlpha()
    {
        System.out.println("~~~~ isVariable_Test~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();

        Character wlkr = ' ';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = 'A';
        assertEquals(testLkdStack.isVariable(wlkr), true);

        wlkr = 'b';
        assertEquals(testLkdStack.isVariable(wlkr), true);

        wlkr = '&';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '0';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '*';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '+';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '/';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '^';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '@';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '1';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = '3';
        assertEquals(testLkdStack.isVariable(wlkr), false);

        wlkr = 'Z';
        assertEquals(testLkdStack.isVariable(wlkr), true);

        wlkr = 'p';
        assertEquals(testLkdStack.isVariable(wlkr), true);

        System.out.println("\n\n~~~~ isVariable_Test Passed~~~~~");
    }

    @Test
    void caseOfAlpha()
    {
        System.out.println("~~~~ caseOfAlpha_Test~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFixStack = new LinkedStack<>();

        Character wlkr = 'a';
        testLkdStack.caseOfAlpha(wlkr,pstFixStack );
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();

        wlkr = 'b';
        testLkdStack.caseOfAlpha(wlkr,pstFixStack );
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();

        wlkr = 'c';
        testLkdStack.caseOfAlpha(wlkr,pstFixStack );
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();

        wlkr = 'd';
        testLkdStack.caseOfAlpha(wlkr,pstFixStack );
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();


        System.out.println("~~~~ caseOfAlpha_Test passed~~~~~\n\n");
    }

    @Test
    void isPower()
    {
        System.out.println("~~~~ isPower_Test~~~~~\n\n");

        LinkedStack<String> testLkdStack = new LinkedStack<>();

        Character wlkr = ' ' ;
        assertEquals(testLkdStack.isPower(wlkr), false);

        wlkr = 'a';
        assertEquals(testLkdStack.isPower(wlkr), false);

        wlkr = 't';
        assertEquals(testLkdStack.isPower(wlkr), false);

        wlkr = '-';
        assertEquals(testLkdStack.isPower(wlkr), false);

        wlkr = '+';
        assertEquals(testLkdStack.isPower(wlkr), false);

        wlkr = '^';
        assertEquals(testLkdStack.isPower(wlkr), true);

        System.out.println("~~~~ isPower_Test passed~~~~~\n\n");
    }

    @Test
    void caseOfPower()
    {
        System.out.println("~~~~ caseOfPower_Test~~~~~\n\n");
        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFixStack = new LinkedStack<>();

        Character wlkr = '^';

        testLkdStack.caseOfPower(wlkr,pstFixStack );
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();


        System.out.println("\n\n~~~~ caseOfPower_Test passed ~~~~~");

    }

    @Test
    void isOperator()
    {
        System.out.println("~~~ isOperator_Test ~~~~~\n\n");
        LinkedStack<Character> testStack = new LinkedStack<>();
        Character wklr = '+';
        assertEquals(testStack.isOperator(wklr), true);

        wklr ='-';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='*';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='+';
        assertEquals(testStack.isOperator(wklr), true);
        wklr ='^';
        assertEquals(testStack.isOperator(wklr), false);

        wklr = '8';
        assertEquals(testStack.isOperator(wklr), false);
        wklr = '(';
        assertEquals(testStack.isOperator(wklr), false);
        wklr = ')';
        assertEquals(testStack.isOperator(wklr), false);

        System.out.println("~~~ isOperator_Test passed~~~~~\n\n");
    }

    @Test
    void caseOfOperator()
    {
        System.out.println("~~~ caseOfOperator_Test ~~~~~\n\n");
        LinkedStack<Character> testStack = new LinkedStack<>();
        LinkedStack<Character> pstFixStack = new LinkedStack<>();
        LinkedStack<Character> opStack = new LinkedStack<>();

        System.out.println("\n - - - Test 1 walker is / and * * in op stack- - - -\n");
        Character wlkr = '/';

        pstFixStack.push('a');
        pstFixStack.push('b');
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();

        opStack.push('*');
        opStack.push('*');

        testStack.caseOfOperator(wlkr,pstFixStack, opStack);

        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        pstFixStack.printStack();



        System.out.println("\n - - - Test 2 walker is * and / / in op stack- - - -\n");

        wlkr = '*';
        pstFixStack.clear();
        opStack.clear();
        opStack.push('/');
        opStack.push('/');
        testStack.caseOfOperator(wlkr,pstFixStack, opStack);
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        pstFixStack.printStack();

        System.out.println("\n - - - Test 3 walker is * and * * + / / - - - -\n");
        wlkr = '*';
        pstFixStack.clear();
        opStack.clear();

        opStack.push('*');
        opStack.push('*');
        opStack.push('+');
        opStack.push('/');
        opStack.push('/');
        testStack.caseOfOperator(wlkr,pstFixStack, opStack);
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        pstFixStack.printStack();

        System.out.println("\n - - - Test 4 walker is * and / /  - * * - - - -\n");
        wlkr = '*';
        pstFixStack.clear();
        opStack.clear();

        opStack.push('/');
        opStack.push('/');
        opStack.push('-');
        opStack.push('*');
        opStack.push('*');
        testStack.caseOfOperator(wlkr,pstFixStack, opStack);
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        pstFixStack.printStack();

        System.out.println("\n - - - Test 5 walker is + and - -  ( - +  - - - -\n");
        wlkr = '+';
        pstFixStack.clear();
        opStack.clear();

        opStack.push('-');
        opStack.push('-');
        opStack.push('(');
        opStack.push('-');
        opStack.push('+');
        testStack.caseOfOperator(wlkr,pstFixStack, opStack);
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        opStack.printStack();


        System.out.println("\n - - - Test 6 walker is - and * *  ) - +  - - - -\n");
        wlkr = '-';
        pstFixStack.clear();
        opStack.clear();

        opStack.push('*');
        opStack.push('*');
        opStack.push(')');
        opStack.push('-');
        opStack.push('+');
        testStack.caseOfOperator(wlkr,pstFixStack, opStack);
        System.out.println(pstFixStack.toString());
        pstFixStack.printStack();
        System.out.println(opStack.toString());
        opStack.printStack();


        System.out.println("\n\n~~~ caseOfOperator_Test ~~~~~");
    }

    @Test
    void giveValue()
    {
        System.out.println("~~~ giveValue_Test ~~~~~\n\n");
        LinkedStack<Integer> testStack = new LinkedStack<>();
        int valOfOprtr = 0;

        Character wlkr = '+';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 1);

        wlkr = '-';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 1);

        wlkr = '*';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 2);

        wlkr = '/';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 2);

        wlkr = '(';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 0);

        wlkr = ')';
        valOfOprtr = testStack.giveValue(wlkr);
        assertEquals(valOfOprtr, 0);


        System.out.println("\n\n~~~ giveValue_Test passed~~~~~");
    }

    @Test
    void isWeaker()
    {
        System.out.println("~~~ isWeaker_Test ~~~~~\n\n");
        LinkedStack<Integer> testStack = new LinkedStack<>();

        Character wlkrVal = ' ' ;
        Character stackOpVal = ' ' ;
        int valWlkr = 0;
        int valStackOp = 0;

        wlkrVal = '+';
        stackOpVal = '+';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '+';
        stackOpVal = '-';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '+';
        stackOpVal = '*';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '+';
        stackOpVal = '/';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '-';
        stackOpVal = '+';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '-';
        stackOpVal = '-';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '-';
        stackOpVal = '*';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '-';
        stackOpVal = '/';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);



        wlkrVal = '*';
        stackOpVal = '+';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), false);



        wlkrVal = '*';
        stackOpVal = '-';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), false);


        wlkrVal = '*';
        stackOpVal = '*';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '*';
        stackOpVal = '/';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);


        wlkrVal = '/';
        stackOpVal = '+';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), false);

        wlkrVal = '/';
        stackOpVal = '-';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), false);

        wlkrVal = '/';
        stackOpVal = '*';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);

        wlkrVal = '/';
        stackOpVal = '/';
        valWlkr = testStack.giveValue(wlkrVal);
        valStackOp = testStack.giveValue(stackOpVal);
        assertEquals(testStack.isWeaker(valWlkr, valStackOp), true);


        System.out.println("\n\n~~~ isWeaker_Test passed~~~~~");
    }

    @Test
    void isLeftParenthesis()
    {
        System.out.println("~~~~ isLeftParenthesis_Test~~~~~\n\n");

        LinkedStack<Character> testLkdStack = new LinkedStack<>();

        Character wlkr = ' ';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = 'a';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = 't';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = '-';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = '+';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = '^';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = '*';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), false);

        wlkr = '(';
        assertEquals(testLkdStack.isLeftParenthesis(wlkr), true);

        System.out.println("~~~~ isLeftParenthesis_Test passed~~~~~\n\n");
    }

    @Test
    void caseOfLeftParenthesis()
    {
        System.out.println("~~~~ caseOfLeftParenthesis_Test~~~~~\n\n");
        LinkedStack<Character> testLkdStack = new LinkedStack<>();
        LinkedStack<Character> opStack = new LinkedStack<>();

        Character wlkr = '(';

        testLkdStack.caseOfPower(wlkr,opStack );
        System.out.println(opStack.toString());
        opStack.printStack();


        System.out.println("\n\n~~~~ caseOfLeftParenthesis_Test passed ~~~~~");
    }

    @Test
    void isRightParenthesis()
    {
        System.out.println("~~~~ isRightParenthesis_Test~~~~~\n\n");

        LinkedStack<Character> testLkdStack = new LinkedStack<>();

        Character wlkr = ' ';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = '(';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = 't';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = '-';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = '+';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = '^';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = '*';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), false);

        wlkr = ')';
        assertEquals(testLkdStack.isRightParenthesis(wlkr), true);

        System.out.println("~~~~ isRightParenthesis_Test passed~~~~~\n\n");
    }

    @Test
    void caseOfRightParenthesis()
    {
        System.out.println("~~~~ caseOfRightParenthesis ~~~~~~~~\n\n");
        LinkedStack<Character> testLkdStack = new LinkedStack<>();
        LinkedStack<Character> pstFix = new LinkedStack<>();
        LinkedStack<Character> opStack = new LinkedStack<>();

        pstFix.push('a');
        pstFix.push('b');
        pstFix.push('*');
        pstFix.push('c');
        pstFix.push('a');

        opStack.push('/');
        opStack.push('(');
        opStack.push('-');

        testLkdStack.caseOfRightParenthesis(pstFix,opStack);

        System.out.println(pstFix.toString());
        pstFix.printStack();

        System.out.println(opStack.toString());
        opStack.printStack();

        System.out.println("\n\n~~~~ caseOfRightParenthesis passed~~~~~~~~");



        System.out.println("\n\n ~~~ Additional step test~~~~~\n\n");
        testLkdStack.caseOfOperator('+', pstFix, opStack);
        testLkdStack.caseOfAlpha('d', pstFix);
        testLkdStack.caseOfOperator('*', pstFix, opStack);
        testLkdStack.caseOfAlpha('e', pstFix);

        System.out.println(pstFix.toString());
        pstFix.printStack();

        System.out.println(opStack.toString());
        opStack.printStack();

        System.out.println("\n\n ~~~ Additional step test~~~~~");


    }
}