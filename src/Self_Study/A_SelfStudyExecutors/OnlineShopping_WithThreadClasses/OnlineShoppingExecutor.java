package Self_Study.A_SelfStudyExecutors.OnlineShopping_WithThreadClasses;
import java.util.concurrent.Executor;

// Executor arayüzünü implement eden sınıf
public class OnlineShoppingExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        // Runnable görevini çalıştır
        command.run();
    }
}
