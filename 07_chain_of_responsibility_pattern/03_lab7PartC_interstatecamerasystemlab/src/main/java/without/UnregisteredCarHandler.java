package without;

import java.util.Collection;
import java.util.Optional;

public class UnregisteredCarHandler extends CarHandler{
    UnregisteredCarHandler(CarHandler carHandler, Collection<Car> car){
        super(carHandler, car);
    }

    public void handle(CameraRecord cameraRecord){
        boolean found = false;
        for(Car car: cars){
            if(cameraRecord.getLicenseplate().equals(car.getLicensePlate())){
                found = true;
            }
        }

        if(!found){
            System.out.println("This car isn't registered");
        }

        nextHandler.handle(cameraRecord);
    }

}
