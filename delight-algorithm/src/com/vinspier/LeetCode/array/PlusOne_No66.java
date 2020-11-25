package com.vinspier.LeetCode.array;

import java.util.Arrays;

/**
* @description: 数组加1问题
* @author: vinspeir
* @date:2020/9/20 16:00
*/
public class PlusOne_No66 {

    public static void main(String[] args) {
        PlusOne_No66 plusOne_no66 = new PlusOne_No66();
        int[] y = new int[]{9};
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
        // 最后一位索引
        int index = len - 1;
        // 最后一位是9 需要进位
        // 从末尾往头部寻找 直到全部进位完成
        while (index >= 0){
            // 未循环到首位 最后一位+1直接返回
            if (digits[index] < 9){
                digits[index]++;
                return digits;
            }
            digits[index] = 0;
            index--;
        }
        // 首位是9 并且需要进位 则扩容数组
        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }

    /**
     *
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            // 未循环到首位就截至 最后轮到的+1 返回原数组
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // 首位是9 并且需要进位 则扩容数组
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        return newArray;
    }

}
