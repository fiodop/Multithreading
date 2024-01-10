package threads;

public class MyThread3 implements Runnable{
    public void run(){
        for (int i = 1; i <=1000; i++){
            System.out.println(i);
        }
    }

}
