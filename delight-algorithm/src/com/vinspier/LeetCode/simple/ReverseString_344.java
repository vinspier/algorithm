package com.vinspier.LeetCode.simple;

/**
 * 反转字符串 要求不允许使用额外的数组空间
 * 只允许有一个O（1）的额外临时空间
 *
 */
public class ReverseString_344 {


    public static void main(String[] args) {
        ReverseString_344 reverseString_344 = new ReverseString_344();
        reverseString_344.reverseString("vinspier".toCharArray());
        reverseString_344.reverseString1("vinspier".toCharArray());
    }

    /**
     * 思路：双指针方式
     * head,tail指针 当head >= tail 结束交换
     * @param s
     */
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        // 临时存储字符空间
        char temp;
        while(head <= tail){
            temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
        System.out.println(String.valueOf(s));
    }

    /**
     * 思路二：使用逻辑 ^ 运算 交换数值
     * (a ^ b) ^ a = b
     * [a][b]
     * [a^b][b]
     * [a^b][a]
     * [b][a]
     * 此方法未使用额外的空间
     */
    public void reverseString1(char[] s) {
        int len = s.length;
        int last;
        for (int i = 0; i < len / 2; i++){
            last = len - i -1;
            s[i] ^= s[last];
            s[last] ^= s[i];
            s[i] ^= s[last];
        }
        System.out.println(String.valueOf(s));
    }

}
