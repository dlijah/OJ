package _1_50.两数相加;

public class Solution2 {
    /*
    LeetCode 2th
    题目：
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
     */
    /*
    思路1：
        首先分析不能是简单的整数相加，因为会超过int型，甚至是long型的范围。
        链表相加需要逐位相加，然后也要考虑进位。
        当一个链表结束之后将另一个链表余下部分拼接到结果链表上
        同时仍然要考虑进位问题，有可能链表结束了进位标志仍然为true，
        此时就需要在结果后面补上一个1。
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static boolean carrybit = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        carrybit=false;
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1!=null&&l2!=null){
            temp.next=new ListNode(add(l1.val,l2.val));
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            temp.next=l1;
            while(carrybit&&l1!=null){
                l1.val=add(l1.val,0);
                l1=l1.next;
            }
        }else if ((l2!=null)){
            temp.next=l2;
            while(carrybit&&l2!=null){
                l2.val=add(l2.val,0);
                l2=l2.next;
            }
        }
        if(carrybit){
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new ListNode(1);
        }
        return result.next;
    }
    public static int add(int a , int b){
        int result = a+b;
        if(carrybit){
            result++;
            carrybit=false;
        }
        if(result>9){
            result = result%10;
            carrybit=true;
        }
        return result;
    }

    /*
    思路2：
        将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0，比如 987 + 23 = 987 + 023 = 1010
        每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
        如果两个链表全部遍历完毕后，进位值为 1，则在新链表最前方添加节点 1
        小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，
        该指针的下一个节点指向真正的头结点head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode l1 = solution2.new ListNode(9);
        ListNode l3 = solution2.new ListNode(9);
        ListNode l4 = solution2.new ListNode(3);
        ListNode l2 = solution2.new ListNode(1);
        ListNode l5 = solution2.new ListNode(6);
        ListNode l6 = solution2.new ListNode(4);
        l1.next=l3;
//        l3.next=l4;
//        l2.next=l5;
//        l5.next=l6;
        System.out.println(solution2.addTwoNumbers(l1,l2));
    }
}
