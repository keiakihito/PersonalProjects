package Methods;

import FileWrite.WriteFile;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BroydenMethodTest {

    @Test
    void stub_Test(){
        System.out.println("\n\n~~  Stub test ~~ \n\n");
        RealMatrix matrixA = null;
        RealMatrix matrixV = null;
        RealMatrix matrixX = null;
        RealMatrix matrixF = null;
        RealMatrix matrixJ = null;

//        BroydenMethod.findLambdaWithI(matrixA, matrixX);
//        BroydenMethod.findLambdaWithJ(matrixA, matrixX);
//        BroydenMethod.generateX_knot(matrixV);
//        BroydenMethod.constructI(1);
//        BroydenMethod.constructF(matrixA, matrixX);
//        BroydenMethod.fillUpRowF(matrixF, matrixA, matrixX);
//        BroydenMethod.fillUpLastRowF(matrixF, matrixA, matrixX);
//        BroydenMethod.fillUpRowJ(matrixJ, matrixX);
//        BroydenMethod.fillUpLastRowJ(matrixJ, matrixX);
//        BroydenMethod.checkEpsilon(matrixX, matrixF);

        System.out.println("\n\n~~  ✅✅Stub test passed✅✅~~ \n\n");
    }

    @Test
    void findLambdaWithI()
    {
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

        if(test) {
            double[] arrayV = {2.0, -2.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
            System.out.println("\nMatrixA:");
            System.out.println(matrixA.toString());


            double lambda = BroydenMethod.findLambdaWithI(matrixA, matrixX_knot);

            System.out.println("lambda: " + lambda);

        }

//        if(test) {
//            double[] arrayV = {1.0, 1.0};
//            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
//            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);
//
//            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
//            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
//            System.out.println("\nMatrixA:");
//            System.out.println(matrixA.toString());
//
//            double lambda = BroydenMethod.findLambdaWithJ(matrixA, matrixX_knot);
//
//            System.out.println("lambda: " + lambda);
//
//        }

        if(test) {
            double[] arrayV = {1.0, 1.0, 1.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{4.0, -2.0, 2.0}, {-2.0, 5.0, 1}, {2.0, 1, 3}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
            System.out.println("\nMatrixA:");
            System.out.println(matrixA.toString());

            double lambda = BroydenMethod.findLambdaWithI(matrixA, matrixX_knot);

            System.out.println("lambda: " + lambda);

        }



        System.out.println("\n\n~~  ✅✅findLambda test✅✅ ~~ \n\n");
    }

    @Test
    void  findLambdaWithJ()
    {
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

//        if(test) {
//            double[] arrayV = {2.0, -2.0};
//            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
//            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);
//
//            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
//            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
//            System.out.println("\nMatrixA:");
//            System.out.println(matrixA.toString());
//
//
//            double lambda = BroydenMethod.findLambdaWithJ(matrixA, matrixX_knot);
//
//            System.out.println("lambda: " + lambda);
//
//        }

//        if(test) {
//            double[] arrayV = {1.0, 1.0};
//            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
//            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);
//
//            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
//            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);
//            System.out.println("\nMatrixA:");
//            System.out.println(matrixA.toString());
//
//            double lambda = BroydenMethod.findLambdaWithJ(matrixA, matrixX_knot);
//
//            System.out.println("lambda: " + lambda);
//
//        }

        if(test) {
            double[] arrayV = {1.0, 1.0, 1.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{4.0, -2.0, 2.0}, {-2.0, 5.0, 1}, {2.0, 1, 3}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);

            double lambda = BroydenMethod.findLambdaWithJ(matrixA, matrixX_knot);
            ArrayList<Double> error = BroydenMethod.findErrorRateWithJ(matrixA, matrixX_knot);

//            System.out.println("ArrayList error: ");
//            System.out.println(error.toString());

            System.out.println("lambda: " + lambda);

        }


        System.out.println("\n\n~~  ✅✅findLambda test✅✅ ~~ \n\n");
    }

    @Test
    void findLambdaWithInverseJ()
    {
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

        if(test) {
            double[] arrayV = {2.0, -2.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);

            double lambdaNewton = NewtonMethod.findLambda(matrixA, matrixX_knot);
            double lambdaJacobi = BroydenMethod.findLambdaWithJ(matrixA, matrixX_knot);
            double lambdaJacobiInv = BroydenMethod.findLambdaWithInverseJ(matrixA, matrixX_knot);


            System.out.println("Newtons Method Lambda: " + lambdaNewton);
            System.out.println("Broyden's Method Lambda: " + lambdaJacobi);
            System.out.println("Good Broyden's Method Lambda: " + lambdaJacobiInv);

        }

    }

    @Test
    void findEigenVecWithInverseJ(){
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

        if(test) {
            double[] arrayV = {2.0, -2.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);

            RealMatrix newtonEigenVec = NewtonMethod.findEigenVec(matrixA, matrixX_knot);
            RealMatrix jacobiEigenVec = BroydenMethod.findEigenVec(matrixA, matrixX_knot);
            RealMatrix jacobiInvEigenVex = BroydenMethod.findEigenVecWithInverseJ(matrixA, matrixX_knot);


            System.out.println("Newtons Method eigenvector: " + newtonEigenVec.toString());
            System.out.println("Broyden's Method eigenvector: " + jacobiEigenVec.toString());
            System.out.println("Good Broyden's Method eigenvector: " + jacobiInvEigenVex.toString());

        }

    }

    @Test
    void findErrorRateWithInverseJ()
    {
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

        if(test) {
            double[] arrayV = {2.0, -2.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);

            ArrayList<Double> newtonErrorList= NewtonMethod.findErrorRate(matrixA, matrixX_knot);
            ArrayList<Double> jacobiErrorList = BroydenMethod.findErrorRateWithJ(matrixA, matrixX_knot);
            ArrayList<Double> jacobiInvErrorList= BroydenMethod.findErrorRateWithInverseJ(matrixA, matrixX_knot);


            System.out.println("Newtons Method error list: " + newtonErrorList.toString());
            System.out.println("Broyden's Method error list: " + jacobiErrorList.toString());
            System.out.println("Good Broyden's Method error list: " + jacobiInvErrorList.toString());

        }
    }

    @Test
    void generateX_knot() {
    }

    @Test
    void constructI() {
        System.out.println("\n\n~~  construtI test ~~ \n\n");
        boolean test = true;

        if (test){
            int size =4;
            RealMatrix matrixI = BroydenMethod.constructI(4);
            System.out.println(matrixI.toString());
        }


        System.out.println("\n\n~~  ✅✅constructI test passed✅✅~~ \n\n");

    }

    @Test
    void constructJ() {
    }

    @Test
    void fillUpRowJ() {
    }

    @Test
    void fillUpLastRowJ() {
    }

    @Test
    void constructF() {
    }

    @Test
    void fillUpRowF() {
    }

    @Test
    void fillUpLastRowF() {
    }

    @Test
    void checkEpsilon()
    {
        int size = 4;
        // Make three identical real matrix
        RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);

        // Construct V is an initial guess V = [1, 1...1]
        RealMatrix matrixV_pstv = WriteFile.constructVPositive(size);

        // Construct X_knot is an initial guess X0 = [1, 1...1, λ]
        RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);

        //Broyden method with Jacobi record
        ArrayList<Double> errorListBroydenJacobi = BroydenMethod.findErrorRateWithJ(spdMatrix, matrixX_knot_pstv);

    }

    @Test
    void findEigenVec()
    {
        int size = 4;
        boolean test = true;

//        if(test){
//            // Make three identical real matrix
//            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);
//
//            // Construct V is an initial guess V = [1, 1...1]
//            RealMatrix matrixV_pstv = WriteFile.constructVPositive(size);
//
//            // Construct X_knot is an initial guess X0 = [1, 1...1, λ]
//            RealMatrix matrixX_knot_pstv = NewtonMethod.generateX_knot(matrixV_pstv);
//
//            RealMatrix newtonEigenVec = NewtonMethod.findEigenVec(spdMatrix, matrixX_knot_pstv);
//            System.out.println("Newton Eigenvector: ");
//            System.out.println(newtonEigenVec.toString());
//
//            RealMatrix broydenEigenVec = BroydenMethod.findEigenVec(spdMatrix, matrixX_knot_pstv);
//            boolean isConverge = BroydenMethod.checkConvergence(spdMatrix, matrixX_knot_pstv);
//            if(isConverge){
//                System.out.println("Broyden Eigenvector: ");
//                System.out.println(broydenEigenVec.toString());
//            }
//        }


        if(test) {
            double[] arrayV = {1.0, 1.0, 1.0};
            RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);

            double[][] arrayA = {{4.0, -2.0, 2.0}, {-2.0, 5.0, 1}, {2.0, 1, 3}};
            RealMatrix matrixA = BroydenMethod.convertRealMatrix(arrayA);

            RealMatrix newtonEigenVec = NewtonMethod.findEigenVec(matrixA, matrixX_knot);
            System.out.println("Newton Eigenvector: ");
            System.out.println(newtonEigenVec.toString());

            RealMatrix broydenEigenVec = BroydenMethod.findEigenVec(matrixA, matrixX_knot);
            System.out.println("Broyden Eigenvector: ");
            System.out.println(broydenEigenVec.toString());

        }


    }

}