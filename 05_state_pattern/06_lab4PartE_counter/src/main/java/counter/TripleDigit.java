package counter;

public class ThreeDigit extends CountDigitState{
    ThreeDigit(Counter counter){
        super(counter);
    }

    private void checkForUpgrade(){
        if(counter.getCount() < 100){
            CountDigitState newState = new TwoDigit(counter);
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
