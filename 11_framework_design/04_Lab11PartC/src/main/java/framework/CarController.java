package framework;

public class CarController {
    private CarActionDispatcher carActionDispatcher;
    public void action(String action){
        carActionDispatcher.action(action);
    }
}
