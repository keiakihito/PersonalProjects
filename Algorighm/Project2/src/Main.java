/**
 * Class name, main.java
 * Author Keita Katsumi
 * CS 3110 Fall 2023
 * Project 2
 * Last modified Dec 4th, 2023
 * Description:
 * The main executes the 4 different test cases
 * 1. The algorithm1Test shows the accuracy of my Algorithm 1 (MergeSort) execution.
 * 2. The algorithm2Test shows the accuracy of my Algorithm 2 (QuickSort) execution.
 * 3. The algorithm1Test shows the accuracy of my Algorithm 1 (MedianOfMedian) execution.
 * 4. The run50times3Algorithm check 50 times average execution time and export csv file.
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
       TestSuites.algorithm1Test();
       TestSuites.algorithm2Test();
       TestSuites.algorithm3Test();
            // TestSuites.run50times3Algorithms();
    }// end of main method

}//end of Main class

/*Sample run



~~~~ algorithm1Test ~~~~~


 - - - Test 1 - - - - - 
Original array: 
2, 0, 1, 

Expected: [0]
Actual: 0
 - - - ✅Test 1 passed✅- - - - - 


 - - - Test 2 - - - - - 
Original array: 
2, 0, 1, 

Expected: [1]
Actual: 1
 - - - ✅Test 2 passed✅- - - - - 


 - - - Test 3 - - - - - 
Original array: 
2, 0, 1, 

Expected: [2]
Actual: 2
 - - - ✅Test 3 passed✅- - - - - 


 - - - Test 4 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [0]
Actual: 0
 - - - ✅Test 4 passed✅- - - - - 


 - - - Test 5 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [1]
Actual: 1
 - - - ✅Test 5 passed✅- - - - - 


 - - - Test 6 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [2]
Actual: 2
 - - - ✅Test 6 passed✅- - - - - 


 - - - Test 7 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [3]
Actual: 3
 - - - ✅Test 7 passed✅- - - - - 


 - - - Test 8 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [4]
Actual: 4
 - - - ✅Test 8 passed✅- - - - - 


 - - - Test 9 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [5]
Actual: 5
 - - - ✅Test 9 passed✅- - - - - 


 - - - Test 10 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [6]
Actual: 6
 - - - ✅Test 10 passed✅- - - - - 


~~~~ 👏👏👏algorithm1Test Passed👏👏👏 ~~~~~


~~~~ algorithm2Test ~~~~~


 - - - Test 1 - - - - - 
Original array: 
2, 0, 1, 

Expected: [0]
Actual: 0
 - - - ✅Test 1 passed✅- - - - - 


 - - - Test 2 - - - - - 
Original array: 
2, 0, 1, 

Expected: [1]
Actual: 1
 - - - ✅Test 2 passed✅- - - - - 


 - - - Test 3 - - - - - 
Original array: 
2, 0, 1, 

Expected: [2]
Actual: 2
 - - - ✅Test 3 passed✅- - - - - 


 - - - Test 4 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [0]
Actual: 0
 - - - ✅Test 4 passed✅- - - - - 


 - - - Test 5 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [1]
Actual: 1
 - - - ✅Test 5 passed✅- - - - - 


 - - - Test 6 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [2]
Actual: 2
 - - - ✅Test 6 passed✅- - - - - 


 - - - Test 7 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [3]
Actual: 3
 - - - ✅Test 7 passed✅- - - - - 


 - - - Test 8 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [4]
Actual: 4
 - - - ✅Test 8 passed✅- - - - - 


 - - - Test 9 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [5]
Actual: 5
 - - - ✅Test 9 passed✅- - - - - 


 - - - Test 10 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [6]
Actual: 6
 - - - ✅Test 10 passed✅- - - - - 


~~~~ 👏👏👏algorithm2Test Passed👏👏👏 ~~~~~


~~~~ algorithm3Test ~~~~~


 - - - Test 1 - - - - - 
Original array: 
2, 0, 1, 

Expected: [0]
Actual: 0
 - - - ✅Test 1 passed✅- - - - - 


 - - - Test 2 - - - - - 
Original array: 
2, 0, 1, 

Expected: [1]
Actual: 1
 - - - ✅Test 2 passed✅- - - - - 


 - - - Test 3 - - - - - 
Original array: 
2, 0, 1, 

Expected: [2]
Actual: 2
 - - - ✅Test 3 passed✅- - - - - 


 - - - Test 4 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [0]
Actual: 0
 - - - ✅Test 4 passed✅- - - - - 


 - - - Test 5 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [1]
Actual: 1
 - - - ✅Test 5 passed✅- - - - - 


 - - - Test 6 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [2]
Actual: 2
 - - - ✅Test 6 passed✅- - - - - 


 - - - Test 7 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [3]
Actual: 3
 - - - ✅Test 7 passed✅- - - - - 


 - - - Test 8 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [4]
Actual: 4
 - - - ✅Test 8 passed✅- - - - - 


 - - - Test 9 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [5]
Actual: 5
 - - - ✅Test 9 passed✅- - - - - 


 - - - Test 10 - - - - - 
Original array: 
5, 2, 0, 1, 4, 3, 6, 

Expected: [6]
Actual: 6
 - - - ✅Test 10 passed✅- - - - - 


~~~~ 👏👏👏algorithm3Test Passed👏👏👏 ~~~~~
[Finished in 325ms]

*/