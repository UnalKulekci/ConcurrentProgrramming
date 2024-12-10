package labs.h2_bridgeCrossing;

public class Bridge {

    private Road roadEast = new Road("East");
    private Road roadWest = new Road("West");

    public Road getRoadEast() {
        return roadEast;
    }

    public Road getRoadWest() {
        return roadWest;
    }
}
