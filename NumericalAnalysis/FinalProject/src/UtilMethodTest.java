import Methods.UtilMethod;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;

import static org.apache.commons.math3.linear.MatrixUtils.isSymmetric;

class UtilMethodTest {

    @org.junit.jupiter.api.Test
    void generateMatrixWithEigenvalues() {

    }

    @org.junit.jupiter.api.Test
    void isPositiveDefinite() {
        // Create a symmetric positive definite matrix
        double[][] matrixData = {
                {4, 1, 2},
                {1, 5, 6},
                {2, 6, 3}
        };
        RealMatrix matrix = new Array2DRowRealMatrix(matrixData);
        RealMatrix copiedMatrix = matrix.copy(); // Duplicate matrix

        // Check for symmetry
        if (isSymmetric(matrix, 0.001)) {
            System.out.println("Matrix is symmetric.");
        } else {
            System.out.println("Matrix is not symmetric.");
            return;
        }

        // Check for positive definiteness
        if (UtilMethod.isPositiveDefinite(matrix)) {
            System.out.println("Matrix is positive definite.");
        } else {
            System.out.println("Matrix is not positive definite.");
        }

        double[][] matrixData2 = {
                {3, 1, -1},
                {1, 4, 2},
                {-1, 2, 5}
        };
        RealMatrix matrix2 = new Array2DRowRealMatrix(matrixData2);



        // Check for symmetry
        if (isSymmetric(matrix2, 0.001)) {
            System.out.println("Matrix is symmetric.");
        } else {
            System.out.println("Matrix is not symmetric.");
            return;
        }

        // Check for positive definiteness
        if (UtilMethod.isPositiveDefinite(matrix2)) {
            System.out.println("Matrix is positive definite.");
        } else {
            System.out.println("Matrix is not positive definite.");
        }




    } // end of is PositiveDefinite

    @Test
    void generateSPDMatrix() {

        int counter = 0;
        int size = 0;

        //Max number of int in Java is 2^32 - 1 = 214748364
        for (int i = 2; i < 32; i++){
            if(i < 32){
                size = (int) Math.pow(2, i);
            }else{
                size = (int) Math.pow(2, i) - 1;
            }

            while (counter < 100){
                // i is size of matrix
                RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);
                if(UtilMethod.isSPD(spdMatrix)){
                    counter++;
                }
            }


            System.out.println("\nsize " + size  + " SPD matrix found");
        }


        System.out.println("\n👏👏👏SPDs found!👏👏👏");

    }
} // end of test suite