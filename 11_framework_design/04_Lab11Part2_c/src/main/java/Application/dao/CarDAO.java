package Application.dao;

import org.carframework.integration.Observer;

public class CarDAO implements Observer {
    public void update(double speed){
        this.save(speed);
    }

    public void save(double speed){
        System.out.println("DB: speed="+speed);
    }
}
