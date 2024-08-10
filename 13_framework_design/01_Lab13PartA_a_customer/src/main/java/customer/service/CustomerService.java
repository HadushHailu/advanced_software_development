package customer.service;

import customer.dao.ICustomerDAO;
import customer.domain.Address;
import customer.domain.Customer;
import customer.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
            @Qualifier
    ICustomerDAO iCustomerDAO;
    @Autowired
    EmailSender emailSender;

    public void addCustomer(String name, String email,
                            String street, String city, String zip){
        Address address = new Address(street, city, zip);
        Customer customer = new Customer(name, email, address);
        iCustomerDAO.save(customer);
        emailSender.sendEmail(email, "Welcome "+name+" as a new customer");
    }
}
