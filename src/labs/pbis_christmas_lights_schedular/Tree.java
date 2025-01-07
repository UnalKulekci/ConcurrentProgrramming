package labs.pbis_christmas_lights_schedular;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Tree {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(3);

        // Tekil ışıklar oluşturulup zamanlanıyor
        Light light1 = new Light(10);
        Light light2 = new Light(20);
        Light light3 = new Light(30);

        executorService.scheduleAtFixedRate(light1, 0, light1.getDelay(), TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(light2, 0, light2.getDelay(), TimeUnit.MILLISECONDS);
        executorService.scheduleAtFixedRate(light3, 0, light3.getDelay(), TimeUnit.MILLISECONDS);

        // Tüm ışıkları içeren zincir ekleniyor
        LightsChain lightsChain = new LightsChain();
        executorService.scheduleAtFixedRate(lightsChain, 0, 250, TimeUnit.MILLISECONDS);

        // Programın çalışmasını uzatmak için bekleme süresi eklenebilir
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down executor...");
            executorService.shutdown();
        }));
    }
}
