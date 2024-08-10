package automatic_gate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GateController {
    private PropertyChangeSupport support;
    private Gate gate;
    private GateState gateState;

    GateController(){
        support = new PropertyChangeSupport(this);
        gate = new Gate();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setGateState(GateState gateState) {
        this.gateState = gateState;
    }

    public void pressButton(){
        gateState.pressButton();
    }
    public void stopGate(){
        gate.stop();
    }

    public void openGate(){
        gate.open();
    }

    public void closeGate(){
        gate.close();
    }

    public void sensorOpenSignal(){
        gateState.sensorOpenSignal();
    }

    public void sensorClosedSignal(){
        gateState.sensorClosedSignal();
    }

    public void fireChange(GateState currentGateState){
        System.out.println("Current gate state: " + currentGateState.getState());
        States oldState = gateState.getState();
        support.firePropertyChange("state", oldState, currentGateState.getState());
    }


}
