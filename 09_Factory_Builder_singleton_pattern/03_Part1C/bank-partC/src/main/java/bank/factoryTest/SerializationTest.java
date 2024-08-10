package bank.factoryTest;

import bank.email.EmailSender;
import bank.email.IEmailSender;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) {
        try {
            IEmailSender instance1 = EmailSender.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();
// deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            IEmailSender instance2 = (EmailSender) in.readObject();
            in.close();
            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
