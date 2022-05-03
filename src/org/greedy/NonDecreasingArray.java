package org.greedy;


import java.util.Arrays;

// 判断一个数组能够删除一个数字使其成为 非递减数组
public class NonDecreasingArray {
    public static void main(String[] args) {
//        int[] arr = {4, 2, 3, 7};  // true {2,2,3,9}
//        int[] arr = {4, 5, 3, 9}; // true {4,5,5,9}
        int[] arr = {4, 5, 3, 9, 1}; // false {4,5,5,9,9}
        System.out.println(nonDecreasingArray(arr));
    }

    // 当出现 arr[i-1] > arr[i]的时候，修改arr[i-1]=arr[i],
    // 因为如果修改arr[i]=arr[i-1], 可能对 i 后面的值有影响  ==> {4,2,3,9} -> {2,2,3,9}
    // 但是有一种例外情况: arr[i-2]>arr[i], 这个时候需要修改 arr[i]=arr[i-1]  ==> {4,5,3,9} -> {4,5,5,9}
    public static boolean nonDecreasingArray(int[] arr) {
        // cnt 表示 后一个元素大于前一个元素的 个数
        int cnt = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                continue;
            }
            cnt++;
            if (i >= 2 && arr[i - 2] > arr[i]) {
                arr[i] = arr[i - 1];
            } else {
                arr[i - 1] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        return cnt <= 1;
    }
}
