package easy;

import java.util.Arrays;

public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // 1. Add elements from nums2 to nums1 array:
        System.arraycopy(nums2, 0, nums1, m, n);

        // 2. Simply sort array using QuickSort algorithm:
        quickSort(nums1, 0, nums1.length-1);

    }

    public void quickSort(int[] array, int startIndex, int endIndex){
        // this method will be used recursively, so all in all we finally come to just 1 element
        // thus, need to check for this:
        if(startIndex < endIndex) {
            // pick element from the middle of given interval
            int pivotIndex = startIndex + (endIndex - startIndex) / 2;
            int pivotValue = array[pivotIndex];

            int i = startIndex;
            int j = endIndex;

            // make all elements to the left from pivot to be less or equal to pivot
            // and all elements to the right from pivot to be greater than pivot
            while(i <= j) {

                while(array[i] < pivotValue)
                    i++;

                // ok, so here we either passed through all elements to the left from pivot element
                // or we found 'imperfection' where element from left need to be swapped with element to the right

                // let's find 'imperfection' element to the right:
                while (array[j] > array[pivotIndex])
                    j--;

                // ok, so here we either passed through all elements to the right from pivot element
                // or we found 'imperfection' where element from right need to be swapped with element to the left

                // doing swap:
                if(i<=j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    // moving indexes
                    i++;
                    j--;
                }
            }
            quickSort(array, startIndex, i-1);
            quickSort(array, i, endIndex);
        }
    }

    public static void main(String[] args) {
        //int[] nums1 = {4,5,6,0,0,0};
        //int[] nums2 = {1,2,3};
        int[] nums1 = {-1,0,0,0,3,0,0,0,0,0,0}; // m=5
        int[] nums2 = {-1,-1,0,0,1,2}; // n=6
        new MergeSortedArray88().merge(nums1,5,nums2,6);
        System.out.println(Arrays.toString(nums1));
    }
}