import MatrixUtil.*;
import Test.TestSuites;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Basic Test for classical multiplication, method (a)
       TestSuites.classicalMultiplicationTest();

        //Basic Test for divide and conquer multiplication, method (b)
       TestSuites.divideConquerMultiplicationTestA();

        //Alternate test for the divide and conquer multiplication, method (b)
        //The test creates random number from -9 to 9
        //It creates N by N matrices size of 2^2 to 2^10
        //Compare the calculation result between method a and method b.
        TestSuites.divideConquerMultiplicationTestB();

        //Basic Test for strassen multiplication, method (c)
       TestSuites.strassenMultiplicationTestA();

        //Alternate test for the strassen multiplication, method (c)
        //The test creates random number from -9 to 9
        //It creates N by N matrices size of 2^2 to 2^10
        //Compare the calculation result between method a and method b.
       TestSuites.divideConquerMultiplicationTestB();

        //The test method executes all the three  methods 50 times each
        //It records each time execution time and its average time in the end
        //It is up to 2^1 to 2^10
        //FIXME the first iteration becomes outlier , value is exceeding, why 🤔
       TestSuites.run50timesEachMethod();




    } // End of Main method

} // End of Main class
