package cp_5.s1_ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class FarmSimulation {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> boxes = new ConcurrentHashMap<>();

        Thread farmer1 = new Farmer("Verena", boxes);
        Thread farmer2 = new Farmer("Pierre", boxes);

        Thread[] cows = new Thread[10];
        for (int i = 0; i < cows.length; i++) {
            cows[i] = new Cow("Cow" + (i + 1), boxes);
        }


        farmer1.start();
        farmer2.start();


        for (Thread cow : cows) {
            cow.start();
        }
    }
}
