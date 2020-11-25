package com.vinspier.LeetCode.array;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: TwoSum
 * @Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author:
 * @Date: 2020/5/14 17:00
 * @Version V1.0
 **/
public class TwoSum_No1 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] nums, int target){
        // 存放未找到满足条件的已判断数值
        HashMap<Integer,Integer> storeMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int deviation = target - nums[i];
            // 若有匹配的数值 返回
            if (storeMap.containsKey(deviation)){
                return new int[]{storeMap.get(deviation),i};
            }
            storeMap.put(nums[i],i);
        }
        return null;
    }

}
