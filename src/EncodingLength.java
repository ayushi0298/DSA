public class EncodingLength {
    public String encoding(String text) {
        String encodedString = "";

        for (int i = 0, count = 1; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
                count++;
            else {
                encodedString = encodedString.concat(Integer.toString(count))
                        .concat(Character.toString(text.charAt(i)));
                count = 1;
            }
        }
        return encodedString;
    }

    // Driver code
    public static void main(String[] args) {
        EncodingLength g = new EncodingLength();
        String str = "GGGGGrrrrrrrrrrrrrrt";
        System.out.println(g.encoding(str));
    }
}
