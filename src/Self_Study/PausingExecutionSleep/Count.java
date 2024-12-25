package Self_Study.PausingExecutionSleep;

public class Count {
    public static void main(String[] args) {
        // Main thread referansı
        Thread mainThread = Thread.currentThread();

        // 1'den 20'ye kadar sayan iş parçacığı (Runnable)
        Runnable countTask = () -> {
            try {
                for (int i = 1; i <= 20; i++) {
                    System.out.println("Thread sayıyor: " + i);
                    Thread.sleep(1000);  // Her sayıda 1 saniye bekler

                    // 15 olduğunda main thread'i kes
                    if (i == 15) {
                        System.out.println("15'e ulaşıldı. Main thread kesiliyor...");
                        mainThread.interrupt();  // Main thread'i kes
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread kesildi.");
            }
        };

        // Thread oluştur ve başlat
        Thread thread = new Thread(countTask);
        thread.start();

        // Main thread 1'den 15'e kadar sayar
        try {
            for (int i = 1; i <= 18; i++) {
                System.out.println("Main thread sayıyor: " + i);
                Thread.sleep(1000);  // Her sayıda 1 saniye bekler
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread kesildi! Sayma işlemi durduruldu.");
            return; // Main thread dongusunu sonlardirmak icin
        }
    }
}
