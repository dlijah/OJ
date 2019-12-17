package 盛水最多的容器;

/*
    LeetCode 10th
    题目：
        给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        说明：你不能倾斜容器，且 n 的值至少为 2。
        图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例：
        输入: [1,8,6,2,5,4,8,3,7]
        输出: 49

*/
public class Solution11 {
    /*
    思路1:
        穷举
        遍历所有种情况，得到所有可能的盛水量，取最大的结果返回。
     */
    public int maxArea(int[] height) {
        int res = 0;
        int temp = 0;
        for(int i = 0;i < height.length ; i++){
            for(int j = i+1; j < height.length ; j++){
                temp = Math.min(height[i],height[j])*(j-i);
                if(temp>res) res = temp;
            }
        }
        return res;
    }

    /*
    思路2：
        双指针法
            首先将两个指针分别指向数组两端，此时能够得到一个盛水容量，然后将较短边的指针向内移动，得到新的容量，直到两个指针重合。
        合理性分析：
            向内收窄短板可以获取面积最大值。
        若不指定移动规则，所有移动出现的 S(i, j)S(i,j) 的状态数为 C(n, 2)C(n,2)，即暴力枚举出所有状态。
        在状态 S(i, j)S(i,j) 下向内移动短板至 S(i + 1, j)S(i+1,j)（假设 h[i] < h[j]h[i]<h[j] ），则相当于消去了 {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}S(i,j−1),S(i,j−2),...,S(i,i+1) 状态集合。而所有消去状态的面积一定 <= S(i, j)<=S(i,j)：
        短板高度：相比 S(i, j)S(i,j) 相同或更短（<= h[i]<=h[i]）；
        底边宽度：相比 S(i, j)S(i,j) 更短。
        因此所有消去的状态的面积都 < S(i, j)<S(i,j)。我们每次向内移动短板，所有的消去状态都不会导致丢失面积最大值 。

     */
    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }



    public static void main(String[] args) {
        盛水最多的容器.Solution11 solution = new 盛水最多的容器.Solution11();
        int[] ints ={1,8};
        System.out.println(solution.maxArea(ints));
    }
}