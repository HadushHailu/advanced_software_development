package bank.integration;

import bank.service.IAccountService;

public abstract class EmailObserver {
    IAccountService iAccountService;

    public EmailObserver(IAccountService iAccountService){
        this.iAccountService = iAccountService;
    }
    abstract public void doNotify();
}
