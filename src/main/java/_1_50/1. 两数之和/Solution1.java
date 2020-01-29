package _1_50.两数之和;

import java.util.*;

public class Solution1 {
    /*
    LeetCode 1st
    题目：
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
    示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
     */
    /*
    思路1：
        将数组存入map种快速判断是否存在符合要求的结果，key为值，value为下标。
        实际提交时又遇到特殊情况，即单个元素出现多次且满足要求的情况，比如[3,3]，target=6，
        此时要返回[0,1]，在放入map的时候判断是否已经存在于map中，如果存在的话判断是不是满足要求，
        如果满足要求直接返回两次出现的下标即可。
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer , Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&target==nums[i]*2){
                result[0]=map.get(nums[i]);
                result[1]=i;
                return result;
            }
            map.put(nums[i],i);
        }
        for(Integer i:map.keySet()){
            if(map.containsKey(target-i)&&i*2!=target){
                result[0]=map.get(i);
                result[1]=map.get(target-i);
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{0 ,2, 11, 13 ,11,15} , 22)));
    }
}
