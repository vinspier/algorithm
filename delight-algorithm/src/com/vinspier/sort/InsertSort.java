package com.vinspier.sort;

/**
 * 直接插入排序
 * 选择一端开始，从起始第一位开始，当作是已经是排好序的数组
 * 依次把后面的数 插入 到 前面 已经排好序的数组中去
 *
 * */
public class InsertSort {

    /**
     * 时间复杂度
     * 最差的情况 n + (n-1) + ……+ 1 = O(n^2)
     * 最好情况 比较了一边发现不用交换 O(n)
     * 平均情况O(n^2)
     *
     * 辅助空间 O(1)
     * */
    public static int[] sort(int[] array) {
        if (array.length < 2){
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            // 先与最边上的数 比较 是否需要继续查找比较
            if (array[i] < array[i - 1]){
                int temp = array[i];
                int j = i;
                // temp 逐一比较 找到合适的位置
                for (; j >= 1 && array[j-1] > temp ;j--){
                    array[j] = array[j-1];
                }
                array[j] = temp;
            }
        }
        return array;
    }

}
