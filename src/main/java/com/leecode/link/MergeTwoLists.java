package com.leecode.link;

/**
 * @Author zhongzaitao
 * @Date 2019-10-31 20:19
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode listNode1 , ListNode listNode2){
        if (listNode1 == null ){
            return listNode2;
        }else if (listNode2 == null){
            return listNode1;
        }
        else if (listNode1.val < listNode2.val){
            listNode1.next = mergeTwoLists(listNode1.next , listNode2);
            return listNode1;
        }else {
            listNode2.next = mergeTwoLists(listNode1 , listNode2.next);
            return listNode2;
        }
    }
}



