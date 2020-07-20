package com.vinspier.LeetCode.simple;

/**
 * 一维数组的动态和
 * 输入 nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * */
public class RunningSum_No1480 {

    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public int[] runningSum1(int[] nums) {
        for (int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
