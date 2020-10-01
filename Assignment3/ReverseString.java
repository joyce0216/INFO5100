package info5100;

public class ReverseString {
    private String s;

    public ReverseString(String s){
        this.s = s;
    }

    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        //trim the space in the front and back
        //split words by multiple spaces
        String[] words = s.trim().split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }

    public static void printStrings(String origin, String reversed) {
        System.out.println("Origin string: " + origin + "; Reversed string: " + reversed);
    }

    public static void main(String[] args){
        String string1 = "I love Java";
        ReverseString rs1 = new ReverseString(string1);
        String rString1 = rs1.reverse(string1);
        printStrings(string1, rString1);

        String string2 = " ";
        ReverseString rs2 = new ReverseString(string2);
        String rString2 = rs2.reverse(string2);
        printStrings(string2, rString2);

        String string3 = "  Java      is full    of   fun!!            ";
        ReverseString rs3 = new ReverseString(string3);
        String rString3 = rs3.reverse(string3);
        printStrings(string3, rString3);
    }
}
