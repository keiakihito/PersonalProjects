/**
 * Class name, main.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 *
 * Description:
 * The main executes the 9 different csv file writing methods to record excution results
 *
 * 1. Average time writing files check 100 times average time
 * Case 1: 1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian
 * Case 2: 1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian
 * Case 3: 1. Steepest Decent, 2. Conjugate Gradient, 3. QR factorizatoin
 *
 * 2. Error records with initial guess positive or negative column vector
 * Case 1: 1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian and  initial guess x0 = [1, 1...𝜆]
 * Case 2: 1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian and initial guess x0 = [-1, -1...𝜆]
 * Case 3: 1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian and  initial guess x0 = [1, 1...𝜆]
 * Case 4: 1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian and initial guess x0 = [-1, -1...𝜆]
 * Case 5: 1. Steepest Decent, 2. Conjugate Gradient with initial guess x0 = [1, 1...]
 * Case 6: 1. Steepest Decent, 2. Conjugate Gradient with initial guess x0 = [-1, -1...]
 *
 * Last modified Dec 18th, 2023
 */

import Methods.UtilMethod;
import FileWrite.*;
import junit.framework.TestSuite;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        //Average time writing files

        //Case1
        //Writing a CSV file for execution average time result
        //Comparing three find eigenvalues algorithms
        //1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian
        WriteFile.writeExtTimeCSVfiles1();


        //Case2
        //Writing a CSV file for execution average time result
        //Comparing three find eigenvalues algorithms
        //1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian
       WriteFile.writeExtTimeCSVfiles2();


        //Case3
        //Writing a CSV file for execution average time result
        // 1. Steepest Decent, 2. Conjugate Gradient, 3. QR factorizatoin
        //Comparing three find eigenvalues algorithms
       WriteFile.writeExtTimeCSVfiles3();


        // Error Analysis
        //Case1
        //Writing a CSV file for error analysis
        //1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian
        //Initial guess x0 = [1, 1... λ]
       WriteFile.writeErrorCase1CSVfiles();

        //Case2
        //Writing a CSV file for error analysis
        //1. Newton, 2. Broyden with Identity matrix, 3. Broyden with Jacobian
        //Initial guess x0 = [-1, -1... λ]
       WriteFile.writeErrorCase2CSVfiles();

        //Case3
        //Writing a CSV file for error analysis
        //1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian
        //Initial guess x0 = [1, 1... λ]
       WriteFile.writeErrorCase3CSVfiles();

        //Case4
        //Writing a CSV file for error analysis
        //1. Newton, 2. Broyden with Jacobi, 3. Good Broyden with Jacobian
        //Initial guess x0 = [-1, -1... λ]
       WriteFile.writeErrorCase4CSVfiles();


        //Case5
        //Writing a CSV file for error analysis
        //Comparing Steepest Decent and Conjugate Gradient methods
        //1. Steepest Decent, 2. Conjugate Gradient
        //Initial guess x0 = [1, 1... ]
       WriteFile.writeErrorCase5CSVfiles();

        //Case6
        //Writing a CSV file for error analysis
        //Comparing Steepest Decent and Conjugate Gradient methods
        //1. Steepest Decent, 2. Conjugate Gradient
        //Initial guess x0 = [-1, -1... ]
       WriteFile.writeErrorCase6CSVfiles();


    } // end of main





} // end of Main class`