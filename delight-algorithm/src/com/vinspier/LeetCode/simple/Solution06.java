package com.vinspier.LeetCode.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 对字符串进行 分行 Z形变换
 */
public class Solution06 {

    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        System.out.println(solution06.convert("PAYPALISHIRING",4));
        System.out.println(solution06.convertByPosition("PAYPALISHIRING",4));
    }

    public String convert(String s, int numRows) {
        // 一行 直接返回源字符串
        if (numRows == 1){
            return s;
        }
        // 计算最大行数
        int maxRow = Math.min(numRows,s.length());
        // 每一行用stringBuilder提前记录
        List<StringBuilder> rowBuilder = new ArrayList<>(maxRow);
        for (int i = 0; i < maxRow; i++){
            rowBuilder.add(new StringBuilder());
        }
        // 当前行
        int currentRow = 0;
        // 向上还是向下跨行 向下为true 起始向下
        boolean downOrUp = false;
        for (char c : s.toCharArray()){
            rowBuilder.get(currentRow).append(c);
            // 第一行 或 最后一行 需要变换方向
            if (currentRow == 0 || currentRow == maxRow - 1){
                downOrUp = !downOrUp;
            }
            currentRow += downOrUp ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        rowBuilder.forEach(item -> result.append(item.toString()));
        return result.toString();
    }

    /**
     * 按规律位置取值
     * 1、一次循环 需要走 times = numRows * 2 - 2次
     * 2、第一行和最后一行只需要按times间隔获取即可
     * 3、其他行 每次循环都会有二个字符 并且从上之下 times差距为 times - 2
     */
    public String convertByPosition(String s, int numRows) {
        // 一行 直接返回源字符串
        if (numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        StringBuilder result = new StringBuilder();
        // 计算一次循环需要的步数
        int times = 2 * numRows - 2;
        int secondTimes = times;
        for (int i = 0; i < numRows; i++){
            int start = i;
            // 非第一行和最后一行 间距递归-2
            if (i == 0 || i == numRows - 1){
                while (start < len){
                    result.append(chars[start]);
                    start += times;
                }
            }else {
                secondTimes = secondTimes - 2;
                while (start < len){
                    result.append(chars[start]);
                    if (start + secondTimes < len){
                        result.append(chars[start + secondTimes]);
                    }
                    start += times;
                }
            }
        }
        return result.toString();
    }
}
