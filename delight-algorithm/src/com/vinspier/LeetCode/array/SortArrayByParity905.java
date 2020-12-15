package com.vinspier.LeetCode.array;

import java.util.Arrays;

/**
 * 给定一个数组 将所有的偶数和奇数分堆
 * 偶数在前 奇数在后
 * */
public class SortArrayByParity905 {

    public static void main(String[] args) {
        SortArrayByParity905 sortArrayByParity905 = new SortArrayByParity905();
        int[] newArr = sortArrayByParity905.sortArrayByParity(new int[]{1,3,5,7,9,0,2,4,6,8});
        Arrays.asList(newArr).forEach(System.out::println);
    }

    /**
     * 思路 双指针方式
     * start end
     * 从头开始找到奇数 再从尾部找到偶数 两者交换位置
     * 直到 start >= end
     *
     * */
    public int[] sortArrayByParity(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            // 从头寻找奇数
            if ((arr[start] & 1) == 1){
                while (start < end){
                    if ((arr[end] & 1) == 0){
                        // 交换位置
                        arr[start] ^= arr[end];
                        arr[end] ^= arr[start];
                        arr[start] ^= arr[end];
                        end--;
                        break;
                    }
                    end--;
                }
            }
            start++;
        }
        return arr;
    }

}
