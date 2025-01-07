package labs.dbis_joins;


// Stage 2: Assembling the product
public class AssemblingStage extends Stage {
    public AssemblingStage() {
        super("Stage 2: Assembling the product");
    }

    @Override
    protected void performTask() {
        try {
            Thread.sleep(3000); // Simulate assembly time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

