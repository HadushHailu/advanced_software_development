package bank.domain;

public class SavingAccount extends Account{
    public SavingAccount(long accountnr){
        super(accountnr);
    }

    @Override
    public double getRate(double balance){
        SavingInterestStrategy savingInterestStrategy = InterestStrategyFactory.getSavingInterestStrategy(balance);
        return savingInterestStrategy.getRate();
    }
}
