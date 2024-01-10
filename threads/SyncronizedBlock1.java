package threads;

public class SyncronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImplementation2 runnable = new MyRunnableImplementation2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter2 {
    static int cnt = 0;
}

class MyRunnableImplementation2 implements Runnable {
    public void doWork1() {
        synchronized (this){
        Counter2.cnt++;
        System.out.print(Counter2.cnt + " ");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}
