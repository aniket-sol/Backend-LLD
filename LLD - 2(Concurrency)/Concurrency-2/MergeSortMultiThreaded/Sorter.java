import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
    List<Integer> arrayToSort;
    ExecutorService ex;

    Sorter(List<Integer> arrayToSort, ExecutorService ex){
        this.arrayToSort = arrayToSort;
        this.ex = ex;
    }
    
    public List<Integer> call() throws Exception{
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int mid = arrayToSort.size()/2;

        //Left Half
        List<Integer> leftHalf = new ArrayList<>();
        for(int i=0; i<mid; i++){
            leftHalf.add(arrayToSort.get(i));
        }

        //Right Half
        List<Integer> rightHalf = new ArrayList<>();
        for(int i=mid; i<arrayToSort.size(); i++){
            rightHalf.add(arrayToSort.get(i));
        }

        Sorter taskForLeft = new Sorter(leftHalf, ex);
        Sorter taskForRight = new Sorter(rightHalf, ex);

        Future<List<Integer>> leftFuture  = ex.submit(taskForLeft);
        Future<List<Integer>> rightFuture  = ex.submit(taskForRight);

        leftHalf = leftFuture.get();
        rightHalf = rightFuture.get();

        List<Integer> finalSortedList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i<leftHalf.size() && j<rightHalf.size()){
            if(leftHalf.get(i) < rightHalf.get(j)){
                finalSortedList.add(leftHalf.get(i));
                i++;
            }else{
                finalSortedList.add(rightHalf.get(j));
                j++;
            }
        }

        while(i<leftHalf.size()){
            finalSortedList.add(leftHalf.get(i));
            i++;
        }

        while(j<rightHalf.size()){
            finalSortedList.add(rightHalf.get(j));
            j++;
        }

        return finalSortedList;
    }
}
