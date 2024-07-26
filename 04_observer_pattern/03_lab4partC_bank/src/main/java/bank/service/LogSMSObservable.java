package bank.service;

import bank.integration.LogSMSObserver;

import java.util.ArrayList;
import java.util.Collection;

public class LogSMSObservable {
    private Collection<LogSMSObserver> observerCollection = new ArrayList<>();

    public void addObserver(LogSMSObserver bankObserver){
        observerCollection.add(bankObserver);
    }

    public void removeObserver(LogSMSObserver bankObserver){
        observerCollection.remove(bankObserver);
    }

    public void doNotify(){
        System.out.println("++ Sending notification ++");
        for(LogSMSObserver logSMSObserver:observerCollection){
            logSMSObserver.doNotify();
        }
    }
}
