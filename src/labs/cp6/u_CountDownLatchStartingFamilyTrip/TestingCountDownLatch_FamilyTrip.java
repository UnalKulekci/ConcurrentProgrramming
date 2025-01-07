package labs.cp6.u_CountDownLatchStartingFamilyTrip;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class TestingCountDownLatch_FamilyTrip {
    public static void main(String[] args) throws InterruptedException {

        Vehicle seatAlhambra = new Vehicle(new ArrayList<>());
        seatAlhambra.printVehicleContent();

        String[] family = {"Jean", "Anna", "Joseph",
                "Martha", "Eleonore", "Paul", "Catarina"};

        // Create a countDownLatch
        CountDownLatch latch = new CountDownLatch(family.length);

        Thread[] threads = new Thread[family.length];
        for (int i = 0; i < family.length; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                try {
                    System.out.println(family[index] + " is getting ready.");
                    Thread.sleep((long) (Math.random() * 3000));
                    seatAlhambra.addPassenger(family[index] + "'s suitcase");
                    System.out.println(family[index] + " got into the vehicle.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
            threads[i].start();
        }

        latch.await();

        seatAlhambra.printVehicleContent();
        System.out.println("Family trip can start");
    }
}
