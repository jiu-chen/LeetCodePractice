package org.doublePointer;

import java.util.Arrays;

// 有序数字的Two Sum
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println(Arrays.toString(res));

        int[] n = null;
        System.out.println(Arrays.toString(n));  // null
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
