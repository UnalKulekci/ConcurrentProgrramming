package cp_5.slides_exmp.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();

        // Yazar iş parçacıkları oluşturma
        Thread writer1 = new WriterThread(map, "Writer-1", 1);
        Thread writer2 = new WriterThread(map, "Writer-2", 2);

        // Okuyucu iş parçacıkları oluşturma
        Thread reader1 = new ReaderThread((ConcurrentHashMap<Integer, String>) map, "Reader-1");
        Thread reader2 = new ReaderThread((ConcurrentHashMap<Integer, String>) map, "Reader-2");

        // İş parçacıklarını başlatma
        writer1.start();
        writer2.start();
        reader1.start();
        reader2.start();
    }
}
