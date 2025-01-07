package labs.cp6.t_semaphoreforDogFeeding;

import java.util.concurrent.Semaphore;

public class Breeder implements Runnable {
    public String name;
    private Semaphore mutexBreeder;

    public Breeder(String name, Semaphore mutex) {
        this.name = name;
        this.mutexBreeder = mutex; // Mutex'i al
    }

    @Override
    public void run() {
        // Kaseye yemek koyma
        for(int i = 0; i < 3; i++) { // 3 Kase icin
            try {
                mutexBreeder.acquire();
                System.out.println(name + " puts food into bowl " + i);
                Thread.sleep(1000); // Yemek koyma süresi
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutexBreeder.release();
            }
        }

        }

} // End of the Class
