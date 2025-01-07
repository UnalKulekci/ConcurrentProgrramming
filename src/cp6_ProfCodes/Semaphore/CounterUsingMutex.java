package cp6_ProfCodes.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Mutex: İki durumlu bir semafor (binary semaphore) olarak işlev görür.
 * Yalnızca bir izin olduğunda, karşılıklı dışlama (mutual exclusion) sağlamak için kullanılır.
 * Bu sınıf, aynı anda yalnızca bir iş parçacığının kritik bölgeye erişmesini sağlar.
 */
class CounterUsingMutex {
    private Semaphore mutex; // Mutex olarak kullanılan Semaphore
    private int count; // Sayaç değişkeni

    /**
     * Yapıcı metod, bir izin içeren semafor başlatır.
     * Bu, aynı anda yalnızca bir iş parçacığının kritik bölgeye girmesine izin verir.
     */
    CounterUsingMutex() {
        mutex = new Semaphore(1); // 1 izinli semafor (Binary Semaphore)
        count = 0; // Sayaç başlangıç değeri
    }

    /**
     * Sayaç değerini artırır.
     * Mutex, iş parçacığının kritik bölgeye erişimini kontrol eder.
     * @throws InterruptedException İş parçacığı beklerken kesilirse fırlatılır.
     */
    void increase() throws InterruptedException {
        mutex.acquire(); // İzin al, eğer izin yoksa bekle (blokla)
        this.count = this.count + 1; // Sayaç artırılır (Kritik Bölge)
        Thread.sleep(1000); // 1 saniye gecikme (Simülasyon amaçlı)
        mutex.release(); // İzin serbest bırakılır
    }

    /**
     * Sayaç değerini döner.
     * @return Mevcut sayaç değeri
     */
    int getCount() {
        return this.count;
    }

    /**
     * Mutex üzerinde bekleyen iş parçacıklarının olup olmadığını kontrol eder.
     * @return Eğer bekleyen iş parçacığı varsa true, yoksa false döner.
     */
    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads();
    }
}
