package framework;

public class DefaultActionHandler extends ActionHandler{
    private CarMotor carMotor;
    DefaultActionHandler(ActionHandler nextHandle, CarMotor carMotor){
        super(nextHandle);
        this.carMotor = carMotor;
    }

    @Override
    public void handle(String action){
        if(action.equals("default")){
            this.carMotor.send(0);
        }
    }
}
