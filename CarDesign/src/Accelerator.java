public class Accelerator {
    boolean Applied;

    public void Applied() {
        if (!Applied) {
            Applied = true;
            System.out.println("Accelerator applied");
        } else {
            System.out.println("Accelerator already applied");

        }
    }
    public void Released() {
        if (Applied) {
            Applied = false;
            System.out.println("Accelerator released");
        } else {
            System.out.println("Accelerator already released");

        }
    }
}
