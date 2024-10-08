import java.lang.reflect.Executable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        Count count = new Count();
        ExecutorService ex = Executors.newCachedThreadPool();

        Adder task1 = new Adder(count);
        Subtractor task2 = new Subtractor(count);

        Future<Void> adder = ex.submit(task1);
        Future<Void> subtract = ex.submit(task2);

        adder.get();
        subtract.get();

        System.out.println(count.value);
    }    
}
