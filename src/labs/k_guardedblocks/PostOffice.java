package labs.k_guardedblocks;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;

public class PostOffice {

    private final LinkedList<Package> packages = new LinkedList<>();
    private final int CAPACITY = 5;

    // Paket ekleme (müşteri)
    public synchronized void addPackage(Package pkg) throws InterruptedException {
        while (packages.size() == CAPACITY) {
            System.out.println("Post office full! " + pkg + " is waiting.");
            wait(); // Kapasite doluysa bekle
        }
        packages.add(pkg);
        System.out.println("Package added: " + pkg);
        notifyAll(); // Postacıları haberdar et
    }

    // Paket teslim alma (postacı)
    public synchronized Package deliverPackage() throws InterruptedException {
        while (packages.isEmpty()) {
            System.out.println("No packages available! Postman is waiting.");
            wait(); // Liste boşsa bekle
        }
        Package pkg = packages.removeFirst();
        notifyAll(); // Müşterileri haberdar et
        return pkg;
    }
}

