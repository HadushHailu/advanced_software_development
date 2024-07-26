package bank.integration;

import bank.service.IAccountService;

public class SMSSender extends LogSMSObserver {
    @Override
    public void doNotify(){
        String str = iAccountService.getLastChangedLog();
        sendSMS(str);
    }

    public void sendSMS(String str){
        System.out.println("SMSSender: " + str);
    }

    public SMSSender(IAccountService iAccountService){
        super(iAccountService);
    }
}
