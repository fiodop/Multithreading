package threads;

public class Ex12 {
    static final Object lock = new Object();
    void mobileCall() {
        synchronized (lock) {
            System.out.println("mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Mobile call ends");
        }
    }
    void skypeCall()  {
        synchronized (lock) {
            System.out.println("skypeCall starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("skypeCall ends");
        }
    }
    void whattsappCall() {
        synchronized (lock) {
            System.out.println("WhattsappCall starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhattsappCall ends");
        }
    }

    public static void main(String[] args) {
//        Ex12 line = new Ex12();
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImpWhatsapp());
        Thread thread3 = new Thread(new RunnableImpSkype());

        thread1.start();;
        thread2.start();
        thread3.start();

    }
}

class RunnableImpSkype implements Runnable{
    @Override
    public void run() {
        new Ex12().skypeCall();
    }
}

class RunnableImpWhatsapp implements Runnable {
    @Override
    public void run() {
        new Ex12().whattsappCall();
    }
}
class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new Ex12().mobileCall();
    }
}
