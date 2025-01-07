package labs.pbis_christmas_lights_schedular;

public class Light implements Runnable {

    private Boolean isOn;
    private Integer delay;

    public Light(Integer delay) {
        this.isOn = false;
        this.delay = delay;
    }

    public Integer getDelay() {
        return delay;
    }

    public void flicker() {
        isOn = !isOn;
        System.out.print(isOn ? "🟡" : "⭕");
    }

    @Override
    public void run() {
        flicker();
    }
}
