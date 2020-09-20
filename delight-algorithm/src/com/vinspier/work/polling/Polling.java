package com.vinspier.work.polling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 大鱼网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2020/8/5 18:57 <br>
 * @Author: <a href="fanxb@haibaobaoxian.cn">fxb</a>
 */
public class Polling {

    // 轮询目标 id做标识
    private static List<Integer> idList = new ArrayList<>();
    // 轮询目标对应的实际存储对象
    private static List<Node> nodes = new ArrayList<>();

    // 上一次 目标指针缓存
    private static Integer lastPointer = 12;

    static {
        init();
    }

    private static void init(){
        for (int i = 0; i < 20; i++){
            idList.add(i);
            if (i % 2 == 0 || i % 3 == 0){
                nodes.add(new Node(i,1));
            }else {
                nodes.add(new Node(i,0));
            }
        }
    }


    public static void main(String[] args) {
        testSubList();
       // getIds();

//        System.out.println(idList.toString());
//        System.out.println(nodes.toString());
//        System.out.println("---------------------------------------");
//        new Thread(() -> {
//            // 模拟修改 轮询的存储对象
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            nodes.get(14).setWork(0);
//            nodes.get(2).setWork(0);
//
//        }).start();
//        while (true){
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            testPoll();
//        }

    }

    public static void testPoll(){
        // 寻找上一次指针在轮询目标中的定位
        // int lastIndex = idList.indexOf(lastPointer);
         int lastIndex = getIds().indexOf(lastPointer);
        int fetchIndex = lastIndex;
        // 从 lastIndex - size 区间 寻找可用目标
        while (++fetchIndex < idList.size()){
            // 寻找到可用目标 退出
            if (nodes.get(fetchIndex).getWork() == 1){
                System.out.println("[lastIndex = " + lastIndex + "] [fetchIndex = " + fetchIndex + "] [node=" + nodes.get(fetchIndex).toString() + "]");
                // 当前获取到目标对象的id表示 存入缓存中
                lastPointer = nodes.get(fetchIndex).getId();
                return;
            }
        }
        // 从 0 - lastIndex 区间 寻找可用目标
        if (fetchIndex >= nodes.size()){
            fetchIndex = -1;
        }
        while (++fetchIndex <= lastIndex){
            if (nodes.get(fetchIndex).getWork() == 1){
                System.out.println("[lastIndex = " + lastIndex + "] [fetchIndex = " + fetchIndex + "] [node=" + nodes.get(fetchIndex).toString() + "]");
                // 当前获取到目标对象的id表示 存入缓存中
                lastPointer = nodes.get(fetchIndex).getId();
                return;
            }
        }

    }

    public static void testSubList(){
        // System.out.println(nodes.subList(18,19));

        System.out.println(nodes.subList(0,12).getClass());

         System.out.println(nodes.subList(20,20));

        System.out.println(nodes.contains(null));
    }

    // stream操作 获取数组ids
    public static List<Integer> getIds(){
        List<Integer> idList =  nodes.stream().map(Node::getId).collect(Collectors.toList());
       // System.out.println(idList.toString());
        return idList;
    }

}
