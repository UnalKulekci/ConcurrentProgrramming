package labs.dbis_joins;
import java.util.ArrayList;
import java.util.List;

public class ProductionLine {

    public static void main(String[] args) {

        // Stage 1: Preparing raw materials
        Thread stage1 = new Thread(() -> {
            System.out.println("Stage 1: Preparing raw materials...");
            try {
                Thread.sleep(2000); // Simulate time for preparation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stage 1: Completed raw materials preparation.");
        });

        // Stage 2: Assembling the product
        Thread stage2 = new Thread(() -> {
            System.out.println("Stage 2: Assembling the product...");
            try {
                Thread.sleep(3000); // Simulate time for assembly
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stage 2: Completed product assembly.");
        });

        // Stage 3: Quality control
        Thread stage3 = new Thread(() -> {
            System.out.println("Stage 3: Quality control...");
            try {
                Thread.sleep(1500); // Simulate time for quality control
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stage 3: Quality control completed.");
        });

        // Start and manage threads sequentially
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

