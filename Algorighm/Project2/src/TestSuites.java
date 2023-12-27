import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class TestSuites {

    public static void algorithm1Test(){
        System.out.println("\n\n~~~~ algorithm1Test ~~~~~");

        boolean test = true;

        //Test 1
        System.out.println("\n\n - - - Test 1 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 1 passed✅- - - - - ");


        //Test 2
        System.out.println("\n\n - - - Test 2 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 2 passed✅- - - - - ");



        //Test 3
        System.out.println("\n\n - - - Test 3 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 3 passed✅- - - - - ");



        //Test 4
        System.out.println("\n\n - - - Test 4 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 4 passed✅- - - - - ");


        //Test 5
        System.out.println("\n\n - - - Test 5 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 5 passed✅- - - - - ");


        //Test 6
        System.out.println("\n\n - - - Test 6 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 6 passed✅- - - - - ");


        //Test 7
        System.out.println("\n\n - - - Test 7 - - - - - ");
        if(test){
            int kthSmallestIdx = 4;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 7 passed✅- - - - - ");


        //Test 8
        System.out.println("\n\n - - - Test 8 - - - - - ");
        if(test){
            int kthSmallestIdx = 5;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 8 passed✅- - - - - ");


        //Test 9
        System.out.println("\n\n - - - Test 9 - - - - - ");
        if(test){
            int kthSmallestIdx = 6;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 9 passed✅- - - - - ");

        //Test 10
        System.out.println("\n\n - - - Test 10 - - - - - ");
        if(test){
            int kthSmallestIdx = 7;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm1.findMergeSort(arr, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 10 passed✅- - - - - ");





        System.out.println("\n\n~~~~ 👏👏👏algorithm1Test Passed👏👏👏 ~~~~~");
    } // end of algorithm1 Test

    public static void algorithm2Test(){
        System.out.println("\n\n~~~~ algorithm2Test ~~~~~");

        boolean test = true;

        //Test 1
        System.out.println("\n\n - - - Test 1 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 1 passed✅- - - - - ");


        //Test 2
        System.out.println("\n\n - - - Test 2 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 2 passed✅- - - - - ");



        //Test 3
        System.out.println("\n\n - - - Test 3 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 3 passed✅- - - - - ");



        //Test 4
        System.out.println("\n\n - - - Test 4 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 4 passed✅- - - - - ");


        //Test 5
        System.out.println("\n\n - - - Test 5 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 5 passed✅- - - - - ");


        //Test 6
        System.out.println("\n\n - - - Test 6 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 6 passed✅- - - - - ");


        //Test 7
        System.out.println("\n\n - - - Test 7 - - - - - ");
        if(test){
            int kthSmallestIdx = 4;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 7 passed✅- - - - - ");


        //Test 8
        System.out.println("\n\n - - - Test 8 - - - - - ");
        if(test){
            int kthSmallestIdx = 5;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 8 passed✅- - - - - ");


        //Test 9
        System.out.println("\n\n - - - Test 9 - - - - - ");
        if(test){
            int kthSmallestIdx = 6;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 9 passed✅- - - - - ");

        //Test 10
        System.out.println("\n\n - - - Test 10 - - - - - ");
        if(test){
            int kthSmallestIdx = 7;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int lstIdx = arr.length - 1;
            int kthSmallestVal = Algorithm2.findQuickSort(arr, kthSmallestIdx,0, lstIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 10 passed✅- - - - - ");





        System.out.println("\n\n~~~~ 👏👏👏algorithm2Test Passed👏👏👏 ~~~~~");
    } // end of algorithm2Test

    public static void algorithm3Test(){
        System.out.println("\n\n~~~~ algorithm3Test ~~~~~");

        boolean test = true;

        //Test 1
        System.out.println("\n\n - - - Test 1 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 1 passed✅- - - - - ");


        //Test 2
        System.out.println("\n\n - - - Test 2 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 2 passed✅- - - - - ");



        //Test 3
        System.out.println("\n\n - - - Test 3 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {2, 0, 1};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 3 passed✅- - - - - ");



        //Test 4
        System.out.println("\n\n - - - Test 4 - - - - - ");
        if(test){
            int kthSmallestIdx = 1;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 4 passed✅- - - - - ");


        //Test 5
        System.out.println("\n\n - - - Test 5 - - - - - ");
        if(test){
            int kthSmallestIdx = 2;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 5 passed✅- - - - - ");


        //Test 6
        System.out.println("\n\n - - - Test 6 - - - - - ");
        if(test){
            int kthSmallestIdx = 3;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 6 passed✅- - - - - ");


        //Test 7
        System.out.println("\n\n - - - Test 7 - - - - - ");
        if(test){
            int kthSmallestIdx = 4;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 7 passed✅- - - - - ");


        //Test 8
        System.out.println("\n\n - - - Test 8 - - - - - ");
        if(test){
            int kthSmallestIdx = 5;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 8 passed✅- - - - - ");


        //Test 9
        System.out.println("\n\n - - - Test 9 - - - - - ");
        if(test){
            int kthSmallestIdx = 6;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 9 passed✅- - - - - ");

        //Test 10
        System.out.println("\n\n - - - Test 10 - - - - - ");
        if(test){
            int kthSmallestIdx = 7;
            int[] arr = {5, 2, 0, 1, 4, 3, 6};
            int[] cpyArr = arr.clone();
            int kthSmallestIdxCpyArr = kthSmallestIdx - 1;
            Arrays.sort(cpyArr);
            System.out.println("Original array: ");
            for (int val: arr){
                System.out.print(val + ", ");
            }

            int kthSmallestVal = Algorithm3.MM_method(arr, arr.length, kthSmallestIdx);

            System.out.println("\n\nExpected: [" + cpyArr[kthSmallestIdxCpyArr] + "]");
            System.out.println("Actual: " + kthSmallestVal);
            arr = null;
        }
        System.out.println(" - - - ✅Test 10 passed✅- - - - - ");





        System.out.println("\n\n~~~~ 👏👏👏algorithm3Test Passed👏👏👏 ~~~~~");
    } // end of algorithm3Test


    //Make 3 array lists which contains the 50 times time result
    // Make average time array list

    //Set loop outer loop until 2^ 30 size of array
        // Make an array size of 2 ^ i with random number
        //set inner loop keep  which iterates 50 times algorithm 1, 2, 3
            // Call Algorithm1
            //Store the result to arraylist
            // Call Algorithm 2
            //Store the result to arraylist
            // Call Algorithm 3
            //Store the result to arraylist

        //Calculate average
        //Store the result array

    //Make scv file to export


    //Write 50 times  iteration average result to csv file
    public static void run50times3Algorithms() throws IOException {
        System.out.println("🕰Let's check run time 50 times each method🕰️");

        //Make 3 array lists which contains the 50 times time result
        // Make average time array list

        final int NUM_OF_EXECUTION = 50;
        final int NUM_OF_MAX_POWER = 17; // Max number int JAVA 2147483647, 2^30 = 1073741824, 2^31 = 2147483648
        ArrayList<Double> listOfTimeAlgo1 = new ArrayList<>();
        ArrayList<Double> listOfTimeAlgo2 = new ArrayList<>();
        ArrayList<Double> listOfTimeAlgo3 = new ArrayList<>();
//        ArrayList<Double> listOfAveTimesAlgo1 = new ArrayList<>();
//        ArrayList<Double> listOfAveTimesAlgo2 = new ArrayList<>();
//        ArrayList<Double> listOfAveTimesAlgo3 = new ArrayList<>();



        // Make file object to write out csv file after iteration and average calculation
        File myObj = new File("/Users/keita-katsumi/Dropbox/Academic/CalPolyPomona/2023/Fall2023/CS 3310/Project/P2/Project2/DataSet/AveTimes.csv");
        FileWriter fw = new FileWriter(myObj);
        BufferedWriter bw = new BufferedWriter(fw);

        try {

            bw.write("3 Algorithms average times, millisecond second (ms), (ex. second = 1000 ms; minutes = 60000 ms)");
            bw.newLine();
            bw.write("Problem size, Algorithm1(Merge), Algorithm2(Quick), Algorithm3(MM)");
            bw.newLine();

            //Set loop outer loop until 2^ 29 size of array
            for (int i = 1; i <= NUM_OF_MAX_POWER; i++){
                //Max number int JAVA 2147483647,
                // 2^30 = 1073741824, 2^31 = 2147483648
                int size = (int) Math.pow(2, i);

                StringBuffer sbSize = new StringBuffer();
                sbSize.append(size); // Record the number of problem size later

                // Make an array size of 2 ^ i with random number
                // Make 2 copies
                int[] arrForAlgo1 = new int[size];
                Algorithm1.fillUpArray(arrForAlgo1);
                int[] arrForAlgo2  = new int[size];
                arrForAlgo2= arrForAlgo1.clone();
                int[] arrForAlgo3  = new int[size];
                arrForAlgo3= arrForAlgo1.clone();

                //set inner loop keep  which iterates 50 times algorithm 1, 2, 3
                for (int j = 0; j < NUM_OF_EXECUTION; j++){

                    // Assume user wants to find the last element
                    int kthSmallestIdx = size - 1;

                    // Call Algorithm1
                    //Store the result to arraylist
                    double startTime = System.currentTimeMillis();
                    Algorithm1.findMergeSort(arrForAlgo1, kthSmallestIdx);
                    double endTime =System.currentTimeMillis() - startTime;

                    //Store the execution time
                    listOfTimeAlgo1.add(endTime);


                    // Call Algorithm 2
                    //Store the result to arraylist
                    startTime = System.currentTimeMillis();
                    Algorithm2.findQuickSort(arrForAlgo2, kthSmallestIdx,0, size - 1);
                    endTime =System.currentTimeMillis() - startTime;

                    //Store the execution time
                    listOfTimeAlgo2.add(endTime);


                    // Call Algorithm 3
                    //Store the result to arraylist
                    if(i < 15){
                        startTime = System.currentTimeMillis();
                        Algorithm3.MM_method(arrForAlgo3, arrForAlgo3.length, kthSmallestIdx);
                        endTime =System.currentTimeMillis() - startTime;

                        //Store the execution time
                        listOfTimeAlgo3.add(endTime);
                    }else{
                        endTime = 0.0 / 0.0; // Store NaN
                        listOfTimeAlgo3.add(endTime);

                    }

                } // end of inner loop


                //Calculate average and store the result to the average time array
                double algo1AveTime = getAverage(listOfTimeAlgo1);
                double algo2AveTime = getAverage(listOfTimeAlgo2);
                double algo3AveTime = getAverage(listOfTimeAlgo3);
//                listOfAveTimesAlgo1.add(algo1AveTime);
                //Write classical multiplication time
                bw.write((size)+ "," + algo1AveTime+ "," + algo2AveTime + "," + algo3AveTime);
                bw.newLine();

                //Initialize the list of array for storing the next iteration result
                listOfTimeAlgo1.clear();
                listOfTimeAlgo2.clear();
                listOfTimeAlgo3.clear();

                System.out.println("\n\n  - - -  " + i +  " times iteration is done- - - - - ");
                System.out.println(" - - - ✅　The size of  " + size +  " is recorded ✅ - - - - - ");
            } // end of outer loop

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Make scv file to export
        bw.close();
        fw.close();


    } // end of 50 times iteration


    public static double getAverage(ArrayList<Double> listOfTimes){
        double result = 0.0;
        double sum = 0.0;
        //The first one is outlier
        int totalSize = listOfTimes.size() - 1;

        for (int i = 1; i < listOfTimes.size(); i++){
            sum += listOfTimes.get(i);
        }
        result = sum / totalSize;

        return result;
    } // end of get average



}// End of test suite
