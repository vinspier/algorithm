package com.vinspier.LeetCode.string;

/**
 * 旋转字符串
 * A = 'abcde', B = 'cdeab'
 * A依次把最左边字符移动到最后边 然后判断是否与B相等
 *
 *
 * @author: vinspier
 * @date: 2020/11/22 13:14
 */
public class RotateString_796 {

    public static void main(String[] args) {
        RotateString_796 rotateString_796 = new RotateString_796();
        long start = System.currentTimeMillis();
        System.out.println(rotateString_796.rotateStringEquals("abcdesdfghjsdfsdfsdfqws","sdfsdfqwsabcdesdfghjsdf"));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(rotateString_796.rotateStringKMP("abcdesdfghjsdfsdfsdfqws","sdfsdfqwsabcdesdfghjsdf"));
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用字符串提供的equals方法
     * @param a
     * @param b
     * @return
     */
    public boolean rotateStringEquals(String a, String b) {
        if (null == a || null == b){
            return false;
        }
        if (a.equals(b)){
            return true;
        }
        if (a.length() != b.length()){
            return false;
        }
        int len = a.length();
        // 开始旋转 逐一判断
        // 这里只需要移动len - 1就好了 上面已做原始字符串是否相等
        for (int i = 0; i < len - 1; i++){
            // 一直有字符串新建操作 内存消耗很大
            a = a.substring(1) + a.substring(0,1);
            if (a.equals(b)){
                return true;
            }
        }
        return false;
    }


    /**
     * 问题的延申
     *
     * A = 'abcde', B = 'cdeab'
     * 相当于 b是否是a + (a - 1)的子字符串问题
     * cdeab 是否是 abcdeabcd的子字符串
     * 1、string原生的contains方法
     * 2、KMP算法
     *
     * @param a
     * @param b
     * @return
     */
    public boolean rotateStringKMP(String a, String b) {
        if (null == a){
            throw new IllegalArgumentException("source string value can not be null");
        }
        if (null == b){
            return false;
        }
        if (a.equals(b)){
            return true;
        }
        if (a.length() != b.length()){
            return false;
        }
        StringKMP stringKMP = new StringKMP();
        return stringKMP.kmpMatch(a + a.substring(0,a.length() - 1),b) > -1;
    }

}
