package labs.n_ReentrantReadWriteLock;

import java.util.Stack;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// NewsFeed class for managing the news feed
public class NewsFeed {

    private final Stack<News> stack = new Stack<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    // Producer adds news to the stack
    public void put(News news) {
        lock.writeLock().lock();
        try {
            stack.push(news);
        } finally {
            lock.writeLock().unlock();
        }
    }

    // Reader reads the latest news without removing it
    public News read() {
        lock.readLock().lock();
        try {
            return stack.isEmpty() ? null : stack.peek();
        } finally {
            lock.readLock().unlock();
        }
    }
}
