package labs.dbis_joins;

public abstract class Stage extends Thread {
    private String stageName;

    public Stage(String stageName) {
        this.stageName = stageName;
    }

    @Override
    public void run() {
        System.out.println(stageName + ": Starting...");
        performTask();
        System.out.println(stageName + ": Completed.");
    }

    // Her aşamanın özelleştireceği iş metodu
    protected abstract void performTask();
}

