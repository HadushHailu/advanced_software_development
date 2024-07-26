package bank;

import java.util.Collection;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.*;


public class Application {
	public static void main(String[] args) {
		HistoryList historyList = new HistoryList();
		IAccountService accountService = new AccountService();

		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");

		//use account 1;
		ICommand depositCommand1 = new DepositCommand(accountService, 1263862, 240);
		depositCommand1.execute();
		historyList.addCommand(depositCommand1);
		ICommand depositCommand2 = new DepositCommand(accountService, 1263862, 529);
		depositCommand2.execute();
		historyList.addCommand(depositCommand2);
		ICommand  withdrawCommand1 = new WithdrawCommand(accountService, 1263862, 230);
		withdrawCommand1.execute();
		historyList.addCommand(withdrawCommand1);
		//use account 2;
		ICommand depositCommand4 = new DepositCommand(accountService, 4253892, 12450);
		depositCommand4.execute();
		historyList.addCommand(depositCommand4);
		ICommand transferFundsCommand = new TransferFundsCommand(accountService,4253892, 1263862, 100, "payment of invoice 10232");
		transferFundsCommand.execute();
		historyList.addCommand(transferFundsCommand);

		Collection<Account> accountlist = accountService.getAllAccounts();
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

		System.out.println("[+] === UNDO ===");
		historyList.undo();
		Collection<Account> accountlist1 = accountService.getAllAccounts();
		Customer customer1 = null;
		for (Account account : accountlist1) {
			customer1 = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer1.getName());
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


