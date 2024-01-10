package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntEx {
//    static  int cnt = 0;
    static AtomicInteger cnt = new AtomicInteger(0);
    public static void increment(){
        cnt.addAndGet(-5);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl18());
        Thread thread2 = new Thread(new MyRunnableImpl18());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(cnt);
    }
}

class MyRunnableImpl18 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            AtomicIntEx.increment();
        }
    }
}