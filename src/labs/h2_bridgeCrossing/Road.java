package labs.h2_bridgeCrossing;

public class Road {

    private String position;
    public Road(String position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return position + " road";
    }
}
