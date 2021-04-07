
import java.util.ArrayList;

public class Car {

    String id;
    boolean isEngineOn;
    boolean isAcOn;
    ArrayList<Doors> doors = new ArrayList<>(4);
    ArrayList<Doors> windows = new ArrayList<>(4);
    ArrayList<Gears> gears = new ArrayList<>(3);
    Brakes brakeApplied = new Brakes();
    Accelerator acceleratorApplied = new Accelerator();
    boolean isCarLocked;

    public Accelerator getAcceleratorApplied() {
        return acceleratorApplied;
    }

    public void setAcceleratorApplied(Accelerator acceleratorApplied) {
        this.acceleratorApplied = acceleratorApplied;
    }

    public Car(String id) {
        this.id = id;
        for (int i = 0; i < 4; i++) {
            doors.add(new Doors());
        }
        for (int i = 0; i < 4; i++) {
            windows.add(new Doors());
        }
        for (int i = 0; i < 3; i++) {
            gears.add(new Gears());
        }
    }

    public ArrayList<Gears> getGears() {
        return gears;
    }

    public void setGears(ArrayList<Gears> gears) {
        this.gears = gears;
    }

    public ArrayList<Doors> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Doors> doors) {
        this.doors = doors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCarLocked() {
        return isCarLocked;
    }

    public void setCarLocked(boolean carLocked) {
        isCarLocked = carLocked;
    }

    public boolean isAcOn() {
        return isAcOn;
    }

    public void setAcOn(boolean acOn) {
        isAcOn = acOn;
    }

    public Brakes getBrakeApplied() {
        return brakeApplied;
    }

    public void setBrakeApplied(Brakes brakeApplied) {
        this.brakeApplied = brakeApplied;
    }

    public boolean isEngineOn() {
        return isEngineOn;
    }

    public void setEngineOn(boolean engineOn) {
        this.isEngineOn = engineOn;
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
        Doors door = doors.get(doorNumber);
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
        gear.isGearsApplied();
    }

    public void gearReleased(int gearsNumber) {
        Gears gear = gears.get(gearsNumber);
        System.out.println("Operating gear" + gearsNumber);
        gear.isGearsReleased();
    }

    public void acceleratorApplied() {
        acceleratorApplied.AcceleratorApplied();
    }

    public void acceleratorReleased() {
        acceleratorApplied.AcceleratorReleased();
    }

    public void brakeApplied() {
        brakeApplied.BrakesApplied();
    }

    public void brakeReleased() {
        brakeApplied.BrakesReleased();
    }

    public void stopCarThroughBrakes() {
        if (brakeApplied.isBrakesApplied) {
            System.out.println("Car stopped for a while");
        } else {
            System.out.println("Brake is not applied till now");

        }
    }

}
