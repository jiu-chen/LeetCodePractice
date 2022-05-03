package org.collections;

import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
}
