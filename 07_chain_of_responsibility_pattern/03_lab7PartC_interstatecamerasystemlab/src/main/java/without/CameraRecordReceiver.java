package without;


import java.util.Collection;

public class CameraRecordReceiver {
	private CarHandler chainOfHandlers;

	public void setChainOfHandlers(CarHandler chainOfHandlers) {
		this.chainOfHandlers = chainOfHandlers;
	}

	public void receiveCameraRecord(CameraRecord cameraRecord) {
		System.out.println("receiving "+cameraRecord);
		this.chainOfHandlers.handle(cameraRecord);
	}


}
