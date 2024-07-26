package automatic_gate;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GateController {
    private PropertyChangeSupport support;
    private States currentState;
    private Gate gate;

    GateController(){
        support = new PropertyChangeSupport(this);
        gate = new Gate();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void changeGateState(States states){
        System.out.println("Current gate state: " + states);
        States oldState = currentState;
        this.currentState = states;
        support.firePropertyChange("state", oldState, currentState);
    }

    public void sensorOpenSignal(){
        gate.stop();
        this.changeGateState(States.OPEN);
    }

    public void sensorClosedSignal(){
        gate.stop();
        this.changeGateState(States.CLOSE);
    }

    public void pressButton(){
        if(currentState == States.OPEN){
            gate.close();
            this.changeGateState(States.CLOSING);
        } else if (currentState == States.CLOSE) {
            gate.open();
            this.changeGateState(States.OPENING);
        } else if (currentState == States.OPENING) {
            gate.close();
            this.changeGateState(States.CLOSING);
        }else{
            gate.open();
            this.changeGateState(States.OPENING);
        }
    }

}
