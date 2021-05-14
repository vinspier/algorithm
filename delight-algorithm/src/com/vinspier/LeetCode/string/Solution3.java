package com.vinspier.LeetCode.string;

import java.util.HashMap;

/**
 * 找出其中不含有重复字符的 最长子串 的长度
 * */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.lengthOfLongestSubstring("abceabcbb"));
//        System.out.println(solution3.lengthOfLongestSubstring("aaabbb"));
//        System.out.println(solution3.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution3.lengthOfLongestSubstring("abba"));
        System.out.println(solution3.lengthOfLongestSubstring1("abba"));
    }

    /**
     * 思路一：
     * 1、逐个遍历 将字符放入hashMap中 直到有重复的重新寻找
     * key 为字符
     * value 为字符的索引位置
     *
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null){
            return 0;
        }
        if (s.length() < 2){
            return s.length();
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index;
        int longestSubLen = 0;
        // 起始位
        int start = 0;
        // 结束位
        int i = 0;
        while (i < len){
            index = hashMap.getOrDefault(chars[i],-1);
            // 若还未重复 将字符存入map
            if (index == -1){
                hashMap.put(chars[i],i);
                i++;
                continue;
            }
            // 若遇到到重复字符
            int repeatIndex = i;
            longestSubLen = Math.max(longestSubLen,i - start);
            // 碰到重复的字符时 如果后面的一直和当前字符相等则继续往下走
            while (i < len - 2 && chars[i] == chars[i + 1]){
                i++;
            }
            // 1、一直再往后一个的字符也是重复的 则清空map
            if (repeatIndex < i){
                hashMap.clear();
                hashMap.put(chars[i],i);
                start = i;
                i++;
                continue;
            }
            // 2、再往后一个字符非重复 则替换map中重复字符的index 并且把start在map中重复的字符所在位置 + 1
            for (int j = start; j < index + 1; j++){
                // 删除重复位置的字符所在位置之前的所有字符
                hashMap.remove(chars[j]);
            }
            // 计算新的位置
            start = index + 1;
            // 把重复的字符最后一次出现的位置放入map
            hashMap.put(chars[i],i);
            i++;
        }
        return Math.max(longestSubLen,i - start);
    }

    /**
     * 思路2
     * 滑动窗口方式
     * hashmap做字符存储 key字符 value字符的索引位置
     * */
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int left = 0;
        int findIndex;
        int longestSubLen = 0;
        for (int i = 0; i < len; i++){
            findIndex = hashMap.getOrDefault(chars[i],-1);
            // 若hashmap中已经存在 则进行滑动窗口
            if (findIndex > -1){
                left = Math.max(left,findIndex + 1);
            }
            hashMap.put(chars[i],i);
            // 重新比较一下 最长不重复子字符串
            longestSubLen = Math.max(longestSubLen,i - left + 1);
        }
        return longestSubLen;
    }

}
