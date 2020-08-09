package com.vinspier.LeetCode.simple;

public class Shuffle_1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] numsNew = new int[2 * n];
        for (int i = 0 ; i < n; i++){
            numsNew[2*i] = nums[i];
            numsNew[2*i + 1] = nums[i + n];
        }
        return numsNew;
    }

}
