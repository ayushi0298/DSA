package CollectionFramework_InterviewBit;

//Functional interface

public interface hi{
    int calculate(int x);

}
class a {

    public static void main(String args[]) {

        int a = 9;
        hi h = (int x) -> x * x;
        int ans = h.calculate(a);
        System.out.println(ans);
    }
}
