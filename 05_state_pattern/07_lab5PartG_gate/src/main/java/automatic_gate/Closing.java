package automatic_gate;

public class Closing extends GateState{
    private final States state = States.CLOSING;
    Closing(GateController gateController){
        super(gateController);
    }

    private void fireAndUpdateState(GateState newState){
        gateController.fireChange(newState);
        gateController.setGateState(newState);
    }

    public void pressButton(){
        gateController.stopGate();
        this.fireAndUpdateState(new StandStill(gateController, this));
    }
    public void sensorClosedSignal(){
        gateController.stopGate();
        this.fireAndUpdateState(new Closed(gateController));
    }
    public void sensorOpenSignal(){
        System.out.println("Error with sensor reading");
    }

    public States getState() {
        return state;
    }
}
