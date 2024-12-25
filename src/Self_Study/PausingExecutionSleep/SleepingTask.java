package Self_Study.PausingExecutionSleep;

class SleepingTask implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread is sleeping...");
            // 10 saniye boyunca uyur
            Thread.sleep(10000);
            System.out.println("Thread woke up normally.");
        } catch (InterruptedException e) {
            // Kesilirse burası çalışır
            System.out.println("Thread was interrupted during sleep!");
        }
    }
}
