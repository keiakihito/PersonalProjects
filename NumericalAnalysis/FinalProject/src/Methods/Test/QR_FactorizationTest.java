package Methods;

import org.apache.commons.math3.linear.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QR_FactorizationTest {

    @Test
    void solveX()
    {
        boolean test = true;
        if(test) {
//            double[] arrayV = {1.0, 1.0, 1.0};
//            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
//            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{5.0, 2.0}, {2.0, 3.0}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
//            System.out.println(UtilMethod.isSPD(matrixA));
//            matrixA = QR_Factorization.findLambda(matrixA);
//            System.out.println("QR_Factorization eigen value" + matrixA.toString());

            double[][] arrayB = {{-2.0}, {4.0}};
            RealMatrix solutionVecb = BroydenMethod.convertRealMatrix(arrayB);
            DecompositionSolver solver = new QRDecomposition(matrixA).getSolver();
            RealMatrix matrixX = solver.solve(solutionVecb);

            System.out.println("solution x for matrix A: " + matrixX.toString());

            // It shows the matrix A solution is different from
            // matrix A after  Householder transform solution x
            // The eigen vector should be the same tough.
            QRDecomposition qrDecomposition = new QRDecomposition(matrixA);
            RealMatrix matrixA_UH = qrDecomposition.getH();
            solver = new QRDecomposition(matrixA_UH).getSolver();
            RealMatrix matrixX2 = solver.solve(solutionVecb);

            System.out.println("Solution x for after Householder transformation: " + matrixX2);


        }
    }

    @Test
    void findLambdaWithBasicQR()
    {
//        double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
        double[][] arrayA = {{3.0, -1.0, -0.5}, {-1.0, 3.0, 2.0}, {-0.5, 2.0, 3.0}};
        RealMatrix matrixA = new Array2DRowRealMatrix(arrayA);

//        RealMatrix basicQREigVals = QR_Factorization.findLambdaWithBasicQR(matrixA);
//        System.out.println("BasicQR eigenvalues: " + basicQREigVals);

//        RealMatrix HHTEigVals = QR_Factorization.findLambdaWithHouseHolderT(matrixA);
//        System.out.println("HHT eigenvalues: " + HHTEigVals);


    }

    @Test
    void findSolutionVec()
    {
        //Solution vector x = {{-1.2727}, {2.1818}}
        double[][] arrayA = {{5.0, 2.0}, {2.0, 3.0}};
        double[][] arrayB = {{-2}, {4}};
        RealMatrix matrixA = new Array2DRowRealMatrix(arrayA);
        RealMatrix realVecB =  new Array2DRowRealMatrix(arrayB);

        RealMatrix solVecX = QR_Factorization.findSolutionVec(matrixA, realVecB);
        System.out.println(solVecX.toString());

    }


}