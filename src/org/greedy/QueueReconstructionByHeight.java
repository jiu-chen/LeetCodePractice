package org.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = queueReconstructionByHeight(people);
        for (int[] r : result) {
            System.out.print(Arrays.toString(r) + "\t");
        }
    }

    private static int[][] queueReconstructionByHeight(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return (o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[1]);
//            }
//        });
        // <=>
        Arrays.sort(people, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));

        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[queue.size()][]);
    }
}
