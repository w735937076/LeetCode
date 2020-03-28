package Question23;

import common.ListNode;

/**
 * @Author: WZL
 * @Date: 2020/3/13 16:08
 */
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t3 = l3;
        int i = 2;

        while(i < 4){
           t1.next = new ListNode(i);
           t1 = t1.next;

           t2.next = new ListNode(i+2);
           t2 = t2.next;

           t3.next = new ListNode(i+i);
           t3 = t3.next;

           i++;
        }

        ListNode[] lists = {l1,l2,l3};

//        printListNode(mergeKLists(lists),"循环合并：");
        printListNode(mergeKLists2(lists),"分治法：");
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }

        ListNode result = new ListNode(-1);
        for(int i = 1 ; i < lists.length ; i++){
            lists[i] = Question21.Solution.mergeTwoLists(lists[i-1],lists[i]);
            if( i == lists.length - 1){
                result.next = lists[i];
            }
        }

        return result.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return Question21.Solution.mergeTwoLists(l1,l2);
    }

    public static void printListNode(ListNode listNode,String msg){
        while(listNode != null){
            System.out.println(msg+"=="+listNode.val);
            listNode = listNode.next;
        }
    }
}
