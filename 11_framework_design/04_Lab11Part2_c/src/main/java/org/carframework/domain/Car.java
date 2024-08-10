package org.carframework.domain;

public class Car {
    protected double speed;
    protected CarState carState;

    public Car(){}
    public void goFaster(){
        carState.goFaster();
    }

    public void goSlower(){
        carState.goSlower();
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public Car(double speed) {
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carState=" + carState +
                ", speed=" + speed +
                '}';
    }
}
