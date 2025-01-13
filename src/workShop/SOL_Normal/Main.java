package workShop.SOL_Normal;

public class Main {

    public static void main(String[] args) {

        PrintQueue printQueue = new PrintQueue(5);

        for (int i = 1; i <= 3; i++) {
            Thread userThread = new Thread(new User(printQueue, "User_" + i));
            userThread.start();
        }

        for (int i = 1; i <= 2; i++) {
            Thread printerThread = new Thread(new Printer(printQueue, "Printer_" + i));
            printerThread.start();
        }
    }
} 