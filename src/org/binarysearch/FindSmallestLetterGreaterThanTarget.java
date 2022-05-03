package org.binarysearch;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] carr = {'c', 'f', 'j'};
        char target = 'f';  // 'j'
        char res = findSmallestLetterGreaterThanTarget(carr, target);
        System.out.println(res);
    }

    // 在 h 的赋值表达式为 h = m 的情况下，如果循环条件为 l <= h，那么会出现循环无法退出的情况，因此循环条件只能是 l < h。
    private static char findSmallestLetterGreaterThanTarget(char[] letters, char target) {
        if (target > letters[letters.length - 1]) {
            return letters[0];
        }
        int l = 0, h = letters.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (letters[mid] > target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }
}
