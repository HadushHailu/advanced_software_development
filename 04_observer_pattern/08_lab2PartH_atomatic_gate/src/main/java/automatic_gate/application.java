package automatic_gate;

public class application {
    public static void main(String[] args) {
        GateController gateController = new GateController();
        Sensor sensor = new Sensor(gateController);
        Remote remote = new Remote(gateController);

        BuzzerController buzzerController = new BuzzerController();
        lightController lightController = new lightController();
        gateController.addPropertyChangeListener(buzzerController);
        gateController.addPropertyChangeListener(lightController);

        System.out.println("-- Sensor open signal");
        sensor.sensorOpenSignal();
        System.out.println("-- Remote control pressed");
        remote.pressButton();
        System.out.println("-- Sensor close signal");
        sensor.sensorClosedSignal();
        System.out.println("-- Remote control pressed");
        remote.pressButton();

    }
}
