package threads;

public class Ex2 {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        Mythread2 thread2 = new Mythread2();
        thread1.start();
        thread2.start();

    }
}
