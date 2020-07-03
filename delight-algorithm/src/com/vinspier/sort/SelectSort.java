package com.vinspier.sort;


/**
 * 简单选择排序
 *
 * 以一个起始位开始，与剩下的比较，
 * 找出最小值，与第一个位置交换
 *
 * */
public class SelectSort {

    /**
     * 时间复杂度
     * 最差的情况 n + (n-1) + ……+ 1 = O(n^2)
     * 最好情况O(n^2)
     * 平均情况O(n^2)
     *
     * 辅助空间 O(1)
     * */
    public static int[] sort(int[] array){
        if (array.length < 2){
            return array;
        }
        int temp;
        int minIndex;
        // 比较数的起始位置
        for (int i = 0; i < array.length - 1; i++){
            minIndex = i;
            // 逐一比较
            for (int j = i + 1; j < array.length;j++){
                if (array[minIndex] - array[j] > 0){
                    minIndex = j;
                }
            }
            // 判断是否需要交换位置
            if (minIndex != i){
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

}
