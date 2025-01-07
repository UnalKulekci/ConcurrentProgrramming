package labs.cp6.u_CountDownLatchStartingFamilyTrip;

import java.util.ArrayList;

public class Vehicle {

    ArrayList<String> passengers;

    public Vehicle(ArrayList<String> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(String passenger) {
        passengers.add(passenger);
    }


    public void printVehicleContent() {
        if (passengers.isEmpty()) {
            System.out.println("Vehicle content: []");
        } else {
            System.out.println("Vehicle content: [" + String.join(", ", passengers) + "]");
        }
    }
}
