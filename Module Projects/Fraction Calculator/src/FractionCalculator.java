import java.util.Scanner;

public class FractionCalculator {

   private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        intro();
        System.out.println(getOperation(input));

    }

    public static void intro() {

        System.out.println("This program is a fraction calculator\n" +
                "It will add, subtract, multiply and divide fractions until you type Q to quit.\n" +
                "Please enter your fractions in the form a/b, where a and b are integers.\n" +
                "------------------------------------------------------------------------------ ");
    }

    //Asks the user to enter in a valid mathematical operation. If the user enters anything except "+", "", "/", "*", "=", "q", or "Q" it should re-prompt them until there is valid input.
    public static String getOperation(Scanner input) {

        String allowedInputs = "+-/*=Qq";
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operation = input.next();

        while ((operation.length() != 1) || (!allowedInputs.contains(operation))) {
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operation = input.next();
        }
        return operation;
    }

    //returns true if the parameter is in the form "a/b" where a is any int and b is any positive int
    /*public boolean validFraction(String input) {

    }

    //It prompts the user for a String that is a validFraction. If they enter any thing that is not a valid Fraction, it should re-prompt them until it is valid
    public Fraction getFraction(Scanner input) {

    }*/
}
