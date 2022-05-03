package org.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] internals = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(nonOverlappingIntervals(internals));
    }

    private static int nonOverlappingIntervals(int[][] internals) {
        // 实现 compare() 函数时避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出。
        // 使用 lambda 表示式创建 Comparator 会导致算法运行时间过长，如果注重运行时间，可以修改为普通创建 Comparator 语句：
        Arrays.sort(internals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return (Integer.compare(o1[0], o2[0]));
                return (o1[1] < o2[1] ? -1 : (o1[0] == o2[0] ? 0 : 1));
            }
        });
        // cnt就是表示需要移除的区间个数
        int cnt = 0;
        int end = internals[0][1];
        for (int i = 1; i < internals.length; i++) {
            if (internals[i][0] < end) {
                cnt++;
                continue;
            }
            end = internals[i][1];
        }
        return cnt;
    }
}
