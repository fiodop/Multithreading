package threads;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        new Person("Artem", callBox);
        new Person("Zaur", callBox);
        new Person("Kamil", callBox);
        new Person("Alex", callBox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callBox;
    public Person(String name, Semaphore callBox){
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
        System.out.println(name + " waiting");
            callBox.acquire();
            System.out.println(name + " using call box");
            Thread.sleep(2000);
            System.out.println(name + " ended call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }
    }
}

