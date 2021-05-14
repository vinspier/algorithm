package com.vinspier.LeetCode.array;

/**
 *
 * */
public class Solution1310 {

    /**
     * 粗暴解法
     * arr len = m
     * queries len = n
     * 时间复杂度 O[m * n]
     *  */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        int left,right;
        for (int i = 0; i < queries.length; i++){
            left = queries[i][0];
            right = queries[i][1];
            while (right < arr.length && left <= right){
                result[i] ^= arr[left++];
            }
        }
        return result;
    }

    /**
     * 前缀异或思想
     *
     * 对arrs做 0 - i的递归异或运算 记录在一个xors数组中
     *
     * arrs[a1,a2,a3,a4 ........ a9,a10....a_n]
     *               ^               ^
     *               i               j
     *
     * 对于 0 <= i <= j <= arrs.len 做 arrs[i] ^ arrs[i + 1] ... ^ arrs[j]
     *
     * 等同于 xors[i] ^ xors[j + 1] 因为 a ^ a = 0 , a ^ 0 = a
     *
     * */
    public int[] xorQueriesPrefix(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] xors = new int[len + 1];
        for (int i = 0; i < len; i++){
            xors[i + 1] = xors[i] ^ arr[i];
        }
        len = queries.length;
        int[] result = new int[len];
        for (int j = 0; j < len; j++){
            result[j] = xors[queries[j][0]] ^ xors[queries[j][1] + 1];
        }
        return result;
    }
}
