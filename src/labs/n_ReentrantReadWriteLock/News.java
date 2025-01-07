package labs.n_ReentrantReadWriteLock;

import java.time.LocalDateTime;

public class News {
    private String news;
    private LocalDateTime date;
    public News(String news) {
        this.news = news;
        this.date = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "News{" +
                "news='" + news + '\'' +
                ", date=" + date +
                '}';
    }
}