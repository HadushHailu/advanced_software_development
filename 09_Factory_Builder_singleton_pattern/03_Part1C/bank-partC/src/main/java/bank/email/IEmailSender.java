package bank.email;

import java.io.Serializable;

public interface IEmailSender extends Serializable {
    public void send(String message);
}
