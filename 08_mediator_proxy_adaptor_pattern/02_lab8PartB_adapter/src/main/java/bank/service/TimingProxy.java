package bank.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {
    private Object target;
    public TimingProxy(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long start = System.currentTimeMillis();
        Object returnValue = method.invoke(target, args);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("Elapsed Time for " +method.getName()+" is: "+timeElapsed +"ms");

        return returnValue;
    }
}
