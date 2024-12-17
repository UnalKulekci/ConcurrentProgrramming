package labs.q1_callablePizza_exmp;

import java.util.concurrent.Callable;

public class Pizzaiolo implements Callable {

    private String name;

    public Pizzaiolo(String name) {
        this.name = name;
    }

    @Override
    public Pizza call() throws Exception {

        System.out.println(name + " got a pizza requested ");
        Pizza pizza = new Pizza();

        pizza.prepare();
        pizza.bake();
        pizza.cut();

        System.out.println("Pizza is ready to serve");
        return pizza;
    }
}
