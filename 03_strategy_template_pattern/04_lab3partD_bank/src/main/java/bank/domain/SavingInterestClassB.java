package bank.domain;

public class SavingInterestClassB implements SavingInterestStrategy {
    private final double rate = 0.02;

    public double getRate(){
        return rate;
    }
}
