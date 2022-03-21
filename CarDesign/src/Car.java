
import java.util.ArrayList;

public class Car {

    String id;
    ArrayList<Doors> doors = new ArrayList<>();
    ArrayList<Doors> windows = new ArrayList<>();
    ArrayList<Gears> gears = new ArrayList<>();
    Engine engine = new Engine();
    AC ac= new AC();
    Controller controller = new Controller();

    boolean isCarLocked;

    protected Car(String id, ArrayList<Doors> doors, ArrayList<Doors> windows, ArrayList<Gears> gears) {
        this.id = id;
        this.doors = doors;
        this.windows = windows;
        this.gears = gears;
    }

    protected Car(String id) {
        this.id = id;
    }

    protected Car(String id, ArrayList<Doors> doors, ArrayList<Gears> gears) {
        this.id = id;
        this.doors = doors;
        this.gears = gears;
    }

    protected void startCar() {
        if (!engine.isOn && !isCarLocked) {
            engine.isOn = true;
            System.out.println("Car started");
        } else {
            System.out.println("Car already started");

        }
    }

    protected void stopCar() {
        if (engine.isOn) {
            engine.isOn = false;
            System.out.println("Car stopped");
            carLock();
        } else {
            System.out.println("Car already stopped");

        }
    }

    protected void carLock() {
        isCarLocked = true;
        System.out.println("Car locked");
    }

    protected void carUnlock() {
        isCarLocked = false;
        System.out.println("Car unlocked");
    }

    protected void openDoor(int doorNumber) {
        Doors door = doors.get(doorNumber);
        System.out.println("Operating door" + doorNumber);
        door.doorOpen();
    }

    protected void closeDoor(int doorNumber) {
        Doors door = doors.get(doorNumber);
        System.out.println("Operating door" + doorNumber);
        door.doorClose();
    }

    protected void openWindow(int windowNumber) {
        Doors door = windows.get(windowNumber);
        System.out.println("Operating window" + windowNumber);
        door.windowOpen();
    }

    protected void closeWindow(int windowNumber) {
        Doors door = windows.get(windowNumber);
        System.out.println("Operating window" + windowNumber);
        door.windowClose();
    }

    protected void onAC() {
        if (!ac.isOn) {
            ac.isOn = true;
            System.out.println("AC is on now");
        } else {
            System.out.println("AC is already on");

        }
    }

    protected void offAC() {
        if (ac.isOn) {
            ac.isOn = false;
            System.out.println("AC is off now");
        } else {
            System.out.println("AC is already off");

        }
    }

    protected void gearApplied(int gearsNumber) {
        Gears gear = gears.get(gearsNumber);
        System.out.println("Operating gear" + gearsNumber);
        gear.Applied();
    }

    protected void gearReleased(int gearsNumber) {
        Gears gear = gears.get(gearsNumber);
        System.out.println("Operating gear" + gearsNumber);
        gear.Released();
    }

    protected void stopCarThroughBrakes() {
        if (controller.Applied) {
            System.out.println("Car stopped for a while");
        } else {
            System.out.println("Brake is not applied till now");

        }
    }

}
