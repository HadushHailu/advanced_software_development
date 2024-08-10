package customer.dao;

import customer.domain.Customer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class MockCustomerDAO implements ICustomerDAO{
    public void save(Customer customer){
        System.out.println("Test environment: customer "+customer.getName()+" saved");
    }
}
