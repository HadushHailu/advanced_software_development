package bank.service;

public class TransferFundsCommand implements ICommand{
    private IAccountService iAccountService;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private String description;

    public TransferFundsCommand(IAccountService iAccountService,
                         long fromAccountNumber, long toAccountNumber,
                         double amount,String description){
        this.iAccountService = iAccountService;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute(){
        iAccountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
    }

    @Override
    public void unExecute(){
        iAccountService.transferFunds(toAccountNumber, fromAccountNumber, amount, description);
    }
}
