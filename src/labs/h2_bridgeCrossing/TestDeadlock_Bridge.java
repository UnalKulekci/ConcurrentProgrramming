package labs.h2_bridgeCrossing;

public class TestDeadlock_Bridge {

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        (new Thread(new Vehicle("Ferrari", bridge,
                bridge.getRoadEast()))).start();
        (new Thread(new Vehicle("BMW", bridge,
                bridge.getRoadWest()))).start();

        /* Version without DeadLock
        (new Thread(new VehicleWithoutDeadlock("Ferrari", bridge,
        bridge.getRoadEast()))).start();
        (new Thread(new VehicleWithoutDeadlock("BMW", bridge,
        bridge.getRoadWest()))).start();
        */

    }
}
