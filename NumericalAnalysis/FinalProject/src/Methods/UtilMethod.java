/**
 * Class name, UtilMethod.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 *
 * Description:
 * These methods are helper library to examine each algorithm execution time and residual.
 *
 * Last modified Dec 23rd, 2023
 */

package Methods;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.Random;

import static org.apache.commons.math3.linear.MatrixUtils.isSymmetric;

public class UtilMethod {

    /**
    *The methods create Symmetric Positive Deterministic (SPD) matrix with random double data type
    *@Param int size
    *@Return ReamMatrix SPD matrix
    */
    public static RealMatrix generateSPDMatrix(int size)
    {
        double[][] matrixData = new double[size][size];
        RealMatrix spdMatrix = null;

        final double MAX_DIAG_VAL = 200.0000;
        final double MIN_DIAG_VAL = 100.0000;
        final double MAX_NON_DIAG_VAL = 1.0000;

        Random rand = new Random();


        // Create a random matrix
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    // Diagonal elements range between 20 and 10.
                    matrixData[i][j] = rand.nextDouble() * (MAX_DIAG_VAL - MIN_DIAG_VAL) + MIN_DIAG_VAL;
                } else {
                    // Generating a random value within [-1.0, 1.0] in non diagonal elements
                    matrixData[i][j] = rand.nextDouble() * 2 * MAX_NON_DIAG_VAL - MAX_NON_DIAG_VAL;
                }
            }
        }

        //To ensure making SPD matrix, M(T) * M guarantees the SPD matrix.
        RealMatrix randmMtrx = new Array2DRowRealMatrix(matrixData);
        RealMatrix spdMtrx = randmMtrx.transpose().multiply(randmMtrx);


        return spdMtrx;

    } // end of generateSPDMatrix


    /**
    * The function checks whether the matrix is positive Definite  or not
    * @Param  RealMatrix matrix, square real matrix
    * @Return boolean
    */
    public static boolean isPositiveDefinite(RealMatrix matrix)
    {
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);

        // Get the eigenvalues
        double[] eigenvalues = eigenDecomposition.getRealEigenvalues();

//        printArray(eigenvalues);

        // Check if all eigenvalues are positive
        for (double eigenvalue : eigenvalues) {
            if (eigenvalue <= 0) {
                return false;
            }
        }

        return true;
    } // end of isPositiveDefinite

    /**
    * The function checks whether the matrix is SPD or not
    * @Param  RealMatrix, square real matrix
    * @Return boolean
    */
    public static boolean isSPD(RealMatrix matrix)
    {
        if(isPositiveDefinite(matrix) && isSymmetric(matrix, 0.0001)){
            return true;
        } else{
            return false;
        }
    } // end of isSPD

} // end of UtilMethod class
