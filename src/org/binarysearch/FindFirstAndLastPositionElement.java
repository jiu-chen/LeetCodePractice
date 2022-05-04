package org.binarysearch;


import java.util.Arrays;

// Find First and Last Position of Element in Sorted Array
// if no the element, return [-1, -1]
public class FindFirstAndLastPositionElement {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 7, 8, 8, 12};
        int target = 7;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

    private static int[] searchRange(int[] nums, int target) {
        // todo
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, last};
        }
    }

    // 找到大于或等于target的第一个元素的下标
    // 如果找不到，返回最后一个元素下标
    private static int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }


}
