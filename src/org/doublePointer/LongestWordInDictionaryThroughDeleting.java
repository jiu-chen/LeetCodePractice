package org.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
// 如果有多个相同长度的结果，返回字典序的最小字符串。


public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<>(
                Arrays.asList("ale", "apple", "monkey", "plea")
        );
        System.out.println(findLongestWord(s, d));
    }


    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    // 通过删除字符串 s 中的一个或多个字符能得到字符串 t，可以认为 t 是 s 的子序列
    // ，我们可以使用 `双指针` 来判断一个字符串是否为另一个字符串的子序列。
    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
