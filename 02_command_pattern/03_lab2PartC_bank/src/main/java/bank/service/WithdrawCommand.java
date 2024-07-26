package bank.service;

public class WithdrawCommand implements ICommand{
    private IAccountService iAccountService;
    private double amount;
    private long accountNumber;

    public WithdrawCommand(IAccountService iAccountService,
                    long accountNumber,
                    double amount){
        this.iAccountService= iAccountService;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    @Override
    public void execute(){
        iAccountService.withdraw(accountNumber, amount);
    }

    @Override
    public void unExecute(){
        iAccountService.deposit(accountNumber, amount);
    }
}
