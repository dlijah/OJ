package 剑指offer.替换空格;

public class Test4 {
    /*
    题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
     */


    public String replaceBlank(String param){
        String[] temp = param.split(" ");
        StringBuilder sb = new StringBuilder(temp[0]);
        for(int i = 1 ; i < temp.length ; i++){
            sb.append("%20");
            sb.append(temp[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.replaceBlank("We are happy."));
    }
}
