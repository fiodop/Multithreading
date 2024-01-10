package threads;

public class InterruptiopEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("main thread ends");
    }
}

class InterruptedThread extends Thread{
    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 1; i <=1000000000; i++){
            if (isInterrupted()) {
                System.out.println("Поток хотят прервать");
                System.out.println(sqrtSum);
                return;
            }
                sqrtSum = Math.sqrt(i);
            try{
                Thread.sleep(100);
            }catch(Exception e){
                System.out.println("Potok hotyat prervat davayte zavershim ego rabotu");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}