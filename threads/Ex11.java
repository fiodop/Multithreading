package threads;

public class Ex11 {
    static int cnt = 0;
    public static synchronized void increment(){ cnt++; }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(cnt);
    }
}

class R implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++){
            Ex11.increment();
            System.out.println(Ex11.cnt);
        }
    }
}