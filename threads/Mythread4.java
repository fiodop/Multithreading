package threads;

public class Mythread4 implements Runnable{
    public void run(){
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }

}
