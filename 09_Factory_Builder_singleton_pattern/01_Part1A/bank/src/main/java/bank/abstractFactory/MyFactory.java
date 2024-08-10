package bank.abstractFactory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.email.EmailSender;
import bank.email.IEmailSender;

public interface MyFactory {
    public IAccountDAO getAccountDAO();
    public IEmailSender getEmailSender();
}
