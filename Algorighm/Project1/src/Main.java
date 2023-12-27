/**
 * Authour: Keita Katsumi
 * Class: CS 3310 SP 2023 Project 1
 * 
 * Description:
 * The main program excutes the test cases for the three matrix maltiplication methods
 * Alternate test cases for Divide and Conquer method and Strassen's method
 * The run50timesEachMethod records the each iteration excution time and cauculate average time,
 * and it creates record file from 2^2 matrix to 2^12 matrix
 * 
 * Last update: Octorber 31st, 2023
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        //Basic Test for classical multiplication, method (a)
       classicalMultiplicationTest();

        //Basic Test for divide and conquer multiplication, method (b)
       divideConquerMultiplicationTestA();

        //Another test suites for the divide and conquer multiplication, method (b)
        divideConquerMultiplicationTestB();

        //Basic Test for strassen multiplication, method (c)
       strassenMultiplicationTestA();


        //Another test suites for the Strassen multiplication, method (c)
       strassenMultiplicationTestB();


        //The test method executes all the three  methods 50 times each
        //It records each time execution time and its average time in the end
        //It is up to 2^1 to 2^11
        //FIXME the first iteration becomes outlier , value is exceeding, why 🤔
       // run50timesEachMethod();


    } // End of Main method





    //TestSuites
    /**
     *The method is for the 10 test cases on the report for the classcial multiplicaiton
     * @Param N/A
     * @Return N/A
     */
    public static void classicalMultiplicationTest(){
        //Test suite  for classical multiplication, method a
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


    /**
     *The method is for the 10 test cases on the report for the divide and conquer matrix multiplication 
     * @Param N/A
     * @Return N/A
     */
    public static void divideConquerMultiplicationTestA(){

        //Test suites for the divide and conquer multiplication, method b
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


    /**
     *The method is another test cases the divide and conqpuer method
     * It starts 2^2 matrix with filling up random numbers up to 2^11 by 2^11 
     * @Param N/A
     * @Return N/A
     */
    public static void divideConquerMultiplicationTestB(){

        //Another test suites for the divide and conquer multiplication, method b
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



    
    /**
     *The method is for the 10 test cases on the report for Strassen's matrix multiplication 
     * @Param N/A
     * @Return N/A
     */
    public static void strassenMultiplicationTestA(){

        //The test suite for the strassen multiplication, method c
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


    /**
     *The method is another test for the Strassen's matrix multiplication method
     * It starts 2^2 matrix with filling up random numbers up to 2^11 by 2^11 
     * @Param N/A
     * @Return N/A
     */
    public static void strassenMultiplicationTestB(){

        //Another test suites for the Strassen multiplication, method c
        System.out.println("\n\n~~~ strassenMultiplicationTestB ~~~~~");
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


    /**
     *The method runs three methods 50 times
     * Each iteration calculate matrix multiplication from the size of 2^2 to 2^12 
     * It checks the starting time and end time and store the result to the Array list
     * After calculating 50 times, the program recoreds the each iteration results and the average time to cvs files.
     * @Param N/A
     * @Return N/A, but its creates files which records the excution results.
     */
    public static void run50timesEachMethod() throws IOException {
        
        System.out.println("\n\n🕰Let's check run time 50 times each method🕰️");
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
                    listOfTimeClassic.add(endTime);

                    //Estimate for divide and conquer multiplication execution time
                    startTime = System.currentTimeMillis();
                    int [][] mtxD= DivideConquer.divideConquerMultiplication(mtxA, mtxB);
                    endTime = System.currentTimeMillis() - startTime;
                    listOfTimeDivide.add(endTime);

                    //Estimate for strassen conquer execution time
                    startTime = System.currentTimeMillis();
                    int [][] mtxE= Strassen.strassenMultiplication(mtxA, mtxB);
                    endTime = System.currentTimeMillis() - startTime;
                    listOfTimeStrassen.add(endTime);


                } // end of inner loop

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
        } //End of for outer loop

    } // end of run50timesEachMethod


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



    /**
     * first matrix column must be equal to the second matrix
     * @Param ArrayList<Double>listOfTimes, the results of excution result.
     * @return double average execution time
     */
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








} // End of Main class




/*
Sample run

~~~ classicalMultiplicationTest ~~~~~



~~~Test 1~~~~

Result:
19 22   
43 50   

Expected:
19 22   
43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 2~~~~

Result:
36 41   
64 73   

Expected:
36 41   
64 73   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 3~~~~

Result:
19 22   
43 50   

Expected:
19 22   
43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 4~~~~

Result:
36 41   
64 73   

Expected:
36 41   
64 73   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 5~~~~

Result:
19 -22   
-43 50   

Expected:
19 -22   
-43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 6~~~~

Result:
19 -22   
-43 50   

Expected:
19 -22   
-43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 7~~~~

Result:
10 10 10 10   
20 20 20 20   
30 30 30 30   
40 40 40 40   

Expected:
10 10 10 10   
20 20 20 20   
30 30 30 30   
40 40 40 40   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 8~~~~

Result:
40 40 40 40   
30 30 30 30   
20 20 20 20   
10 10 10 10   

Expected:
40 40 40 40   
30 30 30 30   
20 20 20 20   
10 10 10 10   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 9~~~~

Result:
-40 -16 -8 0   
-12 -30 0 6   
-4 0 -20 8   
0 2 4 -10   

Expected:
-40 -16 -8 0   
-12 -30 0 6   
-4 0 -20 8   
0 2 4 -10   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 10~~~~

Result:
46 14 14 24   
78 14 14 64   
-86 -78 -86 -4   
-62 -14 -14 -44   

Expected:
46 14 14 24   
78 14 14 64   
-86 -78 -86 -4   
-62 -14 -14 -44   
 
- - -  ✅PASS✅ - - - - - 


~~~ 👏 👏 👏 classicalMultiplicationTest_PASSED👏 👏 👏 ~~~~~

~~~ divideConquerMultiplicationTestA ~~~~~



~~~Test 1~~~~

Result:
19 22   
43 50   

Expected:
19 22   
43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 2~~~~

Result:
36 41   
64 73   

Expected:
36 41   
64 73   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 3~~~~

Result:
19 22   
43 50   

Expected:
19 22   
43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 4~~~~

Result:
36 41   
64 73   

Expected:
36 41   
64 73   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 5~~~~

Result:
19 -22   
-43 50   

Expected:
19 -22   
-43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 6~~~~

Result:
19 -22   
-43 50   

Expected:
19 -22   
-43 50   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 7~~~~

Result:
10 10 10 10   
20 20 20 20   
30 30 30 30   
40 40 40 40   

Expected:
10 10 10 10   
20 20 20 20   
30 30 30 30   
40 40 40 40   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 8~~~~

Result:
40 40 40 40   
30 30 30 30   
20 20 20 20   
10 10 10 10   

Expected:
40 40 40 40   
30 30 30 30   
20 20 20 20   
10 10 10 10   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 9~~~~

Result:
-40 -16 -8 0   
-12 -30 0 6   
-4 0 -20 8   
0 2 4 -10   

Expected:
-40 -16 -8 0   
-12 -30 0 6   
-4 0 -20 8   
0 2 4 -10   
 
- - -  ✅PASS✅ - - - - - 

~~~Test 10~~~~

Result:
46 14 14 24   
78 14 14 64   
-86 -78 -86 -4   
-62 -14 -14 -44   

Expected:
46 14 14 24   
78 14 14 64   
-86 -78 -86 -4   
-62 -14 -14 -44   
 
- - -  ✅PASS✅ - - - - - 


~~~ 👏 👏 👏 divideConquerMultiplicationTestA_PASSED👏 👏 👏 ~~~~~
~~~ divideConquerMultiplicationTestB ~~~~~


😠😠😠Let's get serious 😠😠😠


  - - - The size of matrix 4 X 4 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 8 X 8 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 16 X 16 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 32 X 32 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 64 X 64 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 128 X 128 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 256 X 256 - - - - - 

 The result of classical multiplication == The result of divide and conquer multiplication
 - - -  ✅PASS✅ - - - - - 


  - - - The size of matrix 512 X 512 - - - - - 

[Cancelled]

*/
