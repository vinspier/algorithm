package com.vinspier.LeetCode.bitCalculate;

/**
 * 判断一个整数是否为2的n次幂
 *
 * @author: vinspier
 * @date: 2020/11/24 13:54
 */
public class PowerOfTwo231 {

    public static void main(String[] args) {
        PowerOfTwo231 powerOfTwo231 = new PowerOfTwo231();
        System.out.println(powerOfTwo231.powerOfTwo(3));
    }

    /**
     * 计算二进制比特位为1的个数 是否只有一个
     * */
    public boolean powerOfTwo(int var){
        if (var < 1){
            return false;
        }
        if (var == 1){
            return true;
        }
        // 数值二进制表示法中 1的位数
        int count = 0;
        int template = 1;
        for (int i = 0; i < 31; i++){
            if ((template & var) != 0){
                count++;
            }
            // 拿1 每次左移一位 去比较对应位的数值是否为1
            template = template << 1;
        }
        return count == 1;
    }

    /**
     *  若N为2的n次幂
     *  则有 N & (N - 1)的特殊结论
     *
     * @author: vinspier
     * @date:
     */
    public boolean powerOfTwo1(int n){
        if (n < 1){
            return false;
        }
        return (n & (n -1)) == 0;
    }

}
