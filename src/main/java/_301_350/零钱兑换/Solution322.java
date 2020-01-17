package _301_350.零钱兑换;

import test.Test;

import java.util.Arrays;

public class Solution322 {


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
