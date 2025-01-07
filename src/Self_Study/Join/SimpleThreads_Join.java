package Self_Study.Join;

public class SimpleThreads_Join {

    static void threadMessage(String message) {
        System.out.format("%s: %s%n", Thread.currentThread().getName(), message);
    }

    private static class MessageLoop implements Runnable {
        @Override
        public void run() {
            String[] importantInfo = {
                    "Important data 1",
                    "Important data 2",
                    "Important data 3",
                    "Important data 4"
            };

            try {
                for(int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I was not done!");
            }
        } // End of the run metod
    } // End of the Runnable -> MessageLoop Class


    public static void main(String args[]) throws InterruptedException {
        // Delay, in milliseconds, we interrupt MessageLoop
        // thread (default one hour).
        long patience = 1000 * 60 * 60; // in seconds.

        // If command line argument present, gives patience
        // in seconds.
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer.");
                System.exit(1);
            }
        }

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            try {
                Thread.sleep(1000); // For messageLoop thread
            } catch (InterruptedException e) {
                threadMessage("Interrupted!");
            }
            if ((System.currentTimeMillis() - startTime) > patience) {
                threadMessage("Tired of waiting!");
                break; // Exit the loop
            }
        }
        t.join(); // Wait indefinitely
        threadMessage("Finally!");
    }


} // End of the SimpleThreads_Join Class
