package JUCtest;

public class Generator {
    public static int count = 0;
    public static synchronized int getCount(){
        int i=0;
        count = Integer.parseInt(count+"")+1;
        return count;
    }
}
