package org.carframework.domain;

public abstract class CarState {
    protected Car car;
    public CarState(Car car){
        this.car = car;
    }
    abstract public void goFaster();
    abstract public void goSlower();
}
