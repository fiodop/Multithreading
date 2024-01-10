package threads;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        Future<Integer> future = executorService.submit(factorial2);
        try {
            System.out.println(future.isDone());
            System.out.println("Hotim poluchit resultat");
            factorialResult = future.get();
            System.out.println("poluchili resultat");
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
    }
}

class Factorial2 implements Callable<Integer>{
    int f;
    public Factorial2(int f){
        this.f = f;
    }
    @Override
    public Integer call() throws Exception {
        if (f <= 0){
            throw new Exception("vi vveli nevernoye chislo");
        }
        int result = 0;
        for (int i = 1; i <= f; i++){
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}