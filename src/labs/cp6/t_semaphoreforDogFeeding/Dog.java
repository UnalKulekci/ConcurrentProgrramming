package labs.cp6.t_semaphoreforDogFeeding;

import java.util.concurrent.Semaphore;

public class Dog implements Runnable {
    private Semaphore mutexDog;
    private String name;

    public Dog(String name, Semaphore mutex) {
        this.name = name;
        this.mutexDog = mutex; // Mutex'i al
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // 3 kase için döngü
            try {
                mutexDog.acquire(); // Mutex'i al
                System.out.println(name + " is eating in bowl " + i);
                Thread.sleep(1000); // Yemek yeme süresi
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutexDog.release(); // Mutex'i serbest bırak
            }
        }
    }
}