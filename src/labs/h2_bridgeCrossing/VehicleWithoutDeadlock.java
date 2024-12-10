package labs.h2_bridgeCrossing;

public class VehicleWithoutDeadlock implements  Runnable{

    String name;
    private Bridge bridge;
    private Road road;

    public VehicleWithoutDeadlock(String name, Bridge bridge, Road road) {
        this.name = name;
        this.bridge = bridge;
        this.road = road;
    }

    /*
    @Override
    public void run() {
        // Köprü için tek bir kilit kullanarak deadlock'u önlüyoruz
        synchronized (bridge) {
            System.out.println(name + " is entering on the one-way bridge from " + road);
            try {
                Thread.sleep(100); // Köprü üzerinde geçiş süresini simüle ediyoruz
            } catch (InterruptedException e) {
                e.printStackTrace(); // Hata durumunda istisna yığını yazdırılır
            }
            System.out.println(name + " is leaving the one-way bridge");
        }
    }
     */

    @Override
    public void run() {
        Road firstRoad = bridge.getRoadEast().hashCode() < bridge.getRoadWest().hashCode()
                ? bridge.getRoadEast() : bridge.getRoadWest();
        Road secondRoad = bridge.getRoadEast().hashCode() >= bridge.getRoadWest().hashCode()
                ? bridge.getRoadEast() : bridge.getRoadWest();

        synchronized (firstRoad) { // Her zaman önce düşük hash kodlu yol kilitlenir
            System.out.println(name + " is entering on the one-way bridge from " + road);
            synchronized (secondRoad) { // Daha sonra yüksek hash kodlu yol kilitlenir
                System.out.println(name + " is leaving the one-way bridge");
            }
        }
    }


}
