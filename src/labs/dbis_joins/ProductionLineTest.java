package labs.dbis_joins;

public class ProductionLineTest {

    public static void main(String[] args) {

        Stage stage1 = new PreparingStage();
        Stage stage2 = new AssemblingStage();
        Stage stage3 = new QualityControlStage();

        try {
            stage1.start();
            stage1.join(); // Wait for stage 1 to complete

            stage2.start();
            stage2.join(); // Wait for stage 2 to complete

            stage3.start();
            stage3.join(); // Wait for stage 3 to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
