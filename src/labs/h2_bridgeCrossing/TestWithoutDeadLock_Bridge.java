package labs.h2_bridgeCrossing;

public class TestWithoutDeadLock_Bridge {

    public static void main(String[] args) throws InterruptedException {

        Bridge bridge = new Bridge();

        Thread bmw = new Thread(new VehicleWithoutDeadlock("BMW", bridge, bridge.getRoadWest()));
        Thread ferrari = new Thread(new VehicleWithoutDeadlock("Ferrari", bridge, bridge.getRoadEast()));

        // BMW önce köprüye girer
        bmw.start();
        bmw.join(); // BMW'nin işlemini tamamlamasını bekler

        // Ferrari daha sonra köprüye girer
        ferrari.start();
        ferrari.join(); // Ferrari'nin işlemini tamamlamasını bekler
    }
}


