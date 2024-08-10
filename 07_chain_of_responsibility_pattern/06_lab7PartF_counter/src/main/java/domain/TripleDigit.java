package domain;

public class TripleDigit extends CountDigitState {
    public TripleDigit(Counter counter){
        super(counter);
    }

    private void checkForUpgrade(){
        if(counter.getCount() < 100){
            CountDigitState newState = new DoubleDigit(counter);
            counter.setCountDigitState(newState);
        }
    }
    @Override
    public void decrement(){
        counter.setCount(counter.getCount() - 3);
        this.checkForUpgrade();
    }
    @Override
    public void increment(){
        counter.setCount(counter.getCount() + 3);
        this.checkForUpgrade();
    }
}
