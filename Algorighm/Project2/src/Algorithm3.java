/**
 * Class name Algorithm3.java
 *  Author Keita Katsumi
 *  CS 3110 Fall 2023
 *  Project 2
 *  Last modified Dec 4th, 2023
 *  Description:
 *      The median of median algorithm finds the kth smallest element.
 *      It finds median of medians, make another array until it picks medians of median pivot value.
 *      When it finds the pivot value and it makes partition of the array.
 *      The program calls recursively until the target index is found.
 */

import java.util.Arrays;
import java.util.Random;

public class Algorithm3 {

    /**
     * The method finds the median of medians as a pivot value and makes partition
     * It returns the kth smallest index value when the kth smallest index and pivot index matches.
     * @Param int[] arr,  the original array
     * @Param in numOfElmnt, the number of elements in the array. Problem size
     * @Param int kthSmallIdx, the kth smallest index from user.
     * @Return int the kth smallest value in the array
     */
    public static int MM_method(int[] arr, int numOfElmnt, int kthSmallIdx){
        int userIdx = kthSmallIdx - 1;
        return select2(arr, numOfElmnt, userIdx);
    }


    /**
     * The method finds the median of medians as a pivot value and makes partition
     * It returns the kth smallest index value when the kth smallest index and pivot index matches.
     * @Param int[] arr,  the original array
     * @Param in numOfElmnt, the number of elements in the array. Problem size
     * @Param int userIdx, the kth smallest index from user.
     * @Return int the kth smallest value in the array
     */
    public static int select2(int[]arr, int numOfElmnt, int userIdx){
//        assert userIdx >= 0 : "User should provides kth smallest greater than 1";

        if(numOfElmnt <=3){
            Arrays.sort(arr);
            return arr[userIdx];
        }

        //Find medians of median
        int[] medians = new int[numOfElmnt];
        medians = makeMdnsArr(arr);

        // Recursive call to find medians of medians in the original array
        int medIndx =0;
        if(medians.length % 2 == 0){
            medIndx = medians.length / 2 -1; // ex size 4 array index 1 is median index
        }else {
            medIndx = medians.length / 2;
        }
        int medianOfMedians = select2(medians, medians.length, medIndx);

        //Make 2 subsets less than pivot value or bigger than pivot value
        // It gets pivot index in the original array
        int pivotIdx = partition(arr, medianOfMedians);

        //Keep calling the method recursively
        // until the pivot position matches kth smallest index.
        if(pivotIdx == userIdx) {
            return arr[pivotIdx];
        }else if(userIdx < pivotIdx){
            int[] smllSubArr = chopHalf(arr, 0, pivotIdx);
            return select2(smllSubArr, smllSubArr.length, userIdx);
        }else{ // the case of  pivot index < user index
            //The bigger sub array starts from the pivot index +1 through the last index of the original array
            int[] bggrSubArr = chopHalf(arr, pivotIdx+1, arr.length - 1);
            return select2(bggrSubArr, bggrSubArr.length, userIdx - pivotIdx-1);
        }
    } // end of select2

    /**
     * The method divides subgroups of the array and sort the subgroups.
     * Make the medians array and call recursively until it finds the medians of median.
     * @Param int[] arr,  the original array
     * @Return int mdnsArr[wk], it means the median of median value.
     */
    public static int[] makeMdnsArr(int[] arr){
        final int NUM_OF_DINOMINATOR = 3;
        //The new arrays is a collection of median of each sub set
        int[] mdnsArr = new int [arr.length / NUM_OF_DINOMINATOR];

        //the walker iterates the original array from the first index to the last number of mdnsArr
        for(int wk = 0; wk < mdnsArr.length; wk++){
            int lftIdx = wk * NUM_OF_DINOMINATOR;
            int medIdx = lftIdx +1;
            int rghtIdx = medIdx + 1;

            //Compare 3 elements and store the middle into the medians array
            mdnsArr[wk] = sort3Elem(arr, lftIdx, medIdx, rghtIdx);
        }

        return mdnsArr;
    } // end of makeMdnsArr

    /**
     * The method makes partition in the array with the pivot value
     * @Param int[] arr,  the original array
     * @Param int pivotVal, the pivot value found with select 2.
     * @Return int bck_wk, the second pointer points to the pivot value index.
     */
    public static int partition(int[] arr, int pivotVal){

        // When the number of problem is 1 or 2.
        if(arr.length == 1) {return 0;}
        if(arr.length == 2){
            if(arr[0] > arr[1]){
                swap(arr, 0, 1);
            }
            if(arr[0] == pivotVal){return 0;}
            else{return 1;}
        }

        //Find the pivot value index
        // and save the value  to the last index of the array
        int pivotIdx = findPivotIdx(arr, pivotVal);
        swap(arr, pivotIdx, arr.length - 1);

        int secondlstIdx = arr.length - 2;

        //Let front walker as fnt_wk, the back walker as bck_wk
        //fnt_wk detect the element smaller than pivot value from the first index to the 2nd last element
        //bck_wk which detect the element which is bigger than pivot value, and swap.
        int bck_wk = 0;
        for (int fnt_wk = 0; fnt_wk<= secondlstIdx; fnt_wk++){
            if(arr[fnt_wk] < pivotVal ){
                swap(arr, bck_wk, fnt_wk);
                bck_wk++;
            }else{
                //This is the case front walker marks the current value is smaller than pivot
                // No need to swap with the back walker element which will become pivot index
                continue;
            }
        } // end of loop

        //In the last index, the pivot value was saved and swap it with back walker index
        //Then, the back walker points the pivot value and pivot index in the original array.
        swap(arr, bck_wk, arr.length-1);

        // The back walker points to the pivot index.
        return bck_wk;
    } // end of partition


    /**
     * The method makes the half size copied array with the original array
     * @Param int[]arr, original array
     * @Param int fistIdx, the first index of the array
     * @Param int lstIdx, the last index of the array
     * @Return  int[] choppedArr, the left or right side half size copied array.
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
     * The method sorts the three values as lower, middle, higher.
     * @Param int[]arr, original array
     * @Param  int fistIdx, the lower value  index of the array
     * @Param  int midIdx, the middle value  index of the array
     * @Param int lstIdx, the higher index of the array
     * @Return int arr[midIdx], the middle value
     */
    public static int sort3Elem(int[] arr, int fstIdx, int midIdx, int lstIdx){

        if(arr[midIdx] < arr[fstIdx]) {
            swap(arr, fstIdx, midIdx);
        }
        if (arr[lstIdx] < arr[midIdx]){
            swap(arr, lstIdx, midIdx);
        }
        if (arr[midIdx] < arr[fstIdx]){
            swap(arr, midIdx, fstIdx);
        }

        return  arr[midIdx];
    } // end of sort3Elem

    /**
     * The method finds the pivot value index with linear search
     * @Param int[]arr, original array
     * @Param int pivotVal, pivot value in the array
     * @Return int pivotIdx, pivot index in the array
     */
    public static int findPivotIdx(int[] arr, int pivotVal){
        int pivotIdx = -1; // For the sake of assertion
        for (int wk = 0; wk < arr.length; wk++){
            if (arr[wk] == pivotVal){
                pivotIdx = wk;
                break;
            }
            else{
                continue;
            }
        }
        assert pivotIdx != -1 : "The pivot value must exist in the array";
        return pivotIdx;
    } // end of findPivotIdx

    /**
     *The method swap two values.
     * @Param int fstIdx, the first index to swap.
     * @Param int scndIdx, the second index to swap.
     * @Return void, just swap values in the array
     */
    public static void swap(int arr[], int fstIdx, int scndIdx){
        assert fstIdx>= 0 : "The first index should be greater than 0";
        assert arr.length >= scndIdx - 1  : "The second index should be less than the array size";

        int temp = arr[fstIdx];
        arr[fstIdx] = arr[scndIdx];
        arr[scndIdx] = temp;
    } // end of swap





    // Helper methods
    /**
     * Fill the empty matrix ascending order
     * @Param mtx, the empty array
     * @return mtx, the matrix filled with some values
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


    //Check my methods works the kth smallest element correctly.
    public static int sortArrayKthSmallest(int arr[], int userIdx){
        Arrays.sort(arr);
        int realIdx = userIdx - 1;
//        System.out.println("\n\npivotIdx from sortArrayKthSmallest: [" + realIdx + "]");
        return arr[realIdx];
    }


}// end of Algorithm3
