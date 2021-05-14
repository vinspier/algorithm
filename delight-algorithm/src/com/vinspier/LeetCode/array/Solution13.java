package com.vinspier.LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马字符 转 十进制 和
 * */
public class Solution13 {

    private static Map<Character,Integer> storeMap = new HashMap<>();

    static {
       storeMap.put('I',1);
       storeMap.put('V',5);
       storeMap.put('X',10);
       storeMap.put('L',50);
       storeMap.put('C',100);
       storeMap.put('D',500);
       storeMap.put('M',1000);
       // IV
       storeMap.put('a',4);
       // IX
       storeMap.put('b',9);
       // XL
       storeMap.put('c',40);
       // XC
       storeMap.put('d',90);
       // CD
       storeMap.put('e',400);
       // CM
       storeMap.put('f',900);
    }

    /**
     * 思路一
     * 当左边数字比右边数字小时做减法 反之做加法
     * */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int pre = storeMap.get(chars[0]);
        int sum = 0;
        for (int i = 1; i < chars.length; i++){
            int num = storeMap.get(chars[i]);
            sum += (pre < num ? -1 : 1) * pre;
            pre = num;
        }
        // 最后一位肯定是+
        sum += pre;
        return sum;
    }

    /**
     * 思路二
     * 把需要做减法的组合字符枚举出来 替换这些字符
     * */
    public int romanToIntByReplace(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++){
            sum += storeMap.get(chars[i]);
        }
        return sum;
    }

}
