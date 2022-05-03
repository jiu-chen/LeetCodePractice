package org.binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        int m = 8;
        int result = sqrt(m);
        System.out.println(result);
    }

    private static int sqrt(int m) {
        int l = 1, h = m / 2;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mid * mid == m) {
                return mid;
            } else if (mid * mid > m) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

}
