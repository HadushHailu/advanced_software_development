package domain;

public class decrement implements ICommand{
    private Counter counter;

    public decrement(Counter counter){
        this.counter = counter;
    }

    @Override
    public void execute(){
        counter.decrement();
    }

    @Override
    public void unExecute(){
        counter.increment();
    }

}
