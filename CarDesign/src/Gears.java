public class Gears {
    boolean Applied;

    protected void Applied() {
        if(!Applied){
            Applied=true;
            System.out.println("gears applied");
        }
        else{
            System.out.println("gears already applied");

        }
    }
    protected void Released() {
        if(Applied){
            Applied=false;
            System.out.println("gears released");
        }
        else{
            System.out.println("gears already released");

        }
    }
}
