package automatic_gate;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BuzzerController implements PropertyChangeListener {

    private void on(){
        System.out.println("Buzzer is on");
    }

    private void off(){
        System.out.println("Buzzer is off");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if((States)evt.getNewValue() == States.CLOSING || (States)evt.getNewValue() == States.OPENING){
            this.on();
        }else{
            this.off();
        }
    }
}
