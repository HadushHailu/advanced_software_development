package bank.service;

import java.util.Collection;
import bank.domain.Account;

public interface IAccountService {
    Account createAccountChecking(long accountNumber, String customerName);
    Account createAccountSaving(long accountNumber, String customerName);
    void addInterest();
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
}
