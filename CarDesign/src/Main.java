public class Main {
    public static void main(String args[]) {
        Car car1 = new Car("A101");
        car1.startCar();
        car1.stopCar();
        car1.openDoor(2);
        car1.closeDoor(2);
        car1.openWindow(2);
        car1.openWindow(2);
        car1.closeWindow(2);
        car1.onAC();
        car1.onAC();
        car1.offAC();
        car1.gearApplied(1);
        car1.gearReleased(1);
        car1.acceleratorApplied();
        car1.acceleratorApplied();
        car1.brakeApplied();
        car1.stopCarThroughBrakes();
        car1.brakeReleased();
        car1.stopCarThroughBrakes();

    }
}





