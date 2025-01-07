package labs.i_starvation;

public class Employee extends Thread {

    private String name;
    private String room;
    private int exaggeratedTimeUsageFactor;

    public Employee(String name, String room, int exaggeratedTimeUsageFactor) {
        this.name = name;
        this.room = room;
        this.exaggeratedTimeUsageFactor = exaggeratedTimeUsageFactor;
    }

    public synchronized void useRoom(int time) {
        System.out.println(name + " uses room for " + time + " seconds");

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        System.out.println(name + " started");
        while (true) {
            useRoom(100 * exaggeratedTimeUsageFactor);
        }
    }
}
