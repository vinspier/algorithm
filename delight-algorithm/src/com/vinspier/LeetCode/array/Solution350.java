package com.vinspier.LeetCode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 寻找两个数组的元素交集
 */
public class Solution350 {

    public static void main(String[] args) {
        Solution350 solution350 = new Solution350();

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        // 保证第一个数据为短数组
        if (nums2.length < nums1.length){
            return intersect(nums2,nums1);
        }
        // 遍历第一个数组放入map key为值 value为出现的次数
        Map<Integer,Integer> storeMap = new HashMap<>();
        for (int num : nums1){
            int count = storeMap.getOrDefault(num,0) + 1;
            storeMap.put(num,count);
        }
        // 遍历第二个数组 从map中寻找第一个数组相同的元素
        int[] result = new int[nums1.length];
        int k = 0;
        for (int num : nums2){
            int count = storeMap.getOrDefault(num,0);
            // 大于0 表示存在
            if (count > 0){
                result[k++] = num;
                storeMap.put(num,count - 1);
            }
        }
        if (k == nums1.length){
            return result;
        }
        return Arrays.copyOfRange(result,0,k);
    }

}
