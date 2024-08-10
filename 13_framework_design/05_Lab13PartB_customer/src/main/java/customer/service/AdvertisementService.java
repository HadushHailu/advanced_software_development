package customer.service;

import customer.dao.AddCustomerEvent;
import customer.dao.CustomerRatingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
    @Autowired
    ApplicationEventPublisher publisher;
    @EventListener
    public void onEvent(AddCustomerEvent event) {
        System.out.println("AdvertisementService: Received event :" + event.getMessage());
        publisher.publishEvent(new CustomerRatingEvent(event.getMessage()));
    }
}
