package domain;

public class EvenCounterLessThan10_12_13 extends CounterHandler{
    public EvenCounterLessThan10_12_13(CounterHandler counterHandler){
        super(counterHandler);
    }

    @Override
    public void handle(int count){
        if((count%2 == 0 && count < 10) || count == 12 || count == 13){
            System.out.println("RED");
        }else{
            nextHandler.handle(count);
        }
    }
}
