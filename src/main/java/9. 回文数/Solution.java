package 回文数;

import java.util.ArrayList;

public class Solution {
    /*
    LeetCode 9th
    题目：
        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        示例 1:
            输入: 121
            输出: true
        示例 2:
            输入: -121
            输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        示例 3:
            输入: 10
            输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
        进阶:
        你能不将整数转为字符串来解决这个问题吗？
     */
    /*
    思路1：
        将数字转化成字符串进行处理，首位比对后判定是否是回文数
     */
    public boolean isPalindrome(int x) {
        String str = ""+x;
        boolean res = true;
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) == str.charAt(j)){
                i++;j--;
                continue;
            }
            res = false;
            break;
        }
        return res;
    }

    /*
    思路2：
        直接对数字进行操作，数字分解后存到arraylist中，对数组进行
     */
    public boolean isPalindrome1(int x){
        boolean res = true;
        if(x<0) return false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (x/10!=0){
            list.add(x%10);
            x=x/10;
        }
        list.add(x);
        int i = 0 ;
        int j = list.size()-1;
        while (i<j){
            if(list.get(i).equals(list.get(j))){
                i++;j--;
                continue;
            }
            res=false;
            break;
        }
        return res;
    }
    public int endless(int a){
        System.out.println(a++);
        return endless(a);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.endless(1);
//        System.out.println(solution.isPalindrome1(101));
    }
}
