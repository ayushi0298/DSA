public class Brakes {
    boolean Applied;

    public void Applied() {
        if (!Applied) {
            Applied = true;
            System.out.println("Brake applied");
        } else {
            System.out.println("Brake already applied");

        }
    }

    public void Released() {
        if (Applied) {
            Applied = false;
            System.out.println("Brake released");
        } else {
            System.out.println("Brake already released");
        }
    }
}
