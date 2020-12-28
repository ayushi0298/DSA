package Interview.String;
//https://www.geeksforgeeks.org/microsoft-interview-experience-set-42-sde1/?ref=rp
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReverseCharacterStream {
    static String output ="";
    public void reverseStream(char temp) {
        output = temp + output;
    }

    public static void main(String args[]) throws IOException {
        ReverseCharacterStream rc = new ReverseCharacterStream();
        FileReader sourceStream = null;
        try {
            sourceStream = new FileReader("/Users/akamsh/IdeaProjects/DSA/src/Interview/String/input");
            int temp;
            while ((temp = sourceStream.read()) != -1) {
                //System.out.println((char)temp);
                rc.reverseStream((char) temp);
            }
            System.out.println(output);
        } finally {
            if (sourceStream != null)
                sourceStream.close();
        }
    }
}
