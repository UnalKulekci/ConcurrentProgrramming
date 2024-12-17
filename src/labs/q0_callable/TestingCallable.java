package labs.q0_callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestingCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableMultiplication cm1 = new CallableMultiplication(1, 20, 30);
        CallableMultiplication cm2 = new CallableMultiplication(2, 400, 20);

        CallableException callableException = new CallableException(3);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> futureTask1 = executorService.submit(cm1);
        Future<Integer> futureTask2 = executorService.submit(cm2);
        Future<Integer> futureTask3 = executorService.submit(callableException);

        System.out.println("Future task 1 -> " + futureTask1.get());
        System.out.println("Future task 2 -> " + futureTask2.get());

        try {
            System.out.println("Future task 3 -> " + futureTask3.get());
        } catch (Exception e) {
            System.out.println("Caught Exception -> " + e);
        }

        if (futureTask1.isDone() && futureTask2.isDone() && futureTask3.isDone()) {
            executorService.shutdown();
        }
    }
}

