public class Doors {
    boolean isOpen;
    boolean isOpenWindow;

    public void doorOpen() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(" door opened");

        } else {
            System.out.println(" door already opened");

        }
    }
    public void doorClose() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Door closed");
        } else {
            System.out.println("Door already closed");

        }

    }

    public void windowOpen() {
        if (!isOpenWindow) {
            isOpenWindow = true;
            System.out.println("Window opened");

        } else {
            System.out.println(" Window already opened");

        }
    }

    public void windowClose() {
        if (isOpenWindow) {
            isOpenWindow = false;
            System.out.println("Window closed");

        } else {
            System.out.println(" Window already closed");

        }
    }

}
