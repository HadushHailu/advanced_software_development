package counter;

public class incrementCommand implements ICommand{
    private Counter counter;

    public incrementCommand(Counter counter){
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
