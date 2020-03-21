package 剑指offer.构建乘积数组;

import java.util.Arrays;

public class Solution66 {
    /*
    题目：
        给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
        (题目理解：比如b[1]=a[0]*a[2]*a[3]*a[4])
    示例:
        输入: [1,2,3,4,5]
        输出: [120,60,40,30,24]
    提示：
        所有元素乘积之和不会溢出 32 位整数
        a.length <= 100000
     */
    /*
    思路：如果可以用除法，直接计算出所有a数组里的数的乘积然后除以a[i]即可。
        不适用除法的话使用两个辅助数组：前缀数组和后缀数组，分别表示该元素前面的累乘
        和后面的元素累乘的结果，b数组就是将这两个数组之间的元素相乘即可达到。
     */
    public static int[] constructArr(int[] a) {
        if(a==null||a.length<2)return new int[0];
        int[] prefix = new int[a.length]; prefix[0]=1;
        int[] suffix = new int[a.length]; suffix[suffix.length-1]=1;
        for(int i=1;i<prefix.length;i++){
            prefix[i]=a[i-1]*prefix[i-1];
        }
        for(int i=suffix.length-2;i>=0;i--){
            suffix[i] = a[i+1]*suffix[i+1];
        }
        int[] result = new int[a.length];
        result[0]=suffix[0];
        result[a.length-1]=prefix[a.length-1];
        for(int i=1;i<a.length-1;i++){
            result[i]=prefix[i]*suffix[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1,2,3,4,5})));
    }
}
