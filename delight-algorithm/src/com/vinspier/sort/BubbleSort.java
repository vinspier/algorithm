package com.vinspier.sort;

/**
 * 冒泡排序 选择从一端向一端行进
 * 比较相邻两个数 将较大/较小的数网指定一端移动
 *
 * */
public class BubbleSort {

    /**
     * 时间复杂度
     * 最差的情况 n + (n-1) + ……+ 1 = O(n^2)
     * 最好情况 比较了一边发现不用交换 O(n)
     * 平均情况O(n^2)
     *
     * 辅助空间 O(1)
     * */
    public static int[] sort(int[] array){
        if (array.length < 2){
            return array;
        }
        int temp;
        // 交换轮数n-1次
        for (int i = 0; i < array.length - 1; i++){
            // 在一次遍历中交换的次数
            int swap = 0;
            for(int j = 0; j < array.length - i - 1;j++){
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swap++;
                }
            }
            if (swap == 0){
                break;
            }
        }
        return array;
    }

}
