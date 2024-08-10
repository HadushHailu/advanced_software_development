package without;

import java.util.Collection;

public class SpeedingCarHandler extends CarHandler{
    SpeedingCarHandler(Collection<Car> car){
        super(car);
    }

    public void handle(CameraRecord cameraRecord){
        if(cameraRecord.getSpeed() >= 65){
            System.out.println("speeding ticket issued");
        }
    }

}
