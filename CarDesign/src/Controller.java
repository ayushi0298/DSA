public class Controller implements ControllerInterface {
    boolean Applied;

    @Override
    public void brakeApplied() {
        if (!Applied) {
            Applied = true;
            System.out.println("Brake applied");
        } else {
            System.out.println("Brake already applied");

        }
    }

    @Override
    public void brakeReleased() {
        if (Applied) {
            Applied = false;
            System.out.println("Brake released");
        } else {
            System.out.println("Brake already released");
        }
    }

    @Override
    public void acceleratorApplied() {
        if (!Applied) {
            Applied = true;
            System.out.println("Accelerator applied");
        } else {
            System.out.println("Accelerator already applied");

        }
    }

    @Override
    public void acceleratorReleased() {
        if (Applied) {
            Applied = false;
            System.out.println("Accelerator released");
        } else {
            System.out.println("Accelerator already released");

        }

    }

}
