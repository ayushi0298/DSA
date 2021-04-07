public class Brakes {
    boolean isBrakesApplied;

    public boolean isBrakesApplied() {
        return isBrakesApplied;
    }

    public void setBrakesApplied(boolean brakesApplied) {
        isBrakesApplied = brakesApplied;
    }

    public void BrakesApplied() {
        if (!isBrakesApplied) {
            isBrakesApplied = true;
            System.out.println("Brake applied");
        } else {
            System.out.println("Brake already applied");

        }
    }

    public void BrakesReleased() {
        if (isBrakesApplied) {
            isBrakesApplied = false;
            System.out.println("Brake released");
        } else {
            System.out.println("Brake already released");
        }
    }
}
