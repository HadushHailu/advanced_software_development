package bank.email;

public class MockEmailSender implements IEmailSender{
    private static MockEmailSender instance;

    private MockEmailSender() {
        // To avoid reflection object instantiation
        if (instance != null) {
            throw new IllegalStateException("EmailSender already instantiated");
        }
    }
    public static MockEmailSender getInstance() {
        if (instance == null) {
            synchronized (MockEmailSender.class){
                if (instance == null) {
                    instance = new MockEmailSender();
                }
            }
        }
        return  instance;
    }

    @Override
    public void send(String message) {
        System.out.println("Test Sending email: " + message);
    }

    protected  Object readResolve() {
        return instance;
    }
}
