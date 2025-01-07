package labs.dbis_joins;

// Stage 1: Preparing raw materials
public class PreparingStage extends Stage {
    public PreparingStage() {
        super("Stage 1: Preparing raw materials");
    }

    @Override
    protected void performTask() {
        try {
            Thread.sleep(2000); // Simulate preparation time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

