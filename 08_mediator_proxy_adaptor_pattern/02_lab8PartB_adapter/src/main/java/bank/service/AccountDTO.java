package bank.service;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    long accountnumber;
    Collection<AccountEntryDTO> entryList = new ArrayList<>();
    CustomerDTO customer;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountDTO() {
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Collection<AccountEntryDTO> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntryDTO> entryList) {
        this.entryList = entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
