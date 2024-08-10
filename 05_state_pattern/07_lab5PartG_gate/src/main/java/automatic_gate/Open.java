package automatic_gate;

public class Open extends GateState{
    private final States state = States.OPEN;
    Open(GateController gateController){
        super(gateController);
    }

    private void fireAndUpdateState(GateState newState){
        gateController.fireChange(newState);
        gateController.setGateState(newState);
    }

     public void pressButton(){
        gateController.openGate();
        this.fireAndUpdateState(new Closing(gateController));
     }
     public void sensorClosedSignal(){
         System.out.println("Error with sensor reading");
     }
     public void sensorOpenSignal(){
         System.out.println("Do nothing");
     }

    public States getState() {
        return state;
    }
}
