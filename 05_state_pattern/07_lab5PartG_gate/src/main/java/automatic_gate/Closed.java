package automatic_gate;

public class Closed extends GateState{
    private final States state = States.CLOSED;
    Closed(GateController gateController){
        super(gateController);
    }

    private void fireAndUpdateState(GateState newState){
        gateController.fireChange(newState);
        gateController.setGateState(newState);
    }

    public void pressButton(){
        gateController.openGate();
        this.fireAndUpdateState(new Opening(gateController));
    }
    public void sensorClosedSignal(){
        System.out.println("Do nothing");
    }
    public void sensorOpenSignal(){
        System.out.println("Error with sensor reading");
    }

    public States getState() {
        return state;
    }
}
