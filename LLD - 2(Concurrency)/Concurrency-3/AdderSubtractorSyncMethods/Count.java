public class Count {
    int value = 0;
    synchronized void add(int x){
        this.value += x;
    }
    synchronized void subtract(int x){
        this.value -= x;
    } 
}
