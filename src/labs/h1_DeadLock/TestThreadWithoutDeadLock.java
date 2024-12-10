package labs.h1_DeadLock;

/*
Çözüm: Kilitleme Sırasına Dikkat Ederek Deadlock'tan Kaçınma

Deadlock oluşmasını önlemek için tüm thread'lerin kaynaklara (lock'lara) aynı sırada erişmesini sağlıyoruz.
Bu örnekte:
- Hem ThreadDemo1 hem de ThreadDemo2 önce Lock1'i kilitliyor, ardından Lock2'yi kilitliyor.
- Böylece bir thread diğerinin kilitlemesini beklerken deadlock durumu oluşmuyor.
*/

public class TestThreadWithoutDeadLock {

    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {
        // İki thread oluşturulur
        TestThreadWithoutDeadLock.ThreadDemo1 T1 = new TestThreadWithoutDeadLock.ThreadDemo1();
        TestThreadWithoutDeadLock.ThreadDemo2 T2 = new TestThreadWithoutDeadLock.ThreadDemo2();

        // Thread'ler başlatılır
        T1.start();
        T2.start();
    }

    /*
    Kilitleme sırası değiştirildi: Her iki thread'de aynı sırada kilit işlemi yapıyor.
    Önce Lock1 kilitleniyor, ardından Lock2 kilitleniyor.
    Bu şekilde deadlock problemi engellenmiş oluyor.
    */
    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) { // İlk olarak Lock1 kilitlenir
                System.out.println("Thread 1: Lock1 kilitlendi...");
                try {
                    Thread.sleep(10); // Diğer thread'in çalışması için kısa bir bekleme
                } catch (InterruptedException e) {
                }
                synchronized (Lock2) { // Daha sonra Lock2 kilitlenir
                    System.out.println("Thread 1: Lock1 ve Lock2 kilitlendi...");
                }
            }
        }
    }

    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock1) { // İlk olarak Lock1 kilitlenir (Sıra aynı)
                System.out.println("Thread 2: Lock1 kilitlendi...");
                try {
                    Thread.sleep(10); // Diğer thread'in çalışması için kısa bir bekleme
                } catch (InterruptedException e) {
                }
                synchronized (Lock2) { // Daha sonra Lock2 kilitlenir
                    System.out.println("Thread 2: Lock1 ve Lock2 kilitlendi...");
                }
            }
        }
    }
}