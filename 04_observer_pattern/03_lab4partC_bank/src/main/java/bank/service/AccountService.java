package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.integration.EmailObserver;
import bank.integration.LogSMSObserver;


public class AccountService extends LogSMSObservable implements IAccountService {
	private IAccountDAO accountDAO;
	private String lastChangedLog;
	private EmailObservable emailObservable;

	public String getLastChangedLog() {
		return lastChangedLog;
	}

	@Override
	public void addObserver(LogSMSObserver iLogObserver){
		super.addObserver(iLogObserver);
	}
	public AccountService(){
		accountDAO=new AccountDAO();
		emailObservable = new EmailObservable();
	}

	public void addEmailObserver(EmailObserver emailObserver){
		emailObservable.addObserver(emailObserver);
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		this.lastChangedLog = "Account created: accNumber " + accountNumber;
		emailObservable.doNotify();
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		this.lastChangedLog = "Deposit Made accNumber: " + accountNumber;
		super.doNotify();
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		this.lastChangedLog = "Withdrawal Made accNumber: " + accountNumber;
		super.doNotify();
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		this.lastChangedLog = "Transfer Made FromAccNumber: "+ fromAccountNumber;
		super.doNotify();
	}
}
