package 笔试题练习;

import java.util.Scanner;

public class 字符串校验 {
    /*
    题目：
    字符串校验
        1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
        2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
        3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++){
            System.out.println(stringcheck(sc.nextLine()));
        }
    }
    public static String stringcheck(String before){
        if(before.length()<3)return before;
        String after = "";
        for(int i=0;i<before.length()-2;i++){
            if(before.charAt(i)==before.charAt(i+1)&&before.charAt(i)==before.charAt(i+2)){
                String temp = before.substring(0,i)+before.substring(i+1,before.length());
                before=stringcheck(temp);
            }else if(i+3<before.length()&&before.charAt(i)==before.charAt(i+1)&&before.charAt(i+2)==before.charAt(i+3)){
                String temp = before.substring(0,i+2)+before.substring(i+3,before.length());
                before=stringcheck(temp);
            }
        }
        return before;
    }
}
