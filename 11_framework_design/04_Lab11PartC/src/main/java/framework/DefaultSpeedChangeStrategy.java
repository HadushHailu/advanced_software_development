package framework;

public class DefaultSpeedChangeStrategy extends SpeedChangeStrategy{

    @Override
    public int compute(double speed){
        if(speed < 70){
            return 1;
        }
        return 3;
    }
}
