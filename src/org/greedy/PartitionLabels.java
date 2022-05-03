package org.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public static void main(String[] args) {
//        String s = "ababcbacadefegdehijhklij";   // [9, 7, 8]
//        String s = "ababcbacadefegdehijahklij";    // [25] 在遍历到第一个j的时候，end的值是24
        String s = "ababcbacadefegdeahijhklij";    // [17, 8] 在遍历到第一个a的时候，end的值是16
        List<Integer> res = partitionLabels(s);
        System.out.println(res);
    }

    private static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int start=0, end=0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            end=Math.max(end, map.get(s.charAt(i)));
            if(i==end){
                result.add(end-start+1);
                start=i+1;
            }
        }
        return result;

    }
}
