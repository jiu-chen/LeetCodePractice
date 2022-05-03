package org.doublePointer;

import java.util.Arrays;

// 判断一个非负整数是否为两个整数的平方和
public class SumOfSquareNumbers {
    public static void main(String[] args) {
//        int num = 8;  // null
        int num = 10;  // [1, 3]
        int[] res = sumOfSquareNumbers(num);
        System.out.println(Arrays.toString(res));
    }

    private static int[] sumOfSquareNumbers(int num) {
        int i = 1;
        int j = (int) Math.sqrt(num);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == num) {
                return new int[]{i, j};
            } else if (sum < num) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
