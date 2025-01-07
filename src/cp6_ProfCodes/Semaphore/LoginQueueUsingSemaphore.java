package cp6_ProfCodes.Semaphore;

import java.util.concurrent.Semaphore;

public class LoginQueueUsingSemaphore {

    private final Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);  // Semafor oluşturuluyor,belli slot sayisi ile
    }

    boolean tryLogin() {
        return semaphore.tryAcquire();  // Giriş denemesi
    }

    void logout(){
        semaphore.release(); // Çıkış yapıldığında izin serbest bırakılıyor
    }

    int availableSlots() {
        return semaphore.availablePermits(); // Mevcut izin sayısını döner
    }
}
