package domain;

public class OddCounterGreaterThan15Not_17_19 extends CounterHandler{
    public OddCounterGreaterThan15Not_17_19(CounterHandler counterHandler){
        super(counterHandler);
    }

    @Override
    public void handle(int count){
        if((count%2 == 1 && count < 15) || count == 17 || count == 19){
            System.out.println("BLUE");
        }else{
            nextHandler.handle(count);
        }
    }
}
