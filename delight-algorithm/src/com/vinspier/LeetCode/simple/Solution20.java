package com.vinspier.LeetCode.simple;

import java.util.Stack;

/**
 * 对称的括号
 * */
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("[]{}()"));
        System.out.println(solution20.isValid("[{]}()"));
        System.out.println(solution20.isValid("){"));
    }

    /**
     * 思路一
     * 使用栈先进后出 遇到右括号 弹出左括号
     * 最终判断栈是否为空
     * */
    public boolean isValid(String s) {
        if (null == s || (s.length() & 1) == 1){
            return false;
        }
        char[] chars = s.toCharArray();
        // 存储临时左括号
        Stack<Character> characters = new Stack<>();
        for (char c : chars){
            // 左侧 入栈
            if (c == '[' || c == '(' || c == '{'){
                characters.push(c);
                continue;
            }
            // 右侧 出栈
            if (characters.isEmpty()){
                return false;
            }
            char left = characters.pop();
            if (!isSymmetry(left,c)){
                return false;
            }
        }
        return characters.isEmpty();
    }

    /**
     * 思路二 与栈相同 使用链表支持的 可添加/移除首个元素特性
     *
     * 思路三 字符串操作 替换 '{}''[]''()'为空串 最后判断是否为空串
     * */
    public boolean isValidByLinkedList(String s) {
        return false;
    }


    public boolean isSymmetry(char left,char right){
        switch (right){
            case '}': return left == '{';
            case ']': return left == '[';
            case ')': return left == '(';
            default: return false;
        }
    }

}
