package cp_5.s1_ConcurrentHashMap;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

// Bunu da writer thread gibi dusun
public class Farmer extends Thread {
    private ConcurrentHashMap<Integer, Integer> map; // Kutular için
    private String farmerName;
    private Random random;

    public Farmer(String name, ConcurrentHashMap<Integer, Integer> map) {
        this.farmerName = name;
        this.map = map;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            int box = random.nextInt(3); // 0, 1 veya 2 kutusunu seç
            int foodUnits = random.nextInt(100); // 0-99 arasında rastgele yiyecek birimi
            map.put(box, foodUnits); // Kutunun içeriğini güncelle
            System.out.println(farmerName + " put " + foodUnits + " food units into box" + box);

            try {
                Thread.sleep(1000); // Bir süre bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
