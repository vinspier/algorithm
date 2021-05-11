package com.vinspier.LeetCode.simple;

/**
 * 整数反转
 */
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(-1563847412));
        System.out.println(solution7.reverseByString(-123));
    }

    /**
     * int 范围 -2147483648 至 2147483647
     * */
    public int reverse(int x) {
        // 若只有一位 直接返回原值
        if (x / 10 == 0){
            return x;
        }
        int result = 0;
        while (x != 0){
            int mod = x % 10;
            if (result > 214748364 || (result == 214748364 && mod > 7)){
                return 0;
            }
            if (result < -214748364 || (result == -214748364 && mod < -8)){
                return 0;
            }
            result = result * 10 + mod;
            x /= 10;
        }
        return result;
    }

    /**
     * 轮转除法
     * */
    public int reverseArray(int x) {
        // 若只有一位 直接返回原值
        if (x / 10 == 0){
            return x;
        }
        // 记录是否小于0 标识位
        boolean negative = x < 0;
        x = Math.abs(x);
        int len = String.valueOf(Math.abs(x)).length();
        int [] resultArray = new int[len];
        int index = 0;
        // 对数据进行轮转计算
        while (x / 10 != 0){
            resultArray[index++] = x % 10;
            x /= 10;
        }
        resultArray[index] = x;
        long result = 0;
        for (int i = 0; i < resultArray.length;i++){
            result += resultArray[i] * Math.pow(10,len - i - 1);
        }
        result *= negative ? -1 : 1;
        if (result < Integer.MAX_VALUE && result > Integer.MIN_VALUE){
            return (int)result;
        }
        return 0;
    }

    public int reverseStringBuilder(int x) {
        // 若只有一位 直接返回原值
        if (x / 10 == 0){
            return x;
        }
        // 记录是否小于0 标识位
        boolean negative = x < 0;
        x = Math.abs(x);
        StringBuilder result = new StringBuilder();
        while (x / 10 != 0){
            result.append(x % 10);
        }
        result.append(x);
        String result1 = (negative ? "-" : "") + result.toString();
        try {
            return Integer.parseInt(result1);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 转字符串
     * 字符串类反转字符
     * 双指针交换位置
     * */
    public int reverseByString(int x) {
        // 若只有一位 直接返回原值
        if (x / 10 == 0){
            return x;
        }
        // 记录是否小于0 标识位
        boolean negative = x < 0;
        String origin = String.valueOf(Math.abs(x));
        String result = (negative ? "-" : "") + new StringBuffer(origin).reverse().toString();
        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return 0;
        }
    }
}
