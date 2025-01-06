package cp_5.slides_exmp.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestAtomic {
    public static void main(String[] args) {
        // Counter Test
        Counter counter = new Counter();
        runTest(counter, "Counter");

        // SynchronizedCounter Test
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        runTest(synchronizedCounter, "SynchronizedCounter");

        // AtomicCounter Test
        AtomicCounter atomicCounter = new AtomicCounter();
        runTest(atomicCounter, "AtomicCounter");
    }

    private static void runTest(Object counter, String counterType) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    if (counterType.equals("Counter")) {
                        ((Counter) counter).increment();
                    } else if (counterType.equals("SynchronizedCounter")) {
                        ((SynchronizedCounter) counter).increment();
                    } else if (counterType.equals("AtomicCounter")) {
                        ((AtomicCounter) counter).increment();
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Bekle
        }

        // Sonuçları yazdır
        if (counterType.equals("Counter")) {
            System.out.println("Final count for Counter: " + ((Counter) counter).getValue());
        } else if (counterType.equals("SynchronizedCounter")) {
            System.out.println("Final count for SynchronizedCounter: " + ((SynchronizedCounter) counter).getValue());
        } else if (counterType.equals("AtomicCounter")) {
            System.out.println("Final count for AtomicCounter: " + ((AtomicCounter) counter).getValue());
        }
    }
}
