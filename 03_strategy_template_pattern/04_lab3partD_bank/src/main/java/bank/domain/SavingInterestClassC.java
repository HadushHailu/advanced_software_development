package bank.domain;

public class SavingInterestClassC implements SavingInterestStrategy {
    private final double rate = 0.04;

    public double getRate(){
        return rate;
    }
}
