package com.vinspier.LeetCode.bitCalculate;

/**
 * 找出非空数组中 只出现一次的数字
 *
 * @author: vinspier
 * @date: 2020/11/24 14:47
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(1 & 1 ^ 1 & 2 ^ 2 ^ 2 ^ 3);
        System.out.println(singleNumber.singleNumRepeat2(new int[]{1,2,3,4,5,4,3,2,1}));
        System.out.println(singleNumber.singleNumRepeat3(new int[]{1,1,1,4,4,4,5,2,2,2,3,3,3}));
    }

    /**
     * 2m + 1个数
     *  只有一个数是唯一的 其他的都是2个
     * 思路：a ^ a ^ b = b;
     * @author: vinspier
     * @date:
     */
    public int singleNumRepeat2(int [] arr){
        int len = arr.length;
        if (len == 0){
            throw new IllegalArgumentException("int arr value can not to be null or length must be greater than 0");
        }
        int result = arr[0];
        for (int i = 1; i < len; i++){
            result ^= arr[i];
        }
        return result;
    }

    /**
     *  问题升级
     *  3m + 1个数 找出唯一出现的数字
     * 思路一：3（a + b + c）- [3(a + b) + c] = 2c
     *
     *  (0 & a) ^ a ^ a ^ target = target
     *  所以只需要找出需要&的个数 = m个
     * @author: vinspier
     * @date:
     */
    public int singleNumRepeat3(int [] nums){
        int seenOnce = 0, seenTwice = 0;
        for (int num : nums) {
            // first appearance:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }


}
