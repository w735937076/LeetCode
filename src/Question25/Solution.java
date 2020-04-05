package Question25;

import common.ListNode;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        int i = 1;
        while(i < 11){
            temp.next = new ListNode(i);
            temp = temp.next;
            i ++;
        }

        ListNode.printListNode(head.next,"翻转K个前：");
        ListNode.printListNode(reverseKGroup(head.next,4),"翻转K个后：");
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int length = 0;
        while(null != temp){
           temp = temp.next;
           length ++;
        }

        return null;
    }

//    public static ListNode reverseKGroup(ListNode head, int k) {
//        ListNode temp = new ListNode(-1);
//        ListNode prev = temp;
//        ListNode curr = head;
//        ListNode next;
//
//        temp.next = head;
//        int length = 0;
//        while(head != null) {
//            length++;
//            head = head.next;
//        }
//        head = temp.next;
//        for(int i = 0; i < length / k; i++) {
//            for(int j = 0; j < k - 1; j++) {
//                next = curr.next;
//                curr.next = next.next;
//                next.next = prev.next;
//                prev.next = next;
//            }
//            prev = curr;
//            curr = prev.next;
//        }
//        return temp.next;
//    }
}
