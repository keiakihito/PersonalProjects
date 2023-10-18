package MatrixUtil;

import java.util.ArrayList;

public class DivideConquer {

    /**
     *b) DivideConquerMultiplication
     */

    /**
     * multiple two matrix with splitting and combine sub matrices recursively
     * @Param int[][] mtxA, N by N original size of matrix 1
     * @Param int[][] mtxB, N by N original size of matrix 2
     * @return int[][] mtxC, integrated matrix with C11, C12, C21 and C22
     */
    public static int[][]divideConquerMultiplication(int[][] mtxA, int[][] mtxB){
        assert isNbyN(mtxA) : "The matrix should be N by N";
        assert isNbyN(mtxB) : "The matrix should be N by N";

        int[][] mtxC = new int[mtxA.length][mtxB.length];

        //Base case using 2 by 2 multiplication with method a
        if(mtxA.length == 2 && mtxB.length==2){
            mtxC = Classical.classicalMatrixMultiplication(mtxA,mtxB);
        }
        else{

            //Divide section
            //Split matrix into 4 partitions as a11, a12, a21, a22 and so on.
            //Store 4 sub matrices to the Array list for the recursive calculation
            ArrayList<int[][]> subMtricesA =  splitMtx(mtxA);
            ArrayList<int[][]> subMtricesB =  splitMtx(mtxB);

            //Conquer section
            //Recursive call divideCouquerMultiplicatoin method until the base case 2X2
            mtxC = conquerMatrices(subMtricesA,subMtricesB);
        }

        return mtxC;
    } // End of divideConquerMultiplication method





    //Lower methods for the DivideConquerMultiplication
    /**
     * Check the row size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */

    /**
     * Check the column size of the two matrices
     * @Param matrixA, int[][]mtxA
     * @Param matrixB, int[][]mtxB
     * @return boolean
     */

    /**
     * Check whether the number is power of 2 or not.
     * @Param int number
     * @return boolean
     */
    public static boolean isPowerOfTwo(int num){
        assert num >= 0 : "The number should be positive number";
        if (num == 0) {return false;}
        return (int)(Math.ceil(Math.log(num) / Math.log(2))) == (int)(Math.floor(Math.log(num) / Math.log(2)));
    }

    /**
     * Check the number of row and number of column are the same size
     * Check the 2 matrices' row and column are the same
     * @Param int[][] mtx, matrix
     * @return boolean
     */
    public static boolean isNbyN(int[][]mtx){
        if (mtx.length != mtx[0].length) {return false;}
        return true;
    }

    /**
     *Calculate two matrices addition
     * @Param int[][] mtxA, the first matrix
     * @Param int [][] mtxB, the second matrix
     * @return int[][] mtxC, result of sum of two matrices
     */
    public static int[][] addMtx(int[][]mtxA, int[][] mtxB){
        assert isMatchNumOfRow(mtxA, mtxB) : "The number of 2 matrices' row should match ";
        assert isMatchNumOfColumn(mtxA, mtxB) : "The number of 2 matrices' column should match ";
//        if(!isMatchNumOfRow(mtxA, mtxB)){return null;}
//        if(!isMatchNumOfColumn(mtxA, mtxB)){return null;}
        int [][]mtxC = new int[mtxA.length][mtxA[0].length];

        for(int r_wk = 0; r_wk < mtxA.length; r_wk++){
            for (int c_wk = 0; c_wk < mtxA[0].length; c_wk++){
                mtxC[r_wk][c_wk] = mtxA[r_wk][c_wk] + mtxB[r_wk][c_wk];
            }
        }

        return  mtxC;
    }

    /**
     *Extract top left , top right, bottom left, and bottom right partition value and copy to 4 sub matrices.
     * @Param int[][] mtx, an original matrix to split
     * @return ArrayList<int[][]> listOfSubMtrcs, aggregation of 4 sub matrices
     */
    public static ArrayList<int[][]> splitMtx(int[][] mtx){
        assert mtx.length > 3 : "The row of matrix should be >= 4";
        assert mtx[0].length > 3 : "The column of matrix should be >= 4";
        assert isNbyN(mtx) : "The mtx size should be N by N";
        assert isPowerOfTwo(mtx.length) : "Row size should be 2^k";
        assert isPowerOfTwo(mtx[0].length) : "Column size should be 2^k";

        //Make 4 sub matrices as partition
        //top left , top right, bottom left, and bottom right
        int[][] subMtxTpL = new int[mtx.length / 2][mtx[0].length / 2];
        int[][] subMtxTpR = new int[mtx.length / 2][mtx[0].length / 2];
        int[][] subMtxBtL = new int[mtx.length / 2][mtx[0].length / 2];
        int[][] subMtxBtR = new int[mtx.length / 2][mtx[0].length / 2];

        //Adjust offset to store copy value in the corresponding sumMtxValue row and column
        int offset = mtx[0].length/2;

        //Make top left partition, call a11
        //The first loop iterates from the first row to the n/2 row
        //The second loop iterates from the first column to the n/2 column
        for (int r_wk= 0; r_wk < (mtx.length / 2); r_wk++){
            for (int c_wk = 0; c_wk < (mtx[0].length/2); c_wk++){
                subMtxTpL[r_wk][c_wk] = mtx[r_wk][c_wk];
            }
        }

        //Make top right partition, call a12
        //The first loop iterates from the first row to the n/2 row
        //The second loop iterates from the n/2 column to the last column.
        for (int r_wk= 0; r_wk < (mtx.length / 2); r_wk++){
            for (int c_wk = (mtx[0].length/2); c_wk < mtx[0].length; c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                subMtxTpR[r_wk][c_wk - offset] = mtx[r_wk][c_wk];
            }
        }

        //Make bottom left  partition, call a21
        //The first loop iterates from the n/2 row to the last row
        //The second loop iterates from the first column to the n/2 column
        for (int r_wk= (mtx.length / 2); r_wk < mtx.length; r_wk++){
            for (int c_wk = 0; c_wk < (mtx[0].length/2); c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                subMtxBtL[r_wk - offset][c_wk] = mtx[r_wk][c_wk];
            }
        }

        //Make bottom right partition, call a22
        //The first loop iterates from the n/2 row to the last row
        //The second loop iterates  from the n/2 row to the last column.
        for (int r_wk= (mtx.length / 2); r_wk < mtx.length; r_wk++){
            for (int c_wk = (mtx[0].length/2); c_wk < mtx[0].length; c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                subMtxBtR[r_wk - offset][c_wk - offset] = mtx[r_wk][c_wk];
            }
        }

        //Aggregate 4 sub matrices to return all the 4 matrices.
        ArrayList<int[][]> listOfSubMtrcs = new ArrayList<>();
        listOfSubMtrcs.add(subMtxTpL);
        listOfSubMtrcs.add(subMtxTpR);
        listOfSubMtrcs.add(subMtxBtL);
        listOfSubMtrcs.add(subMtxBtR);

        return listOfSubMtrcs;
    }

    /**
     *Iterates 4 sub matrices in the ArrayList to copy the value to the new integrated matrix
     * @Param ArrayList<int[][]> listOfSubMtrcs, aggregation of 4 sub matrices
     * @return int[][] intgrtdMtx, integrated matrix with C11, C12, C21 and C22
     */
    public static int[][] aggregateMtx(ArrayList<int[][]> listOfSubMtrcs){
        assert isNbyN(listOfSubMtrcs.get(0)) : "The matrix should be N by N";
        assert isPowerOfTwo(listOfSubMtrcs.get(0).length) : "The matrix's row should be 2^k";
        assert isPowerOfTwo(listOfSubMtrcs.get(0)[0].length) : "The matrix's column should be 2^k";

        int newSize =listOfSubMtrcs.get(0).length * 2;
        int[][] intgrtdMtx = new int[newSize][newSize];

        //Adjust offset to store copy value in the corresponding sumMtxValue row and column
        int offset = newSize/2;

        //Extract top left partition, call a11
        //Copy values to the new integrated Matrix
        //The first loop iterates from the first row to the n/2 row
        //The second loop iterates from the first column to the n/2 column
        for (int r_wk= 0; r_wk < (newSize / 2); r_wk++){
            for (int c_wk = 0; c_wk < (newSize/2); c_wk++){
                intgrtdMtx[r_wk][c_wk] = listOfSubMtrcs.get(0)[r_wk][c_wk];
            }
        }

        //Extract top right partition, call a12
        //Copy values to the new integrated Matrix
        //The first loop iterates from the first row to the n/2 row
        //The second loop iterates from the n/2 column to the last column.
        for (int r_wk= 0; r_wk < (newSize / 2); r_wk++){
            for (int c_wk = (newSize/2); c_wk < newSize; c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                intgrtdMtx[r_wk][c_wk] = listOfSubMtrcs.get(1)[r_wk][c_wk - offset];
            }
        }

        //Extract bottom left partition, call a21
        //Copy values to the new integrated Matrix
        //The first loop iterates from the n/2 row to the last row
        //The second loop iterates from the first column to the n/2 column
        for (int r_wk= (newSize/ 2); r_wk < newSize; r_wk++){
            for (int c_wk = 0; c_wk < (newSize/2); c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                intgrtdMtx[r_wk][c_wk] = listOfSubMtrcs.get(2)[r_wk - offset][c_wk];
            }
        }

        //Extract bottom right partition, call a22
        //Copy values to the new integrated Matrix
        //The first loop iterates from the n/2 row to the last row
        //The second loop iterates  from the n/2 row to the last column.
        for (int r_wk= (newSize / 2); r_wk < newSize; r_wk++){
            for (int c_wk = (newSize/2); c_wk < newSize; c_wk++){
                //offset to store copy value in the corresponding sumMtxValue row and column
                intgrtdMtx[r_wk][c_wk] = listOfSubMtrcs.get(3)[r_wk - offset][c_wk - offset];
            }
        }

        return intgrtdMtx;
    }

    /**
     * Integrate total 8 sub matrices to 1 matrix with addition and multiplication
     * @Param ArrayList<int[][]> subMatricesA, aggregation of 4 sub matrices
     * @Param ArrayList<int[][]> subMatricesB, aggregation of 4 sub matrices
     * @return int[][] mtxC, integrated matrix with C11, C12, C21 and C22
     */
    public static int[][] conquerMatrices(ArrayList<int[][]>subMtricesA, ArrayList<int[][]>subMtricesB){
        //Make left to partition C11
        //[0] a11, [1]a12, [2]a21, [3]a22
        // a11 * b11 = C11 left sub matrix
        int[][] subMtxC11L = divideConquerMultiplication(subMtricesA.get(0), subMtricesB.get(0));
        // a12 * b21 = C11 right sub matrix
        int[][] subMtxC11R = divideConquerMultiplication(subMtricesA.get(1), subMtricesB.get(2));
        int[][] subMtxC11 = addMtx(subMtxC11L, subMtxC11R);

        //Make left to partition C12
        //[0] a11, [1]a12, [2]a21, [3]a22
        // a11 * b12 = C12 left sub matrix
        int[][] subMtxC12L = divideConquerMultiplication(subMtricesA.get(0), subMtricesB.get(1));
        // a12 * b22 = C12 right sub matrix
        int[][] subMtxC12R = divideConquerMultiplication(subMtricesA.get(1), subMtricesB.get(3));
        int[][] subMtxC12 = addMtx(subMtxC12L, subMtxC12R);

        //Make left to partition C21
        //[0] a11, [1]a12, [2]a21, [3]a22
        // a21 * b11 = C21 left sub matrix
        int[][] subMtxC21L = divideConquerMultiplication(subMtricesA.get(2), subMtricesB.get(0));
        // a22 * b21 = C11 right sub matrix
        int[][] subMtxC21R = divideConquerMultiplication(subMtricesA.get(3), subMtricesB.get(2));
        int[][] subMtxC21 = addMtx(subMtxC21L, subMtxC21R);

        //Make left to partition C22
        //[0] a11, [1]a12, [2]a21, [3]a22
        // a21 * b12 = C22 left sub matrix
        int[][] subMtxC22L = divideConquerMultiplication(subMtricesA.get(2), subMtricesB.get(1));
        // a22 * b22 = C22 right sub matrix
        int[][] subMtxC22R = divideConquerMultiplication(subMtricesA.get(3), subMtricesB.get(3));
        int[][] subMtxC22 = addMtx(subMtxC22L, subMtxC22R);

        //Make matrix C with aggregating sub matrices multiplication
        ArrayList<int[][]> subMtricesC =  new ArrayList<>();
        subMtricesC.add(subMtxC11);
        subMtricesC.add(subMtxC12);
        subMtricesC.add(subMtxC21);
        subMtricesC.add(subMtxC22);

        int[][] mtxC = new int[subMtricesA.get(0).length][subMtricesA.get(0).length];
        mtxC = aggregateMtx(subMtricesC);

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


} // End of class
