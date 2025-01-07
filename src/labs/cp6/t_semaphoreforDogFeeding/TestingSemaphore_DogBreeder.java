package labs.cp6.t_semaphoreforDogFeeding;

public class TestingSemaphore_DogBreeder {
    public static void main(String[] args) {
        BowlsSemaphores bowlsSemaphores = new BowlsSemaphores(3); // 3 kase

        new Thread(new Breeder("Marco", bowlsSemaphores.getSemaphore(0))).start();
        new Thread(new Breeder("Luisa", bowlsSemaphores.getSemaphore(1))).start();

        for (int i = 1; i <= 10; i++) {
            new Thread(new Dog("Dog" + i, bowlsSemaphores.getSemaphore(i % 3))).start(); // 10 köpek
        }
    }
}
