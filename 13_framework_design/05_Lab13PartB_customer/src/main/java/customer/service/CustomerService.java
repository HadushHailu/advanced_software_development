package customer.service;

import customer.dao.AddCustomerEvent;
import customer.dao.ICustomerDAO;
import customer.domain.Address;
import customer.domain.Customer;
import customer.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerDAO iCustomerDAO;
    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    EmailSender emailSender;

    public void addCustomer(String name, String email,
                            String street, String city, String zip){
        Address address = new Address(street, city, zip);
        Customer customer = new Customer(name, email, address);
        iCustomerDAO.save(customer);
        emailSender.sendEmail(email, "Welcome "+name+" as a new customer");
        publisher.publishEvent(new AddCustomerEvent("New cutomer with name="+name+" and email="+email+" is added"));
    }
}
