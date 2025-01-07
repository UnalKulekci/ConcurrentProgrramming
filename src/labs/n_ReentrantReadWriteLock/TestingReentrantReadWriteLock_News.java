import labs.n_ReentrantReadWriteLock.News;
import labs.n_ReentrantReadWriteLock.NewsFeed;

// Main class for testing the news feed
public class TestingReentrantReadWriteLock_News {
    public static void main(String[] args) {
        NewsFeed newsFeed = new NewsFeed();

        // Add initial news
        newsFeed.put(new News("START OF NEWS"));

        // Producer thread to produce news
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 200; i++) {
                newsFeed.put(new News("News " + i));
                try {
                    Thread.sleep(10); // Simulate delay in producing news
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Reader threads to read news
        for (int i = 0; i < 20; i++) {
            Thread reader = new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    News news = newsFeed.read();
                    if (news != null) {
                        System.out.println(Thread.currentThread().getName() + " read: " + news);
                    }
                    try {
                        Thread.sleep(50); // Simulate delay in reading news
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            reader.start();
        }

        // Start the producer thread
        producer.start();
    }
}
