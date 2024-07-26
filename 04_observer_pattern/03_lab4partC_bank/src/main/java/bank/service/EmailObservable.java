package bank.service;

import bank.integration.EmailObserver;

import java.util.ArrayList;
import java.util.Collection;

public class EmailObservable {
    private Collection<EmailObserver> emailObservers = new ArrayList<>();

    public void addObserver(EmailObserver emailObserver){
        emailObservers.add(emailObserver);
    }

    public void removeObserver(EmailObserver emailObserver){
        emailObservers.remove(emailObserver);
    }

    public void doNotify(){
        System.out.println("++ Sending notification ++");
        for(EmailObserver emailObserver:emailObservers){
            emailObserver.doNotify();
        }
    }
}
