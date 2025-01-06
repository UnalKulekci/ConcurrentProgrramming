package labs.cp5.r_blockingQueue;

class Package {

    private String sender;
    private int packageId;
    private static int nextId = 1;
    public Package(String sender) {
        this.sender = sender;
        this.packageId = nextId++;
    }

    @Override
    public String toString() {
        return "Package-" + packageId + " from " + sender;
    }
}
