package 剑指offer.斐波那契额数列;

public class Test7 {
    public static int Fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int first = 0;
        int second = 1 ;
        for(int i = 0 ; i < n ; i++){
            int temp;
            temp = second+first;
            first = second;
            second = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(0));
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(7));

    }
}
