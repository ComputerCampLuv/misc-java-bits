import java.util.*;

public class OddsEvens {

    private static String name;
    private static int playerOddEven;
    private static Scanner input = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        //divider();
        //greeting();
        //oddsEvensChoice();
        //divider();
        //fingerBang();
        //divider();
    }
    public static void greeting(){
        System.out.println("Let's play a game called \"Odds And Evens\"");
        divider();
        System.out.print("What is your name? ");
        name = input.nextLine();
    }
    public static void oddsEvensChoice(){
    System.out.print("Hi " + name + ", what do you choose? (O)dds or (E)vens? ");
        if (input.next().toUpperCase().startsWith("O")){
            playerOddEven = 1;
            System.out.println(name + " chooses Odds, computer will be Evens");
        }else {
            playerOddEven = 0;
            System.out.println(name + " chooses Evens, computer will be Odds");
        }
    }
    public static void divider(){
        System.out.println("-------------------------------------------------------");
    }
    public static void fingerBang(){
        System.out.print("Okay " + name + ", how many fingers do you play? ");
        int playerFingers = input.nextInt();
        int compFingers = rand.nextInt(6);
        System.out.println(name + " chooses " + playerFingers + ". Computer plays " + compFingers + ".");
        divider();
        System.out.println(playerFingers + " + " + compFingers + " = " + (playerFingers + compFingers));
        int result = (playerFingers + compFingers) % 2;
        if (result == 0){
            System.out.println("The result is Even!");
            if (playerOddEven == 0){
                System.out.println(name + " is the winner :D");
            } else {
                System.out.println("Finally robotic beings rule the world!");
            }
        } else{
            System.out.println("The result is Odd!");
            if (playerOddEven == 1){
                System.out.println(name + " is the winner :D");
            } else {
                System.out.println("Finally robotic beings rule the world!");
            }
        }
    }
}