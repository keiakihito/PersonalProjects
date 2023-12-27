/**
 * Class name, BroydenMethod.java
 * Author Keita Katsumi
 * MAT 4210 Fall 2023
 * Final project
 * Description:
 * The class is a utility class to execute Broyden's method which finds λ and eigenvector pair.
 * There are some variation.
 * 1. Standard Broyden's method which has an initial guess of matrix A is an Identity matrix or a Jacobian matrix
 * 2. "Good" Broyden's method which has an initial guess of matrix A is an Identity matrix or a Jacobian matrix
 * Last modified Dec 23rd, 2023
 */

package Methods;

import org.apache.commons.math3.linear.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class BroydenMethod {

    //Standard Broyden's method implementation

    /**
     * Broyden's method in system
     * The method accept real matrix and initial guess x knot.
     * Set matrixA = Identity matrix or J(X)
     * Keep iterating until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from the last row value in the current solution vector X
     */
    public static double findLambdaWithI(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 10000;

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixI = constructI(matrixA.getRowDimension()+1);
        RealMatrix matrixA_pre = matrixI.copy(); // A0

        //Make X1
        // Initial guess A = I(X)
        //Ax = b solve for x
        // I(x) * delta = -F(X), solve for delta
        DecompositionSolver solver = new LUDecomposition(matrixA_pre).getSolver();
        RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
        RealMatrix matrixX_pre = matrixX_i.copy();
        matrixX_i = matrixX_i.add(delta); // Xi


        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION && loop){
//            System.out.println("\n\n~~ Iteration " + counter +" ~~");

            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix matrixF_result = constructF(matrixA, matrixX_i).subtract(constructF(matrixA, matrixX_pre));
            RealMatrix matrixAMultDelta = matrixA_pre.multiply(delta);
            RealMatrix numerator = matrixF_result.subtract(matrixAMultDelta);
            numerator = numerator.multiply(delta.transpose());

            //Calculate denominator
            RealMatrix denominator = delta.transpose().multiply(delta);
            double denoScalar = denominator.getEntry(0,0);

            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            RealMatrix matrixA_crrnt = matrixA_pre.add(numerator.scalarMultiply(1/ denoScalar));


//            System.out.println(" \n- - - Ax = b part - - - ");
            //LU decomposition
            solver = new LUDecomposition(matrixA_crrnt).getSolver();
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return 0.0 / 0.0;
            }
            matrixF_Xi = constructF(matrixA, matrixX_i);
            delta = solver.solve(matrixF_Xi.scalarMultiply(-1.0));

            //X(i+1) = Xi + delta_i
            matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                loop = false;
            }else{
                matrixA_pre = matrixA_crrnt.copy();
                counter++;
            }

        } // end of while

        if (counter == NUM_OF_MAX_ITERATION){ return 0.0 / 0.0;}

        double lambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        return lambda;
    }

    /**
     * Broyden's method in system for find error rate
     * The method accept real matrix and initial guess x knot.
     * Set matrixA = Identity matrix or J(X)
     * Keep iterating until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from the last row value in the current solution vector X
     */
    public static ArrayList<Double> findErrorRateWithI(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 10000;

        ArrayList<Double> errorList = new ArrayList<Double>();

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixI = constructI(matrixA.getRowDimension()+1);
        RealMatrix matrixA_pre = matrixI.copy(); // A0

        //Make X1
        // Initial guess A = I(X)
        //Ax = b solve for x
        // I(x) * delta = -F(X), solve for delta
        DecompositionSolver solver = new LUDecomposition(matrixA_pre).getSolver();
        RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
        RealMatrix matrixX_pre = matrixX_i.copy();
        matrixX_i = matrixX_i.add(delta); // Xi


        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION && loop){

            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix matrixF_result = constructF(matrixA, matrixX_i).subtract(constructF(matrixA, matrixX_pre));
            RealMatrix matrixAMultDelta = matrixA_pre.multiply(delta);
            RealMatrix numerator = matrixF_result.subtract(matrixAMultDelta);
            numerator = numerator.multiply(delta.transpose());

            //Calculate denominator
            RealMatrix denominator = delta.transpose().multiply(delta);
            double denoScalar = denominator.getEntry(0,0);

            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            RealMatrix matrixA_crrnt = matrixA_pre.add(numerator.scalarMultiply(1/ denoScalar));


//            System.out.println(" \n- - - Ax = b part - - - ");
            //LU decomposition
            solver = new LUDecomposition(matrixA_crrnt).getSolver();
            matrixF_Xi = constructF(matrixA, matrixX_i);
            delta = solver.solve(matrixF_Xi.scalarMultiply(-1.0));

            matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            double crrntLambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
            double pstLambda = matrixX_pre.getEntry(matrixX_pre.getRowDimension() - 1, 0);
            double error = Math.abs(crrntLambda - pstLambda);
            errorList.add(error);
            if(checkEpsilon(matrixX_i, matrixX_pre)){
                loop = false;
            }else{
                matrixA_pre = matrixA_crrnt.copy();
                counter++;
            }

        } // end of while

        return errorList;
    }


    /**
     * Broyden's method in system checks it converges or not.
     * @Param RealMatrix matrixA , Matrix A for Av = 𝜆v
     * @Param double matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return boolean
     */
    public static boolean checkConvergenceWithI(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        boolean isConverged = false;
        double lambda = findLambdaWithI(matrixA, matrixX_knot);
        // Check the lambda is NaN or not
        if (!Double.isNaN(lambda)){
            isConverged = true;
        }

        return isConverged;
    }


    /**
     * Broyden's method in system
     * The method accept real matrix and initial guess x knot.
     * Set matrixA = J(X)
     * Keep iterating until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from  the last row value in the current solution vector X
     */
    public static double findLambdaWithJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 10000;

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_pre = matrixJ.copy(); // A0

        //Make X1
        // Initial guess A = I(X)
        //Ax = b solve for x
        // I(x) * delta = -F(X), solve for delta
        DecompositionSolver solver = new LUDecomposition(matrixA_pre).getSolver();
        RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
        RealMatrix matrixX_pre = matrixX_i.copy();
        matrixX_i = matrixX_i.add(delta); // Xi


        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION && loop){
//             System.out.println("\n\n~~ Iteration " + counter +" ~~");

             //Broyden's method
            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix matrixF_result = constructF(matrixA, matrixX_i).subtract(constructF(matrixA, matrixX_pre));
            RealMatrix matrixAMultDelta = matrixA_pre.multiply(delta);
            RealMatrix numerator = matrixF_result.subtract(matrixAMultDelta);
            numerator = numerator.multiply(delta.transpose());

            //Calculate denominator
            RealMatrix denominator = delta.transpose().multiply(delta);
            double denoScalar = denominator.getEntry(0,0);

            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            RealMatrix matrixA_crrnt = matrixA_pre.add(numerator.scalarMultiply(1/ denoScalar));


//            System.out.println(" \n- - - Ax = b part - - - ");

            //LU decomposition
            solver = new LUDecomposition(matrixA_crrnt).getSolver();
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return 0.0 / 0.0;
            }
            matrixF_Xi = constructF(matrixA, matrixX_i);
            delta = solver.solve(matrixF_Xi.scalarMultiply(-1.0));


            // Store current Xi for calculating stopping condition
            matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                loop = false;
            }else{
                matrixA_pre = matrixA_crrnt.copy();
                counter++;
            }

        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return 0.0 / 0.0;}

        double lambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        return lambda;
    }

    /**
     * Broyden's method in system
     * Get eigenvector
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return RealMatrix matrixX_i, solution vector with 𝜆
     */
    public static RealMatrix findEigenVec(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100000;

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_pre = matrixJ.copy(); // A0

        //Make X1
        // Initial guess A = I(X)
        //Ax = b solve for x
        // I(x) * delta = -F(X), solve for delta
        DecompositionSolver solver = new LUDecomposition(matrixA_pre).getSolver();
        RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
        RealMatrix matrixX_pre = matrixX_i.copy();
        matrixX_i = matrixX_i.add(delta); // Xi


        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION && loop){
//            System.out.println("\n\n~~ Iteration " + counter +" ~~");

            //Broyden's method
            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix matrixF_result = constructF(matrixA, matrixX_i).subtract(constructF(matrixA, matrixX_pre));
            RealMatrix matrixAMultDelta = matrixA_pre.multiply(delta);
            RealMatrix numerator = matrixF_result.subtract(matrixAMultDelta);
            numerator = numerator.multiply(delta.transpose());

            //Calculate denominator
            RealMatrix denominator = delta.transpose().multiply(delta);
            double denoScalar = denominator.getEntry(0,0);

            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            RealMatrix matrixA_crrnt = matrixA_pre.add(numerator.scalarMultiply(1/ denoScalar));


            //Ax = b
            //LU decomposition
            solver = new LUDecomposition(matrixA_crrnt).getSolver();
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return null;
            }
            matrixF_Xi = constructF(matrixA, matrixX_i);
            delta = solver.solve(matrixF_Xi.scalarMultiply(-1.0));


            // Store current Xi for calculating stoping condition
            matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                loop = false;
            }else{
                matrixA_pre = matrixA_crrnt.copy();
                counter++;
            }

        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return null;}

        return matrixX_i;
    }


    /**
     * Broyden's method in system checks it converges or not.
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return boolean
     */
    public static boolean checkConvergenceWithJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        boolean isConverged = false;
        double lambda = findLambdaWithJ(matrixA, matrixX_knot);
        // Check the lambda is NaN or not
        if (!Double.isNaN(lambda)){
            isConverged = true;
        }

        return isConverged;
    }


    /**
     * Broyden's method with Jacobi matrix draw a graph
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return ArrayList<Double> errorList
     */
    public static ArrayList<Double> findErrorRateWithJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100000;

        ArrayList<Double> errorList = new ArrayList<Double>();

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_pre = matrixJ.copy(); // A0

        //Make X1
        // Initial guess A = J(X)
        //Ax = b solve for x
        // J(x) * delta = -F(X), solve for delta
        DecompositionSolver solver = new LUDecomposition(matrixA_pre).getSolver();
        RealMatrix delta = solver.solve(matrixF.scalarMultiply(-1.0));
        RealMatrix matrixX_pre = matrixX_i.copy();
        matrixX_i = matrixX_i.add(delta); // Xi


        // Need X1 and X0 to iterate this loop
        //Broyden's method
        //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
        //Ai * delta = F(xi)
        //X(i+1) = Xi + delta
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION && loop){
            if(counter % 1000 == 0){
                System.out.println("\n\n~~ Iteration " + counter +" ~~");
            }

            //Calculate numerator
            // [F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') }
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix matrixF_result = constructF(matrixA, matrixX_i).subtract(constructF(matrixA, matrixX_pre));
            RealMatrix matrixAMultDelta = matrixA_pre.multiply(delta);
            RealMatrix numerator = matrixF_result.subtract(matrixAMultDelta);
            numerator = numerator.multiply(delta.transpose());

            //Calculate denominator
            //(delta' * delta)
            RealMatrix denominator = delta.transpose().multiply(delta);
            double denoScalar = denominator.getEntry(0,0);

            //A_crrnt = A_pre + {[F(x_crrnt)- F(x_pre) - A_pre * delta] * (delta') } / (delta' * delta)
            RealMatrix matrixA_crrnt = matrixA_pre.add(numerator.scalarMultiply(1/ denoScalar));

            //LU decomposition
            //Ai * delta = F(xi)
            solver = new LUDecomposition(matrixA_crrnt).getSolver();
            if (!solver.isNonSingular()) {
                System.out.println("A matrix is singular and it cannot iterates anymore");
                return errorList;
            }
            matrixF_Xi = constructF(matrixA, matrixX_i);
            delta = solver.solve(matrixF_Xi.scalarMultiply(-1.0));


            //X(i+1) = Xi + delta
            matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi


            if(checkEpsilon(matrixX_i, matrixX_pre)){
                loop = false;
            }else{
                matrixA_pre = matrixA_crrnt.copy();
                counter++;
            }

            //Calculate eigenvalue difference between next Xi and current Xi
            double error = getError(matrixX_i, matrixX_pre);
            errorList.add(error);

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }
        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return null;}


        //counter is number of iteration
        return errorList;
    }





    //"Good" Broyden's method implementation

    /**
     * AKA "good "Broyden's method in system
     * The method accept real matrix and initial guess x knot.
     * Set matrixA = J(X)
     * Keep iterating until the lambda converges
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return double lambda, eigenvalue from  the last row value in the current solution vector X
     */
    public static double findLambdaWithInverseJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 100000;

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_inv_crrnt = null;

        //Make A_knot_inverse
        try {
            matrixA_inv_crrnt = new LUDecomposition(matrixJ).getSolver().getInverse();
        } catch (SingularMatrixException e) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return 0.0/0.0; // Return NaN
        }



        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION){
                if(counter % 1000 == 0){
                    System.out.println("\n\n~~ Iteration " + counter +" ~~");
                }




            //Update Xi with calculating delta
            // X_current = delta + X_pre
            // Initial guess A = J(X)
            matrixF = constructF(matrixA, matrixX_i);
            //△ = (-1) * A^(-1) * F(X_i)
            RealMatrix delta = matrixA_inv_crrnt.multiply(matrixF).scalarMultiply(-1.0);
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }

            //"Good" Broyden's method
            //Let matrixY = F(X_i) - F(X_pre)
            //inverseA_next =
            // inverseA_crrnt + {[△ - inverseA_crrnt * matrixY] * (delta)(T) * inverseA_crrnt } / (delta(T) * inverseA_crrnt * matrixY)

            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix numerator = delta.subtract(matrixA_inv_crrnt.multiply(matrixY)).multiply(delta.transpose().multiply(matrixA_inv_crrnt));

            //Calculate denominator
            RealMatrix denoMtx = delta.transpose().multiply(matrixA_inv_crrnt.multiply(matrixY));
            double denoSclar = denoMtx.getEntry(0,0);

            //Update matrixA_inverse
            matrixA_inv_crrnt = matrixA_inv_crrnt.add(numerator.scalarMultiply(1 / denoSclar));



        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return 0.0 / 0.0;}

        double lambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        return lambda;
    }

    /**
     * Good Broyden's method in system
     * Get eigenvector
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return RealMatrix matrixX_i, eigen vector with 𝜆
     */
    public static RealMatrix findEigenVecWithInverseJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 10000;

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_inv_crrnt = null;

        //Make A_knot_inverse
        try {
            matrixA_inv_crrnt = new LUDecomposition(matrixJ).getSolver().getInverse();
        } catch (SingularMatrixException e) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null; // Return NaN
        }



        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION){
//             System.out.println("\n\n~~ Iteration " + counter +" ~~");



            //Update Xi with calculating delta
            // X_current = delta + X_pre
            // Initial guess A = J(X)
            matrixF = constructF(matrixA, matrixX_i);
            //△ = (-1) * A^(-1) * F(X_i)
            RealMatrix delta = matrixA_inv_crrnt.multiply(matrixF).scalarMultiply(-1.0);
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }

            //"Good" Broyden's method
            //Let matrixY = F(X_i) - F(X_pre)
            //inverseA_next =
            // inverseA_crrnt + {[△ - inverseA_crrnt * matrixY] * (delta)(T) * inverseA_crrnt } / (delta(T) * inverseA_crrnt * matrixY)

            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix numerator = delta.subtract(matrixA_inv_crrnt.multiply(matrixY)).multiply(delta.transpose().multiply(matrixA_inv_crrnt));

            //Calculate denominator
            RealMatrix denoMtx = delta.transpose().multiply(matrixA_inv_crrnt.multiply(matrixY));
            double denoSclar = denoMtx.getEntry(0,0);

            //Update matrixA_inverse
            matrixA_inv_crrnt = matrixA_inv_crrnt.add(numerator.scalarMultiply(1 / denoSclar));



        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return null;}


        return matrixX_i;
    }


    /**
     * Good Broyden's method in system checks it converges or not.
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrix X_knot, initial column vector X0 with last row is 𝜆
     * @Return boolean
     */
    public static boolean checkConvergenceWithInverseJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        boolean isConverged = false;
        double lambda = findLambdaWithInverseJ(matrixA, matrixX_knot);
        // Check the lambda is NaN or not
        if (!Double.isNaN(lambda)){
            isConverged = true;
        }

        return isConverged;
    }

    /**
     * Broyden's method with Jacobi matrix draw a graph
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX_knot, initial column vector X0 with last row is 𝜆
     * @Return ArrayList<Double> errorList
     */
    public static ArrayList<Double> findErrorRateWithInverseJ(RealMatrix matrixA, RealMatrix matrixX_knot)
    {
        final int NUM_OF_MAX_ITERATION = 10000;

        ArrayList<Double> errorList = new ArrayList<Double>();

        //Make Xi vector, system F(X),  Identity matrix I(X)
        RealMatrix matrixX_i = matrixX_knot.copy();
        RealMatrix matrixF = constructF(matrixA, matrixX_i);
        RealMatrix matrixJ = constructJ(matrixA, matrixX_knot);
        RealMatrix matrixA_inv_crrnt = null;

        //Make A_knot_inverse
        try {
            matrixA_inv_crrnt = new LUDecomposition(matrixJ).getSolver().getInverse();
        } catch (SingularMatrixException e) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null; // Return NaN
        }



        // Need X1 and X0 to iterate this loop
        int counter = 1;
        boolean loop = true;
        while(counter<= NUM_OF_MAX_ITERATION){
            if(counter % 100 == 0){
                System.out.println("\n\n~~ Iteration " + counter +" ~~");
            }

            //Update Xi with calculating delta
            // X_current = delta + X_pre
            // Initial guess A = J(X)
            matrixF = constructF(matrixA, matrixX_i);
            //△ = (-1) * A^(-1) * F(X_i)
            RealMatrix delta = matrixA_inv_crrnt.multiply(matrixF).scalarMultiply(-1.0);
            RealMatrix matrixX_pre = matrixX_i.copy();
            matrixX_i = matrixX_i.add(delta); // Xi

            //Calculate eigenvalue difference between next Xi and current Xi
            double error = getError(matrixX_i, matrixX_pre);
            errorList.add(error);

            if(checkEpsilon(matrixX_i, matrixX_pre)){
                break;
            }else{
                counter++;
            }

            //"Good" Broyden's method
            //Let matrixY = F(X_i) - F(X_pre)
            //inverseA_next =
            // inverseA_crrnt + {[△ - inverseA_crrnt * matrixY] * (delta)(T) * inverseA_crrnt } / (delta(T) * inverseA_crrnt * matrixY)

            //Calculate numerator
            RealMatrix matrixF_Xi = constructF(matrixA, matrixX_i);
            RealMatrix matrixF_Xpre = constructF(matrixA, matrixX_pre);
            RealMatrix matrixY = matrixF_Xi.subtract(matrixF_Xpre);
            RealMatrix numerator = delta.subtract(matrixA_inv_crrnt.multiply(matrixY)).multiply(delta.transpose().multiply(matrixA_inv_crrnt));

            //Calculate denominator
            RealMatrix denoMtx = delta.transpose().multiply(matrixA_inv_crrnt.multiply(matrixY));
            double denoSclar = denoMtx.getEntry(0,0);

            //Update matrixA_inverse
            matrixA_inv_crrnt = matrixA_inv_crrnt.add(numerator.scalarMultiply(1 / denoSclar));


        } // end of while

        // When it doesn't converge, it returns NaN
        if (counter == NUM_OF_MAX_ITERATION){ return null;}

        //Omit the first one
        errorList.remove(0);

        //counter is number of iteration
        return errorList;
    }



    // Sub methods

    /**
     * generateX_kont with matrixV, initial guess
     * @Param RealMatrix matrixV, initial column vector X0 with last row is 𝜆
     * @Return RealMatrix matrixX_knot, column vector x= [v1, v2...𝜆]
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
     * constructI, it constructs the identity matrix with given size.
     * @Param int size, desired matrix size.
     * @Return RealMatrix matrixI, Identity matrix with the size of parameter
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



    /**
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
     * constructJacobi, construct Jacobi matrix with partial derivative
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return RealMatrix matrixJ, J(X) in the system substituting Ax
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
     * @Param double[][] valOfJ,
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
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
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
     * constructF
     * @Param RealMatrix matrixA, Matrix A for Av = 𝜆v
     * @Param RealMatrix matrixX, column vector v= [v1, v2...𝜆]
     * @Return double matrixF
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
     * @Param double[]valOfF,
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
     * Check difference between previous lambda and current lambda is less than epsilon
     * @Param, RealMatrix matrixX_current, current column vector X for Ax = b
     * @Param RealMatrix matrixX_pre, previous column vector X for Ax = b
     * @Return boolean
     */
    public static boolean checkEpsilon(RealMatrix matrixX_crrnt, RealMatrix matrixX_pre)
    {
        final double EPSILON =1e-4;

        int lstRowIndx = matrixX_crrnt.getRowDimension() - 1;
        double crrntLambda = matrixX_crrnt.getEntry(lstRowIndx, 0);
        double pstLambda = matrixX_pre.getEntry(lstRowIndx, 0);
        double error = Math.abs(crrntLambda - pstLambda);
//        System.out.println("\n\nERROR_DIFF" + error);
//        System.out.println(error < EPSILON);


        return ((error< EPSILON));
    }// end of checkEpsilon

    /**
     * Calculate error difference between  X(i+1) - X(i)
     * @Param RealMatrix matrixX_i, current column vector X for Ax = b
     * @Param RealMatrix matrixX_pre, previous column vector X for Ax = b
     * @Return error
     */
    public static double getError(RealMatrix matrixX_i, RealMatrix matrixX_pre)
    {
        double crrntLambda = matrixX_i.getEntry(matrixX_i.getRowDimension()-1, 0);
        double pstLambda = matrixX_pre.getEntry(matrixX_pre.getRowDimension() - 1, 0);
        double error = Math.abs(crrntLambda - pstLambda);
        return error;
    } // end of getError



} // end of BroydenMethod class
