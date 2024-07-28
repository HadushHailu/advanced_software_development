package counter;

public class OneDigit extends CountDigitState{
    OneDigit(Counter counter){
        super(counter);
    }

    private void checkForUpgrade(){
        if(counter.getCount() >= 10){
            CountDigitState newState = new TwoDigit(counter);
            counter.setCountDigitState(newState);
        }
    }

    @Override
    public void decrement(){
        counter.setCount(counter.getCount() - 1);
        this.checkForUpgrade();
    }
    @Override
    public void increment(){
        counter.setCount(counter.getCount() + 1);
        this.checkForUpgrade();
    }
}
