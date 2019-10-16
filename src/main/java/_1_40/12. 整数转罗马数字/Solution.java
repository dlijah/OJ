package 整数转罗马数字;

public class Solution {
    private String[] A = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private int[] B = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

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
        System.out.println(solution.intToRoman(1994));
    }
}
