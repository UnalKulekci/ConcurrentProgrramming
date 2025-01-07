package labs.cp5.s3;

import java.util.concurrent.atomic.AtomicLong;

public class Calculator {

    private AtomicLong result = new AtomicLong(0); // Başlangıç değeri 0


    public void addition(int n1) {
        result.addAndGet(n1);
    }

    public void subtraction(long n1) {
        result.addAndGet(-n1);
    }

    public void multiplication(long n1) {
        result.set(result.get() * n1);
    }

    public void division(long n1) {
        if (n1 != 0) { // Sıfıra bölme kontrolü
            result.set(result.get() / n1);
        } else {
            System.out.println("Error: Division by zero");
        }
    }

    public long getResult() {
        return result.get();
    }

}