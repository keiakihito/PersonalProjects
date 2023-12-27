/**
 * Class name, QR_Factorization.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 * Description:
 * This class is a utility class for QR_Factorization method
 * findSolutionVec solves Ax =b
 * And it is used for calculating average execution time
 * with Steepest Gradient and Conjugate gradient method utility classes
 * Last modified Dec 23rd, 2023
 */

package Methods;

import org.apache.commons.math3.linear.*;

import java.util.ArrayList;

public class QR_Factorization
{
    /**
     * Basic QR_Factorization algorithm to solve Ax = b
     * @Param RealMatrix matrixA, Matrix A for Ax = b
     * @Param RalMatrix matrix realMtxB, Matrix b  for Ax = b
     * @Return RealMatrix matrixEigVals, solution vector X for Ax = b
     */
    public static RealMatrix findSolutionVec(RealMatrix matrixA, RealMatrix realMtxB)
    {
        // Perform QR decomposition of matrixA
        //A = QR
        // where Q is an orthogonal matrix Q(T) * Q = I
        // And R is  an upper triangular matrix.
        QRDecomposition qrDecomposition = new QRDecomposition(matrixA);
        RealMatrix matrixR = qrDecomposition.getR();
        RealMatrix matrixQ = qrDecomposition.getQ();

        //Solve Ax = b by substituting A = QR -> (QR)x = b
        // Q = Q^(-1) = Q(T) since Q is an orthogonal matrix
        // Ax = b
        //-> (QR)x = b
        // -> Rx = Q^(-1)*b
        // -> Rx = Q(T) *b
        //Let x is solution vector x to be solved
        DecompositionSolver solver = new QRDecomposition(matrixR).getSolver();
        if (!solver.isNonSingular()) {
            System.out.println("A matrix is singular and it cannot be solved");
            return null;
        }
        // -> Rx = Q(T) *b
        RealMatrix solVecX = solver.solve(matrixQ.transpose().multiply(realMtxB));

        //After solving it, we get solution vector X
        return solVecX;
    }


    /**
     * Basic QR_Factorization algorithm to find multiple eigenvalue
     * Making a Jacobi and iterates until the lambda converges
     * @Param RealMatrix matrixA, initial matrix A and it gets update until finding eigenvalues
     * @Return RealMatrix matrixEigVals, Diagonal eigen values matrix after converged
     */
    public static RealMatrix findLambdaWithBasicQR(RealMatrix matrixA)
    {
        final int NUM_OF_MAX_ITERATION = 100000;


        //Make an initial matrix A and it gets updated
        RealMatrix matrixEigVals = matrixA.copy();
        RealMatrix matrixPre = null;


        int counter = 1;

        //Keep updating matrix A until diagonal value becomes eigenvalues
        while(counter<= NUM_OF_MAX_ITERATION ){
            matrixPre = matrixEigVals.copy();
            matrixEigVals = decomposeAndUpdate(matrixPre);
            if(checkEpsilonEigVals(matrixEigVals)){
                break;
            }else{
                counter++;
            }

        } // end of while

        if (counter == NUM_OF_MAX_ITERATION){ return null;}

        return matrixEigVals;
    } // end of findLambda


    /**
     * decomposeAndUpdate does decompose matrix A to matrix Q and matrix R
     * then, it updates matrix A with R * Q
     * @Param RealMatrix A, Matrix A for Ax = b
     * @Return RealMatrix updateA
     */
    public static RealMatrix decomposeAndUpdate(RealMatrix matrixA)
    {
        // Perform QR decomposition
        QRDecomposition decomposition = new QRDecomposition(matrixA);
        RealMatrix matrixQ = decomposition.getQ();
        RealMatrix matrixR = decomposition.getR();

        // Update A as A <- R * Q
        RealMatrix updatedA = matrixR.multiply(matrixQ);
        return updatedA;
    }


    //FIXME Need more research and study how the HouseHoder transformation works
    /**
     * HouseHolder Transformation QR_Factorization algorithm to find multiple eigenvalue
     * @Param RealMatrix matrixA, Matrix A for Ax = b
     * @Return RealMatrix matrixEigVals, Diagonal eigen values matrix
     */
    public static RealMatrix findLambdaWithHouseHolderT(RealMatrix matrixA){
        final int NUM_OF_MAX_ITERATION = 100000;

        RealMatrix matrixEigVals = matrixA.copy();
        //Q_knot is Identity matrix
        RealMatrix matrixQ_pre = constructI(matrixA.getRowDimension());
        RealMatrix matrixQ_crrnt = null;
        RealMatrix matrixQ_chld = null;
        RealMatrix matrixR = null;

        int counter = 1;
        boolean loop = true;
        while(loop && counter <= NUM_OF_MAX_ITERATION){

            QRDecomposition decomposition = new QRDecomposition(matrixEigVals);
            RealMatrix matrixEigValsHHT = decomposition.getH();

            // Perform QR decomposition
            decomposition = new QRDecomposition(matrixEigValsHHT.multiply(matrixQ_pre));
            matrixQ_crrnt = decomposition.getQ();
            matrixR = decomposition.getR();
            matrixQ_chld = matrixQ_pre.transpose().multiply(matrixQ_crrnt);
            matrixEigVals = matrixR.multiply(matrixQ_chld);
            matrixQ_pre = matrixQ_crrnt;

            if(checkEpsilonEigVals(matrixEigVals)){
                loop = false;
            }else{
                counter++;
            }

        }

        return matrixEigVals;
    }

    //FIXME Need more research and study how the HouseHoder transformation works
    /**
     * HouseHolder transformation with Rayleigh Quotient Iteration QR_Factorization algorithm
     * to find multiple eigenvalue
     * @Param RealMatrix matrixA, Matrix A for Ax = b
     * @Return RealMatrix matrixEigs, Diagonal eigen values matrix
     */
    public static RealMatrix findLambdaWithHT_RQI(RealMatrix matrixA){
        return null;
    }


    /**
     * constructI, it constructs the identity matrix with given size.
     * @Param int size, size of matrix
     * @Return RealMatrix matrixI, identity matrix with desired size.
     */
    public static RealMatrix constructI(int size)
    {
        double[][] valOfI = new double[size][size];
        int lstIdx = size -1;
        for (int c_wk = 0; c_wk <= lstIdx; c_wk++){
            // Store 1 into all the diagonal index
            valOfI[c_wk][c_wk] = 1.0;
        }

        RealMatrix matrixI = convertRealMatrix(valOfI);
        return matrixI;
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


    /**
     * Check all the non-diagonal values are close to zero
     * @Param, RealMatrix mtxEignVal, current matrix A with eigenvalues
     * @Return boolean
     */
    public static boolean checkEpsilonEigVals(RealMatrix mtxEignVal)
    {
        final double EPSILON =1e-10;
        double error = 0.0;
        for (int r_wk =0; r_wk < mtxEignVal.getRowDimension(); r_wk++){
            for(int c_wk = 0; c_wk < mtxEignVal.getRowDimension(); c_wk++){
                if (c_wk == r_wk) {continue;} // Skip diagonal index
                if (Math.abs(mtxEignVal.getEntry(r_wk, c_wk)) < EPSILON){
                    continue;
                }else{
                    return false;
                }
            } // end of inner loop
        } // end of outer loop

        return true;
    }// end of checkEpsilon


    /*
     * Calculate error difference between  X(i+1) - X(i)
     * @param RealMatrix matrixX_i, RealMatrix matrixX_pre
     * @Return double error, difference between current X and previous X
     * */
    public static double getError(RealMatrix matrixX_i, RealMatrix matrixX_pre)
    {
        double crrntLambda = matrixX_i.getEntry(0, 0);
        double pstLambda = matrixX_pre.getEntry(0, 0);
        double error = Math.abs(crrntLambda - pstLambda);
        return error;
    } // end of getError



}// end of QR_Factorization
