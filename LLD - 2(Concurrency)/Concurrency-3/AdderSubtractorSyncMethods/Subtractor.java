import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void>{
    Count count;
    
    Subtractor(Count count){
        this.count = count;
    }

    public Void call() throws Exception{
        for(int i=1; i<100; i++){
            // count.value -= i;
            count.subtract(i);
        }
        return null;
    }
}
