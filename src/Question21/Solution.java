package Question21;

import common.ListNode;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        printListNode(l1,"l1");
        printListNode(l2,"l2");
        l1 = mergeTwoLists(l1,l2);
        printListNode(l1,"result");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while(null != l1 || null != l2){
            if(null == l2 || (null != l1 && l1.val <= l2.val)){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else if(null == l1 || (null != l2 && l1.val > l2.val)){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        return result.next;
    }

    public static void printListNode(ListNode listNode,String msg){
        while(listNode != null){
            System.out.println(msg+"=="+listNode.val);
            listNode = listNode.next;
        }
    }
}
