package without;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Collection<Car> carCollection = Application.getCarContacts();
		CameraRecordReceiver cameraRecordReceiver = new CameraRecordReceiver();
		Camera camera = new Camera(cameraRecordReceiver);

		CarHandler speedingCar = new SpeedingCarHandler(carCollection);
		CarHandler stolenCar = new StolenCarHandler(speedingCar, carCollection);
		CarHandler unpaidTicketCar = new UnpaidTicketsCarHandler(stolenCar, carCollection);
		CarHandler unregisteredCarhandler = new UnregisteredCarHandler(unpaidTicketCar, carCollection);

		cameraRecordReceiver.setChainOfHandlers(unregisteredCarhandler);
		camera.generateCameraRecords();

	}


	public static Collection<Car> getCarContacts(){
		List<Car> cars = new ArrayList<>(){{
			add(new Car("Kebede", "kebede", "KL 0001", false, new Address("LA", "BC", "1234")));
			add(new Car("Hadush", "kebede", "SA 9801", false, new Address("LA", "BC", "1234")));
			add(new Car("Fana", "kebede", "SS 3333", true, new Address("LA", "BC", "1234")));
			add(new Car("Teklu", "kebede", "LX 1243", false, new Address("LA", "BC", "1234")));
			add(new Car("Solomun", "kebede", "KP 9978", false, new Address("LA", "BC", "1234")));
			add(new Car("Teklay", "kebede", "GG 1112", true, new Address("LA", "BC", "1234")));
			add(new Car("Amare", "kebede", "FX 1333", false, new Address("LA", "BC", "1234")));
		}};

		cars.get(0).getTickets().add(new Ticket(new Date(), 400, false));

		return cars;
	}

}
