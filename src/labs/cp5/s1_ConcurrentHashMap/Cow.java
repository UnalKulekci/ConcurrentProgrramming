package labs.cp5.s1_ConcurrentHashMap;


import java.util.concurrent.ConcurrentHashMap;

// Bunu Reader Thread gibi dusun
public class Cow extends Thread {

    private ConcurrentHashMap<Integer, Integer> map;
    private String cowName;
    public Cow(String name, ConcurrentHashMap<Integer, Integer> map) {
        this.cowName = name;
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            int box = (int) (Math.random() * 3); // 0, 1 veya 2 kutusunu seç
            Integer foodUnits = map.get(box); // Kutunun içeriğini al

            if (foodUnits != null && foodUnits > 0) {
                System.out.println(cowName + " ate " + foodUnits + " food units from box" + box);
                map.put(box, 0); // Kutudaki yiyecekleri sıfırla
            } else {
                System.out.println(cowName + " ate nothing");
            }

            try {
                Thread.sleep(500); // Bir süre bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
