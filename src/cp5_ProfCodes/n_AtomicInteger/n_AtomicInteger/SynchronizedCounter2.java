package cp5_ProfCodes.n_AtomicInteger.n_AtomicInteger;

class SynchronizedCounter2 {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}
