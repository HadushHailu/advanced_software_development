package bank.domain;

public class CheckingInterestClassA implements CheckingInterestStrategy{
    private final double rate = 0.015;

    public double getRate(){
        return rate;
    }
}
