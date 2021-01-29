package Interview.String;
//https://www.geeksforgeeks.org/program-reverse-string-iterative-recursive/
//using recursion
public class ReverseAStringRecusrive {
    public static void reverseString(char[] input, int i) {
        int n = input.length;
        if (i == n / 2)
         return;
        swap(input,i,n-i-1);
        reverseString(input,i+1);

    }
    static char[] swap(char []arr, int i, int j)
    {
        char temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }


    public static void main(String args[]) {
        char[] input = "abcd".toCharArray();
        reverseString(input, 0);
        System.out.println(String.valueOf(input));


    }
}
