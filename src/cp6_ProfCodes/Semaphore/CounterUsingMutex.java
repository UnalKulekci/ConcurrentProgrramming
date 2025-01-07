package cp6_ProfCodes.Semaphore;

import java.util.concurrent.Semaphore;


/*
Mutex: İki durumlu bir semafor (binary semaphore) olarak işlev görür.
Sadece bir izin olduğunda, karşılıklı dışlama (mutual exclusion) sağlamak için kullanılır.
 */
class CounterUsingMutex {
    private Semaphore mutex; // Mutex olarak kullanılacak semafor
    private int count; // Sayıcı

    CounterUsingMutex() {
        mutex = new Semaphore(1); // Sadece bir izin ile semafor oluşturuluyor
        count = 0; // Sayıcı başlangıç değeri
    }

    // Burada increase basina synchronized yazarsanda ayni sey olur mutex'siz yani
    void increase() throws InterruptedException {
        mutex.acquire(); // Mutex'i al
        this.count = this.count + 1; // Sayıcıyı artır
        Thread.sleep(1000); // 1 saniye bekle
        mutex.release(); // Mutex'i serbest bırak
    }

    int getCount() {
        return this.count; // Sayıcıyı döner
    }

    boolean hasQueuedThreads() {
        return mutex.hasQueuedThreads(); // Bekleyen iş parçacığı var mı kontrol eder
    }
}

/*
- CounterUsingMutex sınıfı, bir sayıcıyı artırmak için bir mutex kullanır. increase() metodu, sayıcıyı artırmadan önce mutex'i alır ve işlem tamamlandığında serbest bırakır.
getCount() metodu, mevcut sayıcı değerini döner. hasQueuedThreads() metodu, mutex için bekleyen iş parçacıkları olup olmadığını kontrol eder.
 */