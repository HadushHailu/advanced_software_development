package automatic_gate;

public abstract class GateState {
    protected  final GateController gateController;
    GateState(GateController gateController){
        this.gateController = gateController;
    }

    abstract void pressButton();
    abstract void sensorClosedSignal();
    abstract void sensorOpenSignal();
    abstract States getState();

}
