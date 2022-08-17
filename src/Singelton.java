//EAGER INITIALIZATION
/*
public class Singelton {
    private static Singelton instance = new Singelton();

    private Singelton() {
    }
    public static Singelton getInstance() {
        return instance;
    }

    public static void main(String args[]) {
        Singelton instance = Singelton.getInstance();
        System.out.println(instance);
        Singelton instance1 = Singelton.getInstance();
        System.out.println(instance1);
    }
}
*/

//LAZY INITIALIZATION
/*
public class Singelton {
    private static Singelton instance;

    private Singelton() {
    }

    public static Singelton getInstance() {
        if (instance == null) {
            instance = new Singelton();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singelton instance = Singelton.getInstance();
        System.out.println(instance);
        Singelton instance1 = Singelton.getInstance();
        System.out.println(instance1);

    }
}
*/
///THREAD SAFE Method initialization...used when multiple threads try to use singelton class. So multiple threads can access in Lazy initialization case but here only one thread can access.
/*public class Singelton {
    private static Singelton instance;

    private Singelton() {
    }

    public static synchronized Singelton getInstance() {
        if (instance == null) {
            instance = new Singelton();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singelton instance = Singelton.getInstance();
        System.out.println(instance);
        Singelton instance1 = Singelton.getInstance();
        System.out.println(instance1);

    }
}*/
//THREAD SAFE Block initialization.This case is like why to make whole method synchronised? Let's make the write block synchronised
public class Singelton {
    private static Singelton instance;

    private Singelton() {
    }
    public static synchronized Singelton getInstance() {
        if (instance == null) {
            synchronized (Singelton.class) {
                instance = new Singelton();
            }
        }
        return instance;
    }

    public static void main(String args[]) {
        Singelton instance = Singelton.getInstance();
        System.out.println(instance);
        Singelton instance1 = Singelton.getInstance();
        System.out.println(instance1);

    }
}