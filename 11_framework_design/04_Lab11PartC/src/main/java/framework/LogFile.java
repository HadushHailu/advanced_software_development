package framework;

public class LogFile implements Observers{
    public void update(double speed){
        System.out.println("logged: speed: "+speed);
    }
}
