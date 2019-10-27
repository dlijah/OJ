package 最长公共前缀;

import sun.security.krb5.KrbApRep;

public class Solution {
    /*
    leetcode 14th
    题目：
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
    示例 1:
        输入: ["flower","flow","flight"]
        输出: "fl"
    示例 2:
        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
    说明:
        所有输入只包含小写字母 a-z 。
     */

    /*
    思路1：
        首先将第一个字符串暂存，然后遍历字符串数组，每次比对后进行字符串截取。
        注意一些特殊情况即可
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String result = strs[0];
        if(result=="")return "";
        for(int i=1;i<strs.length;i++){
            for(int j=0;j<Math.min(strs[i].length() , result.length());j++){
                result = result.substring(0,Math.min(strs[i].length() , result.length()));
                if(result.charAt(j)!=strs[i].charAt(j)){
                    result = result.substring(0,j);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"aa","a"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
