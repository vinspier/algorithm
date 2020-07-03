package com.vinspier.sort;

import java.util.Arrays;
import java.util.Random;

public class ArraysUtil {

    private static Random random = new Random();

    public static int[] getIntArray(int len,int max){
        int[] initArr = new int[len];
        max = Math.min(max,Integer.MAX_VALUE);
        for (int i = 0; i < len; i++){
            initArr[i] = random.nextInt(max);
        }
        return initArr;
    }

}
