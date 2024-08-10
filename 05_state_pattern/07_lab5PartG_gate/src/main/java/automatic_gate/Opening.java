package automatic_gate;

public class Opening extends GateState{
    private final States state = States.OPENING;
    Opening(GateController gateController){
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
        System.out.println("Error with sensor reading");
    }
    public void sensorOpenSignal(){
        gateController.stopGate();
        this.fireAndUpdateState(new Open(gateController));
    }

    public States getState() {
        return state;
    }
}
