package org.doublePointer;

import java.util.Arrays;

// 归并两个有序的数组
// 把归并结果存到第一个数组上。
public class MergeSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 7, 0, 0, 0};
//        int[] nums2 = {2, 3, 6};
//        mergeSortedArray(nums1, 3, nums2, 3);
        // case 2
        int[] nums1 = {7, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 3, 9};
        mergeSortedArray(nums1, 1, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }

    private static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
