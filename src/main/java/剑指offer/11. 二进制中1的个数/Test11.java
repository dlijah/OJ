package 剑指offer.二进制中1的个数;

public class Test11 {
    /*
    题目：
          输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     */
    /*
    思路1：
        通过API可以轻松实现
     */
    public int NumberOf1(int n) {
        String x= Integer.toBinaryString(n);
        int count = 0;
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)=='1')count++;
        }
        return count;
    }
    /*
    思路2：
        依次判断每一位。判断的方法是先与1相与，
        为1则说明该位为1，为0说明该位为0，
        然后将1左移，再判断倒数第二位，依次循环32次。
        （注意这里使用1左移，而不要让该数右移，右移可能会因符号位的问题而导致死循环，一般情况下能用左移尽量不用右移）。
    */
    public int NumberOf11(int n){
        int flag = 1;
        int count = 0;
        while (flag != 0){
            if((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

   /*
   思路3：
        n与n-1相与，直到相与结果变为0。
        如果n的最右一位为1的话，n-1除了最右位变为0其他位同n相同，
        相与去掉最右边的1；如果n的最右边的1不在最右位，那么n-1相对于n而言，n-1的该位变为0，
        而这个位右边的全变为1；因此n不论是最右的1位在哪，它和n-1的&运算将会让最右的1变为0，
        而这个最右1位的左边不变。即做一次&，n的1的位数减1，这时n的值也变了，因此一直&到n变为0，我们即可得出n的1的个数。
     */
   public static int NumberOf12(int n) {
       int count=0;
       while(n!=0){
           n=n&(n-1); //相与一次，去掉一个1
           count++;
       }
       return count;
   }

    public static void main(String[] args) {
        System.out.println(NumberOf12(10));
    }
}
