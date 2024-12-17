package labs.p_executors_drums;

public class Drum implements Runnable {

    String notes;

    public Drum(String notes) {
        this.notes = notes;
    }

    @Override
    public void run() {
        System.out.println("Playing " +notes + ".");
    }

}
