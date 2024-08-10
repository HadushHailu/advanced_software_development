package bank.email;

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
            synchronized (EmailSender.class){
                if (instance == null){
                    instance = new EmailSender();}
            }
        }
        return instance;
    }

    @Override
    public void send(String message) {
        System.out.println("Production Sending email: " + message);
    }

    protected  Object readResolve() {
        return instance;
    }

}
