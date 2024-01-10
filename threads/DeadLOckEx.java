package threads;

public class DeadLOckEx {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread1 = new Thread10();
        Thread20 thread2 = new Thread20();
        thread1.start();
        thread2.start();
    }
}

class Thread10 extends Thread {
    public void run() {
        System.out.println("Thread10: попытка захватить монитор объекта lock1");
        synchronized (DeadLOckEx.lock1) {
            System.out.println("Thread10: монитор объекта lock1 захвачен");
            System.out.println("Thread10: попытка захватить монитор объекта lock2");
            synchronized (DeadLOckEx.lock2) {
                System.out.println("Thread10: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
class Thread20 extends Thread {
    public void run() {
        System.out.println("Thread20: попытка захватить монитор объекта lock2");
        synchronized (DeadLOckEx.lock2) {
            System.out.println("Thread20: монитор объекта lock2 захвачен");
            System.out.println("Thread20: попытка захватить монитор объекта lock1");
            synchronized (DeadLOckEx.lock1) {
                System.out.println("Thread20: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
