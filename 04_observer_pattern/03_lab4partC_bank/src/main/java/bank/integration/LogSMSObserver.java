package bank.integration;

import bank.service.IAccountService;

public abstract class LogSMSObserver {
    IAccountService iAccountService;

    public LogSMSObserver(IAccountService iAccountService){
        this.iAccountService = iAccountService;
    }
    abstract public void doNotify();
}
