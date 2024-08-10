package counter;

public class Increment implements ICommand{
    private Counter counter;

    public Increment(Counter counter){
        this.counter = counter;
    }

    @Override
    public void execute(){
        counter.increment();
    }

    @Override
    public void unExecute(){
        counter.decrement();
    }
}
