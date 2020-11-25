package com.vinspier.LeetCode.array;

/**
 * 给定 nums = [3,2,2,3], val = 3,
 * 返回新数组的新长度 [2,2,3,3] 两个3其实属于删除的值
 * 
 * @author: vinspier
 * @date: 2020/11/25 23:55
 */
public class RemoveElement27 {

    public static void main(String[] args) {
        RemoveElement27 removeElement27 = new RemoveElement27();
        System.out.println(removeElement27.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    public int removeElement(int[] nums, int val) {
        int removeCount = 0;
        int temp;
        int start = 0;
        int lastRemove = nums.length - 1;
        while (start < nums.length - removeCount){
            if (nums[start] == val){
                while (lastRemove > start && nums[lastRemove] == val){
                    removeCount++;
                    lastRemove--;
                }
                if (lastRemove > start){
                    temp = nums[start];
                    nums[start] = nums[nums.length - removeCount - 1];
                    nums[nums.length - removeCount - 1] = temp;
                    lastRemove--;
                }
                removeCount++;
            }
            start++;
        }
        return nums.length - removeCount;
    }

    /**
     * 双指针方法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        // 记录不等于val的索引值
        // 也是记录长度的值
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
