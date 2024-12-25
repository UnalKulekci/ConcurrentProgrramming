package Self_Study.S2;

// Subclass Thread
public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a Thread ( Thread Class) ");
    }
}
