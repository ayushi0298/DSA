public class Doors {
    boolean isOpen;
    boolean isOpenWindow;

    protected void doorOpen() {
        if (!isOpen) {
            isOpen = true;
            System.out.println(" door opened");

        } else {
            System.out.println(" door already opened");

        }
    }
    protected void doorClose() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Door closed");
        } else {
            System.out.println("Door already closed");

        }

    }

    protected void windowOpen() {
        if (!isOpenWindow) {
            isOpenWindow = true;
            System.out.println("Window opened");

        } else {
            System.out.println(" Window already opened");

        }
    }

    protected void windowClose() {
        if (isOpenWindow) {
            isOpenWindow = false;
            System.out.println("Window closed");

        } else {
            System.out.println(" Window already closed");

        }
    }

}
