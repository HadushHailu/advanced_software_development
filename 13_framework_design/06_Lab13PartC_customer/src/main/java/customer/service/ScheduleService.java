package customer.service;

import customer.integration.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ScheduleService {
    @Autowired
    ILogger iLogger;

    @Scheduled(fixedRate = 15000)
    public void logTime(){
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        iLogger.log(timeFormatter.format(date));
    }
}
