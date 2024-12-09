package labs.d_joins;

import java.util.Stack;

// EmptyingThread is emptying the whole source stack, and pushing its numbers into targetStack.

public class EmptyingThread extends Thread {
    private Stack<Integer> sourceStack;
    private Stack<Integer> targetStack;

    public EmptyingThread(Stack<Integer> sourceStack, Stack<Integer> targetStack) {
        super();
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
    }

    @Override
    public void run() {
        while (!sourceStack.isEmpty()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Integer number = sourceStack.pop();
            System.out.println("Pushed " + number.toString() + " from source stack -> target stack.");

            targetStack.push(number);
        }
    }
}

