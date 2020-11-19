package com.vinspier.LeetCode.simple;

/**
 * 字符串匹配问题
 * 给定两个字符 target 和 template
 * 找到template字符串在target中的第一出现的位置
 *
 * 例如 target=“loveleetcode” template="code"
 * 返回 8
 *
 */
public class StringKMP {


    public static void main(String[] args) {
        StringKMP stringKMP = new StringKMP();
//        System.out.println(stringKMP.normalMatch("loveleetcode","code"));

//        int[] maxLen = stringKMP.getMaxLen("abcdeabcd");
//        maxLen = stringKMP.getNext(maxLen);
//        for (int len : maxLen){
//            System.out.println(len);
//        }

        System.out.println(stringKMP.kmpMatch("loveleetcode","code"));

    }

    /**
     *
     * 暴力解法[暴风算法] 从头到尾一个一个去匹配 直到template在target中所有都匹配
     * 否则返回 -1
     *
     * 时间复杂度为 O((m-n)*n)
     *
     * @param target 目标源字符串
     * @param template 待匹配子字符串
     * @return
     */
    public int normalMatch(String target,String template){
        if (null == target || null == template || target.isEmpty() || template.isEmpty()){
            throw new IllegalArgumentException("target and template can not to be null or empty");
        }
        if (template.length() > target.length()){
            return -1;
        }
        char[] targetChars = target.toCharArray();
        char[] templateChars = template.toCharArray();
        int var1;
        // 外层最后一次开始位置在target.length() - template.length()
        for (int i = 0; i <= targetChars.length - templateChars.length; i++){
            var1 = i;
            for (int j = 0; j < templateChars.length; j++){
                // 只要一个不匹配 立即结束本次子循环
                if (targetChars[var1] != templateChars[j]){
                    break;
                }
                // 最后一位匹配 则返回var1
                if (j == templateChars.length - 1){
                    return i;
                }
                // 继续匹配下一位
                var1++;
            }
        }
        return -1;
    }

    /**
     * 问题的延申 判断 template 是 target 的子字符串问题
     * https://zhuanlan.zhihu.com/p/76348091
     * 寻找出模板字符串中 第n个位置字符的 最大的 前缀 = 后缀的值 标记为 maxLen 数组
     * 然后maxLen数组向右移动一位 即为第n+1个字符不匹配时 需要挪动的字符数量值 标记为 next 数组
     *
     * 例如 target=[aaacaaabcacadaaaab]
     *   template=[aaab]
     *     maxLen=[0120]
     *      next=[-1012]
     *
     * @param target
     * @param template
     * @return
     */
    public int kmpMatch(String target,String template){
        if (null == target || null == template || target.isEmpty() || template.isEmpty()){
            throw new IllegalArgumentException("target and template can not to be null or empty");
        }
        if (template.length() > target.length()){
            return -1;
        }
        int[] next = getNext(getMaxLen(template));
        char[] targetChars = target.toCharArray();
        char[] templateChars = template.toCharArray();
        int i=0,j=0;
        for (; i < targetChars.length && j < templateChars.length;i++,j++){
            if (targetChars[i] != templateChars[j]){
                j = next[j];
            }
        }
        if (j == templateChars.length){
            return i - j;
        }
        return -1;
    }


    /**
     * 计算字符串每个字符的最大前缀=后缀数
     * @param var 模板匹配字符串
     * @return
     */
    public int[] getMaxLen(String var){
        if (null == var || var.isEmpty()){
            throw new IllegalArgumentException("string value can not to be null or empty");
        }
        char[] varChars = var.toCharArray();
        int[] maxLen = new int[varChars.length];
        /**
         * tailStart 为子字符串的最长后缀在字符数组中的起始位置
         * 例如[abceabc]的最长后缀为[bceabc] tailStart = 1
         * */
        int tailStart,headStart;
        for (int i = 0; i < varChars.length; i++){
            // 默认最大相等前后缀数为当前字符串长度 - 1
            int maxCount = 0;
            // times为字符串寻找最大相同前后缀的比较次数
            for (int times = 0; times < i; times++){
                headStart = 0;
                tailStart = 1 + times;
                for (; tailStart <= i; headStart++,tailStart++){
                    if (varChars[tailStart] != varChars[headStart]){
                        break;
                    }
                }
                if (tailStart == i + 1){
                    maxCount = i - times;
                    break;
                }
            }
            maxLen[i] = maxCount;
        }
        return maxLen;
    }

    public int[] getNext(int[] maxLen){
        int last = maxLen.length - 1;
        while (last > 0){
            maxLen[last] = maxLen[--last];
        }
        maxLen[0] = -1;
        return maxLen;
    }

}
