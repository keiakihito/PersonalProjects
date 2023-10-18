/**
 File Name: ArrayStackTest.java
 CS 2400 Spring 2023
 Author: Keita Katsumi
 Description:
 The class tests evaluatePostfix in the ResizeableArrayStack class.
 It accepts post fix notation, and convert variable to corresponding integer, calulate, and returns the result.
 Last update: 04/3/2023
 */

public class ArrayStackTest
{
	public static void main(String[] args) {
		
  System.out.println("~~~ evaluatePostfix_Test~~~~~");

        ResizeableArrayStack<Integer> testStack = new ResizeableArrayStack<>();
        int result = 0;

        String pstFix = "ab*ca-/de*+";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: 33");
        System.out.println("Actual answer : "+ result);


        pstFix = "ae+bd-/";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -4");
        System.out.println("Actual answer : "+ result);


        pstFix = "abc*d*-";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -58");
        System.out.println("Actual answer : "+ result);

        pstFix = "abc-/d* ";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: -10");
        System.out.println("Actual answer : "+ result);


        pstFix = "ebca^*+d-";
        result = testStack.evaluatePostfix(pstFix);
        System.out.println("\n" + pstFix);
        System.out.println("Expected answer: 49");
        System.out.println("Actual answer : "+ result);


        System.out.println("\n\n~~~evaluatePostfix_Test passed~~~~~");


	}
}



/*
Sample Run

~~~ evaluatePostfix_Test~~~~~

ab*ca-/de*+
Expected answer: 33
Actual answer : 33

ae+bd-/
Expected answer: -4
Actual answer : -4

abc*d*-
Expected answer: -58
Actual answer : -58

abc-/d* 
Expected answer: -10
Actual answer : -10

ebca^*+d-
Expected answer: 49
Actual answer : 49


~~~evaluatePostfix_Test passed~~~~~
*/