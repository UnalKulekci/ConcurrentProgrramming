package cp_5.slides_exmp.Atomic;

/*
 * SynchronizedCounter: Thread-safe bir sayaç sınıfıdır.
 * synchronized anahtar kelimesi ile erişimi senkronize eder, böylece aynı anda yalnızca bir iş parçacığı bu metotları çalıştırabilir.
 */
public class SynchronizedCounter extends Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement(){
        count--;
    }

    public synchronized int getValue(){
        return count;
    }
}
