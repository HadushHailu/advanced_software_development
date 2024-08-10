package domain;

public abstract class CounterHandler {
    protected CounterHandler nextHandler;
    public CounterHandler(){}
    public CounterHandler(CounterHandler counterHandler){
        this.nextHandler = counterHandler;
    }

    public abstract void handle(int count);
}
