package bank.domain;

public class InterestStrategyFactory {
    private SavingInterestStrategy savingInterestStrategy;

    private InterestStrategyFactory(){}

    public static SavingInterestStrategy getSavingInterestStrategy(double balance){
        if(balance < 1000){
            return new SavingInterestClassA();
        } else if (balance >= 1000 && balance < 5000) {
            return new SavingInterestClassB();
        }
        else{
            return new SavingInterestClassC();
        }
    }

    public static CheckingInterestStrategy getCheckingInterestStrategy(double balance){
        if(balance < 1000){
            return new CheckingInterestClassA();
        }else{
            return new CheckingInterestClassB();
        }
    }

}
