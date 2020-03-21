package 华为社招笔试题;

import java.util.Scanner;

public class Main {
    /*
    题目：
        有3*n（n为偶数）的格子，用2*1的矩形填满格子有多少种填法
     */
    /*
    思路：
        动态规划思想
        f(n) = 3*f(n-1) + 2*(f(n-2)+f(n-3))
        3*2 很容易知道解法为3种，
        3*4 可以理解为两个3*2，如果两个3*2之间没有跨交界的矩形，此时解法为3*3=9种
            如果可以跨界的话有两种解法，即跨第一行和第二行或者跨第二行和第三行，总共为9+2=11种
        3*6 可以理解为3*4+3*2 如果没有跨交界的矩形，此时解法为11*3=33种
            如果可以跨界的话有两种跨法，右面3*2每种只有一种情况对应，左面3*4可以分成两种情况，
            一种是3*4可以分成两个3*2，两个3*2之间不跨，此时有三种情况，
            另一种是两个3*2之间也跨，此时有一种情况。
            所以跨界是总共有2*（3+1）=8种解法。总计33+8=41种
        3*8 依次类推，3*8的解法数为3+41+2*（11+4） = 153种
        得到了递推公式
     */
    public static int fib(int n){
        if(n==0)return 0;
        if(n==2)return 3;
        int a=3;
        int b=1;
        for(int i=1;i<n/2;i++){
            int temp=a;
            a=a*3+2*b;
            b=temp+b;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fib(sc.nextInt()));
    }
}
