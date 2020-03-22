package 剑指offer.扑克牌中的顺子;

import java.util.Arrays;

/*
    题目：
        从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
    示例 1:
        输入: [1,2,3,4,5]
        输出: True
    示例 2:
        输入: [0,0,1,2,5]
        输出: True
    限制：
        数组长度为 5 
        数组的数取值为 [0, 13]
 */
/*
    思路1：
        基本思路是找出除了0之外的最小元素和最大元素，他们的差小于等于4就是顺子。
        特殊情况是数组中有相同元素就不可能成为顺子，排除。
 */
public class Solution61 {
    public static boolean isStraight(int[] nums) {
        if(nums==null||nums.length!=5){
            return false;
        }
        Arrays.sort(nums);
        int n = 0;
        int min = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0) {
                n++;continue;
            }
            if(min==0)min=nums[i];
            if(nums[i]==nums[i+1]) return false;
        }
        if(nums[nums.length-1]-min<=4) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{13,13,9,12,10}));
        System.out.println(isStraight(new int[]{1,2,0,0,5}));
    }
}
