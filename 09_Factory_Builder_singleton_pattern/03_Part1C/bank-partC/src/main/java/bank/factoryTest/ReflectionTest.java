package bank.factoryTest;

import bank.email.EmailSender;
import bank.email.IEmailSender;

import java.lang.reflect.Constructor;

public class ReflectionTest {
    public static void main(String[] args) {
        IEmailSender instanceOne = EmailSender.getInstance();
        IEmailSender instanceTwo = null;
        try {
            Constructor[] constructors = EmailSender.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (EmailSender) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.getClass().getName()+" with hascode: " + instanceOne.hashCode());System.out.println(instanceTwo.getClass().getName()+" with hascode: " + instanceTwo.hashCode());}
}
