package com.vinspier.sort;

public class ShellSort {


    public static void sort(int[] array,int gap){
        if (array.length < 2){
            return;
        }
        if (gap <= 1){
            gap = array.length / 2;
        }
        for (;gap > 0;gap /= 2){
            for (int i = 0; i < gap; i++){
                sortInsert(array,i,gap);
            }
        }

    }


    /**
     * 对每个分组进行希尔排序
     * 每组start 第一个元素起始位置
     * gap 没组的间隔大小
     * */
    private static void sortInsert(int[] array,int start,int gap) {
        for (int i = start + gap; i < array.length; i += gap) {
            // 先与最边上的数 比较 是否需要继续查找比较
            if (array[i] < array[i - gap]){
                int temp = array[i];
                int j = i;
                // temp 逐一比较 找到合适的位置
                for (; j >= start + gap && array[j - gap] > temp ;j -= gap){
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

}
