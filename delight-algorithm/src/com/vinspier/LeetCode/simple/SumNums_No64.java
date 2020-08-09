package com.vinspier.LeetCode.simple;

public class SumNums_No64 {

    public static void main(String[] args) {
        System.out.println(sumNums(100));
    }

    public static int sumNums(int n) {
        boolean judge = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }

}
