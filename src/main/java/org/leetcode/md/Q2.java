package org.leetcode.md;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 */

//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode o;
        int up = 0;
        int lsum = l1.val + l2.val + up;
        if(lsum > 9){
            up = 1;
            o = new ListNode(lsum - 10);
        } else {
            o = new ListNode(lsum);
        }
        ListNode tempo = o;
        ListNode temp1 = l1.next;
        ListNode temp2 = l2.next;
        while(temp1 != null || temp2 != null){
            int i1 = temp1 == null ? 0 : temp1.val;
            int i2 = temp2 == null ? 0 : temp2.val;
            int isum = i1 + i2 + up;
            if(isum > 9){
                up = 1;
                tempo.next = new ListNode(isum - 10);
            } else {
                up = 0;
                tempo.next = new ListNode(isum);
            }
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
            tempo = tempo.next;
        }
        if(up > 0){
            tempo.next = new ListNode(1);
        }
        return o;
    }

    public static void main(String[] args) {
        ListNode listNode = new Q2().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(7))));
        System.out.println(listNode);
    }

}
