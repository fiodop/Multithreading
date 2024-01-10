package threads;

public class Mythread2 extends Thread{
    public void run(){
        for (int i = 1000; i > 0; i--){
            System.out.println(i);
        }
    }

}
