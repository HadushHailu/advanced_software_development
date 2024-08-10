package domain;

public class EvenCounterGreaterThan10Not_12_13 extends CounterHandler{
    public EvenCounterGreaterThan10Not_12_13(CounterHandler counterHandler){
        super(counterHandler);
    }

    @Override
    public void handle(int count){
        if((count%2 == 0 && count >= 10) && count != 12){
            System.out.println("GREEN");
        }else{
            nextHandler.handle(count);
        }
    }
}
