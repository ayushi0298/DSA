//EAGER INITIALIZATION
/*
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }
    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String args[]) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);
    }
}
*/

//LAZY INITIALIZATION
/*
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);

    }
}
*/
///THREAD SAFE Method initialization...used when multiple threads try to use Singleton class. So multiple threads can access in Lazy initialization case but here only one thread can access.
/*public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);

    }
}*/
//THREAD SAFE Block initialization.This case is like why to make whole method synchronised? Let's make the write block synchronised

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static void main(String args[]) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance1);

    }
}