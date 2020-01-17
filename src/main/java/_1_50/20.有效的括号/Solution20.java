package _1_50.有效的括号;

import java.util.Stack;

public class Solution20 {
    /*
    题目：
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
    示例 1:
        输入: "()"
        输出: true
    示例 2:
        输入: "()[]{}"
        输出: true
    示例 3:
        输入: "(]"
        输出: false
    示例 4:
        输入: "([)]"
        输出: false
    示例 5:
        输入: "{[]}"
        输出: true
     */
    /*
    思路1：
        将括号的左半部分入栈，遍历到右半括号时pop进行匹配，匹配失败返回false，栈空pop抛出异常返回false。
        遍历结束栈中还有值说明还有未匹配的左半括号，返回false。最后验证都通过返回true。
     */
    public boolean isValid(String s) {
        if(s==null||s.length()==0)return true;
        byte[] bytes = s.getBytes();
        Stack<Byte> stack = new Stack();
        for(byte b:bytes){
            if(b=='('||b=='{'||b=='['){
                stack.push(b);
            }else {
                try{
                    switch (stack.pop()) {
                    case '(':
                        if (b != ')') return false;
                        break;
                    case '[':
                        if (b != ']') return false;
                        break;
                    case '{':
                        if (b != '}') return false;
                        break;
                    }
                }catch (Exception e){
                    return false;
                }
            }
        }
        if(stack.size()!=0)return false;
        return true;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
//        System.out.println(solution20.isValid("()"));
//        System.out.println(solution20.isValid("()[]{}"));
//        System.out.println(solution20.isValid("(]"));
        System.out.println(solution20.isValid("()["));
    }
}
