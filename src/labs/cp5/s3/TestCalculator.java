package labs.cp5.s3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();


        ExecutorService executor = Executors.newFixedThreadPool(5);
        // İş parçacıklarını oluşturma
        for (int i = 0; i < 5; i++) {
            final int operation = i; // Lambda ifadesinde kullanmak için final
            executor.execute(() -> {
                long threadId = Thread.currentThread().getId(); // İş parçacığı kimliğini al
                switch (operation) {
                    case 0:
                        calculator.addition(22);
                        System.out.println("Thread " + threadId + ": Added 22 -> " + calculator.getResult());
                        break;
                    case 1:
                        calculator.subtraction(7);
                        System.out.println("Thread " + threadId + ": Subtracted 7 -> " + calculator.getResult());
                        break;
                    case 2:
                        calculator.multiplication(24);
                        System.out.println("Thread " + threadId + ": Multiplied by 24 -> " + calculator.getResult());
                        break;
                    case 3:
                        calculator.division(10);
                        System.out.println("Thread " + threadId + ": Divided by 10 -> " + calculator.getResult());
                        break;
                    case 4:
                        calculator.division(0); // Sıfıra bölme denemesi
                        System.out.println("Thread " + threadId + ": Attempted division by 0");
                        break;
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Bekle
        }

        // Sonucu yazdırma
        System.out.println("Final result: " + calculator.getResult());
    }
}

/*
İşlemlerin Sırası
    İş Parçacıkları: for döngüsü ile 5 iş parçacığı oluşturuluyor. Her bir iş parçacığı, Calculator sınıfının farklı bir metodunu çağırıyor.

İşlemler:
 - İş Parçacığı 0: calculator.addition(22);
    Sonuç: 0 + 22 = 22
 - İş Parçacığı 1: calculator.subtraction(7);
    Sonuç: 22 - 7 = 15
  - İş Parçacığı 2: calculator.multiplication(24);
    Sonuç: 15 24 = 360
 - İş Parçacığı 3: calculator.division(10);
    Sonuç: 360 / 10 = 36
  - İş Parçacığı 4: calculator.division(0);
    Bu işlem sıfıra bölme hatası verir, ancak bu işlem sonucu etkilemez.

Sonuç Hesaplama
    İş parçacıkları, ExecutorService ile eşzamanlı olarak çalıştıkları için işlemler birbirine karışabilir. Ancak, AtomicLong kullanıldığı için her işlem atomik olarak gerçekleştirilir.
    İş parçacıkları tamamlandıktan sonra, calculator.getResult() çağrıldığında, son değer 36 olarak döner.
 */
