package com.vinspier.LeetCode.bitOperate;

/**
 * 异或逻辑
 * a ^ 0 = a
 * a ^ a = 0
 * a ^ b = c 交换律 b = c ^ a
 */
public class Solution1734 {

    public static void main(String[] args) {
        Solution1734 solution1734 = new Solution1734();
        solution1734.decode(new int[]{2,3,4,5});
    }

    /**
     * 它是前 n 个正整数的排列 表示数组值在 1 - n 的数字的排列
     * 关键点 n为奇数 说明perm元素为奇数个
     * perm[a,6 ^ a,6 ^ a ^ 5,6 ^ a ^ 5 ^ 4,6 ^ a ^ 5 ^ 4 ^ 6]
     * encoded[6,5,4,6]
     * 思路
     * 1、perm[] 全部异或一遍  -> permTotal
     * 2、encoded[] 的偶数位全部异或一遍 为 perm[] 除了第一个数的 全部异或 -> encodedTotal
     * 3、根据 a ^ a = 0，a ^ 0 = a 得出 perm[0] = permTotal ^ encodedTotal;
     * */
    public int[] decode(int[] encoded) {
        int permTotal = 0;
        for (int i = 1; i <= encoded.length + 1; i++){
            permTotal ^= i;
        }
        int encodedTotal = 0;
        for (int j = 1; j < encoded.length; j += 2){
            encodedTotal ^= encoded[j];
        }
        int[] perms = new int[encoded.length + 1];
        perms[0] = permTotal ^ encodedTotal;
        for (int i = 1; i < perms.length; i++){
            perms[i] = perms[i - 1] ^ encoded[i - 1];
        }
        return perms;
    }

}
