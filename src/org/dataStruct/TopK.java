package org.dataStruct;

import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] nums = {6, 4, 5, 7, 2, 6, 1};
        int k = 4;
        System.out.printf("Top %d为:%d\n", k, findKthLargest(nums, k));
        System.out.println("====================");
        System.out.printf("Top %d为:%d", k, quickSelect(nums, 0, nums.length - 1, k));
    }

    //  通过构造小顶堆实现
    private static int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }


    // 通过快排实现
    private static int quickSort(int[] nums) {
        // TODO
        return 0;
    }

    // * 通过快速选择实现
    private static int quickSelect(int[] nums, int lo, int hi, int k) {
        int p = (int) (Math.floor(Math.random() * (hi - lo + 1)) + lo);
//        p = 2;  // k=4时， p=2 是最理想的一种情况，一次循环之后 满足 hi(6)==k(4)+i(3)-1,
        // 即  pivot 所指的元素 是我们要找的 Top k
        System.out.println("pivot: " + p);
        swap(nums, p, hi);
        int i = lo;
        int j = lo;
        while (j < hi) {
            if (nums[j] <= nums[hi]) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, i, j);
        // pivot 是我们要找的 Top k
        if (hi == k + i - 1) return nums[i];
        //  Top k 在右边
        if (hi > k + i - 1) return quickSelect(nums, i + 1, hi, k);
        //  Top k 在左边
        // hi -i 表示 p 右边的个数
        // + 1 表示 p 本身
        // k - (hi - i + 1) 表示去掉 p 以及 p 右边的之后的 top 值
        return quickSelect(nums, lo, i - 1, k - (hi - i + 1));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
