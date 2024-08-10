package domain;

public class Logger implements ICountFroLoggersObserver {
    @Override
    public void update(int count){
        System.out.println("Count logged to file="+count);
    }
}
