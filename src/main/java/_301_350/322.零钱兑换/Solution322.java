package _301_350.零钱兑换;

import test.Test;

import java.util.Arrays;

public class Solution322 {
    /*
    题目：
        给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
    示例 1:
        输入: coins = [1, 2, 5], amount = 11
        输出: 3
        解释: 11 = 5 + 5 + 1
    示例 2:
        输入: coins = [2], amount = 3
        输出: -1
    说明:
    你可以认为每种硬币的数量是无限的。
     */

    /*
    思路1：
        采用动态规划思想，以coins = [1, 2, 5], amount = 11举例，
        11的最少硬币组成数=min（10,9,7），也就是f(11)=min（f(11-1)，f(11-2),f(11-5)）
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] counts = new int[amount+1];
        if(amount==0)return -1;
        for(int i = 0;i<coins.length;i++){
            if(coins[i]>=counts.length)break;
            counts[coins[i]]=1;
        }
        for(int i=0;i<counts.length;i++){
            for(int j= 0;j<coins.length;j++){
                int n=i-coins[j];
                if(n>=0&&counts[n]>0){
                    if(counts[i]!=0){
                        counts[i]=Math.min(counts[n]+1,counts[i]);
                    }else {
                        counts[i]=counts[n]+1;
                    }
                }
            }
        }
        int result = counts[amount];
        if(result==0){
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
//        int[] ints = new int[]{186,419,83,408};
//        System.out.println(test.coinChange(ints , 6249));
        int[] ints = new int[]{474,83,404,3};
        System.out.println(test.coinChange(ints , 264));

    }
}
