package bank.abstractFactory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.email.EmailSender;
import bank.email.IEmailSender;

public class ProductionFactory implements MyFactory{
    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAO();
    }

    @Override
    public IEmailSender getEmailSender() {
        return EmailSender.getInstance();
    }
}
