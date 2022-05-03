package org.greedy;

public class CanPlaceFlowers {
    public static void main(String[] args) {
//        flowerbed = [1,0,0,0,1], n = 1
        int[] flowerbed = {1,0,0,0,1};
        int n=1;
        System.out.println(placeFlowersCount(flowerbed, n));
    }

    private static boolean placeFlowersCount(int[] flowerbed, int n) {
        // cnt计数器，用来表示是否有连续的三个0
        // 令cnt初始为1
        int cnt=1, nums=0;
        for (int j : flowerbed) {
            if (j == 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == 3) {
                nums++;
                cnt = 1;
            }
        }
        if(cnt==2){
            nums++;
        }
        return nums<=n;

    }
}
