package 整数反转;


public class Solution7 {
    /*
    leetcode 7th
    题目：
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        示例 1:
            输入: 123
            输出: 321
        示例 2:
            输入: -123
            输出: -321
        示例 3:
            输入: 120
            输出: 21
        注意:
        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    /*
    思路1：
        将整数转换成字符串处理，用一个布尔值表示是否是负数，
        如果是0时字符串截取会变成空，
        如果转化之后再反转超过int范围，都在parseInt时抛异常，catch并且返回0即可。
     */
    public int reverse(int x) {
        String a = ""+x;
        String res = "";
        int resint = 0;
        boolean negative = false;
        if(a.startsWith("-")) {
            negative = true;
            a=a.substring(1,a.length());
        }
        while (a.endsWith("0") ){
            a=a.substring(0,a.length()-1);
        }
        for(int i = a.length()-1 ; i>=0 ; i--){
            res+=a.charAt(i);
        }
        try {
            resint = Integer.parseInt(res);
        }catch (Exception e){
            return 0;
        }
        if(negative) resint = -resint;
        return resint;
    }

    /*
    思路2：
        通过循环将数字x的每一位拆开，在计算新值时每一步都判断是否溢出。
        溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
        从ans * 10 + pop > MAX_VALUE这个溢出条件来看
        当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
        当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
        从ans * 10 + pop < MIN_VALUE这个溢出条件来看
        当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
        当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
     */
    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


    public static void main(String[] args) {
        整数反转.Solution7 solution7 = new 整数反转.Solution7();
        System.out.println(solution7.reverse2(-1230));
    }
}
