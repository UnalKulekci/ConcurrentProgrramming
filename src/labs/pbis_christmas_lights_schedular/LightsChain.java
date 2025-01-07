package labs.pbis_christmas_lights_schedular;

import java.util.LinkedList;

public class LightsChain implements Runnable {

    private LinkedList<Light> lights = new LinkedList<>();

    public LightsChain() {

        // Farklı zaman gecikmeleri ile ışıklar eklenir
        lights.add(new Light(100));
        lights.add(new Light(200));
        lights.add(new Light(300));
    }

    @Override
    public void run() {
        for (Light light : lights) {
            light.flicker();
            try {
                Thread.sleep(light.getDelay());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error: Lights chain interrupted.");
            }
        }
        System.out.println("\n");
    }
}
