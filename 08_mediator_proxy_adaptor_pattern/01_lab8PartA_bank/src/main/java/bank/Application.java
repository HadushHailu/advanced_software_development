package bank;

import java.lang.reflect.Proxy;
import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.TimingProxy;
import bank.service.IAccountService;



public class Application {
	public static void main(String[] args) {
		IAccountService accountService = new AccountService();
		ClassLoader classLoader = IAccountService.class.getClassLoader();
		IAccountService accountServiceProxy = (IAccountService) Proxy.newProxyInstance(classLoader,
												new Class[] { IAccountService.class },
												new TimingProxy(accountService));


		// create 2 accounts;
		accountServiceProxy.createAccount(1263862, "Frank Brown");
		accountServiceProxy.createAccount(4253892, "John Doe");
		//use account 1;
		accountServiceProxy.deposit(1263862, 240);
		accountServiceProxy.deposit(1263862, 529);
		accountServiceProxy.withdraw(1263862, 230);
		//use account 2;
		accountServiceProxy.deposit(4253892, 12450);
		accountServiceProxy.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = accountServiceProxy.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


