package Self_Study.A_SelfStudyExecutors.OnlineShopping_WithThreadClasses;

public class KargoHazirligiThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Kargo Hazirligi yapiliyor..");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Kargo Hazirligi tamamlandi..");
    }
}
