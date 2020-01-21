package 华为社招笔试题;

import java.util.Scanner;

public class Main {
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
