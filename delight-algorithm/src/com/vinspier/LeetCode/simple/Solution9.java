package com.vinspier.LeetCode.simple;

public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        System.out.println(solution9.isPalindrome(11));
    }

    /**
     * 1、数字转字符串
     * 2、数字取模存入数组
     * 3、数字转 字符数组 双指针判断
     * 4、数字取模
     */
    public boolean isPalindrome(int x) {
        // 小于0的肯定不是 | 最低位为0的一定不是
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        // 只有一位 肯定是
        if (x / 10 == 0){
            return true;
        }
        //记录一半的数字
        int len = String.valueOf(x).length();
        int[] low = new int[len / 2];
        // 先取出低位的 一半数据
        for (int i = 0; i < len / 2; i++){
            low[i] = x % 10;
            x /= 10;
        }
        // 长度为奇数 则过滤中间位置
        if ((len & 1) == 1){
            x /= 10;
        }
        for (int i = low.length - 1; i >= 0; i--){
            if (x % 10 != low[i]){
                return false;
            }
            x /= 10;
        }
        return true;
    }

    /**
     * 123454321
     * 分层1234 5 4321部分
     * 对低位部分 进行反转 4321 -> 1234 与高位部分1234比较
     */
    public boolean isPalindrome1(int x) {
        // 小于0的肯定不是 | 最低位为0的一定不是
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        // 只有一位 肯定是
        if (x / 10 == 0){
            return true;
        }
        int reverted = 0;
        // 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，
        // 所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。
        while (x > reverted) {
            reverted = reverted * 10 + x % 10;
            x /= 10;
        }
        // 第二个判断 x为奇数位 去掉中间位
        return x == reverted || x == reverted / 10;
    }

}
