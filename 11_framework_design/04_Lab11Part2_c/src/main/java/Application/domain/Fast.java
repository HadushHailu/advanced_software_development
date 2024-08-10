package Application.domain;

import org.carframework.domain.Car;
import org.carframework.domain.CarState;

public class Fast extends CarState {

    public Fast(Car car){
     super(car);
    }

    public void checkUpdate(){
        if(car.getSpeed() <= 80){
            CarState newState = new Medium(car);
            car.setCarState(newState);
        }
    }
    @Override
    public void goFaster(){
        System.out.println("fast state fast command: speed="+(car.getSpeed()+3));
        car.setSpeed(car.getSpeed()+3);
    }

    @Override
    public void goSlower(){
        System.out.println("fast state slow command: speed="+(car.getSpeed()-3));
        car.setSpeed(car.getSpeed()-3);
        this.checkUpdate();
    }
}
