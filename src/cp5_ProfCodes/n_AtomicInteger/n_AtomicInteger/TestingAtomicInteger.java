package cp5_ProfCodes.n_AtomicInteger.n_AtomicInteger;


public class TestingAtomicInteger {
    public static void main(String[] args) {
        Counter2 simpleCounter = new Counter2();
        simpleCounter.decrement();
        simpleCounter.decrement();
        simpleCounter.increment();
        System.out.println(simpleCounter + " value: " + simpleCounter.value());

        SynchronizedCounter2 synchronizedCounter = new SynchronizedCounter2();
        synchronizedCounter.decrement();
        synchronizedCounter.decrement();
        synchronizedCounter.increment();
        System.out.println(synchronizedCounter + " value: " + synchronizedCounter.value());

        AtomicCounter2 atomicCounter = new AtomicCounter2();
        atomicCounter.decrement();
        atomicCounter.decrement();
        atomicCounter.increment();
        System.out.println(atomicCounter + " value: " + atomicCounter.value());
    }
}
