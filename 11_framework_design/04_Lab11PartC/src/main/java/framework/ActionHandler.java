package framework;

public abstract class ActionHandler {
    protected  ActionHandler nextHandler;
    ActionHandler(ActionHandler nextHandler){
        this.nextHandler = nextHandler;
    }
    abstract void handle(String action);
}
