package 剑指offer.不用加减乘除做加法;

public class Solution65 {
    /*
    题目：
        写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    示例:
        输入: a = 1, b = 1
        输出: 2
        提示：a, b 均可能是负数或 0,结果不会溢出 32 位整数
     */
    /*
    思路：
        位运算：异或：0^0=0，1^1=0，1^0=1,0^1=1，这个刚好符合加法，但是没有考虑进位
               只有在1^1=0的时候有进位，这里可以用与运算&，只有1&1=1，其余四种均为0，
           用&来确定进位，循环异或一次，然后加数相与，左移一位得到进位，如果进位不为0，继续循环
     */
    public static int add(int a, int b) {
        int res = a^b;
        int temp = (a&b)<<1;
        int temp1;
        while (temp!=0){
            temp1=res;
            res = temp1^temp;
            temp = (temp1&temp)<<1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(add(12,17));
    }
}
