package com.vinspier.LeetCode.bitCalculate;

/**
 * 输入一个有符号的int类数
 * 找出二进制表达式中数字位数为 '1' 的个数
 *
 * @author: vinspier
 * @date: 2020/11/24 14:25
 */
public class HamMingWeight {

    public static void main(String[] args) {
        HamMingWeight hamMingWeight = new HamMingWeight();
        System.out.println(hamMingWeight.count(-3));
        System.out.println(hamMingWeight.count1(-3));
    }

    /**
     * 使用模板数1 位移 与目标数与运算 统计1的个数
     * @param n
     * @return
     */
    public int count(int n){
        int count = 0;
        int template = 1;
        for (int i = 0; i < 32; i++){
            if ((template & n) != 0){
                count++;
            }
            template = template << 1;
        }
        return count;
    }

    /**
     * n = n &(n - 1) 将最后一位的1 变成0
     * 判断n是否为0 若不是则count + 1
     * @param n
     * @return
     */
    public int count1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n &= n - 1;
        }
        return count;
    }

    /**
     *  转换成字符串来做
     *
     * @author: vinspier
     * @date:
     */
    public int count2(int n){
        return Integer.toBinaryString(n).replaceAll("0","").length();
    }
}