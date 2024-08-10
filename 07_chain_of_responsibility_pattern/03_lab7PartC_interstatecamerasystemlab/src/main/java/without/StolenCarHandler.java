package without;

import java.util.Collection;

public class StolenCarHandler extends CarHandler{
    StolenCarHandler(CarHandler carHandler, Collection<Car> car){
        super(carHandler, car);
    }

    public void handle(CameraRecord cameraRecord){
        for(Car car: cars){
            if(cameraRecord.getLicenseplate().equals(car.getLicensePlate()) && car.getStolen()){
                System.out.println("Stolen car detected ... Notifying police");
            }
        }

        nextHandler.handle(cameraRecord);
    }

}
