import java.util.Scanner;

public class cryptoProject {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Type the code you wish to encrypt. ");
        String originalCode = input.nextLine();
        System.out.print("What is the encryption key would you like to use? (-26 < 26) ");
        int key = input.nextInt();
        System.out.print("How many characters would you like to display between each space? ");
        int spacing = input.nextInt();
        System.out.println("\n*******************************************************************************\n\n" + encryptString(originalCode, key, spacing));
    }

    public static String encryptString(String string, int shift, int spacing) {

        String normalizedString = normalizeText(string);
        String caesarifiedString = caesarify(normalizedString, shift);
        String endCode = groupify(caesarifiedString, spacing);
        return endCode;
    }

    public static String normalizeText(String string) {

        String normalizedString = string.replaceAll("[^\\p{Alpha}]+", "").toUpperCase();
        return normalizedString;

    }

    public static String caesarify(String obifiedString, int shift) {

        String caesarifiedString = "";

        for (int i = 0; i < obifiedString.length(); i++) {
            char letter = obifiedString.charAt(i);
            int pos = letter + shift;
            if (pos > 'Z') {
                pos -= 26;
            } else if (pos < 'A') {
                pos += 26;
            }
            char newLetter = (char) pos;
            caesarifiedString += newLetter;
        }
        return caesarifiedString;
    }

    public static String groupify(String caesarifiedString, int spacing){

        while (caesarifiedString.length() % spacing != 0){
            caesarifiedString += "x";
        }

        String endCode = "";

        for (int i = 0; i <= caesarifiedString.length() - spacing; i += spacing) {
            String segment = caesarifiedString.substring(i, i + spacing);
            endCode = endCode + segment + " ";
        }
        return endCode;
    }
}
