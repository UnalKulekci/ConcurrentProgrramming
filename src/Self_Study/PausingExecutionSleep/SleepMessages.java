package Self_Study.PausingExecutionSleep;


public class SleepMessages {
    public static void main(String args[])
            throws InterruptedException {

        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            // Dört saniye beklet
            Thread.sleep(4000);
            // Mesajı yazdır
            System.out.println(importantInfo[i]);
        }
    }


} // End of the SleepMessages Class

