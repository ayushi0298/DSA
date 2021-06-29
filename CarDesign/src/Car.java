
import java.util.ArrayList;

public class Car {

    String id;
    ArrayList<Doors> doors = new ArrayList<>();
    ArrayList<Doors> windows = new ArrayList<>();
    ArrayList<Gears> gears = new ArrayList<>();
    boolean isEngineOn;
    boolean isAcOn;
    Brakes brake = new Brakes();
    Accelerator accelerator = new Accelerator();
    boolean isCarLocked;

    public Car(String id, ArrayList<Doors> doors, ArrayList<Doors> windows, ArrayList<Gears> gears) {
        this.id = id;
        this.doors = doors;
        this.windows = windows;
        this.gears = gears;
    }

    public Car(String id) {
        this.id = id;
    }

    public void startCar() {
        if (!isEngineOn && !isCarLocked) {
            isEngineOn = true;
            System.out.println("Car started");
        } else {
            System.out.println("Car already started");

        }
    }

    public void stopCar() {
        if (isEngineOn) {
            isEngineOn = false;
            System.out.println("Car stopped");
            carLock();
        } else {
            System.out.println("Car already stopped");

        }
    }

    public void carLock() {
        isCarLocked = true;
        System.out.println("Car locked");
    }

    public void carUnlock() {
        isCarLocked = false;
        System.out.println("Car unlocked");
    }

    public void openDoor(int doorNumber) {
        Doors door =  doors.get(doorNumber);
        System.out.println("Operating door" + doorNumber);
        door.doorOpen();
    }

    public void closeDoor(int doorNumber) {
        Doors door = doors.get(doorNumber);
        System.out.println("Operating door" + doorNumber);
        door.doorClose();
    }

    public void openWindow(int windowNumber) {
        Doors door = windows.get(windowNumber);
        System.out.println("Operating window" + windowNumber);
        door.windowOpen();
    }

    public void closeWindow(int windowNumber) {
        Doors door = windows.get(windowNumber);
        System.out.println("Operating window" + windowNumber);
        door.windowClose();
    }

    public void onAC() {
        if (!isAcOn) {
            isAcOn = true;
            System.out.println("AC is on now");
        } else {
            System.out.println("AC is already on");

        }
    }
    public void offAC(){
        if (isAcOn) {
            isAcOn = false;
            System.out.println("AC is off now");
        } else {
            System.out.println("AC is already off");

        }
    }

    public void gearApplied(int gearsNumber) {
        Gears gear = gears.get(gearsNumber);
        System.out.println("Operating gear" + gearsNumber);
        gear.Applied();
    }

    public void gearReleased(int gearsNumber) {
        Gears gear = gears.get(gearsNumber);
        System.out.println("Operating gear" + gearsNumber);
        gear.Released();
    }

    public void stopCarThroughBrakes() {
        if (brake.Applied) {
            System.out.println("Car stopped for a while");
        } else {
            System.out.println("Brake is not applied till now");

        }
    }

}
