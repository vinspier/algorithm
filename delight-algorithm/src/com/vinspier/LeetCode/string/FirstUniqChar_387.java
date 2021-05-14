package com.vinspier.LeetCode.string;

/**
 * 字符串中的第一个唯一字符
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母
 */
public class FirstUniqChar_387 {

    public static void main(String[] args) {
        FirstUniqChar_387 firstUniqChar_387 = new FirstUniqChar_387();
        System.out.println(firstUniqChar_387.firstUniqChar("leetcode"));
        System.out.println(firstUniqChar_387.firstUniqChar("loveleetcode"));
    }

    /**
     * 本次方法 只考虑了26个小写字母
     *
     * 思路：由于26个字母是固定的 所以可以预先定义len=26的数组
     * 存储对应字符的在原字符串中最后的下标值
     */
    public int firstUniqChar(String s) {
        // 判断空字符串
        if (null == s || s.isEmpty()){
            return -1;
        }
        // 'A' -> 65 'a' -> 97 相差32
        char[] charValues = s.toCharArray();
        // 数组记录字符最后一次出现的所在索引
        int[] lastCharIndex = new int[26];
        // a-z的值97-122
        for (int i= 0; i < charValues.length; i++){
            lastCharIndex[charValues[i] - 'a'] = i;
        }
        // 在遍历一次原字符数组
        for (int j= 0; j < charValues.length; j++){
            // 若存储的索引等于字符在原字符串中的为止 表示该字符只出现一次
            if (lastCharIndex[charValues[j] - 'a'] == j){
                return j;
            }
            // 将值置1 防止最后一位相同字符判断返回 -1
            lastCharIndex[charValues[j] - 'a'] = -1;
        }
        return -1;
    }

    /**
     * charCount 记录字符出现的次数
     * 根据次数==1 返回字符所在的索引位
     */
    public int firstUniqChar1(String s) {
        // 判断空字符串
        if (null == s || s.isEmpty()){
            return -1;
        }
        // 'A' -> 65 'a' -> 97 相差32
        char[] charValues = s.toCharArray();
        // 数组记录字符最后一次出现的所在索引
        int[] charCount = new int[26];
        // a-z的值97-122
        for (int i= 0; i < charValues.length; i++){
            charCount[charValues[i] - 'a']++;
        }
        // 在遍历一次原字符数组
        for (int j= 0; j < charValues.length; j++){
            if (charCount[charValues[j] - 'a'] == 1){
                return j;
            }
        }
        return -1;
    }

    /**
     * 问题延申
     * 找出第一个只出现一次的字符
     */
    public char firstUniqCountChar(String s) {
        // 判断空字符串
        if (null == s || s.isEmpty()){
            return ' ';
        }
        // 'A' -> 65 'a' -> 97 相差32
        char[] charValues = s.toCharArray();
        // 数组记录字符出现的次数
        int[] charCount = new int[26];
        // a-z的值97-122
        for (int i= 0; i < charValues.length; i++){
            charCount[charValues[i] - 'a']++;
        }
        // 在遍历一次原字符数组
        for (int j= 0; j < charValues.length; j++){
            // 找到出现次数为1的字符
            if (charCount[charValues[j] - 'a'] == 1){
                return charValues[j];
            }
        }
        return ' ';
    }

}
