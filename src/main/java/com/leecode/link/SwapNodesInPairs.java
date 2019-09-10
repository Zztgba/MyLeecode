package com.leecode.link;

/**
 * 1-2-3-4-5
 * 2-1-4-3-5
 * @Author zhongzaitao
 * @Date 2019-9-7 15:23
 */
public class SwapNodesInPairs {
    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode souletion(ListNode head) {
        if (head==null || head.next == null)
            return head;

        ListNode next = head.next;
        head.next = souletion(next.next);
        next.next = head;

        return next;
    }

    public static void main(String[] args) {
        String a= "0123456789";
        System.out.println(a.substring(0,1));

        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode re1 = souletion(l);
        System.out.println(re1);
    }
}
