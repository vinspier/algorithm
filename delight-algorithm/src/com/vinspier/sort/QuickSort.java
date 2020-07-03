package com.vinspier.sort;

/**
 * 快速排序
 *
 * 从数组中选取一个基准数，查找小于该基准数的放左边，大于基准数的放右边
 *
 * */
public class QuickSort {

    /**
     * 时间复杂度
     * 最差的情况O(n^2)
     * 最好情况 O(nlog2n)
     * 平均情况O(nlog2n)
     *
     * 辅助空间 O(1)
     * */
    public static void sort(int[] array,int start,int end) {
        if (start > end){
            return ;
        }
        int standard = array[start];// 基准数
        int low = start;// 低位指针移动的所在位置
        int high = end;// 高位指针移动的所在位置
        while (low < high){
            // 先从高位向低位方向查找小于基准数的位置
            while (high > low && array[high] >= standard){
                high--;
            }
            array[low] = array[high];
            // 先从低位向高位方向查找大于基准数的位置
            while (low < high && array[low] <= standard){
                low++;
            }
            array[high] = array[low];
        }
        // 当两个指针碰撞时 结束循环
        array[low] = standard;
        // 递归 对基准数左右两边的数组 采用同样方式
        sort(array,start,low - 1);
        sort(array,low + 1,end);
    }

}
