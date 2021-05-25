package com.vinspier.LeetCode.list;

/**
 * 合并 二个有序列表(升序)
 * */
public class Solution21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode tail1 = l1;
        tail1.next = new ListNode(2);
        tail1 = tail1.next;
        tail1.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode tail2 = l2;
        tail2.next = new ListNode(3);
        tail2 = tail2.next;
        tail2.next = new ListNode(4);

        Solution21 solution21 = new Solution21();
        solution21.mergeTwoLists(l1,l2);
    }


    /**
     * 思路一
     * 递归思想 比较两个链表的头部 较小的一个指向较大的一个
     * 并且较小的递归向下寻找
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 思路二
     * 迭代方式 逐个迭代两个链表的头部 找到小的节点后 对应链表后移
     * 时间复杂度O(n + m)
     * 并且较小的递归向下寻找
     * */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (null != l1 && null != l2){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        // l1 l2 最多会有一个 还未合并完
        head.next = (l1 == null) ? l2 : l1;
        return result.next;
    }

    /**
     * 节点
     * */
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
