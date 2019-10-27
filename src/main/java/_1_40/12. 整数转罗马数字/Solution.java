package 整数转罗马数字;

public class Solution {
    /*
    leetcode 12th
    题目：
        罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
        通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     示例：
        输入: 3
        输出: "III"

        输入: 4
        输出: "IV"

        输入: 9
        输出: "IX"

        输入: 58
        输出: "LVIII"
        解释: L = 50, V = 5, III = 3.

        输入: 1994
        输出: "MCMXCIV"
        解释: M = 1000, CM = 900, XC = 90, IV = 4.

     */

    /*
    思路1：
        罗马数字有着基本的组成规律，基本数字元素包括
        1-I,4—IV，5-V，9-IX，10-X，40-IL，50-L，90-XC，100-C，
        400-CD，500-D，900-CM，1000-M。
        定义两个数组来表示罗马数字和整数之间的对应关系
        然后将整形参数转换成罗马数字，从数组末端开始迭代（从大到小），
        整数比数组元素大就减去数组元素的值然后返回的字符串上加上对应的罗马数字。
        举例：输入194    194比1000,900,500,400小，比100大，所以循环是194-100-90-4，得到结果是CXCIV。

     */
    private String[] A = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private int[] B = {    1,    4,    5,   9,   10,  40,   50,  90,  100,  400, 500,  900, 1000};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = A.length - 1; i >= 0; i--) {
            while (num >= B[i]) {
                sb.append(A[i]);
                num -= B[i];
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(2994));
    }
}
