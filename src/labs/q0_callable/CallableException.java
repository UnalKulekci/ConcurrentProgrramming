package labs.q0_callable;

import java.util.concurrent.Callable;

public class CallableException implements Callable {

    private Integer id;
    public CallableException(Integer id) {
        this.id = id;
    }

    @Override
    public Exception call() throws Exception {
        System.out.println("Thread #" + id + " started by the executor.");
        Thread.sleep(500);
        throw new Exception("Exception thrown from another thread.");
    }
}