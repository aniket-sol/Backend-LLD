import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        List<Integer> list = List.of(2, 1, 7, 5, 10, 2, 9, 6, 20 , 40 ,50, 19, 16);

        ExecutorService ex = Executors.newCachedThreadPool();
        Sorter task = new Sorter(list, ex);

        Future<List<Integer>> finalFuture = ex.submit(task);
        list = finalFuture.get();
        System.out.println(list);
    }    
}
