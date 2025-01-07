package Self_Study.Join;

// Runnable interface'ini implement eden sınıf
public class MyRunnableJoin implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread started ::: " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished ::: " + Thread.currentThread().getName());
    }
}

