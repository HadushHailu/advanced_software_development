package bank.domain;

public class CheckingInterestClassB implements CheckingInterestStrategy{
    private final double rate = 0.025;

    public double getRate(){
        return rate;
    }
}
