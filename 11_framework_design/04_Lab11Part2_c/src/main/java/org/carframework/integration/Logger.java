package org.carframework.integration;

public class Logger implements Observer{
    public void update(double speed){
        this.log(speed);
    }

    private void log(double speed){
        System.out.println("Logger: speed="+speed);
    }
}
