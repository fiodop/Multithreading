package threads;

import java.util.concurrent.*;

public class RunnableFactorial {
    static int factorialResult = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
//        executorService.execute(factorial);
        Future future =executorService.submit(factorial);

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(future.get());
        System.out.println(factorialResult);
    }
}

class Factorial implements Runnable{
    int f;
    public Factorial(int f){
        this.f = f;
    }
    @Override
    public void run() {
        if (f <= 0){
            System.out.println("Vi vveli nevernoe chislo");
            return;
        }
        int result = 1;
        for (int i = 1; i <=f; i++){
            result*=i;
        }
        RunnableFactorial.factorialResult = result;
    }
}