package demo;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

public class asd {

    public boolean sim(String a , String b){
        String temp = "";
        for(int i = 0 ; i<a.length() ; i++){
            if(a.equals(b)) return true;
            temp = a.substring(1,a.length());
            a = temp + a.substring(0,1);
        }
        return false;
    }
    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdab";
        asd asd = new asd();
        System.out.println(asd.sim(a,b));
    }

}
