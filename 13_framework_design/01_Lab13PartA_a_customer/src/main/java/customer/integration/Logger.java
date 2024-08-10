package customer.integration;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class Logger implements ILogger{
    public void log(String message){
        System.out.println("Logging "+ LocalDateTime.now()  + " " +message);
    }
}
