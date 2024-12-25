package Self_Study.PausingExecutionSleep;

public class InterruptExample {

    public static void main(String[] args) {
        Thread t1 = new Thread(new SleepingTask());

        t1.start();  // Thread başlatılır

        try {
            // Ana iş parçacığı 2 saniye bekler, sonra t1'i keser
            Thread.sleep(2000);
            t1.interrupt();  // t1'i kesintiye uğratır
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

