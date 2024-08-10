package counter;

public class DoubleDigit extends CountDigitState{
    DoubleDigit(Counter counter){
        super(counter);
    }

    private void checkForUpgrade(){
        if(counter.getCount() >= 100){
            CountDigitState newState = new TripleDigit(counter);
            counter.setCountDigitState(newState);
        }
        if(counter.getCount() < 10){
            CountDigitState newState = new SingleDigit(counter);
            counter.setCountDigitState(newState);
        }
    }

    @Override
    public void decrement(){
        counter.setCount(counter.getCount() - 2);
        this.checkForUpgrade();
    }
    @Override
    public void increment(){
        counter.setCount(counter.getCount() + 2);
        this.checkForUpgrade();
    }
}
