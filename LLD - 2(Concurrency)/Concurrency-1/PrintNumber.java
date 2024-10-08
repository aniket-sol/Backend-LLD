public class PrintNumber implements Runnable{
    int noToPrint;

    PrintNumber(int noToPrint){
        this.noToPrint = noToPrint;
    }
    public void run(){
        System.out.println("Thread printing" + Thread.currentThread().getName());
    }
}
