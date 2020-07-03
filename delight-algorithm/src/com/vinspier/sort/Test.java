package com.vinspier.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] array = ArraysUtil.getIntArray(20,50);
        System.out.println(Arrays.toString(array));

        //SelectSort.sort(array);
        //BubbleSort.sort(array);
        //InsertSort.sort(array);
        //QuickSort.sort(array,0,array.length - 1);
        ShellSort.sort(array,6);

        System.out.println("[--------------------------------]");
        System.out.println(Arrays.toString(array));
    }

}
