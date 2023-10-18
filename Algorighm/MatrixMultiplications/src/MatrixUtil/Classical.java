package MatrixUtil;

public class Classical {

    /**
     * a) ClassicalMatrixMultiplication
     * Multiple 2  given Matrix with 3 loops
     * @Param mtxA, the first given matrix
     * @Param mtxB, the second given matrix
     * @return int[][] mtxC, the result of multiplication
     */
    public static int [][] classicalMatrixMultiplication(int[][]mtxA, int [][] mtxB){

        assert checkClmAndRw(mtxA,mtxB) : "The number of colum of matrix A and the number of row matrix B should be equal.";
//        //Check given 2 matrix meets the requirement for multiplication
//        if (!checkClmAndRw(mtxA,mtxB)) {return null;}


        //Make a new row matrix A row by matrix B column
        int [][] mtxC =  new int[mtxA.length][mtxB[0].length];

        //The first loop iterates matrix A row
        //Multiple matrix A row and matrix B column
        //When the first loop finishes iterating the last row of Matrix A and the last column of Matrix B,,
        //it gets out the three nested loop
        //Let iterator, matrix A row walker, call mA_r_wk
        for (int mA_r_wk = 0; mA_r_wk <mtxA.length; mA_r_wk++){

            //The second loop iterates the matrix B column
            //When it iterates the last column of matrix B,
            //it moves to the next row of Matrix A.
            //Let iterator, matrix B column walker, call mB_c_wk
            for (int mB_c_wk = 0; mB_c_wk< mtxB[0].length; mB_c_wk++){

                //The third loop iterates Matrix A column == Matrix B column
                //It multiplies each corresponding value and sum up
                //After multiplying each values, it stores the total sum to Matrix C
                //Let iterator, wk,
                for(int wk = 0; wk < mtxA[0].length; wk++){
                    mtxC[mA_r_wk][mB_c_wk] += mtxA[mA_r_wk][wk] * mtxB[wk][mB_c_wk];

                }

            }
        }

        return mtxC;
    }





    // Helper methods
    /**
     * Check two matrices are identical
     * It will be useful to compare calculation result of three different algorithms
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isIdentical(int[][]mtxA, int[][]mtxB){

        //Check the number of column and row are the same
        if(!isMatchNumOfRow(mtxA,mtxB)){return false;}
        if(!isMatchNumOfColumn(mtxA,mtxB)){return false;}

        //Compare each value in the corresponding value in matrix A and  matrix B
        for (int r_wk = 0; r_wk < mtxA.length; r_wk++){
            for (int c_wk = 0; c_wk< mtxA[0].length; c_wk++ ){
                if(mtxA[r_wk][c_wk] != mtxB[r_wk][c_wk]){
                    return false;
                }
            }
        }
        return  true;
    }

    /**
     * Check the row size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isMatchNumOfRow(int[][]mtxA, int[][]mtxB){
        return mtxA.length == mtxB.length;
    }

    /**
     * Check the column size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */
    public static boolean isMatchNumOfColumn(int[][]mtxA, int[][]mtxB){
        return mtxA[0].length == mtxB[0].length;
    }

    /**
     * Check the requirement for the matrix multiplication
     * first matrix column must be equal to the second matrix
     * @Param int [][]mtxA, the first given matrix
     * @Param int [][]mtxB, the second given matrix
     * @return boolean
     */
    public static boolean checkClmAndRw(int[][] mtxA, int[][] mtxB){
        // the length of the columns in the array
        int lenOfmtxA_clm = mtxA[0].length;
        //  the length of the rows in the array
        int lenOfmtxB_row = mtxB.length;

        return lenOfmtxA_clm == lenOfmtxB_row;
    }


}// End of class
