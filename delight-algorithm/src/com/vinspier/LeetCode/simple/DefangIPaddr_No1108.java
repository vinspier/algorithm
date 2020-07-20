package com.vinspier.LeetCode.simple;

/**
 * IP 地址无效化
 * 其实就是用 "[.]" 代替了每个 "."
 *
 * 考察 string的操作
 * */
public class DefangIPaddr_No1108 {

    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        int index = address.indexOf(".");
        while ( index > 0){
            sb.append(address.substring(0,index)).append("[.]");
            address = address.substring(index + 1);
            index = address.indexOf(".");
        }
        sb.append(address);
        return sb.toString();
    }

    public static String defangIPaddr1(String address) {
        return address.replaceAll(".","[.]");
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("192.168.1.12"));
    }

}
