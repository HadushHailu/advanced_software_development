package without;

import java.util.Collection;

public class UnpaidTicketsCarHandler extends CarHandler{
    UnpaidTicketsCarHandler(CarHandler carHandler, Collection<Car> car){
        super(carHandler, car);
    }

    public void handle(CameraRecord cameraRecord){
        for(Car car: cars){
            if(cameraRecord.getLicenseplate().equals(car.getLicensePlate()) && car.getTickets() != null && !car.getTickets().isEmpty()){
                System.out.println("This owner has unpaid tickets..");
            }
        }

        nextHandler.handle(cameraRecord);
    }

}
