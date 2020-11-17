package com.vinspier.LeetCode.simple;

/**
 * 计算字符串中出现次数最多的字符
 */
public class MonstCountChar {


    /**
     * HashMap即可实现
     */
    public static void main(String[] args) {
        String s = "SADFsdfaSSASDFAKDdskfa";
        char[] value = s.toCharArray();
        int[] count = new int[52];
        int maxIndex = -1;
        int maxCount = 0;
        for (int i = 0; i < value.length; i++){
            int index = value[i] % 65;
            count[index]++;
            if (count[index] > maxCount){
                maxCount = count[index];
                maxIndex = index;
            }
        }
        if (maxIndex > -1){
            System.out.println((char) (65 + maxIndex));
        }

    }

}
