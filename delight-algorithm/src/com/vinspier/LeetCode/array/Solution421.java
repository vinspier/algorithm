package com.vinspier.LeetCode.array;

/**
 * 数组中两个数的最大异或值
 * 0 <= i <= j <= len
 * 时间复杂度O(n^2)
 * */
public class Solution421 {

    public static void main(String[] args) {
        Solution421 solution421 = new Solution421();
        System.out.println(solution421.findMaximumXORNormal(new int[]{8,10,2}));
        System.out.println(solution421.findMaximumXORNormal(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        System.out.println(solution421.findMaximumXOR(new int[]{8,10,2}));
    }

    /**
     * 暴力解法
     * 从第一位开始 往后一次迭代异或
     * */
    public int findMaximumXORNormal(int[] nums) {
        int max = 0;
        for (int i = 0; i <= nums.length; i++){
            for (int j = i; j < nums.length; j++){
                max = Math.max(max,nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    /**
     * a ^ a ^ b = b
     * 采用重复异或去掉前一个数
     * */
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            temp ^= nums[i];
            max = Math.max(max,temp);
            temp ^= nums[i -1];
        }
        return max;
    }

}
