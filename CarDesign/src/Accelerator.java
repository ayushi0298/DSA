public class Accelerator {
    boolean isAcceleratorApplied;

    public boolean isAcceleratorApplied() {
        return isAcceleratorApplied;
    }

    public void setAcceleratorApplied(boolean acceleratorApplied) {
        isAcceleratorApplied = acceleratorApplied;
    }

    public void AcceleratorApplied() {
        if (!isAcceleratorApplied) {
            isAcceleratorApplied = true;
            System.out.println("Accelerator applied");
        } else {
            System.out.println("Accelerator already applied");

        }
    }

    public void AcceleratorReleased() {
        if (isAcceleratorApplied) {
            isAcceleratorApplied = false;
            System.out.println("Accelerator released");
        } else {
            System.out.println("Accelerator already released");

        }
    }
}
