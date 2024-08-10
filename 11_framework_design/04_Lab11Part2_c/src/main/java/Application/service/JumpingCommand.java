package Application.service;

import org.carframework.domain.Car;
import org.carframework.service.ICommand;

public class JumpingCommand implements ICommand {
    private Car car;

    public JumpingCommand(Car car){
        this.car = car;
    }

    @Override
    public void execute(){
        car.goFaster();
    }

    @Override
    public void unExecute(){
        car.goSlower();
    }
}
