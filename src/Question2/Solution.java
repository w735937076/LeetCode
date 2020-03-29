package Question2;

import common.ListNode;

/**
 *
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 * @Author: nick
 * @Date: 2020/3/3 21:27
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }

        //进位数
        int flag = 0;
        ListNode returnNode = new ListNode(0);
        ListNode tempNode = returnNode;

        //为了方便输出查看定义下标
        int inedx = 0;
        while(null != l1 || null != l2 || flag != 0){
            int value1 = 0;
            int value2 = 0;

            if(null != l1){
                value1 = l1.val;
                l1 = l1.next;
            }else{
                value1 = 0;
            }

            if(null != l2){
                value2 = l2.val;
                l2 = l2.next;
            }else{
                value2 = 0;
            }

            if((value1+value2+flag) / 10 > 0 ){
                tempNode.next = new ListNode((value1+value2+flag) % 10);
            }else{
                tempNode.next = new ListNode(value1+value2+flag);
            }

            flag = (value1+value2+flag) / 10;

            tempNode = tempNode.next;

            System.out.println(inedx++ + ":"+tempNode.val);

        }
        return returnNode.next ;
    }
}
