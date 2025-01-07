package cp6_ProfCodes.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Bu sınıf, belirli bir sayıda kullanıcının aynı anda sisteme girmesini sağlamak için Semaphore kullanır.
 * Slot (izin) sınırına ulaşıldığında yeni girişler engellenir.
 * Giriş yapanlar bir slot alır, çıkış yapanlar slotu serbest bırakır.
 *
 * - Web sunucuları ve oyun sunucularında belirli sayıda kullanıcıyı sınırlamak için kullanılır.
 * - Veritabanı bağlantı havuzlarında (connection pool) belirli sayıda bağlantıyı kontrol etmek için yaygın olarak kullanılır.
 */
public class LoginQueueUsingSemaphore {

    /**
     * Semaphore, izin (permit) sayısını takip eden bir sınıftır.
     * Bu izinler, kaynağa eş zamanlı erişimi sınırlar.
     */
    private final Semaphore semaphore;

    /**
     * Yapıcı metod, belirli bir slot sınırı belirler ve bu sınır kadar izin içeren bir semafor oluşturur.
     * @param slotLimit Aynı anda izin verilen maksimum kullanıcı sayısı (slot).
     */
    LoginQueueUsingSemaphore(int slotLimit) {
        semaphore = new Semaphore(slotLimit);
    }

    /**
     * Sisteme giriş yapmaya çalışan kullanıcılar için izin almayı dener.
     * @return Eğer izin mevcutsa true, aksi halde false döner.
     *         - tryAcquire(): Bloklamayan (non-blocking) bir metottur. Slot doluysa false döner.
     *         - acquire(): Slot doluysa, izin açılana kadar bekler (bloklar).
     */
    boolean tryLogin() {
        return semaphore.tryAcquire();
    }

    /**
     * Sisteme giriş yapan bir kullanıcının çıkış yapmasını sağlar. Bir izin serbest bırakılır.
     */
    void logout() {
        semaphore.release();
    }

    /**
     * Sistemde kaç adet boş slot olduğunu döner.
     * @return Mevcut izin (slot) sayısı.
     *         - İlk başlangıçta slot sayısı 3 ise ve 1 kullanıcı girdiğinde 2 döner.
     */
    int availableSlots() {
        return semaphore.availablePermits();
    }
}
