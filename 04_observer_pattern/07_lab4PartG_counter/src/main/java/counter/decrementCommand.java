package counter;

public class decrementCommand implements ICommand{
    private Counter counter;

    public decrementCommand(Counter counter){
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
