package com.vinspier.LeetCode.string;

/**
 * 重构字符串(暂时只考虑小写字母)
 * 检查是否能重新排布其中的字母，使得两相邻的字符不同
 */
public class ReorganizeString767 {

    public static void main(String[] args) {
        ReorganizeString767 reorganizeString767 = new ReorganizeString767();
        System.out.println(reorganizeString767.reorganize("aaabb"));
    }

    /**
     * 思路1
     * 最大出现次数的字符次数 不可大于(len + 1) / 2
     * 字符重构:先从偶数位置填充 再从奇数位填充
     * */
    public String reorganize(String origin){
        int len = origin.length();
        if (len < 2){
            return origin;
        }
        // 记录字符出现次数
        int[] appearCount = new int[26];
        // 字符出现次数最大值
        int appearMax = 0;
        char[] charValues = origin.toCharArray();
        for (int i = 0; i < len; i++){
            appearCount[charValues[i] - 'a']++;
            if (appearCount[charValues[i] - 'a'] > appearMax){
                appearMax = appearCount[charValues[i] - 'a'];
            }
        }
        // 最大次数满足 小于 (len + 1) >> 1 可以重现
        if (appearMax <= (len + 1) >> 1){
            // 从第一个开始填充
            int start = 0;
            for (int j = 0; j < appearCount.length; j++){
                if (appearCount[j] < 1){
                    continue;
                }
                // 组合
                while(appearCount[j] > 0){
                    charValues[start] = (char)('a' + j);
                    start += 2;
                    // 第一次超过末节点 切换奇数位置
                    if (start > len){
                        start = 1;
                    }
                    appearCount[j]--;
                }
            }
            return String.valueOf(charValues);
        }
        return "";
    }

}
