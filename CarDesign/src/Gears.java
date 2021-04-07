public class Gears {
    boolean isApplied;

    public boolean isApplied() {
        return isApplied;
    }

    public void setApplied(boolean applied) {
        isApplied = applied;
    }

    public void isGearsApplied() {
        if(!isApplied){
            isApplied=true;
            System.out.println("gears applied");
        }
        else{
            System.out.println("gears already applied");

        }
    }
    public void isGearsReleased() {
        if(isApplied){
            isApplied=false;
            System.out.println("gears released");
        }
        else{
            System.out.println("gears already released");

        }
    }
}
