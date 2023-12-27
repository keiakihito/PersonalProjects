package Methods;

import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NewtonMethodTest {

    @Test
    void stub_test() {

        System.out.println("\n\n~~  Stub test ~~ \n\n");
        RealMatrix matrixA = null;
        RealMatrix matrixV = null;
        RealMatrix matrixX = null;
        RealMatrix matrixF = null;
        RealMatrix matrixJ = null;

        NewtonMethod.generateX_knot(matrixV);
        NewtonMethod.constructF(matrixA, matrixX);
//        NewtonMethod.fillUpRowF(matrixF, matrixA, matrixX);
//        NewtonMethod.fillUpLastRowF(matrixF, matrixA, matrixX);
//        NewtonMethod.fillUpRowJ(matrixJ, matrixX);
//        NewtonMethod.fillUpLastRowJ(matrixJ, matrixX);
        NewtonMethod.checkEpsilon(matrixX, matrixF);

        System.out.println("\n\n~~  ✅✅Stub test passed✅✅~~ \n\n");
    }

    @Test
    void findLambda(){
        System.out.println("\n\n~~  findLambda test ~~ \n\n");
        boolean test = true;

//        if(test) {
//            //My imitial guess
//            double[] arrayV = {2.0, -2.0};
//            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
//            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);
//
//            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
//            RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);
//
//            double lambda = NewtonMethod.findLambda(matrixA, matrixX_knot);
//
//            System.out.println("lambda: " + lambda);
//
//        }

        if(test) {
            double[] arrayV = {1.0, 1.0, 1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);

            double[][] arrayA = {{4.0, -2.0, 2.0}, {-2.0, 5.0, 1}, {2.0, 1, 3}};
            RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);
            System.out.println("\nMatrixA:");
            System.out.println(matrixA.toString());

            double lambda = NewtonMethod.findLambda(matrixA, matrixX_knot);

            System.out.println("lambda: " + lambda);

        }

        System.out.println("\n\n~~  ✅✅findLambda test✅✅ ~~ \n\n");
    }

    @Test
    void findErrorRateTest(){
        System.out.println("\n\n~~  findErrorRateTest test ~~ \n\n");

        boolean test = true;
        if(test) {
            double[] arrayV = {1.0, 1.0, 1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);

            double[][] arrayA = {{4.0, -2.0, 2.0}, {-2.0, 5.0, 1}, {2.0, 1, 3}};
            RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);

            ArrayList<Double> errorList = NewtonMethod.findErrorRate(matrixA, matrixX_knot);
            System.out.println(errorList.toString());

        }


        System.out.println("\n\n~~  ✅✅findErrorRateTest test✅✅ ~~ \n\n");

    }

    @Test
    void generateX_knot() {
        System.out.println("\n\n~~  generateX_knot test ~~ \n\n");
        boolean test = true;

        if(test) {
            double[] arrayV = {1.0, 1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);

            System.out.println(matrixX_knot.toString());

        }

        if(test) {
            double[] arrayV = {1.0, -1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);

            System.out.println(matrixX_knot.toString());

        }

            System.out.println("\n\n~~  ✅✅generateX_knot test passed✅✅~~ \n\n");
    }

    @Test
    void constructF() {
        System.out.println("\n\n~~  constructF test ~~ \n\n");


        System.out.println("\n\n~~  ✅✅constructF test passed✅✅~~ \n\n");

    }

    @Test
    void fillUpRowF() {

        System.out.println("\n\n~~  fillUpRowF test ~~ \n\n");

        boolean test = true;

        if(test) {
            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);
            System.out.println(matrixA.toString());

            double[] arrayV = {1.0, 1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);
            System.out.println(matrixX_knot.toString());

            RealMatrix matrixF = NewtonMethod.constructF(matrixA, matrixX_knot);
            System.out.println(matrixF.toString());

        }

        System.out.println("\n\n~~  ✅✅fillUpRowF test passed✅✅~~ \n\n");

    }

    @Test
    void fillUpLastRowF() {

        System.out.println("\n\n~~  fillUpLastRowF test ~~ \n\n");

        double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
        RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);
        System.out.println(matrixA.toString());

        double[] arrayV = {1.0, 1.0};
        RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
        RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);
        System.out.println(matrixX_knot.toString());

        RealMatrix matrixF = NewtonMethod.constructF(matrixA, matrixX_knot);
        System.out.println(matrixF.toString());


        System.out.println("\n\n~~  ✅✅fillUpLastRowF test passed✅✅~~ \n\n");

    }

    @Test
    void constructJ() {

        System.out.println("\n\n~~  constructJ test ~~ \n\n");
        boolean test = true;
        if(test) {
            double[][] arrayA = {{3.0, -1.0}, {-1.0, 3.0}};
            RealMatrix matrixA = NewtonMethod.convertRealMatrix(arrayA);
            System.out.println("\nMatrixA:");
            System.out.println(matrixA.toString());

            double[] arrayV = {1.0, 1.0};
            RealMatrix matrixV = NewtonMethod.convertRealMatrix(arrayV);
            RealMatrix matrixX_knot = NewtonMethod.generateX_knot(matrixV);
            System.out.println("\nMatrixX:");
            System.out.println(matrixX_knot.toString());

//            RealMatrix matrixF = NewtonMethod.constructF(matrixA, matrixX_knot);
//            System.out.println(matrixF.toString());

            RealMatrix matrixJ = NewtonMethod.constructJ(matrixA, matrixX_knot);
            System.out.println("\nMatrixJ:");
            System.out.println(matrixJ.toString());


        }

        System.out.println("\n\n~~  ✅✅constructJ test passed✅✅~~ \n\n");

    }

    @Test
    void fillUpRowJ() {

        System.out.println("\n\n~~  fillUpRowJ test ~~ \n\n");


        System.out.println("\n\n~~  ✅✅fillUpRowJ test passed✅✅~~ \n\n");

    }

    @Test
    void fillUpLastRowJ() {

        System.out.println("\n\n~~  fillUpLastRowJ test ~~ \n\n");


        System.out.println("\n\n~~  ✅✅fillUpLastRowJ test passed✅✅~~ \n\n");

    }

    @Test
    void checkEpsilon() {

        System.out.println("\n\n~~  checkEpsilon test ~~ \n\n");
        boolean test = true;

        if(test){
            double[] arrayX_crrnt = {1.0, 1.0, 1.000001};
            RealMatrix matrixX_crrnt = NewtonMethod.convertRealMatrix(arrayX_crrnt);

            double[] arrayX_pre = {1.0, 1.0, 1.000000};
            RealMatrix matrixX_pre = NewtonMethod.convertRealMatrix(arrayX_pre);

            boolean lessEpsilon = NewtonMethod.checkEpsilon(matrixX_crrnt, matrixX_pre);

            assertEquals(true, lessEpsilon);

            lessEpsilon = NewtonMethod.checkEpsilon(matrixX_pre, matrixX_crrnt);

            assertEquals(true, lessEpsilon);
        }

        if(test){
            double[] arrayX_crrnt = {1.0, 1.0, 1.000002};
            RealMatrix matrixX_crrnt = NewtonMethod.convertRealMatrix(arrayX_crrnt);

            double[] arrayX_pre = {1.0, 1.0, 1.000000};
            RealMatrix matrixX_pre = NewtonMethod.convertRealMatrix(arrayX_pre);

            boolean lessEpsilon = NewtonMethod.checkEpsilon(matrixX_crrnt, matrixX_pre);

            assertEquals(false, lessEpsilon);

            lessEpsilon = NewtonMethod.checkEpsilon(matrixX_pre, matrixX_crrnt);

            assertEquals(false, lessEpsilon);

        }


        if(test){
            double[] arrayX_crrnt = {1.0, 1.0, 1.1};
            RealMatrix matrixX_crrnt = NewtonMethod.convertRealMatrix(arrayX_crrnt);

            double[] arrayX_pre = {1.0, 1.0, 1.000000};
            RealMatrix matrixX_pre = NewtonMethod.convertRealMatrix(arrayX_pre);

            boolean lessEpsilon = NewtonMethod.checkEpsilon(matrixX_crrnt, matrixX_pre);

            assertEquals(false, lessEpsilon);

            lessEpsilon = NewtonMethod.checkEpsilon(matrixX_pre, matrixX_crrnt);

            assertEquals(false, lessEpsilon);
        }



        System.out.println("\n\n~~  ✅✅checkEpsilon test passed✅✅~~ \n\n");

    }


}