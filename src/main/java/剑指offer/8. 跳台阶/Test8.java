package 剑指offer.跳台阶;

public class Test8 {
    /*
    题目：
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    /*
    思路1：
        菲波那切数列：跳n阶台阶跳法等于跳n-1阶和n-2阶台阶跳法数之和
     */
    public static int JumpFloor(int target) {
        int a=1;
        int b=1;
        if(target==0)return 0;
        if(target==1)return 1;
        for(int i=2;i<=target;i++){
            int temp = b;
            b=a+b;
            a=temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(5));
    }
}
