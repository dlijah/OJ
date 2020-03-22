package 剑指offer.矩形覆盖;

public class Test10 {
    /*
    题目：
        我们可以用2 X 1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2 X 1的小矩形无重叠地覆盖一个2 X n的大矩形，总共有多少种方法？
     */
    /*
    思路1：
        斐波那契数列： 我们可以以2 X 8的矩形为例。
        先把2X8的覆盖方法记为f(8)，用1X2的小矩形去覆盖时，有两种选择：横着放或者竖着放。
        当竖着放时，右边还剩下2X7的区域。很明显这种情况下覆盖方法为f(7)。
        当横着放时，1X2的矩形放在左上角，其下方区域只能也横着放一个矩形，此时右边区域值剩下2X6的区域，这种情况下覆盖方法为f(6)。
        所以可以得到：f(8)=f(7)+f(6)，
     */
    public static int RectCover(int target) {
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
        System.out.println(RectCover(3));
    }
}
