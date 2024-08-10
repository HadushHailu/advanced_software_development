package bank.factoryTest;

import bank.email.EmailSender;
import bank.email.IEmailSender;

public class ThreadTest {
    public static void main(String[] args) {
//Thread 1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                IEmailSender instance1 = EmailSender.getInstance();
                System.out.println("Instance 1 hash:" + instance1.hashCode());
            }
        });
//Thread 2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                IEmailSender instance2 = EmailSender.getInstance();
                System.out.println("Instance 2 hash:" + instance2.hashCode());
            }
        });
//Thread 3
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                IEmailSender instance3 = EmailSender.getInstance();
                System.out.println("Instance 3 hash:" + instance3.hashCode());
            }
        });


//start all the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
