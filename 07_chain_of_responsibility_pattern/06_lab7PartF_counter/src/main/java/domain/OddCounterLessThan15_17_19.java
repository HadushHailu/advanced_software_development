package domain;

public class OddCounterLessThan15_17_19 extends CounterHandler{

    public OddCounterLessThan15_17_19(){
    }

    @Override
    public void handle(int count){
        if((count%2 == 1 && count >= 15) && count != 17 && count != 19){
            System.out.println("Orange");
        }
    }
}
