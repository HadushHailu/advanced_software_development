package automatic_gate;

public class StandStill extends GateState{
    private final States state = States.STANDSTILL;
    private GateState prevGateState;

    StandStill(GateController gateController, GateState gateState){
        super(gateController);
        this.prevGateState = gateState;
    }

    private void fireAndUpdateState(GateState newState){
        gateController.fireChange(newState);
        gateController.setGateState(newState);
    }

    public void pressButton(){
        if(prevGateState.getState() == States.CLOSING){
            gateController.closeGate();
        } else if (prevGateState.getState() == States.OPENING) {
            gateController.openGate();
        }
        this.fireAndUpdateState(prevGateState);
    }
    public void sensorClosedSignal(){
        System.out.println("Error with sensor reading");
    }
    public void sensorOpenSignal(){
        System.out.println("Error with sensor reading");
    }
    public States getState() {
        return state;
    }
}
