package 剑指offer.求股票的最大利润;

public class Solution63 {
    /*
    题目：
        假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
    示例:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
             注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    示例 2:
        输入: [7,6,4,3,1]
        输出: 0
        解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    限制：0 <= 数组长度 <= 20000
     */
    /*
    思路：
        从后往前找到该位置后面最大的元素并记录下来，也就是这天以后的最高价格，
        用这个价格减去当日的价格可以算出当日能获得的最大收益，最终得到整体的最高收益
     */
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<2)return 0;
        int result=0;
        int[] maxprizeaafter = new int[prices.length];
        maxprizeaafter[maxprizeaafter.length-1]=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            maxprizeaafter[i]=Math.max(maxprizeaafter[i+1],prices[i+1]);
        }
        for(int i=prices.length-2;i>=0;i--){
            if(maxprizeaafter[i]-prices[i]>result){
                result = maxprizeaafter[i]-prices[i];
            }
        }return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
