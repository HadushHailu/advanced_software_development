package automatic_gate;

public class Sensor {
    private GateController gateController;

    Sensor(GateController gateController){
        this.gateController = gateController;
    }

    public void sensorOpenSignal(){
        gateController.sensorOpenSignal();
    }

    public void sensorClosedSignal(){
        gateController.sensorClosedSignal();
    }
}
