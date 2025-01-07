package Self_Study.Join;

public class ThreadsJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnableJoin(), "t1");
        Thread t2 = new Thread(new MyRunnableJoin(), "t2");
        Thread t3 = new Thread(new MyRunnableJoin(), "t3");

        t1.start();

        // start second thread after waiting for 2 seconds or if it's dead
        /*
        Yani t2 thread'i baslamak icin t1 thread'inin bitmesini bekleyecek ama
        sadece iki saniye kadar bekleyecek.
         */
        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();


        // start third thread only when first thread is dead
        /*
        Buradaki try-catch ise t3 thread'inin calismaya baslamasi icin t1'in
        tamamen calismasini bitirmesini bekler(Yani 4 saniye -> MyRunnableJoin'deki run metodunda 4 saniye sleep var)
         */
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();

        // let all threads finish execution before finishing main thread
        /*
        Main thread tum thread'lerin calismayi bitirmesini bekleyecek burasi sayesinde
         */
        try {
            t1.join();
            t2.join();
            //t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads are dead, exiting main thread");
    }
}
