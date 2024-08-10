package org.carframework.domain;

public class Below70 extends CarState{

    public Below70(Car car){
     super(car);
    }

    public void checkUpdate(){
        if(car.getSpeed() >= 70){
            CarState newState = new HigherThan70(car);
            car.setCarState(newState);
        }
    }
    @Override
    public void goFaster(){
        System.out.println("fast command: speed="+(car.getSpeed()+1));
        car.setSpeed(car.getSpeed()+1);
        this.checkUpdate();
    }

    @Override
    public void goSlower(){
        System.out.println("slow command: speed="+(car.getSpeed()-1));
        car.setSpeed(car.getSpeed()-1);
    }
}
