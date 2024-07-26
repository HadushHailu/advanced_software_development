package bank.service;

public class DepositCommand implements ICommand{
    private IAccountService iAccountService;
    private double amount;
    private long accountNumber;

    public DepositCommand(IAccountService iAccountService,
                          long accountNumber,
                          double amount){
        this.iAccountService = iAccountService;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute(){
        iAccountService.deposit(accountNumber, amount);
    }

    @Override
    public void unExecute(){
        iAccountService.withdraw(accountNumber,amount);
    }
}
