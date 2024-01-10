package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumNubers {
    public static long value = 1_000_000_000;
    private static long sum = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResult = new ArrayList<>();
        long valueDelayBy10 = value/10;
        for (int i = 0; i < 10; i++){
            long from  =valueDelayBy10 * i + i;
            long to = valueDelayBy10 * (i+1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartSum = executorService.submit(task);
            futureResult.add(futurePartSum);
        }

    }
}

class PartialSum implements Callable<Long>{

    long from;
    long to;
    long localSum;
    public PartialSum(long from, long to){
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call(){
        for (long i = from; from <= to; i++){
            localSum += i;
        }
        System.out.println("Sum from " + from + " to" + to + " = " + localSum);
        return localSum;
    }
}