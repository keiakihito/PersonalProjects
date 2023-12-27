package Methods;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SteepestDecentTest {

    @Test
    void findSolutionVec()
    {
        //Solution vector x = {{-1.2727}, {2.1818}}
        double[][] arrayA = {{5.0, 2.0}, {2.0, 3.0}};
        double[][] arrayB = {{-2}, {4}};
        RealMatrix matrixA = new Array2DRowRealMatrix(arrayA);
        RealMatrix realVecB =  new Array2DRowRealMatrix(arrayB);

        RealMatrix solVexXQR = QR_Factorization.findSolutionVec(matrixA, realVecB);
        System.out.println("Conjugation Gradient Method vector x: ");
        System.out.println(solVexXQR.toString());

        RealMatrix solVecXCG = ConjugateGradient.findSolutionVec(matrixA, realVecB);
        System.out.println("Conjugation Gradient Method solution vector x: ");
        System.out.println(solVecXCG.toString());

        RealMatrix solVecXSD = SteepestDecent.findSolutionVec(matrixA, realVecB);
        System.out.println("Steepest Decent Method solution vector x: ");
        System.out.println(solVecXSD.toString());

    }
}