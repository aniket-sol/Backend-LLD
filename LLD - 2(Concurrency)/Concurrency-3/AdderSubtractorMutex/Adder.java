import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void>{
    Count count;
    Lock lock;

    Adder(Count count, Lock lock){
        this.count = count;
        this.lock = lock;
    }

    public Void call() throws Exception{
        for(int i=1; i<100; i++){
            lock.lock();
            // System.out.println("Thread printing" + Thread.currentThread().getName());
            count.value += i;
            lock.unlock();
        }
        return null;
    }
}
