/**
 * Class name, NewtonMethod.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 * Description:
 * The class is a utility class to execute Newton's method which finds λ and eigenvector pair.
 * Last modified Dec 23rdth, 2023
 */

package Methods;

import org.apache.commons.math3.linear.*;

import java.util.ArrayList;
import java.util.Random;
public class NewtonMethod
{

    /**
     * Newton's method in system
     * Making a Jacobi and iterates until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from  the last row value in the current solution vector X
     */
    public static double findLambda(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100;

        //Make system F(X), Jacobi J(X), and Jacobi inverse J(X) ^(-1)
        RealMatrix matrixF = constructF(matrixA, matrixX_knot);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixJ_inverse = MatrixUtils.inverse(matrixJ);


        //Make X1
        // xi = x0 - J(x)^(-1) * F(X)
        RealMatrix matrixX_i = matrixX_knot.subtract(matrixJ_inverse.multiply(matrixF));

        //Initialize for the iteration part
        matrixJ = null;
        matrixF = null;

        int counter = 1;
        while(counter<= NUM_OF_MAX_ITERATION ){
//            System.out.println("\n\n~~ Iteration " + counter +" ~~");


            //Solve x for Ax = b
            //In this context J(Xi) * Xi = -F(Xi)
            matrixF = constructF(matrixA, matrixX_i);
            matrixJ = constructJ(matrixA, matrixX_i);
            DecompositionSolver solver = new LUDecomposition(matrixJ).getSolver();
            //Error handling in case of the matrix is a singular
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return 0.0 / 0.0; // Return NaN
            }
            RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));

            // For
            RealMatrix matrixX_pre = matrixX_i.copy();

            //X(i+1) = Xi + delta_i
            matrixX_i = matrixX_i.add(delta);

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }

        } // end of while

        if (counter == 100){ return 0.0 / 0.0;}

        double lambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        return lambda;
    }

    /**
     * Newton's method in system
     * The method accept real matrix and initial guess x knot.
     * Making a Jacobi and iterates until the lambda converges
     * Get eigenvector
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from  the last row value in the current solution vector X
     */
    public static RealMatrix findEigenVec(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100;

        //Make system F(X), Jacobi J(X), and Jacobi inverse J(X) ^(-1)
        RealMatrix matrixF = constructF(matrixA, matrixX_knot);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixJ_inverse = MatrixUtils.inverse(matrixJ);


        //Make X1
        // xi = x0 - J(x)^(-1) * F(X)
        RealMatrix matrixX_i = matrixX_knot.subtract(matrixJ_inverse.multiply(matrixF));

        //Initialize for the iteration part
        matrixJ = null;
        matrixF = null;

        int counter = 1;
        while(counter<= NUM_OF_MAX_ITERATION ){
//            System.out.println("\n\n~~ Iteration " + counter +" ~~");


            //Solve x for Ax = b
            //In this context J(Xi) * Xi = -F(Xi)
            matrixF = constructF(matrixA, matrixX_i);
            matrixJ = constructJ(matrixA, matrixX_i);
            DecompositionSolver solver = new LUDecomposition(matrixJ).getSolver();
            //Error handling in case of the matrix is a singular
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return null; // Return NaN
            }
            RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
            RealMatrix matrixX_pre = matrixX_i.copy();

            //X(i+1) = Xi + delta_i
            matrixX_i = matrixX_i.add(delta);

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }


        } // end of while

        // When it doesn't converge it, it returns null.
        if (counter == 100){return null;}

        return matrixX_i;
    }


    /**
     * Newton's method in system checks it converges or not.
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return boolean
     */
    public static boolean checkConvergence(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        boolean isConverged = false;
        double lambda = findLambda(matrixA, matrixX_knot);
        // Check the lambda is NaN or not
        if (!Double.isNaN(lambda)){
            isConverged = true;
        }

        return isConverged;
    }


    /**
     * Newton's method in system for drawing error analysis
     * The method collects error each iteration as a list
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return ArrayList<Double> errorList
     */
    public static ArrayList<Double> findErrorRate(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100;

        ArrayList<Double> errorList = new ArrayList<Double>();

        //Make system F(X), Jacobi J(X), and Jacobi inverse J(X) ^(-1)
        RealMatrix matrixF = constructF(matrixA, matrixX_knot);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixJ_inverse = MatrixUtils.inverse(matrixJ);


        //Make X1
        // xi = x0 - J(x)^(-1) * F(X)
        RealMatrix matrixX_i = matrixX_knot.subtract(matrixJ_inverse.multiply(matrixF));

        //Initialize for the iteration part
        matrixJ = null;
        matrixF = null;

        int counter = 1;
        while(counter<= NUM_OF_MAX_ITERATION ){
            if(counter % 100 == 0){
                System.out.println("\n\n~~ Iteration " + counter +" ~~");
            }

            //Solve x for Ax = b
            //In this context J(Xi) * Xi = -F(Xi)
            matrixF = constructF(matrixA, matrixX_i);
            matrixJ = constructJ(matrixA, matrixX_i);
            DecompositionSolver solver = new LUDecomposition(matrixJ).getSolver();
            RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
            //Error handling in case of the matrix is a singular
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return errorList; // Return NaN
            }

            //Save current Xi for error calculation
            RealMatrix matrixX_pre = matrixX_i.copy();
            //X(i+1) = Xi + delta_i
            matrixX_i = matrixX_i.add(delta);

            //Calculate eigenvalue difference between next Xi and current Xi
            double error = getError(matrixX_i, matrixX_pre);
            errorList.add(error);

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }
        } // end of while

        return errorList;
    }


    /*
     * Converting double Array or 2D array to real matrix data type
     * @Param double[][] twoDMatrix, any 2D double matrix
     * @Return RealMatrix matrix, converted data type from double to real matrix
     */
    public static RealMatrix convertRealMatrix(double[]singleArray){
        return new Array2DRowRealMatrix(singleArray);
    }

    public static RealMatrix convertRealMatrix(double[][]twoDArray){
        return new Array2DRowRealMatrix(twoDArray);
    }

    /*
     * generateX_kont with matrixV, initial guess
     * @Param RealMatrix matrixV, initial column vector for Av = 𝜆v
     * @Return RealMatrix matriX_knot, column vector v= [v1, v2...𝜆]
     */
    public static RealMatrix generateX_knot(RealMatrix matrixV)
    {
        //Get the size of matrix V
        //Create new empty matrix with 0 and extra space for lambda
        int sizeOfMatrixV = matrixV.getRowDimension();
        double[] matrixX_knotVal= new double[sizeOfMatrixV + 1];
        //Extract values from real matrix to double type
        double[] clmVal = matrixV.getColumn(0);

        //Prep to make real matrix matrixX_knot
        //Copy value from matrixV to matrixX_knot
        for (int i = 0; i < sizeOfMatrixV; i++){
            matrixX_knotVal[i] = clmVal[i];
        }

        //The last row is a place of lambda
        // Set lambda initial value is 0
        matrixX_knotVal[sizeOfMatrixV] = 0.0;


        RealMatrix matrixX_knot = NewtonMethod.convertRealMatrix(matrixX_knotVal);

        return matrixX_knot;
    } // end of generateX_knot

    /**
     * constructF
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return RealMatrix matrixF, F(X) in the system
     */
    public static RealMatrix constructF(RealMatrix matrixA, RealMatrix matrixX)
    {
        //Make empty 2D array to store all the
        int sizeOfF = matrixA.getRowDimension();
        //Matrix F should be N by 1.
        double[] valOfF = new double[sizeOfF + 1];

        // Each row has sum of matrixA[i][j] * matrixX[i]
        fillUpRowF(valOfF, matrixA, matrixX);
        fillUpLastRowF(valOfF, matrixA, matrixX);

        // Create real matrix object with valOfF
        return new Array2DRowRealMatrix(valOfF);

    } // end of constructF

    /**
     * fillUpRow, it fills up from the first row to the last row
     * @Param double[]valOfF
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return void
     */
    public static void fillUpRowF(double[] valOfF, RealMatrix matrixA, RealMatrix matrixX)
    {
        double rowTotal = 0.0;
        int lstIdx = valOfF.length - 1; // Last index of valOfF array
        int lst2ndIdx = valOfF.length - 2; // 2nd last index of ValOfF array

        //r_wk iterates in valOfF array and matrixA from the first index to the 2nd last index
        // Iterates top to bottom
        for(int r_wk = 0; r_wk <= lst2ndIdx; r_wk++){

            //c_wk iterates matrixA the first index to the 2nd last index
            // Iterates left to right
            for (int c_wk = 0; c_wk <= lst2ndIdx; c_wk++){
                //Matrix multiplication of matrix A and matrix X
                // For matrix X c_wk is corresponding to row index since it is n by 1 matrix
                rowTotal += (double) matrixA.getEntry(r_wk, c_wk) * matrixX.getEntry(c_wk, 0);
            } // end of inner loop

            double lambda = matrixX.getEntry(lstIdx, 0);
            rowTotal += -lambda * matrixX.getEntry(r_wk, 0);
            valOfF[r_wk] = rowTotal;
            rowTotal = 0.0; // Initialize for next row calculation
        } // end of outer loop


    } // end of fillUpRowF

    /**
     * fillUpLastRow, it fills up the last row
     * @Param double[][] valOfF
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return void
     */
    public static void fillUpLastRowF(double[] valOfF, RealMatrix matrixA, RealMatrix matrixX)
    {
        //Set the coefficient -(1/2) from the given equation (1/2) * [v] * [v]' = 1, 2-norm version
        final double COEFFICIENT = -0.5;
        double rowTotal = 0.0;
        int lstIdx = matrixX.getRowDimension()-1;
        int lst2ndIdx = matrixX.getRowDimension() - 2;

        // r_wk iterates matrixX from the first index to the 2nd last index
        for (int r_wk = 0; r_wk <= lst2ndIdx; r_wk++){
            rowTotal += COEFFICIENT * Math.pow(matrixX.getEntry(r_wk, 0), 2.0);
        }

        //The last term of the lsat row in F
        // It comes from the given equation (1/2) * [v] * [v]' = 1
        // It follows (-(1/2) * v^2) + (-(1/2) + v^2) + 1 = 0;
        rowTotal += 1;

        valOfF[lstIdx] = rowTotal;

    } // end of fillUpLastRowF


    /**
     * constructJacobi, construct Jacobi matrix with partial derivative
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return double matrixJ, J(X) in the system substituting Ax
     */
    public static RealMatrix constructJ(RealMatrix matrixA, RealMatrix matrixX)
    {
        int size = matrixA.getRowDimension();
        double[][] valOfJ = new double[size + 1][size+1];
        fillUpRowJ(valOfJ, matrixA, matrixX);
        fillUpLastRowJ(valOfJ, matrixX);

        return new Array2DRowRealMatrix(valOfJ);
    } // end of constructJ

    /**
     * fillUpRowJacobi, fill up values from the first row to the second last row for matrixJ
     * @Param double[][] valOfJ
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return void
     */
    public static void fillUpRowJ(double[][] valOfJ, RealMatrix matrixA, RealMatrix matrixX)
    {
        int lstIdx = valOfJ.length - 1;
        int lst2ndIdx = valOfJ.length - 2;
        double lambda = matrixX.getEntry(matrixX.getRowDimension()-1, 0);

        //r_wk iterates the first index to the 2nd last index
        for(int r_wk = 0; r_wk <= lst2ndIdx; r_wk++){
            //Store diagonal value
            valOfJ[r_wk][r_wk] = matrixA.getEntry(r_wk, r_wk) - lambda;
            // c_wk starts 1 index after the diagonal index
            for(int c_wk = r_wk +1 ;c_wk <= lst2ndIdx;c_wk++){
                // Store value symmetrically
                valOfJ[r_wk][c_wk] = matrixA.getEntry(r_wk, c_wk);
                valOfJ[c_wk][r_wk] = matrixA.getEntry(c_wk, r_wk);
            }// end of inner loop

            // Store -Xn from matrixX last index of the current row
            valOfJ[r_wk][lstIdx] = matrixX.getEntry(r_wk, 0) * (-1);

        }// end of outer loop

    } // end of fillUpRow

    /**
     * fillUpLastRowJacobi, fill up values from the first row to the second last row for matrixJ
     * @Param double[][] valOfJ, values to construct a Jacobian matrix
     * @Pram RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return void
     */
    public static void fillUpLastRowJ(double[][] valOfJ,  RealMatrix matrixX)
    {
        int lstIdx = valOfJ.length - 1;
        int lst2ndlstIdx = valOfJ.length - 2;
        //c_wk iterates from the first index to the 2nd last index
        for (int c_wk = 0; c_wk <= lst2ndlstIdx; c_wk++){
            //Partial derivative last row ∂f/∂xn = -xn
            valOfJ[lstIdx][c_wk] = matrixX.getEntry(c_wk, 0) * (-1);
        }
        //Partial derivative last row ∂f/∂入 = 0
        valOfJ[lstIdx][lstIdx] = 0;

    } // end of fillUpLastRowJ

    /**
     * Check difference between previous lambda and current lambda is less than epsilon
     * @Param RealMatrix matrixX_current, current column vector X for Ax = b
     * @Param RealMatrix matrixX_pre, previous column vector X for Ax = b
     * @Return boolean
     */
    public static boolean checkEpsilon(RealMatrix matrixX_crrnt, RealMatrix matrixX_pre)
    {
        final double EPSILON =1e-6;

        int lstRowIndx = matrixX_crrnt.getRowDimension() - 1;
        double crrntLambda = matrixX_crrnt.getEntry(lstRowIndx, 0);
        double pstLambda = matrixX_pre.getEntry(lstRowIndx, 0);

        return (Math.abs(crrntLambda - pstLambda) < EPSILON);
    }// end of checkEpsilon


    /**
    * Calculate error difference between  X(i+1) - X(i)
    * @Param RealMatrix matrixX_i, current column vector X for Ax = b
    * @Param RealMatrix matrixX_pre, previous column vector X for Ax = b
    * @Return error
    * */
    public static double getError(RealMatrix matrixX_i, RealMatrix matrixX_pre)
    {
        double crrntLambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        double pstLambda = matrixX_pre.getEntry(matrixX_pre.getRowDimension() - 1, 0);
        double error = Math.abs(crrntLambda - pstLambda);
        return error;
    } // end of getError



}// end of NewtonMethod class
