package com.vinspier.LeetCode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: vinspeir
 * @date:2020/8/9 22:22
 */
public class RestoreIpAddresses_93 {


    // 输入: "25525511135"
    // 输出: ["255.255.11.135", "255.255.111.35"]

     public List<String> restoreIpAddresses(String s) {
         // 最短长度为4位 0.0.0.0 开始
         if (s.length() < 4){
             return new ArrayList<>();
         }
         return getIpIndex(s,1);
     }

     // s
     // 每一位不能以多个00开头
     // 例如 0.001.010.1
     public List<String> getIpIndex(String s,int times){
         List<String> validIps = new ArrayList<>();
         // 递归到第四位时 只需判断 该位是否满足0 - 255
         if (times == 4){
             if (Integer.valueOf(s) <= 255){
                 validIps.add(s);
             }
             return validIps;
         }else{
             // 第1 - 3 位判断
             // 开始截取位置
             int startIndex = 0;
             // 截取到的ip字符串
             String ipIndex;
             while (startIndex < s.length() - 4 + times){
                 ipIndex = s.substring(0,startIndex + 1);
                 if (Integer.valueOf(ipIndex) > 255){
                     break;
                 }
                 List<String> nextIpIndex = getIpIndex(s.substring(startIndex + 1),times + 1);
                 int currentIndex = startIndex;
                 if (nextIpIndex.size() > 0){
                     nextIpIndex.forEach(v -> {validIps.add(s.substring(0,currentIndex + 1) + "." + v);});
                 }
                 startIndex ++;
             }
         }
         return validIps;
     }

    public static void main(String[] args) {
        RestoreIpAddresses_93 restoreIpAddresses_93 = new RestoreIpAddresses_93();
        List<String> ips = restoreIpAddresses_93.restoreIpAddresses("25525511135");
        ips.forEach(System.out::println);
    }

}
