package bank.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {
    private Object target;
    public LoggingProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("It's Logging..." + method.getName() + " arg" + args[0]);
        // invoke the method on the target
        Object returnValue = method.invoke(target, args);

        return returnValue;
    }
}
