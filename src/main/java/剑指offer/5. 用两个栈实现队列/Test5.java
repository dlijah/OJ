package 剑指offer.用两个栈实现队列;

import java.util.Stack;

public class Test5 {
    /*
    题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
     */

    /*
    思路：
        需要入队时向栈1中push，需要出队时从栈2中pop，如果栈2是空的，将栈1所有元素pop，并push进栈2，实现先进先出。
        详细思路见图片。
     */
    public static class MList<T> {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty()) {  //为空时将栈1的元素“倒进去”
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
