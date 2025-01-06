package Concurrency_HighLevel._CourseExamples.n_AtomicInteger;

public class TestingAtomicInteger {
    public static void main(String[] args) {
        Counter simpleCounter = new Counter();
        simpleCounter.decrement();
        simpleCounter.decrement();
        simpleCounter.increment();
        System.out.println(simpleCounter + " value: " + simpleCounter.value());

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        synchronizedCounter.decrement();
        synchronizedCounter.decrement();
        synchronizedCounter.increment();
        System.out.println(synchronizedCounter + " value: " + synchronizedCounter.value());

        AtomicCounter atomicCounter = new AtomicCounter();
        atomicCounter.decrement();
        atomicCounter.decrement();
        atomicCounter.increment();
        System.out.println(atomicCounter + " value: " + atomicCounter.value());
    }
}
