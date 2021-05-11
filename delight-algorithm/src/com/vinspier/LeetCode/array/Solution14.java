package com.vinspier.LeetCode.array;

/**
 * 字符串数组寻找 最长公共前缀
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        // 纵向匹配
        // 第一个为基准
        String basic = strs[0];
        int basicLen = basic.length();
        for (int i = 0; i < basicLen; i++){
            char c = basic.charAt(i);
            for (int j = 1; j < strs.length; j++){
                // 若其他字符串已达到其最大长度 或者 找到第一个字符串的某个字符不相等 则直接截取 0 至 i-1
                if (i > strs[j].length() || strs[j].charAt(i) != c){
                    return basic.substring(0, i);
                }
            }
        }
        return basic;
    }
}
