package customer.aop;

import customer.config.MyConfigProperties;
import customer.integration.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class PropertiesAdvice {
    @Autowired
    MyConfigProperties myConfigProperties;

    @Before("execution(* customer.service.CustomerService.addCustomer(..))")
    public void proAfterMethod(JoinPoint joinpoint) {
        System.out.println(myConfigProperties.toString());
    }
}
