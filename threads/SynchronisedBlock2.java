package threads;

public class SynchronisedBlock2 {
    static int cnt = 0;
    public static synchronized void increment(){
        synchronized (SynchronisedBlock2.class) {
            cnt++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(cnt);
    }
}

class R2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i ++){
            Ex11.increment();
            System.out.println(Ex11.cnt);
        }
    }
}

