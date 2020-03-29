package common;

/**
 * @Author: WZL
 * @Date: 2020/3/26 10:06
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public static void printListNode(ListNode listNode,String msg){
        while(listNode != null){
            System.out.println(msg+"=="+listNode.val);
            listNode = listNode.next;
        }
    }
}
