package threads;

import java.util.concurrent.CountDownLatch;

public class CountDouwLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static void marketStuffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("market stuff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }

    private static void everythingIsReade() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("everything is ready");
        countDownLatch.countDown();
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Marked opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch: " + countDownLatch.getCount());
    }
    public static void main(String[] args) throws InterruptedException {
        new Friend("Artem", countDownLatch);
        new Friend("Alex", countDownLatch);
        new Friend("Kamil", countDownLatch);
        new Friend("Roman", countDownLatch);
        marketStuffIsOnPlace();
        everythingIsReade();
        openMarket();
    }
}

class Friend extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            countDownLatch.await();
            System.out.println(name + " friend in store");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}