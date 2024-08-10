package framework;

public class CarMotor {
    private int val;

    public void setVal(int val) {
        this.val = val;
    }

    public void send(int val){
        if(val == 0){
            System.out.println("action: straight");
        } else if (val == -1) {
            System.out.println("action: left");
        } else if (val == 1) {
            System.out.println("action: right");
        }
    }
}
