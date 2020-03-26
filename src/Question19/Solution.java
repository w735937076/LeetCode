package Question19;

import common.ListNode;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode temp = head;
        for(int i = 2 ; i < 6 ; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        head = removeNthFromEnd(head,2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length ++;
        }

        temp = pre;
        length = length - n;
        if(length < 0){
            return null;
        }

        while(length > 0){
           temp = temp.next;
           length --;
        }
        temp.next = temp.next.next;

        return pre.next;
    }
}


