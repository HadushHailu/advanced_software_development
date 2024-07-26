package automatic_gate;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class lightController implements PropertyChangeListener {
    private void onRed(){
        System.out.println("Light is on - Red");
    }
    private void onOrange(){
        System.out.println("Light is on - Orange");
    }
    private void off(){
        System.out.println("Light is off");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if((States)evt.getNewValue() == States.CLOSING){
            this.onRed();
        }else if((States)evt.getNewValue() == States.OPENING){
            this.onOrange();
        }else{
            this.off();
        }
    }
}
