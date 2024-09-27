public class Instructor extends User{
    String roleType;
    double avgRating;
    void scheduleClass(){
        System.out.println("Instructor is scheduling class");
    }
    void startSession(){
        System.out.println("Instructor is starting a session");
    }
    Instructor(){
        System.out.println("Instructor constructor is called");
    }
    
}
