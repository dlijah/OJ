package _41_80.接雨水;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    /*
     题目：
        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
        上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    /*
    思路1：

     */
    public static int trap(int[] height) {
        SortedSet sortedSet = new TreeSet<Integer>();
        for(int a:height){
            sortedSet.add(a);
        }
        Iterator it = sortedSet.iterator();
        int squire = 0;
        int nlast = 0;
        while(it.hasNext()){
            int n = (int)it.next();
            int a=0,b=0,num=0;
            boolean tri = true;
            for(int i=0;i<height.length;i++){
                if(height[i]>=n){
                    num++;
                    if(tri){
                        a=i;
                        tri=false;
                    }
                    b=i;
                }
            }
            squire+=(b-a-num+1)*(n-nlast);
            nlast=n;
        }
        return squire;
    }

    public static void main(String[] args) {
//        int[] ints = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] ints = new int[]{4,2,3};
        System.out.println(trap(ints));
    }
}
