package test;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str  ="nihao 你好 喬亂";
        // 字符串转化成 byte 数组
        byte[] bytes = str.getBytes("utf-8");
        // byte 数组转化成字符串
        String s2 = new String(bytes , "utf-8");
//        List list = Collections.synchronizedList(new ArrayList<>());
//        List list = new CopyOnWriteArrayList();
//        list = Collections.unmodifiableList(list);
//        list.add("");
        int[] a = new int[]{1,2};
        int[] b = new int[]{1,2};
        System.out.println(a.equals(b));
        System.out.println(Objects.deepEquals(a,b));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.iterator();
        Integer[] ints = new Integer[arrayList.size()];
        arrayList.toArray(ints);
        System.out.println(Arrays.toString(ints));
        List<String> list = new ArrayList<String>() {{
            add("2");
            add("3");
            add("3");
            add("3");
            add("3");
            add("4");
        }};
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("3")) {
                list.remove(i);
//                i--;
            }
        }
        System.out.println(list.toString());
    }
}
