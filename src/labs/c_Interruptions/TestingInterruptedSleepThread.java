package labs.c_Interruptions;

// Illustrating https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html

public class TestingInterruptedSleepThread {
    public static void main(String[] args) throws InterruptedException {
        // Pausing the execution with sleep:
        System.out.println("Testing interruptions");
        Thread thread = new Thread(new InterruptedSleepThread());
        thread.start();

        // The main thread is going to sleep and the interrupts the secondary thread
        System.out.println("Sleeping ");
        Thread.sleep(3000);
        System.out.println("Interrupting the second thread");
        thread.interrupt();
    }
}
