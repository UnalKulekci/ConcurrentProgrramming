package labs.p_executors_drums;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Partition {

    public static void main(String[] args) {

        Drum bassDrum = new Drum("Bass Drum");
        Drum floortom = new Drum("Floor Tom");
        Drum snareDrum = new Drum("Snare Drum");
        Drum rackTom = new Drum("Rack Tom");
        Drum hiHat = new Drum("Hi-Hat");
        Drum crashCymbal = new Drum("Crash Cymbal");
        Drum rideCymbal = new Drum("Ride Cymbal");
        Drum splashCymbal = new Drum("Splash Cymbal");
        Drum chinaCymbal = new Drum("China Cymbal");

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(9);
        // ScheduledExecutorService executor2 = Executors.newSingleThreadScheduledExecutor()
        int initialDelay = 1000;
        int quaver = 500; // croche
        int crotchet = 1000; // noire
        int minim = 2000; // blanche

        TimeUnit unit = TimeUnit.MILLISECONDS;

        // bassDrum 20000 de ms sonra calmaya baslayacak.
        executor.schedule(bassDrum, 20000, unit);

        executor.scheduleAtFixedRate(floortom, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(snareDrum, initialDelay, minim, unit);
        executor.scheduleAtFixedRate(rackTom, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(hiHat, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(crashCymbal, initialDelay, minim, unit);
        executor.scheduleAtFixedRate(rideCymbal, initialDelay, quaver, unit);
        executor.scheduleAtFixedRate(splashCymbal, initialDelay, crotchet, unit);
        executor.scheduleAtFixedRate(chinaCymbal, initialDelay, minim, unit);

    }
}
