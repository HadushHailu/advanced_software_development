package bank.integration;

import bank.service.IAccountService;

public class Logger extends LogSMSObserver {
    @Override
    public void doNotify(){
        String str = iAccountService.getLastChangedLog();
        sendLog(str);
    }

    public void sendLog(String str){
        System.out.println("Logger: " + str);
    }

    public Logger(IAccountService iAccountService){
        super(iAccountService);
    }
}
