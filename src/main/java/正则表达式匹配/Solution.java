package 正则表达式匹配;

public class Solution {
    /*
    LeetCode 10th
    题目：
        给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
        '.' 匹配任意单个字符
        '*' 匹配零个或多个前面的那一个元素
        所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
        说明:
            s 可能为空，且只包含从 a-z 的小写字母。
            p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
        示例 1:
            输入:
            s = "aa"
            p = "a"
            输出: false
            解释: "a" 无法匹配 "aa" 整个字符串。
        示例 2:
            输入:
            s = "aa"
            p = "a*"
            输出: true
            解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
        示例 3:
            输入:
            s = "ab"
            p = ".*"
            输出: true
            解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
        示例 4:
            输入:
            s = "aab"
            p = "c*a*b"
            输出: true
            解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
        示例 5:
            输入:
            s = "mississippi"
            p = "mis*is*p*."
            输出: false
     */
    /*
    思路1：
        首先字符串匹配有两个特殊符号：'.'和'*'，’.'匹配任意单个字符，'*'匹配任意和改符号之前一位的字符（包含0个）
        首先设置两个指针i和j用来指向匹配的两个字符串，初始值为0，
        然后设置一个temp暂存字符和boolean的是否暂存状态位，temp用来暂存*符号前一位的字符，istemp表示是否开始暂存匹配状态
        退出暂存匹配状态时j指针向前进2位，
        匹配成功条件除了字符相同之外加上匹配字符为'.'也通过。匹配未通过返回false。
        匹配通过后i++,j++，
        如果p遍历之后如果s没遍历完全返回false，否则返回true。
     */
    public boolean isMatch(String s, String p) {
        char temp = '\n' ;
        char temp1 = '\n';
        boolean istemp = false;
        int i=0,j=0;
        while (i<s.length()&&j<p.length()){
            if(j+1<p.length()&&p.charAt(j+1)=='*'){
                istemp = true;
                temp = p.charAt(j);
            }
            if(istemp){
                if (temp=='.'|| s.charAt(i)==temp){
                    i++;
                    temp1=temp;
                }else {
                    j+=2;
                    istemp = false;
                    while (j<p.length()&&p.charAt(j)==temp){
                        j++;
                    }
                }
            }else if(p.charAt(j)=='.'|| p.charAt(j)==s.charAt(i))  {
                i++; j++;
            }
        }
        if(istemp){
            j+=2;
            while (j<p.length()&&p.charAt(j)==temp){
                j++;
            }
        }
        if(i<s.length()||j<p.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("mississippi","mis*sis*ip*."));
    }
}
