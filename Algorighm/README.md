# Design and Analysis of Algorithms (CS 3310)
## Project 1 Abstract
<br><br>
This project asks to implement, test, and analyze the three different matrix multiplication algorithms discussed in class. The matrix size starts 2 by 2 until the maximum size my device can handle due to running out of memory. The input size will be limited in the power of 2 as 2, 4, 8, 16, 32 up to $2^{k}$ where k is the largest size of the Integer. The reason for the power of 2 is to ease the programming component of the assignment.

[Implementation detailed in Java](https://github.com/keiakihito/PersonalProjects/tree/main/Algorighm/Project1/src)<br>

[Project report](https://github.com/keiakihito/PersonalProjects/blob/main/Algorighm/Project1/Documentation/Report/Report.pdf)

<br><br>

## Project 2 Abstract
<br>
This project asks to implement, test, and analyze the three different Selection Problem algorithms that find the kth smallest element in the list of n elements. The class discussed three algorithms: Merge sort, Quick sort, and Median of Medians of algorithms. <br>

* Algorithm 1, Merge Sort, sorts the list and then returns the kth smallest element.<br> 

* Algorithm 2, Quick Sort, applies the procedure Partition used in Quicksort. The procedure partitions pick a pivot value in an array and make a partition based on the pivot value. All elements smaller than some pivot item come before it in the array. Similarly, all elements larger than that pivot item go after it. The second algorithm recursively calls itself by partitioning until the pivot index = kth index. <br>

* Algorithm 3, Median of Medians, applies the Partition algorithm by making sub-1D arrays the size of any odd number. It sorts each variety and makes a new array with all the median values in arrays.

[Implementation detailed in Java](https://github.com/keiakihito/PersonalProjects/tree/main/Algorighm/Project2/src)<br>

[Project report](https://github.com/keiakihito/PersonalProjects/blob/main/Algorighm/Project2/Documentation/Report.pdf)
