/**
 * Class name Algorithm1.java
 *  Author Keita Katsumi
 *  CS 3110 Fall 2023
 *  Project 2
 *  Last modified Dec 4th, 2023
 *  Description
 *      The merge sort algorithm sorts the array and find the kth smallest element.
 */

import java.util.Random;

public class Algorithm1 {
    /**
     * The method sorts the array and random access to get the kth smallest element
     * @Param int[] arr, the original array
     * @Param int position, the user provided index. The kth smallest value index
     */
    public static int findMergeSort(int[] arr, int position){
        int userIdx = position - 1;
        int[] mrgdArr = mergeSort(arr);
        return mrgdArr[userIdx];

    } // end of findMergeSort

    /**
     * The method sorts the array and random access to get the kth smallest element
     * @Param int[] arr, the original array
     */
    public static int[] mergeSort(int[] arr){
        int[] mrgdArr = myMerge(arr, 0, arr.length - 1);
        return mrgdArr;

    } // end of mergeSort

    /**
     * The method sorts the array with divide and conquer recursive call.
     * @Param int[]arr, original array
     * @Param int fistIdx, the first index of the array
     * @Param int lstIdx, the last index of the array
     * @return  int[] arrMrdg, the merged array which is copied from the original array.
     */
    public static int[] myMerge(int[] arr, int fstIdx, int lstIdx){
        //Base case
        if(fstIdx == lstIdx){
            int[] arrMrgd = new int[1];
            arrMrgd[0] = arr[0];
            return arrMrgd;
        }

        //Calculation of the split point
        int midIdx = fstIdx + (lstIdx -  fstIdx)/ 2;

        //Chop the original array
        //Make left half and right half elements in the original array separately
        int[] arrLft = Algorithm1.chopHalf(arr, fstIdx, midIdx);
        int[] arrRght = Algorithm1.chopHalf(arr, midIdx + 1 , lstIdx);


        // Recursively call myMerge and sort the left and right  side half arrays.
        int[] arrLftSorted = myMerge(arrLft, 0 , arrLft.length - 1);
        int[] arrRghtSorted = myMerge(arrRght, 0, arrRght.length - 1 );

        //Merging the two arrays with sorting
        int[] arrMrgd = combineSorts(arrLftSorted, arrRghtSorted);

        return arrMrgd;
    } // enf of myMerge

    /**
     * The method makes the half size copied array with the original array
     * @Param int[]arr, original array
     * @Param int fistIdx, the first index of the array
     * @Param int lstIdx, the last index of the array
     * @return  int[] choppedArr, the left or right side half size copied array.
     */
    public static int[] chopHalf(int[] arr, int fstIdx, int lstIdx){

        //Base case
        // when the arr has only one element, make a copy and return it.
        if(fstIdx == lstIdx){
            int[] choppedArr = new int[1];
            choppedArr[0] = arr[fstIdx];
            return choppedArr;
        }

        //Calculate half size of the original array size
        int size = lstIdx - fstIdx + 1;
        int[] choppedArr = new int[size];

        //Set a walker which iterates the original array from the first index to the last index
        int org_wk = fstIdx;

        //Copy the element from the original array to the copy array
        for(int cpy_wk = 0; cpy_wk <size; cpy_wk++ ){
            choppedArr[cpy_wk] = arr[org_wk++];
        }

        return choppedArr;
    } // end of left Chop


    /**
     * The method merges the two sorted array to make a consolidated array with sorting.
     * @Param int[]lSort, left side sorted array
     * @Param int[]lSort, right side sorted array
     * @return  int[] cmbArr, combined array with sorting.
     */
    public static int[] combineSorts(int[]lSort, int[] rSort){
        if(lSort.length != 1){
            assert lSort[0] <= lSort[1] : "Left array should be sorted";
        }
        if(rSort.length != 1){
            assert rSort[0] <= rSort[1] : "Right array should be sorted";
        }



        //Combined sorted array size  = eft array size + right array size
        int[] cmbArr = new int[lSort.length + rSort.length];

        //Initialize walkers
        // Let a_wk is arr walker
        // Let l_wk is lSort walker
        // Let r_wk is arr walker

        int a_wk = 0;
        int l_wk = 0;
        int r_wk = 0;

        //	Compare the element of lSort and rSort
        //	Decide a smaller element and store the value to the new array
        while(l_wk < lSort.length && r_wk < rSort.length){
            int smaller = (lSort[l_wk] <= rSort[r_wk]) ? lSort[l_wk++] : rSort[r_wk++] ;
            cmbArr[a_wk++] = smaller;
        }

        //Store the leftover to the new array
        while(l_wk < lSort.length){
            cmbArr[a_wk++] = lSort[l_wk++];
//            l_wk++;
        }

        //Store the leftover elements to the new array
        while(r_wk < rSort.length){
            cmbArr[a_wk++] = rSort[r_wk++];
//            r_wk++;
        }

        return cmbArr;
    } // end of combineSorts


    /**
     * The method filling up empty array with random number
     * @Param int[] arr, the original array
     * @Return int[] arr, the original array with random numbers.
     */
    public static int [] fillUpArray(int []arr){

        // -99 to 99 generate
       // create instance of Random class
       Random rand = new Random();

       // Generate random integers in range -9 to 9
       int rndInt = rand.nextInt(99 + 99) -99;

       //let first iterator to visit each row, call r_wk
       //let second iterator to visit each column, call r_wk
       for (int wk = 0; wk <arr.length; wk++ ){
               rndInt = rand.nextInt(99 + 99) -99;
               arr[wk] = rndInt;
       }
       return arr;
    } // end of fillUpArray

    /**
     * The method checks the two array is identical or not.
     * @Param int[] mrgArr, the first array
     * @Param int[] srtdArr, the second array
     * @Return when these two arrays share the same value in every index, it returns true.
     */
    public static boolean checkArray(int[] mrgArr, int[] srtdArr){
        if(mrgArr.length != srtdArr.length){ return false;}

        for (int i = 0; i < mrgArr.length; i++){
            if (mrgArr[i] != srtdArr[i]){
                return false;
            }
        } // end of loop

        return true;
    }



} // end of Algorithm1
