package bank.service;

import java.util.Collection;
import bank.domain.Account;
import bank.integration.EmailObserver;
import bank.integration.LogSMSObserver;

public interface IAccountService {
    String getLastChangedLog();
    void addObserver(LogSMSObserver iLogObserver);
    void addEmailObserver(EmailObserver emailObserver);
    Account createAccount(long accountNumber, String customerName);
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
