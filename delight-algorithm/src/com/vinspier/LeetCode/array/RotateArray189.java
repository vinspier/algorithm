package com.vinspier.LeetCode.array;

import java.util.Arrays;

/**
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 要求只能在原数组操作
 * 
 * @author: vinspier
 * @date: 2020/11/26 15:20
 */
public class RotateArray189 {


    /**
     * 1、BF解法
     * 每处理一次 就移动一次数组
     * 时间O(n) = n * k
     * 空间O(n) = O(1)
     * */

    /**
     * 2、借用额外的数组 [] 记录需要旋转的子数组
     * 进行两次拷贝 即可完成
     *
     * 时间O(n) = k
     * 空间O(n) = Math.min(k,nums.length - k)
     *
     * */

    /**
     * 3、多次旋转
     * a、先对整个数组旋转一次
     * b、再两个子数组各自旋转一次
     * 时间O(n) = n
     * 空间O(n) = O(1)
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99,45,2,45,1,23,6,74};
        RotateArray189 rotateArray189 = new RotateArray189();
        System.out.println("旋转前的数组");
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
        rotateArray189.rotate(nums,2);
        System.out.println("旋转后的数组");
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public int[] rotate(int[] nums, int k) {
        if(k < 0){
            throw new IllegalArgumentException("rotate times k can not be negative int");
        }
        // k为长度的整数倍 旋转后等于原数组直接返回
        if (k % nums.length == 0){
            return nums;
        }
        // 1、旋转整个数组
        rotateArr(nums,0,nums.length - 1);
        // 2、旋转需要移动的子数组
        rotateArr(nums,0,k % nums.length - 1);
        // 3、旋转无需移动的子数组
        rotateArr(nums,k % nums.length,nums.length - 1);
        return nums;
    }

    /**
     * 旋转数组
     * @param nums 源数组
     * @param start 起始位置
     * @param end 结束位置
     */
    public void rotateArr(int[] nums,int start,int end){
        // 1、使用位运算交换
        // 2、使用额外空间交换
        while (start < end){
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }

}
