package labs.a_definingAndStartingThread;

public class Test_A {
    public static void main(String[] args) {
        System.out.println("Hello world from the main thread!");

        // Runnable kullanarak thread oluştur
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        // Thread sınıfını genişleterek thread oluştur
        Thread t2 = new MyThread();
        t2.start();
    }
}

