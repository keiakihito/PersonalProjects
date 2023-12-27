/**
 * Class name, WriteFile.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 * Description:
 * The write files method executes different algorithms
 * Comparing each algorithm execution time and absolute error.
 * Last modified Dec 23rd, 2023
 */


package FileWrite;

import  Methods.*;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WriteFile
{

    /**
     * This method executes 3 algorithms starting from 2^1 matrix until 2^10
     * Find eigenvalue and eigenvector pair
     * Record average execution time to a csv file
     * Comparing
     * 1. Newton's method
     * 2. Bryoden with Identity matrix
     * 3. Broyden with Jacobian matrix
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeExtTimeCSVfiles1() throws IOException
    {
        System.out.println("🕰Let's check run time 100 times each method🕰️");
        final int NUM_OF_EXECUTION = 50;

        // 2^9 takes more than 30 minuit my device
        final int NUM_OF_MAX_POWER = 10;

        //For Newton's method
        ArrayList<Double> newTonExctTimes = new ArrayList<>();

        //Broyden's method starts from Identity matrix
        ArrayList<Double> broydenIdnttyExctTime = new ArrayList<>();

        //Broyden's method starts from Jacobi matrix
        ArrayList<Double> broydenJcbExtTime = new ArrayList<>();



        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ExecutionTimeAve/Case1/Case1_AveTimes.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {
            bw.write("Problem size, Algorithm1(Newton), Algorithm2(Broyden Jacobi with Identity Matrix), Algorithm3(Good Broyden with Jacobi Matrix)");
            bw.newLine();
            int size = 0;
            for(int i = 1; i <= NUM_OF_MAX_POWER; i++){

                //Grow size of matrix every iteration
                size = (int) Math.pow(2, i);

                // Record the number of problem size later
                StringBuffer sbSize = new StringBuffer();
                sbSize.append(size);

                for(int j = 0; j< NUM_OF_EXECUTION; j++){

                    // Make SPD real matrix with current size
                    RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

                    // Construct V is an initial guess V = [1, 1...1], and V = [-1, -1...-1 ]
                    RealMatrix matrixV_pstv = constructVPositive(size);
                    RealMatrix matrixV_ngtv = constructVNegative(size);

                    // Construct X_knot is an initial guess X0 = [1, 1...1, λ], and X0 = [-1, -1...-1, λ]
                    RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);
                    RealMatrix matrixX_knot_ngtv = NewtonMethod.generateX_knot(matrixV_ngtv);

                    // For newtons method
                    //Initial guess X_knot = [1,1..., 1, λ]
                    double startTime = System.currentTimeMillis();
                    boolean isConverged = NewtonMethod.checkConvergence(spdMatrix, matrixX_knot_pstv);
                    double endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        newTonExctTimes.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = NewtonMethod.checkConvergence(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        newTonExctTimes.add(endTime);
                    }

                    // For Broyden's method starting from Identity matrix
                    //Initial guess X_knot = [1,1..., 1, λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithI(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenIdnttyExctTime.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithI(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenIdnttyExctTime.add(endTime);
                    }


                    // For  Broyden's method starting Jacobian matrix
                    //Initial guess X_knot = [1,1..., 1, λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbExtTime.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbExtTime.add(endTime);
                    }

                }// end of inner loop

                //Record average time among converged cases
                double newtonAveTime = getAverageTime(newTonExctTimes);
                double broydenJAveTime = getAverageTime(broydenIdnttyExctTime);
                double broydenJInvAveTime = getAverageTime(broydenJcbExtTime);
                bw.write(size+ "," + newtonAveTime+ "," + broydenJAveTime + "," + broydenJInvAveTime);

                bw.newLine();

                //Initialize arrays for the next size trials
                newTonExctTimes.clear();
                broydenIdnttyExctTime.clear();
                broydenJcbExtTime.clear();

                System.out.println("\nsize 2 ^ " + i + "is recorded✅\n");


            }// end of outer loop


        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();


    } // end of writeExtTimeCSVfiles1


    /**
     * This method executes 3 algorithms and record average on the csv file
     * Find eigenvalue and eigenvector pair
     * Comparing
     * 1. Newton's method
     * 2. Bryoden with Jacobian matrix
     * 3. "Good" Broyden with Jacobian matrix
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeExtTimeCSVfiles2() throws IOException
    {
        System.out.println("🕰Let's check run time 100 times each method🕰️");

        //Comparing initial guess is positive 50 times
        //And initial guess is negative 50 times

        final int NUM_OF_EXECUTION = 50;
        // 2^9 takes more than 30 minuit my device
        final int NUM_OF_MAX_POWER = 10;

        //For Newton's method
        ArrayList<Double> newTonExctTimes = new ArrayList<>();

        //Broyden's method starting from Jacobi matrix
        ArrayList<Double> broydenJcbExctTime = new ArrayList<>();

        //Good Broyden's method starting from Jacobi matrix
        ArrayList<Double> broydenJcbInvExtTime = new ArrayList<>();


        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ExecutionTimeAve/Case2/Case2_AveTimes.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {
            bw.write("Problem size, Algorithm1(Newton), Algorithm2(Broyden Jacobi), Algorithm3(Good Broyden Jacobi )");
            bw.newLine();
            int size = 0;
            for(int i = 1; i <= NUM_OF_MAX_POWER; i++){

                size = (int) Math.pow(2, i);

                // Record the number of problem size later
                StringBuffer sbSize = new StringBuffer();
                sbSize.append(size);

                for(int j = 0; j< NUM_OF_EXECUTION; j++){

                    // Make SPD real matrix with current size
                    RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);


                    // Construct V is an initial guess V = [1, 1...1], and V = [-1, -1...-1 ]
                    RealMatrix matrixV_pstv = constructVPositive(size);
                    RealMatrix matrixV_ngtv = constructVNegative(size);

                    // Construct X_knot is an initial guess X0 = [1, 1...1, λ], and X0 = [-1, -1...-1, λ]
                    RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);
                    RealMatrix matrixX_knot_ngtv = NewtonMethod.generateX_knot(matrixV_ngtv);

                    // For newtons method
                    //Initial guess X_knot = [1,1..., 1, λ]
                    double startTime = System.currentTimeMillis();
                    boolean isConverged = NewtonMethod.checkConvergence(spdMatrix, matrixX_knot_pstv);
                    double endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        newTonExctTimes.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = NewtonMethod.checkConvergence(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        newTonExctTimes.add(endTime);
                    }

                    // For Broyden's method
                    //Initial guess X_knot = [1,1..., 1, λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbExctTime.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbExctTime.add(endTime);
                    }


                    // For "Good" Broyden's method
                    //Initial guess X_knot = [1,1..., 1, λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithInverseJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbInvExtTime.add(endTime);
                    }

                    //Initial guess v = [-1-1...-1,λ]
                    startTime = System.currentTimeMillis();
                    isConverged = BroydenMethod.checkConvergenceWithInverseJ(spdMatrix, matrixX_knot_pstv);
                    endTime = System.currentTimeMillis() - startTime;
                    if(isConverged){
                        broydenJcbInvExtTime.add(endTime);
                    }

                }// end of inner loop

                //Record average time among convergence cases
                double newtonAveTime = getAverageTime(newTonExctTimes);
                double broydenJAveTime = getAverageTime(broydenJcbExctTime);
                double broydenJInvAveTime = getAverageTime(broydenJcbInvExtTime);
                bw.write(size+ "," + newtonAveTime+ "," + broydenJAveTime + "," + broydenJInvAveTime);

                bw.newLine();

                //Initialize arrays for the next size trials
                newTonExctTimes.clear();
                broydenJcbExctTime.clear();
                broydenJcbInvExtTime.clear();

                System.out.println("\nsize 2 ^ " + i + "is recorded✅\n");


            }// end of outer loop


        }catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();


    } // end of writeExtTimeCSVfiles2

    /**
     *This method executes 3 algorithms starting from 2^1 matrix until 2^10
     * solving Ax = b and find solution vector
     * Record average execution time to a csv file
     * Comparing
     * 1. Steepest Decent method
     * 2. Conjugate Gradient
     * 3. QR factorization
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeExtTimeCSVfiles3() throws IOException
    {
        System.out.println("🕰Let's check run time 100 times each method🕰️");
        final int NUM_OF_EXECUTION = 100;
        // 2^12 takes about 12 hours.
        final int NUM_OF_MAX_POWER = 10;

        //For Steepest Decent method
        ArrayList<Double> stptDcntExctTimes = new ArrayList<>();

        //For Conjugate Gradient method
        ArrayList<Double> cnjgtGrdntExctTime = new ArrayList<>();

        //For QR method
        ArrayList<Double> qrFactExtTime = new ArrayList<>();


        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ExecutionTimeAve/Case3/Case3_AveTimes.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Problem size, Algorithm1(Steepest Decent), Algorithm2(Conjugate Gradient), Algorithm3(QR Factorization )");
            bw.newLine();
            int size = 0;
            for(int i = 1; i <= NUM_OF_MAX_POWER; i++){
                //Max number int JAVA 2147483647,
                // 2^30 = 1073741824, 2^31 = 2147483648

                //Grow size of matrix every iteration
                size = (int) Math.pow(2, i);

                // Record the number of problem size later
                StringBuffer sbSize = new StringBuffer();
                sbSize.append(size); // Record the number of problem size later

                for(int j = 0; j< NUM_OF_EXECUTION; j++){

                    // Make SPD matrix
                    RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);
                    // Construct matrixB with random number
                    RealMatrix mtxB = constructB(size);
                    // Construct X_knot is an initial guess X0 = [1, 1...1]
                    RealMatrix matrixX = constructVPositive(size);


                    // For Newtons method
                    double startTime = System.currentTimeMillis();
                    RealMatrix solvec = SteepestDecent.findSolutionVec(spdMatrix, matrixX);
                    double endTime = System.currentTimeMillis() - startTime;
                    stptDcntExctTimes.add(endTime);

                    // For Conjugate Gradient method
                    startTime = System.currentTimeMillis();
                    solvec = ConjugateGradient.findSolutionVec(spdMatrix, matrixX);
                    endTime = System.currentTimeMillis() - startTime;
                    cnjgtGrdntExctTime.add(endTime);

                    // For QR factorization method
                    startTime = System.currentTimeMillis();
                    solvec = QR_Factorization.findSolutionVec(spdMatrix, matrixX);
                    endTime = System.currentTimeMillis() - startTime;
                    qrFactExtTime.add(endTime);

                }// end of inner loop

                //Record average time among convergence cases
                double stptDcntAveTime = getAverageTime(stptDcntExctTimes);
                double cnjgtGrdntAveTime = getAverageTime(cnjgtGrdntExctTime);
                double qrFactAveTime = getAverageTime(qrFactExtTime);

                bw.write(size+ "," + stptDcntAveTime +"," + cnjgtGrdntAveTime +"," + qrFactAveTime);
                bw.newLine();

                //Initialize arrays for the next size trials
                stptDcntExctTimes.clear();
                cnjgtGrdntExctTime.clear();
                qrFactExtTime.clear();

                System.out.println("\nsize 2 ^ " + i + "is recorded✅\n");

            }// end of outer loop


        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();


    } // end of writeExtTimeCSVfiles3

    /**
     * This method execute 3 algorithms with initial guess positive V = [1,1,..𝜆]
     * Record Absolute error each iteration
     * Comparing
     * 1. Newton's method,
     * 2. Bryoden's with Identity matrix
     * 3. Broyden's with Jacobian matrix
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase1CSVfiles() throws IOException
    {
        // Make max size all the three algorithm can handle to check error
        int size = (int)Math.pow(2, 7);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case1/Case1_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {
            bw.write("Number Iteration,  Algorithm1(Newton), Algorithm2(Broyden with Identity Matrix), Algorithm3(Good Broyden with Jacobi matrix)");
            bw.newLine();

            // Make SPD matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

            // Construct V is an initial guess V = [1, 1...1]
            RealMatrix matrixV_pstv = constructVPositive(size);

            // Construct X_knot is an initial guess X0 = [1, 1...1, λ]
            RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);

            //Newton method record
            ArrayList<Double> errorListNewton = NewtonMethod.findErrorRate(spdMatrix, matrixX_knot_pstv);

            //Broyden method with Identity matrix record
            ArrayList<Double> errorListBroydenIdentty = BroydenMethod.findErrorRateWithI(spdMatrix, matrixX_knot_pstv);

            //Broyden method with Jacobi matrix record
            ArrayList<Double> errorListBroydenJacobi = BroydenMethod.findErrorRateWithJ(spdMatrix, matrixX_knot_pstv);


            //Maximum iteration times for each method
            final int NUM_OF_ITERATION = 10000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListNewton.size()){
                    bw.write(errorListNewton.get(i)+ ",");
                }else{
                    bw.write(0.0 + ",");
                }


                if (i < errorListBroydenIdentty.size()){
                    bw.write(errorListBroydenIdentty.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListBroydenJacobi.size()){
                    bw.write(errorListBroydenJacobi.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            }



        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();
    } // end of writeErrorCase1CSVfiles

    /**
     * This method execute 3 algorithms with initial guess negative V = [-1,-1,...𝜆]
     * Record Absolute error each iteration
     * Comparing
     * 1. Newton's method,
     * 2. Bryoden's with Identity matrix
     * 3. Broyden's with Jacobian matrix
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase2CSVfiles() throws IOException
    {

        // Make max size all the three algorithm can handle to check error
        int size = (int)Math.pow(2, 7);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case2/Case2_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Number Iteration,  Algorithm1(Newton), Algorithm2(Broyden with Identity Matrix), Algorithm3(Good Broyden with Jacobi matrix)");
            bw.newLine();

            // Make SPD matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

            // Construct V is an initial guess V = [1, 1...1]
            RealMatrix matrixV_pstv = constructVNegative(size);

            // Construct X_knot is an initial guess X0 = [1, 1...1, λ]
            RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);

            //Newton method record
            ArrayList<Double> errorListNewton = NewtonMethod.findErrorRate(spdMatrix, matrixX_knot_pstv);

            //Broyden method with Identity matrix record
            ArrayList<Double> errorListBroydenIdentty = BroydenMethod.findErrorRateWithI(spdMatrix, matrixX_knot_pstv);

            //Good Broyden method with Jacobi record
            ArrayList<Double> errorListBroydenJacobi = BroydenMethod.findErrorRateWithJ(spdMatrix, matrixX_knot_pstv);


            //Max number of iteration
            final int NUM_OF_ITERATION = 10000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListNewton.size()){
                    bw.write(errorListNewton.get(i)+ ",");
                }else{
                    bw.write(0.0 + ",");
                }


                if (i < errorListBroydenIdentty.size()){
                    bw.write(errorListBroydenIdentty.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListBroydenJacobi.size()){
                    bw.write(errorListBroydenJacobi.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            }

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();

    } // end of writeErrorCase2CSVfiles

    /**
     * This method execute 3 algorithms with initial guess positive V = [1, 1...𝜆]
     * Comparing
     * 1. Newton's method
     * 2. Bryoden with Jacobian matrix
     * 3. "Good" Broyden with Jacobian matrix
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase3CSVfiles() throws IOException
    {

        // Make max size all the three algorithm can handle to check error
        int size = (int)Math.pow(2, 10);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case3/Case3_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Number Iteration,  Algorithm1(Newton), Algorithm2(Broyden with Jacobi), Algorithm3(Good Broyden with Jacobi)");
            bw.newLine();

            // Make three identical real matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);


            // Construct V is an initial guess V = [1, 1...1]
            RealMatrix matrixV_pstv = constructVPositive(size);

            // Construct X_knot is an initial guess X0 = [1, 1...1, λ]
            RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);

            //Newton method record
            ArrayList<Double> errorListNewton = NewtonMethod.findErrorRate(spdMatrix, matrixX_knot_pstv);
            System.out.println("Newton done\n");

            //Broyden method with Jacobi record
            ArrayList<Double> errorListBroydenJacobi = BroydenMethod.findErrorRateWithJ(spdMatrix, matrixX_knot_pstv);
            System.out.println("Broyden done\n");

            //Good Broyden method with Jacobi record
            ArrayList<Double> errorListBroydenJacobiInve = BroydenMethod.findErrorRateWithInverseJ(spdMatrix, matrixX_knot_pstv);


            //Write classical multiplication time
            final int NUM_OF_ITERATION = 1000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListNewton.size()){
                    bw.write(errorListNewton.get(i)+ ",");
                }else{
                    bw.write(0.0 + ",");
                }


                if (i < errorListBroydenJacobi.size()){
                    bw.write(errorListBroydenJacobi.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListBroydenJacobiInve.size()){
                    bw.write(errorListBroydenJacobiInve.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            }



        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();

    } // end of writeErrorCase3CSVfiles

    /**
     * This method execute 3 algorithms with initial guess negative V = [-1, -1...𝜆]
     * Comparing
     * 1. Newton's method,
     * 2. Broyden with Jacobian matrix,
     * 3. "Good" Broyden with Jacobian matrix
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase4CSVfiles() throws IOException
    {

        // Make max size all the three algorithm can handle to check error
        int size = (int)Math.pow(2, 10);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case4/Case4_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Number Iteration,  Algorithm1(Newton), Algorithm2(Broyden Jacobi), Algorithm3(Good Broyden with Jacobi)");
            bw.newLine();

            // Make SPD matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);


            // Construct V is an initial guess  V = [-1, -1...-1 ]
            RealMatrix matrixV_ngtv = constructVNegative(size);

            // Construct X_knot is an initial guess  X0 = [-1, -1...-1, λ]
            RealMatrix matrixX_knot_ngtv = NewtonMethod.generateX_knot(matrixV_ngtv);

            //Newton's method
            ArrayList<Double> errorListNewton = NewtonMethod.findErrorRate(spdMatrix, matrixX_knot_ngtv);
            System.out.println("Newton done\n");

            //Broyden's method with Jacobi
            ArrayList<Double> errorListBroydenJacobi = BroydenMethod.findErrorRateWithJ(spdMatrix, matrixX_knot_ngtv);
            System.out.println("Broyden done\n");

            //Good Broyden method with Jacobi record
            ArrayList<Double> errorListBroydenJacobiInve = BroydenMethod.findErrorRateWithInverseJ(spdMatrix, matrixX_knot_ngtv);


            //Max number iteration time
            final int NUM_OF_ITERATION = 100000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListNewton.size()){
                    bw.write(errorListNewton.get(i)+ ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListBroydenJacobi.size()){
                    bw.write(errorListBroydenJacobi.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListBroydenJacobiInve.size()){
                    bw.write(errorListBroydenJacobiInve.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            } // end of for loop

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();

    } // end of writeErrorCase4CSVfiles

    /**
     * This method execute 3 algorithms with initial guess positive V = [1, 1...]
     * Comparing these method to solve Ax = b for finding a solution vector
     * 1. Steepest Decent
     * 2. Conjugate Gradient
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase5CSVfiles() throws IOException
    {

        // Make max size all the three algorithm can handle to check error
        // Maximum size to handle is 2^12 because of heap memory.
        //But it takes more than a day
        int size = (int)Math.pow(2, 10);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case5/Case5_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Number Iteration,  Algorithm1(Steepest Decent), Algorithm2(Conjugate Gradient)");
            bw.newLine();

            // Make SPD matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

            // Construct V is an initial guess  V = [1, 1... ]
            RealMatrix matrixB_pstv = constructVPositive(size);

            //Steepest Decent method error list
            ArrayList<Double> errorListSD = SteepestDecent.findErrorRateWithPst(spdMatrix, matrixB_pstv);

            //Conjugate Gradient method error list
            ArrayList<Double> errorListCG    = ConjugateGradient.findErrorRateWithPst(spdMatrix, matrixB_pstv);

            //Max number of iteration for each method
            final int NUM_OF_ITERATION = 100000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListSD.size()){
                    bw.write(errorListSD.get(i)+ ",");
                }else{

                    bw.write(0.0 + ",");
                }

                if (i < errorListCG.size()){
                    bw.write(errorListCG.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            } // end of for loop

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();

    } // end of writeErrorCase5CSVfiles

    /**
     * This method execute 3 algorithms with initial guess negative V = [-1, -1...]
     * Comparing these method to solve Ax = b for a finding solution vector
     * 1. Steepest Decent
     * 2. Conjugate Gradient
     * Pick one matrix  all the three can handle and record error rates on the csv file
     * @Param N/A
     * @Return csv file which has average execution time
     */
    public static void  writeErrorCase6CSVfiles() throws IOException
    {
        // Make max size all the three algorithm can handle to check error
        // Maximum size to handle is 2^12 because of heap memory.
        //But it takes more than a day
        int size = (int)Math.pow(2, 10);

        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/MAT 4210/Project/FinalProject/DataSet/ErrorAnalysis/Case6/Case6_ErrorAnalysis.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("Number Iteration,  Algorithm1(Steepest Decent), Algorithm2(Conjugate Gradient)");
            bw.newLine();

            // Make SPD matrix
            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

            // Construct V is an initial guess  V = [-1,-1, ... ]
            RealMatrix matrixB_pstv = constructVNegative(size);

            //Steepest Decent method error list
            ArrayList<Double> errorListSD = SteepestDecent.findErrorRateWithNgt(spdMatrix, matrixB_pstv);

            //Conjugate Gradient method error list
            ArrayList<Double> errorListCG    = ConjugateGradient.findErrorRateWithNgt(spdMatrix, matrixB_pstv);

            //Max number of iteration each method
            final int NUM_OF_ITERATION = 100000;
            for(int i = 0; i < NUM_OF_ITERATION;  i++){
                bw.write(i+1 + ",");

                if (i < errorListSD.size()){
                    bw.write(errorListSD.get(i)+ ",");
                }else{
                    bw.write(0.0 + ",");
                }

                if (i < errorListCG.size()){
                    bw.write(errorListCG.get(i) + ",");
                }else{
                    bw.write(0.0 + ",");
                }

                bw.newLine();
            } // end of for loop

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // end of catch

        //Make scv file to export
        bw.close();
        fw.close();

    } // end of writeErrorCase6CSVfiles


    // Helper method

    /**
     * This method constructs initial guess column vector with v = [1, 1...1]
     * @Param int size, the size of column vector
     * @Return RealMatrix colVec, filled up with 1
     */
    public static RealMatrix constructVPositive (int size)
    {
        final double INITIAL_VAL = 1.0;
        double[] valOfV = new double[size];
      for(int i = 0; i <size; i++){
            valOfV[i] = INITIAL_VAL;
      } // end of loop
        return new Array2DRowRealMatrix(valOfV);
    } // end of constructVPositive

    /**
     * This method constructs initial guess column vector with v = [-1, -1...-1]
     * @Param int size, the size of column vector
     * @Return RealMatrix colVec, filled up with -1
     */
    public static RealMatrix constructVNegative (int size)
    {
        final double INITIAL_VAL = -1.0;
        double[] valOfV = new double[size];
        for(int i = 0; i <size; i++){
            valOfV[i] = INITIAL_VAL;
        } // end of loop
        return new Array2DRowRealMatrix(valOfV);
    } // end of constructVNegative

    /**
     * This method constructs matrixB for Ax = b
     * @Param int size, the size of column vector
     * @Return RealMatrix colVec, filled up with random value
     */
    public static RealMatrix constructB (int size)
    {
        final double MAX_VAL = 100.0000;
        final double MIN_VAL = -100.0000;

        Random rand = new Random();

        double[] valOfB = new double[size];
        for(int i = 0; i <size; i++){
            valOfB[i] = rand.nextDouble() * (MAX_VAL - MIN_VAL) + MIN_VAL;;
        } // end of loop
        return new Array2DRowRealMatrix(valOfB);
    } // end of constructVPositive

    /**
     * Calculate average time for execution time
     * @Param ArrayList<Double>,  the list of execution times
     * @Return double result, Calculation result
     */
    public static double getAverageTime(ArrayList<Double> listOfTimes)
    {
        double result = 0.0;
        double sum = 0.0;
        //The first one is outlier
        int totalSize = listOfTimes.size() - 1;

        for (int i = 1; i < listOfTimes.size(); i++){
            sum += listOfTimes.get(i);
        }
        result = sum / totalSize;

        return result;
    } // end of get average



} // end of FileWrite.WriteFile
