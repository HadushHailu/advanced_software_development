package customer;

import customer.config.MyConfigProperties;
import customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(MyConfigProperties.class)
public class CustomerApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;

	@Autowired
	private MyConfigProperties myConfigProperties;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.addCustomer("Frank Brown", "fbrown@acme.com", "Jefferson", "Fairfeild", "52557");
	}
}
