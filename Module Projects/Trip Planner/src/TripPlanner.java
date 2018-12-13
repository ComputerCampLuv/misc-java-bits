import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TripPlanner {

    private static String name;
    private static String dest;

    public static void main(String[] args) {
        for (int i = 6; i < 13; i++){
            System.out.println(i);
        }
        //greeting();
        //timeBudget();
        //timeZone();
        //countryArea();
    }
    public static void greeting() {
        Scanner input = new Scanner(System.in);
        System.out.print("Hello friend, and who might you be? ");
        name = input.nextLine();
        System.out.print("Hmmm, " + name + "...that's a really terrible name. Bad luck!\nStill it isn't all bad, at least you're off on holiday. Where is it you're off to? ");
        dest = input.nextLine();
        System.out.println(dest + ", crikey! That place is a real shit hole.\n");
    }
    public static void timeBudget() {

        //The Q&A

        Scanner inputInt = new Scanner(System.in);
        Scanner inputDouble = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        System.out.print("How many days are you away for " + name + "? ");
        int dura = inputInt.nextInt();
        System.out.print(dura + " days. How much spending money are you taking?(£) ");
        int spendTotal = inputInt.nextInt();
        System.out.print("What currency do they use over there? ");
        String foreignCurr = inputString.nextLine();
        System.out.print("What is the exchange rate to pounds? ");
        double exRate = inputDouble.nextDouble();

        //The Math

        double foreignSpendTotal = spendTotal*exRate;
        double foreignSpendTotalNew = BigDecimal.valueOf(foreignSpendTotal)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        double foreignSpendDaily = foreignSpendTotal/dura;
        double foreignSpendDailyNew = BigDecimal.valueOf(foreignSpendDaily)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        //The Budget Summary

        System.out.println("\nThat means you're taking " + foreignSpendTotalNew + " " + foreignCurr + ".\nThat'll give you " + foreignSpendDailyNew + " " + foreignCurr + " to spend each day.\n" +
                "Now we could break that down further and tell you how much you can spend in each of your " + dura * 24 + " hours away, or the " + dura * 24 * 60 + " Minutes, but that would be retarded!\n");
    }
    public static void timeZone(){

        //The Q&A

        Scanner inputString = new Scanner(System.in);
        Scanner inputInt = new Scanner(System.in);
        System.out.print("Is the time zone there ahead or behind? ");
        String aheadBehind = inputString.next();
        System.out.print("How many hours are they " + aheadBehind + "? ");
        int timeDiff = inputInt.nextInt();

        if (aheadBehind.equals("ahead")) {
            timeDiff *=-1;
        }

        System.out.println("That means when it's Midday there, it'll be " + (36 + timeDiff) % 24 + ":00 back home. When it's Midnight, the time here will be " + (48 + timeDiff) % 24 + ":00\n");

    }
    public static void countryArea() {

        //Th Q&A

        Scanner inputInt = new Scanner(System.in);
        System.out.print("What is the square area of " + dest + "?(km2) ");
        int areaKm = inputInt.nextInt();
        System.out.print("In miles that's " + areaKm * 0.386102 + " Mi2");
    }
}

//40 - 75 new yorkish
//50 - 0 londish