package Application;

import Application.domain.Slow;
import Application.service.JumpingCar;
import org.carframework.HistoryList;
import org.carframework.domain.Below70;
import org.carframework.service.FasterCommand;
import org.carframework.service.ICommand;

public class Application {
    public static void main(String[] args) {
        HistoryList historyList = new HistoryList();

        JumpingCar jumpingCar = new JumpingCar();
        jumpingCar.setSpeed(39);
        jumpingCar.setCarState(new Slow(jumpingCar));

        ICommand iCommand = new FasterCommand(jumpingCar);
        iCommand.execute();
        historyList.addCommand(iCommand);

        ICommand iCommand1 = new FasterCommand(jumpingCar);
        iCommand1.execute();
        historyList.addCommand(iCommand1);


    }
}
