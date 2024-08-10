package customer.dao;

import customer.domain.Customer;
import customer.integration.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CustomerDAO implements ICustomerDAO{
    @Autowired
    ILogger iLogger;

    public void save(Customer customer){
        System.out.println("CustomerDAO: saving customer "+customer.getName());
        iLogger.log("Customer is saved in the DB: "+customer.getName());
    }
}
