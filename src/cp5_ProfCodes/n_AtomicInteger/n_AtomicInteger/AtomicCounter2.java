package cp5_ProfCodes.n_AtomicInteger.n_AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter2 {
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }
}
