package bank.service;

import java.util.Collection;

import bank.abstractFactory.BankFactory;
import bank.abstractFactory.MyFactory;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.dao.MockAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.email.IEmailSender;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private IEmailSender emailSender;
	private IEmailSender emailSender2;


	public AccountService(){
		BankFactory bankFactory = new BankFactory();
		MyFactory myFactory = bankFactory.getFactoryInstance();
		this.accountDAO = myFactory.getAccountDAO();
		this.emailSender = myFactory.getEmailSender();
		this.emailSender2 = myFactory.getEmailSender();

		System.out.println("emailSender: " + emailSender);
		System.out.println("emailSender2: " + emailSender2);

	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		emailSender.send("create account " + accountNumber);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
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
	}

	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
