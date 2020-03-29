package Question24;

import common.ListNode;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {
    public static void main(String[] args) {
      ListNode head = new ListNode(-1);
      ListNode temp = head;
      for(int i = 1; i < 7; i++){
         temp.next = new ListNode(i);
         temp = temp.next;
      }

      ListNode.printListNode(head.next,"交换前结果：");
      ListNode.printListNode(swapPairs(head.next),"交换后结果：");
    }
    public static ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

}
