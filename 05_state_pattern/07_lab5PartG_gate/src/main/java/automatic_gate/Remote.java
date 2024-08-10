package automatic_gate;

public class Remote {
    private GateController gateController;

    Remote(GateController gateController){
        this.gateController = gateController;
    }

    public void pressButton(){
        gateController.pressButton();
    }
}
