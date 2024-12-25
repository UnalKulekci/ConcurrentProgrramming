package Self_Study.S2;

public class Test {

    public static void main(String[] args) {

        Thread t1 = new HelloThread();
        Thread t2 = new Thread(new HelloRunnable());

        // Runnable Tanımı (Lambda Kullanımı):
        Runnable r = () -> System.out.println("Ben bir Runnable Programim.");
        Thread t3 = new Thread(r);

        t2.start();
        t3.start();
        t1.start();


    }
}
