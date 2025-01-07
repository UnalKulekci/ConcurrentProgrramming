package labs.cp6.t_semaphoreforDogFeeding;

import java.util.concurrent.Semaphore;

public class BowlsSemaphores {
    private final Semaphore[] semaphores;

    public BowlsSemaphores(int numberOfBowls) {
        semaphores = new Semaphore[numberOfBowls];
        for (int i = 0; i < numberOfBowls; i++) {
            semaphores[i] = new Semaphore(1); // Her kase için bir mutex oluştur
        }
    }

    public Semaphore getSemaphore(int index) {
        return semaphores[index]; // Belirli bir kase için semaforu döner
    }
}
