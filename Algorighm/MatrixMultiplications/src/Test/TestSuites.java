package Test;
import MatrixUtil.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TestSuites {

    //Test suite  for classical multiplication, method a
    public static void classicalMultiplicationTest(){

        System.out.println("\n~~~ classicalMultiplicationTest ~~~~~\n\n");
        boolean testing = true;

        if (testing){
            System.out.println("\n~~~Test 1~~~~");
            int[][] mtxA = {{1,2}, {3,4}};
            int[][] mtxB = {{5,6}, {7,8}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 2~~~~");
            int[][] mtxA = {{2,3}, {4,5}};
            int[][] mtxB = {{6,7}, {8,9}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 3~~~~");
            int[][] mtxA = {{-1,-2}, {-3,-4}};
            int[][] mtxB = {{-5,-6}, {-7,-8}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 4~~~~");
            int[][] mtxA = {{-2,-3}, {-4,-5}};
            int[][] mtxB = {{-6,-7}, {-8,-9}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 5~~~~");
            int[][] mtxA = {{1,-2}, {-3,4}};
            int[][] mtxB = {{5,-6}, {-7,8}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 6~~~~");
            int[][] mtxA = {{-1,2}, {3,-4}};
            int[][] mtxB = {{-5,6}, {7,-8}};
            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 7~~~~");
            int[][] mtxA = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
            int[][] mtxB = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};

            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{10,10, 10, 10}, {20, 20, 20, 20}, {30, 30, 30, 30}, {40, 40, 40, 40}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 8~~~~");
            int[][] mtxA = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};
            int[][] mtxB = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};


            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{40, 40, 40, 40}, {30, 30, 30, 30}, {20, 20, 20, 20}, {10,10, 10, 10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 9~~~~");
            int[][] mtxA = {{-4, 4, 4, 4}, {3, -3, 3, 3}, {2,2, -2, 2}, {1,1, 1, -1}};
            int[][] mtxB = {{1, -1, -1, -1}, {-2, 2, -2, -2}, {-3, -3, 3, -3}, {-4, -4, -4, 4}};


            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{-40, -16, -8, 0}, {-12, -30, 0, 6}, {-4, 0, -20, 8}, {0, 2, 4, -10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 10~~~~");
            int[][] mtxA = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}, {-3, -4, -5, -6}};
            int[][] mtxB = {{-7, -8, -9, 0}, {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}};


            int[][] mtxC = Classical.classicalMatrixMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{46, 14, 14, 24}, {78, 14, 14, 64}, {-86, -78, -86, -4}, {-62, -14, -14, -44}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        System.out.println("\n\n~~~ 👏 👏 👏 classicalMultiplicationTest_PASSED👏 👏 👏 ~~~~~");


    }

    //Test suites for the divide and conquer multiplication, method b
    public static void divideConquerMultiplicationTestA(){

        System.out.println("\n~~~ divideConquerMultiplicationTestA ~~~~~\n\n");
        boolean testing = true;

        if (testing){
            System.out.println("\n~~~Test 1~~~~");
            int[][] mtxA = {{1,2}, {3,4}};
            int[][] mtxB = {{5,6}, {7,8}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 2~~~~");
            int[][] mtxA = {{2,3}, {4,5}};
            int[][] mtxB = {{6,7}, {8,9}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 3~~~~");
            int[][] mtxA = {{-1,-2}, {-3,-4}};
            int[][] mtxB = {{-5,-6}, {-7,-8}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 4~~~~");
            int[][] mtxA = {{-2,-3}, {-4,-5}};
            int[][] mtxB = {{-6,-7}, {-8,-9}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 5~~~~");
            int[][] mtxA = {{1,-2}, {-3,4}};
            int[][] mtxB = {{5,-6}, {-7,8}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 6~~~~");
            int[][] mtxA = {{-1,2}, {3,-4}};
            int[][] mtxB = {{-5,6}, {7,-8}};
            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 7~~~~");
            int[][] mtxA = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
            int[][] mtxB = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};

            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{10,10, 10, 10}, {20, 20, 20, 20}, {30, 30, 30, 30}, {40, 40, 40, 40}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 8~~~~");
            int[][] mtxA = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};
            int[][] mtxB = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};


            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{40, 40, 40, 40}, {30, 30, 30, 30}, {20, 20, 20, 20}, {10,10, 10, 10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 9~~~~");
            int[][] mtxA = {{-4, 4, 4, 4}, {3, -3, 3, 3}, {2,2, -2, 2}, {1,1, 1, -1}};
            int[][] mtxB = {{1, -1, -1, -1}, {-2, 2, -2, -2}, {-3, -3, 3, -3}, {-4, -4, -4, 4}};


            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{-40, -16, -8, 0}, {-12, -30, 0, 6}, {-4, 0, -20, 8}, {0, 2, 4, -10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 10~~~~");
            int[][] mtxA = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}, {-3, -4, -5, -6}};
            int[][] mtxB = {{-7, -8, -9, 0}, {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}};


            int[][] mtxC = DivideConquer.divideConquerMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{46, 14, 14, 24}, {78, 14, 14, 64}, {-86, -78, -86, -4}, {-62, -14, -14, -44}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        System.out.println("\n\n~~~ 👏 👏 👏 divideConquerMultiplicationTestA_PASSED👏 👏 👏 ~~~~~");



    }


    public static void divideConquerMultiplicationTestB(){

        System.out.println("~~~ divideConquerMultiplicationTestB ~~~~~");
        System.out.println("\n\n😠😠😠Let's get serious 😠😠😠");

        for (int i = 2; i < 11; i++){

            int size = (int) Math.pow(2, i);
            System.out.println("\n\n  - - - The size of matrix " + size + " X " + size + " - - - - - ");
            int[][] mtxA = new int[size][size];
            fillUpArray(mtxA);
            int[][] mtxB = new int[size][size];
            fillUpArray(mtxB);
            int [][] mtxC= DivideConquer.divideConquerMultiplication(mtxA, mtxB);

            int [][] mtxCPrime = Classical.classicalMatrixMultiplication(mtxA,mtxB);

            if(isIdentical(mtxC, mtxCPrime)){
                System.out.println("\n The result of classical multiplication == The result of divide and conquer multiplication");
                System.out.println(" - - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" - - - - ☠️FAIL☠️ - - - - -");
            }

            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCPrime = null;

        }

        System.out.println("\n\n~~~ 👏 👏 👏 divideConquerMultiplicationTestB_PASSED👏 👏 👏 ~~~~~");

    }

    //The test suite for the strassen multiplication, method c
    public static void strassenMultiplicationTestA(){


        System.out.println("\n~~~ strassenMultiplicationTestA ~~~~~\n\n");
        boolean testing = true;

        if (testing){
            System.out.println("\n~~~Test 1~~~~");
            int[][] mtxA = {{1,2}, {3,4}};
            int[][] mtxB = {{5,6}, {7,8}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 2~~~~");
            int[][] mtxA = {{2,3}, {4,5}};
            int[][] mtxB = {{6,7}, {8,9}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 3~~~~");
            int[][] mtxA = {{-1,-2}, {-3,-4}};
            int[][] mtxB = {{-5,-6}, {-7,-8}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, 22},{43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 4~~~~");
            int[][] mtxA = {{-2,-3}, {-4,-5}};
            int[][] mtxB = {{-6,-7}, {-8,-9}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{36, 41},{64, 73}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 5~~~~");
            int[][] mtxA = {{1,-2}, {-3,4}};
            int[][] mtxB = {{5,-6}, {-7,8}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 6~~~~");
            int[][] mtxA = {{-1,2}, {3,-4}};
            int[][] mtxB = {{-5,6}, {7,-8}};
            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{19, -22},{-43, 50}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 7~~~~");
            int[][] mtxA = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};
            int[][] mtxB = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};

            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{10,10, 10, 10}, {20, 20, 20, 20}, {30, 30, 30, 30}, {40, 40, 40, 40}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 8~~~~");
            int[][] mtxA = {{4, 4, 4, 4}, {3, 3, 3, 3}, {2,2, 2, 2}, {1,1, 1, 1}};
            int[][] mtxB = {{1,1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}};


            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{40, 40, 40, 40}, {30, 30, 30, 30}, {20, 20, 20, 20}, {10,10, 10, 10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 9~~~~");
            int[][] mtxA = {{-4, 4, 4, 4}, {3, -3, 3, 3}, {2,2, -2, 2}, {1,1, 1, -1}};
            int[][] mtxB = {{1, -1, -1, -1}, {-2, 2, -2, -2}, {-3, -3, 3, -3}, {-4, -4, -4, 4}};


            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{-40, -16, -8, 0}, {-12, -30, 0, 6}, {-4, 0, -20, 8}, {0, 2, 4, -10}};


            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        if (testing){
            System.out.println("\n~~~Test 10~~~~");
            int[][] mtxA = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}, {-3, -4, -5, -6}};
            int[][] mtxB = {{-7, -8, -9, 0}, {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 0, -1, -2}};


            int[][] mtxC = Strassen.strassenMultiplication(mtxA, mtxB);
            int[][] mtxCprime =  {{46, 14, 14, 24}, {78, 14, 14, 64}, {-86, -78, -86, -4}, {-62, -14, -14, -44}};

            System.out.println("\nResult:");
            print2DArray(mtxC);
            System.out.println("\nExpected:");
            print2DArray(mtxCprime);

            if(isIdentical(mtxC, mtxCprime)){
                System.out.println(" \n- - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" \n- - - - ☠️FAIL☠️ - - - - -");
            }
            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCprime = null;
        }

        System.out.println("\n\n~~~ 👏 👏 👏 strassenMultiplicationTestA_PASSED👏 👏 👏 ~~~~~");



    }

    public static void strassenMultiplicationTestB(){

        System.out.println("~~~ strassenMultiplicationTestB ~~~~~");
        System.out.println("\n\n😠😠😠Let's get serious 😠😠😠");

        for (int i = 2; i < 11; i++){

            int size = (int) Math.pow(2, i);
            System.out.println("\n\n  - - - The size of matrix " + size + " X " + size + " - - - - - ");
            int[][] mtxA = new int[size][size];
            fillUpArray(mtxA);
            int[][] mtxB = new int[size][size];
            fillUpArray(mtxB);
            int [][] mtxC= Strassen.strassenMultiplication(mtxA, mtxB);

            int [][] mtxCPrime = Classical.classicalMatrixMultiplication(mtxA,mtxB);

            if(isIdentical(mtxC, mtxCPrime)){
                System.out.println("\n The result of classical multiplication == The result of the strassen's multiplication");
                System.out.println(" - - -  ✅PASS✅ - - - - - ");
            }
            else{
                System.out.println(" - - - - ☠️FAIL☠️ - - - - -");
            }

            mtxA = null;
            mtxB = null;
            mtxC = null;
            mtxCPrime = null;

        }

        System.out.println("\n\n~~~ 👏 👏 👏 strassenMultiplicationTestB_PASSED👏 👏 👏 ~~~~~");


    }


    public static void run50timesEachMethod() throws IOException {
        System.out.println("🕰Let's check run time 50 times each method🕰️");
        final int NUM_OF_EXECUTION = 50;
        final int NUM_OF_MAX_POWER = 12;
        ArrayList<Double> listOfTimeClassic = new ArrayList<>();
        ArrayList<Double> listOfTimeDivide = new ArrayList<>();
        ArrayList<Double> listOfTimeStrassen = new ArrayList<>();


        for (int i = 1; i <= NUM_OF_MAX_POWER; i++){
            int size = (int) Math.pow(2, i);
            StringBuffer sbSize = new StringBuffer();
            sbSize.append(size);
            File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/CS 3310/Project/P1/MatrixMultiplication/src/DataSet/" + sbSize + "by" +sbSize + ".csv");
            FileWriter fw = new FileWriter(myObj);
            BufferedWriter bw = new BufferedWriter(fw);

            try {

                bw.write(sbSize +"by" +sbSize + "matrix calculation time, millisecond second (ms), (ex. second = 1000 ms; minutes = 60000 ms)" );
                bw.newLine();
                bw.write("Times of iteration, Classical Multiplication, DivideConquer, Strassen");
                bw.newLine();
                System.out.println("\n\n  - - - The size of matrix " + size + " X " + size + " - - - - - ");


                //Calculating the result each time
                for(int j = 0; j < NUM_OF_EXECUTION; j++){
                    int[][] mtxA = new int[size][size];
                    fillUpArray(mtxA);
                    int[][] mtxB = new int[size][size];
                    fillUpArray(mtxB);

                    //Estimate for the classic multiplication  execution time
                    double startTime = System.currentTimeMillis();
                    int [][] mtxC= Classical.classicalMatrixMultiplication(mtxA, mtxB);
                    double endTime =System.currentTimeMillis() - startTime;
//                System.out.println("Execution time");
//                    System.out.println(endTime);
                    listOfTimeClassic.add(endTime);

                    //Estimate for divide and conquer multiplication execution time
                    startTime = System.currentTimeMillis();
                    int [][] mtxD= DivideConquer.divideConquerMultiplication(mtxA, mtxB);
                    endTime = System.currentTimeMillis() - startTime;
//                    System.out.println(endTime);
                    listOfTimeDivide.add(endTime);

                    //Estimate for strassen conquer execution time
                    startTime = System.currentTimeMillis();
                    int [][] mtxE= Strassen.strassenMultiplication(mtxA, mtxB);
                    endTime = System.currentTimeMillis() - startTime;
//                    System.out.println(endTime);
                    listOfTimeStrassen.add(endTime);


                }

                //Write each result to the file
                for (int j = 0; j < listOfTimeClassic.size();j++) {
                    //Write classical multiplication time
                    bw.write((j+1)+ "," + listOfTimeClassic.get(j)+ "," );

                    //Write divide conquer  multiplication time
                    bw.write(listOfTimeDivide.get(j)+ "," );

                    //Write strassen multiplication time
                    bw.write(listOfTimeStrassen.get(j)+ "," );
                    bw.newLine();
                }

                //Record the average time for each method
                bw.newLine();
                double classicAve = getAverage(listOfTimeClassic);
                double divideAve = getAverage(listOfTimeDivide);
                double strasenAve = getAverage(listOfTimeStrassen);
                bw.write("Average time, " + classicAve + "," + divideAve + "," + strasenAve);

                //Initialize for the next iteration.
                listOfTimeClassic.clear();
                listOfTimeDivide.clear();
                listOfTimeStrassen.clear();


            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            bw.close();
            fw.close();
            System.out.println("\n  - - - The size of matrix " + size + " X " + size + " is recorded - - - - -\n\n ");
        }

    }



    // End of Test suites







    // Helper methods

    /**
     * Fill the empty matrix ascending order
     * @Param mtx, the empty given matrix
     * @return mtx, the matrix filled with some values
     */
    public static int [][] fillUpArray(int [][]mtx){

//        //This value is filled in the matrix up to the last row and columns
//        //Increment each iteration
//        int fllVl = 1;

        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range -9 to 9
        int rndInt = rand.nextInt(9 + 9) -9;

        //let first iterator to visit each row, call r_wk
        //let second iterator to visit each column, call r_wk
        for (int r_wk = 0; r_wk <mtx.length; r_wk++ ){
            for (int c_wk = 0; c_wk<mtx[0].length; c_wk++){
                rndInt = rand.nextInt(9 + 9) -9;
                mtx[r_wk][c_wk] = rndInt;
            }
        }
        return mtx;
    }

    /**
     * Print 2DArray
     * @Param mtx, the first given matrix
     */
    public static void print2DArray(int[][] mtx){
//        System.out.println(Arrays.deepToString(mtx));
        for (int r_wk = 0; r_wk <mtx.length; r_wk++ ) {
            for (int c_wk = 0; c_wk < mtx[0].length; c_wk++) {
                System.out.print(mtx[r_wk][c_wk] + " ");
            }
            System.out.println("  ");
        }
    }

    /**
     * Check two matrices are identical
     * It will be useful to compare calculation result of three different algorithms
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isIdentical(int[][]mtxA, int[][]mtxB){

        //Check the number of column and row are the same
        if(!isMatchNumOfRow(mtxA,mtxB)){return false;}
        if(!isMatchNumOfColumn(mtxA,mtxB)){return false;}

        //Compare each value in the corresponding value in matrix A and  matrix B
        for (int r_wk = 0; r_wk < mtxA.length; r_wk++){
            for (int c_wk = 0; c_wk< mtxA[0].length; c_wk++ ){
                if(mtxA[r_wk][c_wk] != mtxB[r_wk][c_wk]){
                    return false;
                }
            }
        }
        return  true;
    }

    /**
     * Check the row size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isMatchNumOfRow(int[][]mtxA, int[][]mtxB){
        return mtxA.length == mtxB.length;
    }

    /**
     * Check the column size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isMatchNumOfColumn(int[][]mtxA, int[][]mtxB){
        return mtxA[0].length == mtxB[0].length;
    }

    /**
     * Check the requirement for the matrix multiplication
     * first matrix column must be equal to the second matrix
     * @Param int [][]mtxA, the first given matrix
     * @Param int [][]mtxB, the second given matrix
     * @return boolean
     */
    public static boolean checkClmAndRw(int[][] mtxA, int[][] mtxB){
        // the length of the columns in the array
        int lenOfmtxA_clm = mtxA[0].length;
        //  the length of the rows in the array
        int lenOfmtxB_row = mtxB.length;

        return lenOfmtxA_clm == lenOfmtxB_row;
    }




    public static double getAverage(ArrayList<Double> listOfTimes){
        double result = 0.0;
        double sum = 0.0;
        //The first one is outlier
        int totalSize = listOfTimes.size() - 1;

        for (int i = 1; i < listOfTimes.size(); i++){
            sum += listOfTimes.get(i);
        }
        result = sum / totalSize;

        return result;
    }

} // End of Class
