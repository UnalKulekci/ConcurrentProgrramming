package labs.h2_bridgeCrossing;

public class Vehicle implements Runnable {

    String name;
    private Bridge bridge;
    private Road road;

    public Vehicle(String name, Bridge bridge, Road road) {
        this.name = name;
        this.bridge = bridge;
        this.road = road;
    }

    @Override
    public void run() {
        // Do the actions to cross the bridge
        synchronized (road) {
            System.out.println(name + " is entering on the one-way bridge from " + road);
            synchronized (road == bridge.getRoadEast() ?
                    bridge.getRoadWest():
                    bridge.getRoadEast()) {
                System.out.println(name + " is leaving the one-way bridge");
            }
        }
    }
}

/*
BMW is entering on the one-way bridge from West road
Ferrari is entering on the one-way bridge from East road
Ferrari is leaving the one-way bridge
BMW is leaving the one-way bridge
 */