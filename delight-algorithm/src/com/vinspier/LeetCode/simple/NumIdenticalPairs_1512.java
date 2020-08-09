package com.vinspier.LeetCode.simple;

public class NumIdenticalPairs_1512 {

    /**
     * 相同数值的个数n 下标值组合 有n阶加个组合
     * 1 + 2 + ··· + n - 1
     * 那么 只需统计相同数值的个数 并进行累加即可
     * */
    public int numIdenticalPairs(int[] nums) {
        int sum = 0;
        // 条件是 1<=num[i] <= 100
        int[] numCount = new int[101];
        for (int index : nums){
            numCount[index]++;
            sum += numCount[index] - 1;
        }
        return sum;
    }

}
