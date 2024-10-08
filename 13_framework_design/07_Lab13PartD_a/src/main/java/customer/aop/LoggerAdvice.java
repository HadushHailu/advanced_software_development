package customer.aop;

import customer.integration.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Aspect
@Configuration
public class LoggerAdvice {
    @After("execution(* customer.integration.EmailSender.sendEmail(..)) && args(email,message)")
    public void traceaftermethod(JoinPoint joinpoint, String email, String message) {
        EmailSender emailSender = (EmailSender) joinpoint.getTarget();
        System.out.println( LocalDateTime.now() + " method="+ joinpoint.getSignature().getName() +
                " address="+email+" message="+message+" mail server="+emailSender.getOutgoingMailServer());
    }
}
