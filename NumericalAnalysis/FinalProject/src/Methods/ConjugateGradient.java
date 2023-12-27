/**
 * Class name, Conjugate Gradient.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 * Description:
 * This class is a utility class for Conjugate Gradient method
 * findSolutionVec solves Ax =b with an iterative way
 * And it is used for calculating average execution time
 * with Steepest Gradient and QR_Factorization method utility classes
 * Last modified Dec 23rd, 2023
 */

package Methods;

import org.apache.commons.math3.linear.*;

import java.util.ArrayList;


public class ConjugateGradient
{
    /**
     * ConjugateGradient application to find eigenvalue
     * Making a Jacobi and iterates until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Ax = b
     * @Param RalMatrix matrix solMtxb, Matrix b  for Ax = b
     * @Return RealMatrix matrixX_i, solution vector X for Ax = b
     */
    public static RealMatrix findSolutionVec(RealMatrix matrixA, RealMatrix solMtxb)
    {


        final int NUM_OF_MAX_ITERATION = 10000;

        RealMatrix matrixX_i = constructVPositive(matrixA.getRowDimension());
        RealMatrix realMatrixB = solMtxb.copy();
        RealMatrix realMatrixA = matrixA.copy();

        //Find the steepest descent P_knot, b-Ax_knot = -r_knot
        //P_i = b-Ax_i = -r_i, steepest gradient
        RealMatrix p_i =realMatrixB.subtract(realMatrixA.multiply(matrixX_i));
        RealMatrix r_i = p_i.scalarMultiply(-1.0);


        //loop
        int counter = 1;
        while(counter < NUM_OF_MAX_ITERATION){
            RealMatrix alphaNum = (p_i.transpose().multiply(r_i));
            double alphaNumVal = alphaNum.getEntry(0,0);

            // Save A*p_i for the later calculation
            RealMatrix AMultP_i =realMatrixA.multiply(p_i);
            RealMatrix alphaDeno = (p_i.transpose().multiply(AMultP_i));
            double alphaDenoVal = alphaDeno.getEntry(0,0);

            //Scalar to update next matrixX_i
            double alpha = (-1) * alphaNumVal / alphaDenoVal;
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(p_i.scalarMultiply(alpha));

            // update the steepest descent,  r_i = A * solution vector x - solution vector b
            r_i = realMatrixA.multiply(matrixX_i).subtract(realMatrixB);

            if (checkEpsilon(r_i)){
                return matrixX_i;
            }

            //Find beta_i for the next iteration
            RealMatrix betaNume= p_i.transpose().multiply(realMatrixA.multiply(r_i));
            double betaNumeVal = betaNume.getEntry(0,0);
            RealMatrix betaDeno = p_i.transpose().multiply(AMultP_i);
            double betaDenoVal = betaDeno.getEntry(0,0);
            double beta = betaNumeVal / betaDenoVal;
            p_i = r_i.scalarMultiply(-1.0).add(p_i.scalarMultiply(beta));

            counter++;
        }

        return matrixX_i;
    }

    /**
     * Conjugate Gradient iterative method for drawing error analysis
     * The method collects error each iteration as a list
     * @Param RealMatrix matrixA, system for Ax = b
     * @Param RealMatrix solMtxb, RHS column vector for Ax = b
     * @Return ArrayList<Double> errorList
     */
    public static ArrayList<Double> findErrorRateWithPst(RealMatrix matrixA, RealMatrix solMtxb)
    {
        ArrayList<Double> errorList = new ArrayList<Double>();

        final int NUM_OF_MAX_ITERATION = 10000;

        RealMatrix matrixX_i = constructVPositive(matrixA.getRowDimension());
        RealMatrix realMatrixB = solMtxb.copy();
        RealMatrix realMatrixA = matrixA.copy();

        //Find the steepest descent P_knot, b-Ax_knot = -r_knot
        //P_i = b-Ax_i = -r_i, steepest gradient
        RealMatrix p_i =realMatrixB.subtract(realMatrixA.multiply(matrixX_i));
        RealMatrix r_i = p_i.scalarMultiply(-1.0);

        //loop
        int counter = 1;
        while(counter < NUM_OF_MAX_ITERATION){
            RealMatrix alphaNum = (p_i.transpose().multiply(r_i));
            double alphaNumVal = alphaNum.getEntry(0,0);

            // Save A*p_i for the later calculation
            RealMatrix AMultP_i =realMatrixA.multiply(p_i);
            RealMatrix alphaDeno = (p_i.transpose().multiply(AMultP_i));
            double alphaDenoVal = alphaDeno.getEntry(0,0);

            //Scalar to update next matrixX_i
            double alpha = (-1) * alphaNumVal / alphaDenoVal;
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(p_i.scalarMultiply(alpha));

            //Calculate eigenvalue difference between next Xi and current Xi
            double error = getError(matrixX_i, matrixX_pre);
            errorList.add(error);

            // update the steepest descent,  r_i = A * solution vector x - solution vector b
            r_i = realMatrixA.multiply(matrixX_i).subtract(realMatrixB);

            if (checkEpsilon(r_i)){
                return errorList;
            }

            //Find beta_i for the next iteration
            RealMatrix betaNume= p_i.transpose().multiply(realMatrixA.multiply(r_i));
            double betaNumeVal = betaNume.getEntry(0,0);

            RealMatrix betaDeno = p_i.transpose().multiply(AMultP_i);
            double betaDenoVal = betaDeno.getEntry(0,0);
            double beta = betaNumeVal / betaDenoVal;
            p_i = r_i.scalarMultiply(-1.0).add(p_i.scalarMultiply(beta));

            counter++;
        }

        return errorList;
    }// end of findErrorRateWithPst

    /**
     * Steepest Decent iterative method for drawing error analysis
     * The method collects error each iteration as a list
     * @Param RealMatrix matrixA, system for Ax = b
     * @Param RealMatrix solMtxb, RHS column vector for Ax = b
     * @Return ArrayList<Double> errorList
     */
    public static ArrayList<Double> findErrorRateWithNgt(RealMatrix matrixA, RealMatrix solMtxb)
    {
        ArrayList<Double> errorList = new ArrayList<Double>();

        final int NUM_OF_MAX_ITERATION = 10000;

        RealMatrix matrixX_i = constructVNegative(matrixA.getRowDimension());
        RealMatrix realMatrixB = solMtxb.copy();
        RealMatrix realMatrixA = matrixA.copy();

        //Find the steepest descent P_knot, b-Ax_knot = -r_knot
        //P_i = b-Ax_i = -r_i, steepest gradient
        RealMatrix p_i =realMatrixB.subtract(realMatrixA.multiply(matrixX_i));
        RealMatrix r_i = p_i.scalarMultiply(-1.0);

        //loop
        int counter = 1;
        while(counter < NUM_OF_MAX_ITERATION){
            RealMatrix alphaNum = (p_i.transpose().multiply(r_i));
            double alphaNumVal = alphaNum.getEntry(0,0);

            // Save A*p_i for the later calculation
            RealMatrix AMultP_i =realMatrixA.multiply(p_i);
            RealMatrix alphaDeno = (p_i.transpose().multiply(AMultP_i));
            double alphaDenoVal = alphaDeno.getEntry(0,0);

            //Scalar to update next matrixX_i
            double alpha = (-1) * alphaNumVal / alphaDenoVal;
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(p_i.scalarMultiply(alpha));

            //Calculate eigenvalue difference between next Xi and current Xi
            double error = getError(matrixX_i, matrixX_pre);
            errorList.add(error);

            // update the steepest descent,  r_i = A * solution vector x - solution vector b
            r_i = realMatrixA.multiply(matrixX_i).subtract(realMatrixB);

            if (checkEpsilon(r_i)){
                return errorList;
            }

            //Find beta_i for the next iteration
            RealMatrix betaNume= p_i.transpose().multiply(realMatrixA.multiply(r_i));
            double betaNumeVal = betaNume.getEntry(0,0);

            RealMatrix betaDeno = p_i.transpose().multiply(AMultP_i);
            double betaDenoVal = betaDeno.getEntry(0,0);
            double beta = betaNumeVal / betaDenoVal;
            p_i = r_i.scalarMultiply(-1.0).add(p_i.scalarMultiply(beta));

            counter++;
        }

        return errorList;
    } // end of findErrorRateWithNgt

    /**
     * Check difference between previous residual and current residual is less than epsilon
     * @Param, RealMatrix matrixR, residual r = -(-Ax+b)
     * @Return boolean
     */
    public static boolean checkEpsilon(RealMatrix matrixR)
    {
        final double EPSILON =1e-10;

        int lstRowIndx = matrixR.getRowDimension() - 1;
        double valOfR = matrixR.getEntry(lstRowIndx, 0);

        return (Math.abs(valOfR) < EPSILON);
    }// end of checkEpsilon


    /**
     * Calculate error difference between  X(i+1) - X(i)
     * @Param RealMatrix matrixX_i, current solution vector x
     * @Param RealMatrix matrixX_pre, previous solution vector x
     * @Return error
     */
    public static double getError(RealMatrix matrixX_i, RealMatrix matrixX_pre)
    {
        double crrntLambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        double pstLambda = matrixX_pre.getEntry(matrixX_pre.getRowDimension() - 1, 0);
        double error = Math.abs(crrntLambda - pstLambda);
        return error;
    } // end of getError

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


} // end of ConjugateGradient
