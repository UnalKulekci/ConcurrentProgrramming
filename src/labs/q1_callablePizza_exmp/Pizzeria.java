package labs.q1_callablePizza_exmp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pizzeria {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Pizzaiolo marco = new Pizzaiolo("Marco");
        Pizzaiolo antonio = new Pizzaiolo("Antonio");

        ExecutorService executorService = Executors.newScheduledThreadPool(2);

        while (true) {
            Future<Pizza> pizzaFuture1 = executorService.submit(marco);
            Future<Pizza> pizzaFuture2 = executorService.submit(antonio);

            System.out.println(pizzaFuture1.get().hashCode());
            System.out.println(pizzaFuture2.get().hashCode());
        }
    }
}
