package customer.service;

import customer.dao.AddCustomerEvent;
import customer.dao.CustomerRatingEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerRatingService {
    @EventListener
    public void onEvent(CustomerRatingEvent event) {
        System.out.println("CustomerRatingService: Received event :" + event.getMessage());
    }
}
