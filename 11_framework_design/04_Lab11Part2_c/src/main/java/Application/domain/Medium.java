package Application.domain;

import org.carframework.domain.Car;
import org.carframework.domain.CarState;

public class Medium extends CarState {

    public Medium(Car car){
     super(car);
    }

    public void checkUpdate(){
        if(car.getSpeed() > 80){
            CarState newState = new Fast(car);
            car.setCarState(newState);
        } else if (car.getSpeed() < 40) {
            CarState newState = new Slow(car);
            car.setCarState(newState);
        }
    }
    @Override
    public void goFaster(){
        System.out.println("medium state fast command: speed="+(car.getSpeed()+2));
        car.setSpeed(car.getSpeed()+2);
        this.checkUpdate();
    }

    @Override
    public void goSlower(){
        System.out.println("medium state slow command: speed="+(car.getSpeed()-2));
        car.setSpeed(car.getSpeed()-2);
        this.checkUpdate();
    }
}
