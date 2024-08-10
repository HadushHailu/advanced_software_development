package bank.email;

import java.io.Serial;

public class EmailSender implements IEmailSender{
    private static EmailSender instance;

    private EmailSender() {
        // To avoid reflection object instantiation
        if (instance != null) {
            throw new IllegalStateException("EmailSender already instantiated");
        }
    }
    public static EmailSender getInstance() {
        if (instance == null){
            System.out.println("EmailSender not instantiated");
            synchronized (EmailSender.class){
                if (instance == null){
                    instance = new EmailSender();
                }
            }
        }
        return instance;
    }

    @Override
    public void send(String message) {
        System.out.println("Production Sending email: " + message);
    }

    @Serial
    protected  Object readResolve() {
        return instance;
    }

}
