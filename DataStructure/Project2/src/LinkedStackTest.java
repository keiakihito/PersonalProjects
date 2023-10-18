/**
 File Name: LinkedStackTest.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class tests convertToPostfix in the LinkedStack class.
 It accepts infix notation string, and converts post fix notation with linked stack class.
 Last update: 04/3/2023
 */

public class LinkedStackTest
{
	public static void main(String[] args) {

        System.out.println("~~~~ convertToPostfix_Test~~~~~~~~");

        LinkedStack<String> testLkdStack = new LinkedStack<>();
        LinkedStack<String> pstFix = new LinkedStack<>();
        LinkedStack<String> opStack = new LinkedStack<>();

        String inFix = "a*b/(c-a)+d*e";
        String expected = "ab*ca-/de*+";
        pstFix = testLkdStack.convertToPostfix(inFix);
        // pstFix.printStack();
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();


        inFix = "(a+b)/(c-d)";
        expected = "ab+cd-/";
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();

        inFix = "a/(b-c)*d";
        expected = "abc-/d*";
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();

        inFix = "a-(b/(c-d)*e+f)^g";
        expected = "abcd-/e*f+g^-";
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();


        inFix = "(a-b*c)/(d*e^f*g+h)";
        expected = "abc*-def^*g*h+/";
        pstFix = testLkdStack.convertToPostfix(inFix);
        System.out.println("\n\nInfix : " + inFix);
        System.out.print("Expected : " + expected);
        System.out.println(pstFix.toString());
        pstFix.clear();
        opStack.clear();


        System.out.println("\n\n~~~~ convertToPostfix_Test passed~~~~~~~~");


	}
}

/*
Sample run
~~~~ convertToPostfix_Test~~~~~~~~


Infix : a*b/(c-a)+d*e
Expected : ab*ca-/de*+
toString : [+]->[*]->[e]->[d]->[/]->[-]->[a]->[c]->[*]->[b]->[a]->[^]


Infix : (a+b)/(c-d)
Expected : ab+cd-/
toString : [/]->[-]->[d]->[c]->[+]->[b]->[a]->[^]


Infix : a/(b-c)*d
Expected : abc-/d*
toString : [*]->[d]->[/]->[-]->[c]->[b]->[a]->[^]


Infix : a-(b/(c-d)*e+f)^g
Expected : abcd-/e*f+g^-
toString : [-]->[^]->[g]->[+]->[f]->[*]->[e]->[/]->[-]->[d]->[c]->[b]->[a]->[^]


Infix : (a-b*c)/(d*e^f*g+h)
Expected : abc*-def^*g*h+/
toString : [/]->[+]->[h]->[*]->[g]->[*]->[^]->[f]->[e]->[d]->[-]->[*]->[c]->[b]->[a]->[^]


~~~~ convertToPostfix_Test passed~~~~~~~~

*/