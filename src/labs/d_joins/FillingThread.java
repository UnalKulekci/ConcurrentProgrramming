package labs.d_joins;

import java.util.Stack;

// FillingThread waits until EmptyingThread has completed, in order to push back to
// sourceStack all numbers that were put inside targetStack.

public class FillingThread extends Thread {
    private Stack<Integer> sourceStack;
    private Stack<Integer> targetStack;
    private Thread waitOnThread;

    public FillingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack, Thread waitOnThread) {
        super();
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
        this.waitOnThread = waitOnThread;
    }

    @Override
    public void run() {
        // not needed but good practice
        if (this.waitOnThread.isAlive()) {
            try {
                this.waitOnThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // from now on, we know that the
        // emptying thread is done
        System.out.println("\nFilling back source stack from now on.");
        while (!targetStack.isEmpty()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Integer number = targetStack.pop();
            System.out.println("Pushed " + number.toString() + " from target stack -> source stack.");

            sourceStack.push(number);
        }
    }
}
