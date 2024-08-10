package org.carframework.service;

import org.carframework.domain.Car;

public class FasterCommand implements ICommand{
    private Car car;

    public FasterCommand(Car car){
        this.car = car;
    }

    @Override
    public void execute(){
        car.goFaster();
    }

    @Override
    public void unExecute(){
        car.goSlower();
    }
}