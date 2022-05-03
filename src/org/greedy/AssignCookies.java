package org.greedy;

import java.util.Arrays;

// 贪心算法
// https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E8%B4%AA%E5%BF%83%E6%80%9D%E6%83%B3.md
public class AssignCookies {
    public static void main(String[] args) {
//        int[] grid = {1, 3};
//        int[] size = {1, 2, 4};
        int[] grid = {1, 2, 3, 5, 8};
        int[] size = {1, 3, 3, 4, 6, 4};
        System.out.println("count of children: " + assignCookies(grid, size));
    }

    private static int assignCookies(int[] grid, int[] size) {
        Arrays.sort(grid);
        Arrays.sort(size);
        int gi = 0, si = 0;
//        int count = 0;
        while (gi < grid.length && si < size.length) {
            if (grid[gi] <= size[si]) {
//                count++;
                gi++;
            }
            si++;
        }
//        return count;
        return gi;
    }
}
