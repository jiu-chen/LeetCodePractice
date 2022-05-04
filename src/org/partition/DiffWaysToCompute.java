package org.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffWaysToCompute {

    public static void main(String[] args) {
        String s = "2-1-1";
        List<Integer> res = diffWaysToCompute(s);
        System.out.println(res);
    }

    private static List<Integer> diffWaysToCompute(String s) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = diffWaysToCompute(s.substring(0, i));
                List<Integer> right = diffWaysToCompute(s.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '-' -> ways.add(l - r);
                            case '+' -> ways.add(l + r);
                            case '*' -> ways.add(l * r);
                        }
                    }
                }

            }
        }
        // for example: s="5"
        if (ways.size() == 0) {
            ways.add(Integer.valueOf(s));
        }
        return ways;
    }
}
