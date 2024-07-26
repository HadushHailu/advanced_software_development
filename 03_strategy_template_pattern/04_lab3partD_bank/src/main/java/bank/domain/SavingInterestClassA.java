package bank.domain;

public class SavingInterestClassA implements SavingInterestStrategy {
    private final double rate = 0.01;

    public double getRate(){
        return rate;
    }
}
