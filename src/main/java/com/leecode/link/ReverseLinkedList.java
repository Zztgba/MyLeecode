package com.leecode.link;

import java.util.Stack;

/**
 * 1-2-3-4-5
 * 5-4-3-2-1
 * @Author zhongzaitao
 * @Date 2019-9-5 20:31
 */
public class ReverseLinkedList {

    /**
     * 迭代
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;

    }


    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        //1.第一个条件是判断递归开始，传入的参数的合法性。第二个是递归的终止条件
        if(head == null || head.next ==null){
            return head;
        }
        //2.开始进行递归
        ListNode newHead = reverseList2(head.next);
        //3.尾部4-5-null中，head=4,head.next=4-5 head.next.next=4-5-null,也就是5的后继指向4
        head.next.next = head;
        //4.断开之前4-5之间的连接，将4的后继指向null
        head.next = null;
        //5.返回已经反转的链表
        return newHead;

    }



    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode re1 = reverseList1(l);
        ListNode re2 = reverseList2(l);
        System.out.println(re1);
        System.out.println(re2);
    }

}



