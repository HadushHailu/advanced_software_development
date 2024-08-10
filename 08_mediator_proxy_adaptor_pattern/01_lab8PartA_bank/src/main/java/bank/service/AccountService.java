package bank.service;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private ClassLoader classLoader = IAccountDAO.class.getClassLoader();
	IAccountDAO accountDAOLogProxy;
	IAccountDAO accountDAOTimingProxy;

	
	public AccountService(){
		accountDAO=new AccountDAO();
		accountDAOTimingProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader,
				new Class[] { IAccountDAO.class },
				new TimingProxy(accountDAO));
		accountDAOLogProxy = (IAccountDAO) Proxy.newProxyInstance(classLoader,
						new Class[] { IAccountDAO.class },
						new LoggingProxy(accountDAOTimingProxy));
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAOLogProxy.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAOLogProxy.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAOLogProxy.updateAccount(account);
	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAOLogProxy.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAOLogProxy.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAOLogProxy.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAOLogProxy.loadAccount(fromAccountNumber);
		Account toAccount = accountDAOLogProxy.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAOLogProxy.updateAccount(fromAccount);
		accountDAOLogProxy.updateAccount(toAccount);
	}
}
