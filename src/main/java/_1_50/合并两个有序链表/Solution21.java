package _1_50.合并两个有序链表;

public class Solution21 {
    /*
    題目：
        将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
    示例：
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        boolean b = l1.val<l2.val;
        ListNode result = null;
        if(b){
            result = new ListNode(l1.val);
            l1=l1.next;
        }else {
            result = new ListNode(l1.val);
            l2 = l2.next;
        }
        ListNode next = result;
        while (l1.next!=null&&l2.next!=null){

        }


        return null;
    }

}
