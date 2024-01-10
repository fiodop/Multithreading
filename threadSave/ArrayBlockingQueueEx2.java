package threadSave;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

        //Producer

        new Thread(() -> {
            int i = 0;
            while (true){
                try {
                    arrayBlockingQueue.put(i++);
                    System.out.println("Producer added: " + i + arrayBlockingQueue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        //Consumer
        new Thread(() -> {
            while (true) {
                try {
                    int j = arrayBlockingQueue.take();
                    System.out.println("Consumer took elem: " + j + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
