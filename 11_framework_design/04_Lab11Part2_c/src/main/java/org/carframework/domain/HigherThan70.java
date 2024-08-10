package org.carframework.domain;

public class HigherThan70 extends CarState{
    public HigherThan70(Car car){
        super(car);
    }

    public void checkUpdate(){
        if(car.getSpeed() < 70){
            CarState newState = new Below70(car);
            car.setCarState(newState);
        }
    }
    @Override
    public void goFaster(){
        System.out.println("fast command: speed="+(car.getSpeed()+3));
        car.setSpeed(car.getSpeed()+3);
        this.checkUpdate();
    }

    @Override
    public void goSlower(){
        System.out.println("slow command: speed="+(car.getSpeed()-3));
        car.setSpeed(car.getSpeed()-3);
    }
}
