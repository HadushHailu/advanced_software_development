package bank.integration;

import bank.service.IAccountService;

public class EmailSender extends EmailObserver {
    @Override
    public void doNotify(){
        String str = iAccountService.getLastChangedLog();
        sendEmail(str);
    }

    public void sendEmail(String str){
        System.out.println("Email sender: " + str);
    }

    public EmailSender(IAccountService iAccountService){
        super(iAccountService);
    }
}
