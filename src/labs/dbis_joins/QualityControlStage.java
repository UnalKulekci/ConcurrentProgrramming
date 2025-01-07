package labs.dbis_joins;

// Stage 3: Quality control
public class QualityControlStage extends Stage {
    public QualityControlStage() {
        super("Stage 3: Quality control");
    }

    @Override
    protected void performTask() {
        try {
            Thread.sleep(1500); // Simulate quality control time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

