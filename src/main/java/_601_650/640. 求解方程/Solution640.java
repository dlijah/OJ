package _601_650.求解方程;

public class Solution640 {
    /*
    LeetCode 640th
    题目：
        求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
        如果方程没有解，请返回“No solution”。
        如果方程有无限解，则返回“Infinite solutions”。
        如果方程中只有一个解，要保证返回值 x 是一个整数。
    示例 1：
        输入: "x+5-3+x=6+x-2"
        输出: "x=2"
    示例 2:
        输入: "x=x"
        输出: "Infinite solutions"
    示例 3:
        输入: "2x=x"
        输出: "x=0"
    示例 4:
        输入: "2x+3x-6x=x+2"
        输出: "x=-1"
    示例 5:
        输入: "x=x+2"
        输出: "No solution"
     */
    /*
    思路1：
        左边右边分别解析方程，得到ax+b形式的a和b
        需要注意的是x的系数可能是空代表1，‘-’代表-1，其余情况为数字
        多项式按照-和+号进行分解，另外还需要处理结尾的多项式
     */
    public static String solveEquation(String equation) {
        String[] subs = equation.split("=");
        if(subs.length!=2){
            return null;
        }
        String left = subs[0];
        String right = subs[1];
        int []a,b;
        a=getparam(left);
        b=getparam(right);
        if(a[1]==b[1]){
            if(a[0]==b[0])return "Infinite solutions";
            else return "No solution";
        }
        String result = "x="+(b[0]-a[0])/(a[1]-b[1]);
        return result;
    }
    public static int[] getparam(String s){
        int a=0,b=0,last=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+'){
                if(s.charAt(i-1)=='x'){
                    int n ;
                    if(last==i-1) n=1;
                    else if(s.substring(last,i-1).equals("-")) n=-1;
                    else n=Integer.parseInt(s.substring(last,i-1));
                    b+=n;
                    last= i + 1;
                }else {
                    int n;
                    if(s.substring(last,i).equals("-")) n=-1;
                    else n = Integer.parseInt(s.substring(last,i));
                    a += n;
                    last= i + 1;
                }

            }else if(s.charAt(i)=='-'){
                if(s.charAt(i-1)=='x'){
                    int n ;
                    if(last==i-1) n=1;
                    else if(s.substring(last,i-1).equals("-")) n=-1;
                    else n=Integer.parseInt(s.substring(last,i-1));
                    b+=n;
                    last= i;
                }else {
                    int n;
                    if(s.substring(last,i).equals("-")) n=-1;
                    else n = Integer.parseInt(s.substring(last,i));
                    a += n;
                    last= i;
                }
            }
        }
        if(s.endsWith("x")){
            int n ;
            if(last==s.length()-1){ n=1;}
            else if(s.substring(last,s.length()-1).equals("-")) {n=-1;}
            else {n=Integer.parseInt(s.substring(last,s.length()-1));}
            b+=n;
        }else {
            int n;
            if(s.substring(last,s.length()).equals("-")) n=-1;
            else n = Integer.parseInt(s.substring(last,s.length()));
            a += n;
        }
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        String equation = "2x=x";
        System.out.println(solveEquation(equation));
    }
}
