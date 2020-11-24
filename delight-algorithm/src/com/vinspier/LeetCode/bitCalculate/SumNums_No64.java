package com.vinspier.LeetCode.bitCalculate;


/**
 * 位运算求和
 *
 * @author: vinspier
 * @date: 2020/11/24 14:22
 */
public class SumNums_No64 {

    public static void main(String[] args) {
        System.out.println(sumNums(100));
    }


    /**
     * 通过位运算递归求和 以及判断条件
     *
     * @param n
     * @return
     */
    public static int sumNums(int n) {
        boolean judge = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }

}
