package cp_5.slides_exmp.Atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter extends Counter {
    private AtomicInteger c = new AtomicInteger(0);

    @Override
    public void increment() {
        c.incrementAndGet();
    }

    @Override
    public void decrement() {
        c.decrementAndGet();
    }

    @Override
    public int getValue() {
        return c.get();
    }
}
