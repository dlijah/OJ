package _1_40.删除链表倒数第N个节点;

public class Solution19 {
    /*
    题目：
        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    示例：
        给定一个链表: 1->2->3->4->5, 和 n = 2.
        当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：
        给定的 n 保证是有效的。
    进阶：
        你能尝试使用一趟扫描实现吗？
     */
    //辅助链表节点类
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public String print(){
          String result =  val+"";
          if(next!=null){
              result=result+"->"+next.print();
          }
          return result;
      }
    }
    /*
    思路1：
        双指针：一个指针领先另一个指针n位，两个指针同时向后移动，当后面的指针到达尾部时，前面的指针指向需要删除的节点的位置。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = head;
        ListNode a = head;
        ListNode b = head;
        for(int i = 0 ; i < n ; i++){
            b=b.next;
        }
        if(b==null){
            return result.next;
        }
        while(b.next!=null){
            a=a.next;
            b=b.next;
        }
        a.next = a.next.next;
        return result;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.removeNthFromEnd(l1,1).print());
    }
}
