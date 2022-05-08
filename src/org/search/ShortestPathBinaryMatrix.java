package org.search;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1},
                {0, 0, 0},
                {1, 1, 1},
        };

        int[][] grid2 = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 0},
        };
        int path = ShortestPath(grid);
        System.out.println("shortest path: " + path);
        System.out.println("===============");
        int path2 = ShortestPath(grid2);
        System.out.println("shortest path2: " + path2);
    }

    private static int ShortestPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[][] direction = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}};

        grid[0][0] = 1;
        int path = 1;

        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                assert cur != null;
                // x, y 表示当前的下标
                int x = cur[0];
                int y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return path;
                }

                for (int[] d : direction) {
                    // x1, y1 对应 "下一个" 方向的下标
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1) {
                        continue;
                    }
                    queue.add(new int[]{x1, y1});
                    grid[x1][y1] = 1; //    必须要将处理过的下标标记，否则下一次还会处理，造成了死循环
                }
            }
            path++;
        }
        return -1;
    }
}
