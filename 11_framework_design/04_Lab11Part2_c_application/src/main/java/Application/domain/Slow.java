package Application.domain;

import org.carframework.domain.Car;
import org.carframework.domain.CarState;

public class Slow extends CarState {

    public Slow(Car car){
     super(car);
    }

    public void checkUpdate(){
        if(car.getSpeed() >= 40){
            CarState newState = new Medium(car);
            car.setCarState(newState);
        }
    }
    @Override
    public void goFaster(){
        System.out.println("slow state fast command: speed="+(car.getSpeed()+1));
        car.setSpeed(car.getSpeed()+1);
        this.checkUpdate();
    }

    @Override
    public void goSlower(){
        System.out.println("slow state slow command: speed="+(car.getSpeed()-1));
        car.setSpeed(car.getSpeed()-1);
    }
}
