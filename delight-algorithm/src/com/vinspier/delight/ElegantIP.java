package com.vinspier.delight;

import java.util.*;

/**
 *
 * 趣味算法Q40
 * 优雅的ip地址
 * 求用二进制数表示上述形式的 IP 地址时，能使二进制数左右对称的 IP 地址的
 * 个数（用二进制数表示时不省略 0，用完整的 32 位数表示）。
 * */
public class ElegantIP {

    public static final Map<Integer,String> ZERO_DIFF = new HashMap<>();
    public static List<String> array = new ArrayList<>();

    static {
        ZERO_DIFF.put(0,"");
        ZERO_DIFF.put(1,"0");
        ZERO_DIFF.put(2,"00");
        ZERO_DIFF.put(3,"000");
        ZERO_DIFF.put(4,"0000");
        ZERO_DIFF.put(5,"00000");
        ZERO_DIFF.put(6,"000000");
        ZERO_DIFF.put(7,"0000000");
    }

    // 思路
    // 第一步 对称 14位置 23位置 两两对称；
    // 第二步 求出 一个字节对应的比特数对称 转为十进制
    // 第三步 这一组对称数 十进制数 并且0-9都只用到一次
    // 第四步 对这些十进制数 分组 进行排列组合
    public static void main(String[] args) {
        for (int i = 1; i < 256; i++){
            getSymmetry(i);
        }
        System.out.println(getResult(array));
    }

    public static List<String> getSymmetry(Integer i){
        int len = 8 - Integer.toBinaryString(i).length();
        StringBuilder originBinary = new StringBuilder();
        originBinary.append(ZERO_DIFF.get(len)).append(Integer.toBinaryString(i));
        originBinary.reverse();
        byte[] reverseBytes = getBytes(originBinary.toString());
        Integer reverse = getSymmetryFromBytes(reverseBytes);
        if (unique(i.toString(),reverse.toString(),3)){
            // System.out.println(i.toString() + "." + reverse.toString());
            array.add(i.toString() + "." + reverse.toString());
        }
        return array;
    }

    public static boolean unique(String var1 ,String var2,int size){
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < var1.length(); i++){
            stringSet.add(var1.substring(i , i + 1));
        }
        for (int j = 0; j < var2.length(); j++){
            stringSet.add(var2.substring( j, j + 1));
        }
        if (stringSet.size() <= var1.length() + var2.length() && stringSet.size() > size){
            return true;
        }
        return false;
    }

    public static byte[] getBytes(String var){
        byte[] varBytes = new byte[var.length()];
        for (int i = 0; i < var.length(); i++){
            varBytes[i] = Byte.valueOf(var.substring(i,i + 1));
        }
        return varBytes;
    }

    public static int getSymmetryFromBytes(byte[] bytes){
       int sum = 0;
       sum += bytes[7] ;
       sum += bytes[6] << 1;
       sum += bytes[5] << 2;
       sum += bytes[4] << 3;
       sum += bytes[3] << 4;
       sum += bytes[2] << 5;
       sum += bytes[1] << 6;
       sum += bytes[0] << 7;
       return sum;
    }

    public static String getResult(List<String> array){
        if (array.size() > 0){
            for(int i = 0; i < array.size() - 1; i++){
                for(int j = i + 1; j < array.size();j++){
                    if (array.get(i).length() + array.get(j).length() > 10){
                        if (unique(array.get(i),array.get(j),10)){
                            System.out.println(array.get(i) + "." + array.get(j));
                            return array.get(i) + "." + array.get(j);
                        }
                    }
                }
            }
        }
        return "";
    }
}
