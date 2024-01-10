package threads;

public class Ex10 {
    public static void main(String[] args) {
        MyRunnableImplementation runnable = new MyRunnableImplementation();
        Thread thread1 = new Thread(new MyRunnableImplementation());
        Thread thread2 = new Thread(new MyRunnableImplementation());
        Thread thread3 = new Thread(new MyRunnableImplementation());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Counter{
    static int cnt = 0;
}

class MyRunnableImplementation implements Runnable{
    public synchronized void increment(){
        Counter.cnt++;
        System.out.print(Counter.cnt + " ");
    }
    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            increment();
        }
    }
}
