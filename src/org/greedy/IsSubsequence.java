package org.greedy;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abavd";
        String t = "aav";
//        String t = "ava";
        System.out.println(isSubsequence(s, t));
    }

    // s是否可以通过删除某些个（大于或等于0个）字符得到t, 如果可以，那么t就是s的子序列
    private static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
//            if (s.charAt(i) == t.charAt(j)) {
//                i++;
//                j++;
//            }else {
//                i++;
//            }
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == t.length();
    }

}
