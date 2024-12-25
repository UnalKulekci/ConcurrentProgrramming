package Self_Study.S2;

// Provide a Runnable object
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread (Runnable interface)-> Bir thread'class icine parametre olarak vererek calistilabilir..");
    }

}
