package labs.a_definingAndStartingThread;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.print(Colors.ANSI_GREEN);
        System.out.println('\t' + "Hello from a class extending a Thread!");
        System.out.print(Colors.ANSI_RESET);
    }
}


