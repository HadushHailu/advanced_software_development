package without;

import java.util.Collection;

public abstract class CarHandler {
    protected CarHandler nextHandler;
    protected Collection<Car> cars;
    CarHandler(Collection<Car> cars){
        this.cars = cars;
    }
    CarHandler(CarHandler carHandler, Collection<Car> car){
        this.nextHandler = carHandler;
        this.cars = car;
    }
    public abstract void handle(CameraRecord cameraRecord);
}
