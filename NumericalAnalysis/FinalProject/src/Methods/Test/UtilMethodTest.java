package Methods;

import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;

import static FileWrite.WriteFile.constructVPositive;
import static org.junit.jupiter.api.Assertions.*;

class UtilMethodTest {

    @Test
    void isSPD()
    {
        int size =2;
        RealMatrix matrixV_pstv = constructVPositive(size);
//        RealMatrix matrixX_knot_pstv = ConjugateGradient.generateX_knot(matrixV_pstv);
//        System.out.println(matrixX_knot_pstv.toString());

        double[][] arrayA = {{100.0, -1.0}, {-1.0, 100.0}};
//        RealMatrix matrixA = ConjugateGradient.convertRealMatrix(arrayA);
//        double lambda = ConjugateGradient.findLambda(matrixA, matrixX_knot_pstv);

//        System.out.println(UtilMethod.isSPD(matrixJ));

//        double[][] arrayB = {{10.0, -1.0, -1.0}, {-1.0, 10.0, -1.0}, {-1.0, -1.0, 10.0}};
//        RealMatrix matrixB = BroydenMethod.convertRealMatrix(arrayB);
//        System.out.println(UtilMethod.isSPD(matrixB));
//
//        double[] arrayV = {1.0, 1.0, 1.0};
//        RealMatrix matrixV = BroydenMethod.convertRealMatrix(arrayV);
//        RealMatrix matrixX_knot = BroydenMethod.generateX_knot(matrixV);
//
//        for (int i = 0; i < 100; i++){
//            int size = (int) Math.pow(2, 8);
//            RealMatrix matrixV_pstv = constructVPositive(size);
//            RealMatrix matrixX_knot_pstv = ConjugateGradient.generateX_knot(matrixV_pstv);
//            RealMatrix spdMatrix= UtilMethod.generateSPDMatrix(size);
//            RealMatrix matrixJ = ConjugateGradient.constructJ(spdMatrix, matrixX_knot_pstv);
//            if(UtilMethod.isSPD(matrixJ)){
//                System.out.println("SPD!");
//            }
//        }


    }
}