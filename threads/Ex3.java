package threads;

public class Ex3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new Mythread4());
        thread1.start();
        thread2.start();
    }

}
