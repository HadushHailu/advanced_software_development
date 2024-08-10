package counter;

public abstract class CountDigitState {
    protected final Counter counter;
    CountDigitState(Counter counter){
        this.counter = counter;
    }
    abstract void decrement();
    abstract void increment();
}
