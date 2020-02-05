package _1_50.寻找两个有序数组的中位数;

public class Solution4 {
    /*
    LeetCode4th
    题目：
        给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
        你可以假设 nums1 和 nums2 不会同时为空。
    示例 1:
        nums1 = [1, 3]
        nums2 = [2]
        则中位数是 2.0
    示例 2:
        nums1 = [1, 2]
        nums2 = [3, 4]
        则中位数是 (2 + 3)/2 = 2.5
     */
    /*
    思路1：
        将两个有序数组合并成一个有序数组，然后得到中位数。
        但是时间复杂度为O(m+n)不符合要求。
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints  = new int[nums1.length+nums2.length];
        for(int i=0,j=0,n=0;n<ints.length;n++){
            if(i>=nums1.length){
                ints[n]=nums2[j];
                j++;
            }else if(j>=nums2.length||nums1[i]<nums2[j]){
                ints[n]=nums1[i];
                i++;
            } else {
                ints[n]=nums2[j];
                j++;
            }
        }
        double result ;
        if(ints.length%2==0){
            result = (ints[ints.length/2]+ints[ints.length/2-1])/2.0;
        }else {
            result = ints[ints.length/2];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3} , new int[]{1,2}));
    }
}
