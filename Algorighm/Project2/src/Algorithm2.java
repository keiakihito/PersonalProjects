/**
 * Class name Algorithm2.java
 *  Author Keita Katsumi
 *  CS 3110 Fall 2023
 *  Project 2
 *  Last modified Dec 4th, 2023
 *  Description
 *      The quick sort algorithm finds the kth smallest element.
 *      It picks pivot value and check the pivot index matches with the user 's kth smallest index.
 *      The program calls recursively until the target index is found.
 */

import java.util.Arrays;
import java.util.Random;

public class Algorithm2 {

    /**
    * The method find the kth smallest index with quick sort algorithm
    * @Param int[]arr, original array
    * @Param int userIdx, user provided index. The kth smallest index
    * @Param int fistIdx, the first index of the array
    * @Param int lstIdx, the last index of the array
    * @return  int kthSmallerstVal, the kth smallest value
    */
    public static int findQuickSort(int[]arr, int userIdx, int fstIdx, int lstIdx){
        //Convert user specified index to the array index
        //EX, user gives 1, but the array index is [0]
        int realIdx = userIdx - 1;
        int pivotIdx = pivotPartition(arr,  fstIdx, lstIdx);
        int kthSmallersVal = 0;

        //Base case
        if(realIdx == pivotIdx){
//            System.out.println("\n\npivotIdx from findQuickSort: [" + pivotIdx + "]");
            return arr[pivotIdx];
        } else if (realIdx < pivotIdx ) {
            kthSmallersVal =  findQuickSort(arr, userIdx, fstIdx, pivotIdx-1 );
        } else {
            kthSmallersVal =  findQuickSort(arr, userIdx, pivotIdx+1, lstIdx);
        }
        return kthSmallersVal;
    } // end of findQuickSort



    /**
    * The method makes partition in the array with the pivot value.
    * To pick up reasonable pivot, it takes 3 sample values and let the middle one as a pivot.
    * @Param int[]arr, original array
    * @Param  int fistIdx, the first index of the array
    * @Param int lstIdx, the last index of the array
    * @Return int l_wk, it means the pivot value index in the array
    */
    public static int pivotPartition(int[] arr, int fstIdx, int lstIdx){
        assert fstIdx >= 0 : "The first index must be greater than 0";
        assert lstIdx >= 0 : "The last index must be greater than 0";
        assert fstIdx <= lstIdx : "The first index should be less than equal to the last index";
        assert lstIdx <= arr.length - 1 : "The last index must be smaller than array size  - 1";

        //Base case
        // When the first index and the last index are the same, both point the pivot index.
        if(fstIdx == lstIdx){ return fstIdx;}

        //Another considerable elements are only 2
        if(lstIdx - fstIdx == 1){
            if (arr[fstIdx] > arr[lstIdx]){
                swap(arr, fstIdx, lstIdx);
            }
            return fstIdx;
        }

        //Another considerable elements are only 3
        if(lstIdx - fstIdx == 2){

            return sort3Elem(arr, fstIdx, (fstIdx+lstIdx) / 2, lstIdx);
        }

        //Find the middle index,
        //Sort 3 elements, which finds the middle value among the three values
        //Then it finds the middle value index
        //Middle value will be a pivot
        int midIdx = (fstIdx + lstIdx) / 2;
        int midValIdx = sort3Elem(arr, fstIdx, midIdx, lstIdx);
        int pivotVal = arr[midValIdx];

        //This is the case that fist index value and pivot value is the same.
        // The walker finds smaller than the pivot value and swap the first index value
        //After swap, it sorted as small, middle, big
        //When the walker cannot find the smaller value than the pivot,
        //It means the pivot value is the smallest and duplicated at the first index.
        //It returns the first index as smallest value.
        if(arr[fstIdx] == pivotVal){
            int wk = fstIdx;
            while(arr[wk] >= pivotVal){
                wk++;

                //When the walker hits the last index, it means the first index is the smallest value in the scope.
                if(wk == lstIdx){return fstIdx;}
            }

            //Change the smaller value at the first index
            swap(arr, fstIdx, wk);
        }

        //Set pivotIdx to avoid offset calculation
        // arr[midValIdx] is pivot and moves to the 2nd last
        int pivotIdx = lstIdx - 1;
        swap(arr, midValIdx, pivotIdx);

        //Let the left walker as l_wk, which iterates the array from left to right
        //Let the right walker as r_wk, which iterates the array from right to left
        //Both walkers keep moving until they point the same index value
        int l_wk = fstIdx;
        int r_wk = lstIdx-2;

        //The outer loop check the left walker and right walker meet or not.
        //When they meet each other the array is partitioned with pivot value
        while (l_wk <= r_wk){
            // The left walker checks the left side whether there is bigger than pivot value
            // It keeps moving left to right until it finds value bigger than the pivot value
            while ((arr[l_wk] < pivotVal)){ l_wk++;}

            //  The right walker checks the right side whether there is smaller than pivot value
            // It keeps moving right to left until it finds value less than the pivot value
            while ((arr[r_wk] >= pivotVal && l_wk <= r_wk))
            {
                r_wk--;
                if(r_wk == 0){break;} // Avoid out of bound
            }

            //When the left walker and right walker don't meet, it swaps values.
            //Increment both walkers to find next values
            // If the two walkers points the same index value, it exists loop after swapping.
            if (l_wk <= r_wk){

                //When l_wk and r_wk points the same value, and swap the same index value,
                //it doesn't need to move right or left anymore
                //The l_wk points to the pivot value index
                swap(arr, l_wk, r_wk);

                //If left walker and right walker don't meet yet, it keeps moving until they meet.
                if(l_wk <= r_wk){
                    l_wk++;
                    r_wk--;
                }

            } // enf of if (l_wk <= r_wk) 

        } // end of outer loop


//        // The pivot value needs to be middle index for the next investigation
//        //The l_wk becomes the pivot value index
//        // it points to the k th smallest value
            swap(arr, l_wk, pivotIdx);


        //The l_wk is the pivot value index
        return l_wk;
    } // end of pivotPartition


    /**
     * The method sorts the three values as lower, middle, higher.
     * @Param int[]arr, original array
     * @Param  int fistIdx, the lower value  index of the array
     * @Param  int midIdx, the middle value  index of the array
     * @Param int lstIdx, the higher index of the array
     * @Return int midIdx, the middle value index
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

        return midIdx;
    } // end of sort3Elem

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



    //Check methods

    //The method iterates the partitioned array until the pivot index
    //Compare the all the left side elements from pivot
    //If one of them is greater equal than pivot value, it returns false
    public static boolean isLeftSmaller(int arr[], int pivotIdx){
        //Let walker as wk
        // It iterates the array from the first index to the pivot index
        for (int wk = 0; wk < pivotIdx; wk++){
            if(arr[wk] < arr[pivotIdx] ){
                continue;
            }else {
                System.out.println("\n\npivot index is : " + pivotIdx);
                for(int val: arr){
                    System.out.print(val + ",");
                }
                System.out.println("\n\nisLeftSmaller fail:");
                System.out.println("\n\nPivot value: " + arr[wk] + "<" + arr[pivotIdx] + "??");
                return false;
            }

        } // end of for loop

        //It means all the left side elements are smaller than the pivot value
        return true;
    } // end of isLeftSmaller



    //The method iterates the partitioned array until the pivot index
    //Compare the all the left side elements from pivot
    //If one of them is greater equal than pi   vot value, it returns false
    public static boolean isRightBigger(int arr[], int pivotIdx){
        //Let walker as wk
        // It iterates the array from the one next to  the pivot index to the last index
        //Duplication value is allowed
        for (int wk = pivotIdx+1; wk < arr.length ; wk++){
            if(arr[pivotIdx] <=  arr[wk] ) {
                continue;
            }else{
                System.out.println();
                for(int val: arr){
                    System.out.print(val + ",");
                }
                System.out.println("\n\nisRightBigger fail:");

                System.out.println("\n\nPivot value: " + arr[pivotIdx] + "<=" + arr[wk] + "??");
                return false;
            }
        } // end of for loop

        //It means all the right side elements are bigger than the pivot value
        return true;
    } // end of isRightBigger


    //Check my findQuick finds the kth smallest element correctly.🥲
    public static int sortArrayKthSmallest(int arr[], int userIdx){
        Arrays.sort(arr);
        int realIdx = userIdx - 1;
//        System.out.println("\n\npivotIdx from sortArrayKthSmallest: [" + realIdx + "]");
        return arr[realIdx];
    }

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
    }




} // end of Algorithm2
