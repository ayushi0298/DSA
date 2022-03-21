package CollectionFramework_InterviewBit;

public class Test {
    static int a = 10;
    static int b;

    // static block
    static {
        System.out.println("Static block initialized.");
        b = a * 4;
    }
    public void  change(){
        a= a+10;
        System.out.println(a);

    }

    public static void main(String[] args)
    {
        Test t= new Test();
        System.out.println("from main");
        System.out.println("Value of a : "+a);
        System.out.println("Value of b : "+b);
       t.change();

    }
}
