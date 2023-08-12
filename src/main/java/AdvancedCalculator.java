import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdvancedCalculator implements ICalculator{
    private final ExecutorService executorService =
            Executors.newSingleThreadExecutor();


    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }


}
