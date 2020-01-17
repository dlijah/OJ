package _1_50.电话号码的字母组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {
    /*
    题目：
        给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    示例:
        输入："23"
        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

     */
    /*
    思路1；
        分解digits，实现一个两个List<String>join的方法，遍历调用这个方法得到结果。
     */
    public List<String> letterCombinations(String digits) {
        List<List<String>>lists = new ArrayList<List<String>>(){{
            add(Arrays.asList("a","b","c"));
            add(Arrays.asList("d","e","f"));
            add(Arrays.asList("g","h","i"));
            add(Arrays.asList("j","k","l"));
            add(Arrays.asList("m","n","o"));
            add(Arrays.asList("p","q","r","s"));
            add(Arrays.asList("t","u","v"));
            add(Arrays.asList("w","x","y","z"));
        }};
        byte[] bytes = digits.getBytes();
        if(bytes==null||bytes.length==0){
            return new ArrayList<>();
        }
        List<String> result = lists.get(bytes[0]-50);
        for(int i=1;i<bytes.length;i++){
            result = join(result , lists.get(bytes[i]-50));
        }
        return result;
    }

    public List<String> join(List<String> list1 , List<String> list2){
        ArrayList<String> result = new ArrayList<>();
        for(String a:list1){
            for(String b:list2){
                result.add(a+b);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("234"));
    }
}
