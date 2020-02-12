package _1_50.下一个排列;

import java.util.Arrays;

public class Solution31 {
    /*
    LeetCode 31st
    题目：
        实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
        必须原地修改，只允许使用额外常数空间。
        以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
        1,2,3 → 1,3,2
        3,2,1 → 1,2,3
        1,1,5 → 1,5,1
     */
    /*
    思路1：
        找到交换的规律：比如32541，首先从后往前找到第一个比后面的数小的数，这里是2，
        然后从2往后找第一个比这个数小的数，这里找到了1。
        然后将2和1之前的4进行交换得到了34521
        再将4后面的数进行逆序就可以得到结果：34125了。
     */
    public static void nextPermutation(int[] nums) {
        int i1=-1;
        int i2=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i+1]>nums[i]){
                i1=i;break;
            }
        }
        if(i1>=0){
            for(int i=i1;i<=nums.length-2;i++){
                if(nums[i1]>=nums[i+1]){
                    i2=i;break;
                }
            }
            swap(nums,i1,i2);
        }
        reverse(nums,i1+1);
    }
    public static void swap(int[] nums , int x,int y){
        int temp = nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
