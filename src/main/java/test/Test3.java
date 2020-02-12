package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test3 {
    class A{
        Date date;
    }
    public static void main(String[] args) {
        Test3 test3 = new Test3();
        A a  = test3.new A();
        A a1  = test3.new A();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(2020,2,10));
        calendar.add(Calendar.DATE,1);
        a.date=calendar.getTime();
        calendar=Calendar.getInstance();
        calendar.setTime(new Date(2020,2,20));
        calendar.add(Calendar.DATE,1);
        a1.date=calendar.getTime();
        System.out.println(a.date+" , "+a1.date);

    }
}
