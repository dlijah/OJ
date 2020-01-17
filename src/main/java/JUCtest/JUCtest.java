package JUCtest;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCtest implements Runnable {
    private Lock lock = new ReentrantLock();
    private Generator generator = new Generator();
    private static CountDownLatch countDownLatch = new CountDownLatch(100);
    private static List<Integer> result = new Vector<>();

    public void run(){
        countDownLatch.countDown();
        result.add(generator.getCount());

    }

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        for(int i = 0; i<100 ; i++){
            new Thread(new JUCtest()).start();
        }
        countDownLatch.await();
        Thread.sleep(1000);

        Collections.sort(result);
        for(Integer x :result){
            System.out.println(x);
        }

        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }

}
