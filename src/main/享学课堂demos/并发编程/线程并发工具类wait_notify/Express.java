package 并发编程.线程并发工具类wait_notify;

public class Express {
    public final static String CITY = "ShangHai";
    private int km;
    private String site;
    public Express(){}

    public Express(int km , String site){
        this.km=km;
        this.site=site;
    }

    public synchronized void changeKm(){
        this.km = 100;
        notifyAll();
    }
    public synchronized void changeSite(){
        this.site="BeiJing";
        notifyAll();
    }
    public synchronized void waitKm(){
        while (this.km<100){
            try {
                wait();
                System.out.println("check km thread["+Thread.currentThread().getId()+"] is notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is "+this.km+",I will change db.");
    }
    public synchronized void waitSite(){
        while(CITY.equals(this.site)){
            try {
                wait();
                System.out.println("check site thread["+Thread.currentThread().getId()+"] is notified.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is "+this.site+",I will call user.");
    }

}
