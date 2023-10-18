package MatrixUtil;

import java.util.ArrayList;

public class Strassen {


    /**
     *C) Strassen Multiplication
     */

    /**
     * multiple two matrix with splitting and combine sub matrices recursively
     * @Param int[][] mtxA, N by N original size of matrix 1
     * @Param int[][] mtxB, N by N original size of matrix 2
     * @return int[][] mtxC, integrated matrix with C11, C12, C21 and C22
     */
    public static int[][] strassenMultiplication(int[][] mtxA, int[][]mtxB){
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
            //Store 4 submatrices to the Array list for the recursive calculation
            ArrayList<int[][]> subMtricesA =  splitMtx(mtxA);
            ArrayList<int[][]> subMtricesB =  splitMtx(mtxB);

            //Conquer section
            //Recursive call strassenCouquerMultiplicatoin method until the base case 2X2
            mtxC = strassenConquerMatrices(subMtricesA,subMtricesB);

        }

        return mtxC;
    } // End of strassenConquerMatrices method





    //Lower methods
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
     *Calculate two matrices addition
     * @Param int[][] mtxA, the first matrix
     * @Param int [][] mtxB, the second matrix
     * @return int[][] mtxC, result of sum of two matrices
     */
    public static int[][] subtractMtx(int[][]mtxA, int[][] mtxB){
        assert isMatchNumOfRow(mtxA, mtxB) : "The number of 2 matrices' row should match ";
        assert isMatchNumOfColumn(mtxA, mtxB) : "The number of 2 matrices' column should match ";
//        if(!isMatchNumOfRow(mtxA, mtxB)){return null;}
//        if(!isMatchNumOfColumn(mtxA, mtxB)){return null;}
        int [][]mtxC = new int[mtxA.length][mtxA[0].length];

        for(int r_wk = 0; r_wk < mtxA.length; r_wk++){
            for (int c_wk = 0; c_wk < mtxA[0].length; c_wk++){
                mtxC[r_wk][c_wk] = mtxA[r_wk][c_wk] - mtxB[r_wk][c_wk];
            }
        }

        return  mtxC;
    }

    /**
     * Calculate matrix C11 and C22 with strassen method with addition and subtraction
     * @Param int[][] subMtx1, sub matrix
     * @Param int[][] subMtx2, sub matrix
     * @Param int[][] subMtx3, sub matrix
     * @Param int[][] subMtx4, sub matrix
     * @return int[][] mtxC, Calculated with 4 matrices
     */
    public static int[][] calcC11_C22(int[][] subMtx1, int[][] subMtx2, int[][] subMtx3, int[][] subMtx4){
        assert isNbyN(subMtx1) : "The matrix should be N by N";
        assert isPowerOfTwo(subMtx1.length) : "The matrix's row should be 2^k";
        assert isNbyN(subMtx2) : "The matrix should be N by N";
        assert isPowerOfTwo(subMtx2.length) : "The matrix's row should be 2^k";
        assert isNbyN(subMtx3) : "The matrix should be N by N";
        assert isPowerOfTwo(subMtx3.length) : "The matrix's row should be 2^k";
        assert isNbyN(subMtx4) : "The matrix should be N by N";
        assert isPowerOfTwo(subMtx4.length) : "The matrix's row should be 2^k";

        int size = subMtx1.length;
        int[][] subMtxC = new int[size][size];
        subMtxC = addMtx(subMtxC, subMtx1);
        subMtxC = addMtx(subMtxC, subMtx2);
        subMtxC = subtractMtx(subMtxC, subMtx3);
        subMtxC = addMtx(subMtxC, subMtx4);

        return subMtxC;
    }


    /**
     * Integrate total 8 sub matrices to 1 matrix with addition and multiplication
     * @Param ArrayList<int[][]> subMatricesA, aggregation of 4 sub matrices
     * @Param ArrayList<int[][]> subMatricesB, aggregation of 4 sub matrices
     * @return int[][] mtxC, integrated matrix with C11, C12, C21 and C22
     */
    public static int[][] strassenConquerMatrices(ArrayList<int[][]> subMtricesA, ArrayList<int[][]>subMtricesB){


        int[][] mtxC = new int[subMtricesA.get(0).length][subMtricesA.get(0).length];

        //Make sub matrix P
        //P = (a11 + a22) * (b11 + b 22)
        //[0] a11, [1]a12, [2]a21, [3]a22
        int[][] mtxP = strassenMultiplication(addMtx(subMtricesA.get(0), subMtricesA.get(3)), addMtx(subMtricesB.get(0), subMtricesB.get(3)));

        //Make sub matrix Q
        //[0] a11, [1]a12, [2]a21, [3]a22
        //Q = (a21 + a22) * b11
        int[][] mtxQ = strassenMultiplication(addMtx(subMtricesA.get(2), subMtricesA.get(3)), subMtricesB.get(0));


        //Make sub matrix R
        //[0] a11, [1]a12, [2]a21, [3]a22
        //R = a11 * (b12 - b22)
        int[][] mtxR = strassenMultiplication(subMtricesA.get(0), subtractMtx(subMtricesB.get(1), subMtricesB.get(3)));

        //Make sub matrix S
        //[0] a11, [1]a12, [2]a21, [3]a22
        //S = a22 * (b21 - b11)
        int[][] mtxS = strassenMultiplication(subMtricesA.get(3), subtractMtx(subMtricesB.get(2), subMtricesB.get(0)));


        //Make sub matrix T
        //[0] a11, [1]a12, [2]a21, [3]a22
        //T = (a11 + a12) * b22
        int[][] mtxT = strassenMultiplication(addMtx(subMtricesA.get(0), subMtricesA.get(1)), subMtricesB.get(3));

        //Make sub matrix U
        //[0] a11, [1]a12, [2]a21, [3]a22
        //U = (a21 -  a11) * (b11 + b 12)
        int[][] mtxU = strassenMultiplication(subtractMtx(subMtricesA.get(2), subMtricesA.get(0)), addMtx(subMtricesB.get(0), subMtricesB.get(1)));


        //Make sub matrix V
        //[0] a11, [1]a12, [2]a21, [3]a22
        //V = (a12 - a22) * (b21 + b22)
        int[][] mtxV = strassenMultiplication(subtractMtx(subMtricesA.get(1), subMtricesA.get(3)), addMtx(subMtricesB.get(2), subMtricesB.get(3)));


        //Make C11
        // mtxP + mtxS – mtxT + mtxV as c11
        int[][] mtxC11 = calcC11_C22(mtxP, mtxS, mtxT, mtxV);

        //Make C12
        // R+T as c12
        int[][] mtxC12 = addMtx(mtxR, mtxT);

        //Make C21
        //Q + S as c21
        int[][] mtxC21 = addMtx(mtxQ, mtxS);

        //Make C22
        //mtxP + mtxR – mtxQ + mtxU as c22
        int[][] mtxC22 = calcC11_C22(mtxP, mtxR, mtxQ, mtxU);


        //Make matrix C with aggregating sub matrices multiplication
        ArrayList<int[][]> subMatricesC = new ArrayList<>();
        subMatricesC.add(mtxC11);
        subMatricesC.add(mtxC12);
        subMatricesC.add(mtxC21);
        subMatricesC.add(mtxC22);
        mtxC = aggregateMtx(subMatricesC);

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
