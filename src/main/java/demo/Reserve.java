package demo;

class Reserve {

    static class Node {
        Node next;
        int value;
        Node(){}
    }

    public static void reserve(Node node){
        if (node == null || node.next == null) {
            return ;
        }
        Node p = node;
        Node index = null;
        while (p != null){                 //一直迭代到链尾
            Node temp = p.next;          //暂存p下一个地址，防止变化指针指向后找不到后续的数
            p.next = index;               //p.next指向前一个空间
            index = p;                     //新链表的头移动到p，扩长一步链表
            p = temp;                   //p指向原始链表p指向的下一个空间
        }
    }

    public static void main(String[] args) {
        Node node5 = new Node();
        node5.value=5;
        Node node4 = new Node();
        node4.value=4;
        Node node3 = new Node();
        node3.value=3;
        Node node2 = new Node();
        node2.value=2;
        Node node1 = new Node();
        node1.value=1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next = node5;
        node5.next=null;
        reserve(node1);
        return;
    }
}
