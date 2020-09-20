package com.vinspier.LeetCode.simple;

import java.util.Arrays;

/**
* @description: 数组加1问题
* @author: vinspeir
* @date:2020/9/20 16:00
*/
public class PlusOne_No66 {

    public static void main(String[] args) {
        PlusOne_No66 plusOne_no66 = new PlusOne_No66();
        int[] y = new int[]{2,4,9,3,9};
        int[] digits = plusOne_no66.plusOne(y);
        System.out.println(Arrays.toString(digits));
    }

//    输入: [1,2,3]
//    输出: [1,2,4]
//    解释: 输入数组表示数字 123。
    /**
     * 关键点 是否进位
     * 进位是否连续
     * 第一位若要进位 则需要数组扩容
     * */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        // 最后一位加1后 无需进位
        if (digits[len - 1] < 9){
            digits[len - 1]++;
        }else{
            int index = len - 1;
            // 从末尾往头部寻找 直到全部进位完成
            while (index >= 0){
                if (digits[index] < 9){
                    break;
                }
                digits[index] = 0;
                index--;
            }
            // 首位是9 并且需要进位 则扩容数组
            if (index < 0){
                int[] newArray = new int[len + 1];
                newArray[0] = 1;
                return newArray;
            }else{
                digits[index]++;
            }

        }
        return digits;
    }

}
