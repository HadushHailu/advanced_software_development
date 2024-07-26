package bank.domain;

public class CheckingAccount extends Account{

    public CheckingAccount(long accountnr){
        super(accountnr);
    }

    @Override
    public double getRate(double balance){
        CheckingInterestStrategy checkingInterestStrategy = InterestStrategyFactory.getCheckingInterestStrategy(balance);
        return checkingInterestStrategy.getRate();
    }
}
