package labs.i_starvation;

public class TestingStarvation {
    public static void main(String[] args) {
        String sharedRoom = "Polaris";

        Employee e1 = new Employee("Emma", sharedRoom,1);
        Employee e2 = new Employee("Jean", sharedRoom,100);

        e1.start();
        e2.start();
        System.out.println("Main thread ended");

    }
}
