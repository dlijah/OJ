package 剑指offer.变态跳台阶;

public class Test9 {
    /*
    题目：
        一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    /*
    思路1：
        每次的跳法总数都等于前n次之和+1，
        1阶：1
        2阶：1+1=2
        3阶：1+2+1=4
        4阶：1+2+4+1=8
        得到结果为2^n
     */
    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(2));
    }
}
