package threads;

public class Ex5 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("moyPotok");
        myThread5.setPriority(Thread.MIN_PRIORITY);
        System.out.println("Name of myThread5:" + myThread5.getName()+
                " priority of myThread5:" + myThread5.getPriority());
    }
}
class MyThread5 extends Thread{
    public void run(){
        System.out.println("privet");
    }
}
