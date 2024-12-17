package labs.q0_callable;

import java.util.concurrent.Callable;

public class CallableMultiplication implements Callable {

    private Integer id;
    private Integer x;
    private Integer y;

    public CallableMultiplication(Integer id, Integer x, Integer y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread #" + id + " started by the executor." );
        Thread.sleep(500);
        System.out.println("Thread #" + id + " is returning the result." );
        return x*y;
    }
}
