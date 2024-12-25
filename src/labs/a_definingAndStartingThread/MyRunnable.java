package labs.a_definingAndStartingThread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.print(Colors.ANSI_RED);
        System.out.println('\t' + "Hello from a Runnable object!");
        System.out.print(Colors.ANSI_RESET);
    }
}


