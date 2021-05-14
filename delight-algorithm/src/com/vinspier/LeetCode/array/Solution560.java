package com.vinspier.LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 * */
public class Solution560 {

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySumPrefixSum(new int[]{1,1,1},2));
        System.out.println(solution560.subarraySumPrefixSumStoreMap(new int[]{1,1,1},2));
    }

    /**
     * 常规方法
     * 时间复杂度O(n^2)
     * */
    public int subarraySumNormal(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            int current = i;
            int sum = 0;
            for (int j = current; j >= 0; j--){
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和思想
     * 愿数组 num[0 - i]
     * 先计算0 - i的前缀和 sum[0-i]
     *
     * 有以下结论
     * sums[0] = 0
     * sums[i + 1] = sums[i] + nums[i] , i < nums.length;
     *
     * 在i位置 向前寻找连续子数组和为k
     * 等同于 0 <= j <= i 存在 sums[i] - sums[j - 1] = k 即存在一个子数组符合条件 包括sums[i] == k
     * 再转义就是 在0 < j <= i中 存在sums[j - 1] = sums[i] - k 即存在一个子数组符合条件  包括sums[i] == k
     *
     * 此时不用hashmap存储前缀和 其实时间复杂度还是等同于O(n^2)
     * */
    public int subarraySumPrefixSum(int[] nums, int k) {
        int count = 0;
        // 第i位的前缀数组累加和
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++){
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j <= i + 1; j++){
                // 等同于从sums中 寻找是否等于差值 sums[i + 1] -  k
                // 等同于从sums中 寻找所有差值的出现的次数和  sums[i + 1] -  k && 0 <= i < nums.length;
                if (sums[j - 1] == sums[i + 1] -  k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 为降低时间复杂度 可以将sums的前缀和存入hashMap中
     * key为第i位的前缀和，value为和相同的次数
     *
     * 在0 < j <= i中 存在sum[j - 1] = sum[i] - k 即存在一个子数组符合条件
     * 即从map中获取 和为sum[i] - k的个数 累加就好了
     *
     * 从map中获取的时间复杂度是O(1) 总体来说 降低了一个n级别 从o(n^2) -> O(n)
     * */
    public int subarraySumPrefixSumStoreMap(int[] nums, int k) {
        int count = 0;
        // 第i位的前缀数组累加和
        Map<Integer,Integer> sumsMap = new HashMap<>();
        // 等同于sums的首位0
        sumsMap.put(0,1);
        // 第i位的前缀数组累加和
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            // 计算差值
            int differ = sum - k;
            // 从map中获取的时间复杂度是O(1) 总体来说 降低了一个n级别
            count += sumsMap.getOrDefault(differ,0);
            int appear = sumsMap.getOrDefault(sum,0);
            // 如果该和不存在 则初始化
            sumsMap.put(sum,appear+1);
        }
        return count;
    }

}
