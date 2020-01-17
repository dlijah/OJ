package 求解方程;

public class Solution640 {
    public static String solveEquation(String equation) {
        String[] subs = equation.split("=");
        if(subs.length!=2){
            return null;
        }
        String left = subs[0];
        String right = subs[1];
        int a,b,c,d;
        a=getparam(left)[1];
        b=getparam(left)[0];
        c=getparam(right)[1];
        d=getparam(right)[0];
        if(a==c){
            if(b==d)return "Infinite solutions";
            else return "No solution";
        }
        String result = "x="+(d-b)/(a-c);
        return result;
    }
    public static int[] getparam(String s){
        int a=0,b=0,last=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='+'){
                if(s.charAt(i-1)=='x'){
                    if(last==i-1) b+=1;
                    else b += Integer.parseInt(s.substring(last,i-1));
                    last= i + 1;
                }else {
                    a += Integer.parseInt(s.substring(last,i));
                    last= i + 1;
                }

            }else if(s.charAt(i)=='-'){
                if(s.charAt(i-1)=='x'){
                    if(last==i-1) b+=1;
                    else b += Integer.parseInt(s.substring(last,i-1));
                    last= i;
                }else {
                    a += Integer.parseInt(s.substring(last,i));
                    last= i;
                }
            }
        }
        if(s.endsWith("x")){
            int n ;
            if(last==s.length()-1) n=1;
            else if(s.substring(last,s.length()-1)=="-") n=-1;
            else n=Integer.parseInt(s.substring(last,s.length()-1));
            b+=n;
        }else {
            a+=Integer.parseInt(s.substring(last,s.length()));
        }
        return new int[]{a,b};
    }
    public static void main(String[] args) {
        String equation = "-x=-2";
        System.out.println(solveEquation(equation));
    }
}
