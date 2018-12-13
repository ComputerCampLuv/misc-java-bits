import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class BattleShips {

    private static Scanner input = new Scanner(System.in);
    private static char[][] gameBoard = gameBoardCreate();
    private static char[][] enemyStrikes = new char[10][10];
    private static Random rand = new Random();
    private static int playerShips;
    private static int enemyShips;

    public static void main(String[] args) {

        intro();
        gameBoardPrint(gameBoard);
        userDeployment();
        compDeployment();
        battle();
    }

    public static void intro() {

        System.out.println("\n**Welcome to Battle Ships**");
        System.out.println("\nRight now the seas are vacant\n");
    }

    public static char[][] gameBoardCreate() {

        char[][] gameBoard = new char[14][14];
        for (int i = 0; i < gameBoard.length; i++) {
            Arrays.fill(gameBoard[i], ' ');
        }
        for (int i = 0; i < gameBoard.length; i += gameBoard.length - 1) {
            for (int j = 2; j < gameBoard[i].length - 2; j++) {
                gameBoard[i][j] = (char) (j + 46);
            }
        }
        for (int i = 1; i < gameBoard.length; i += gameBoard.length - 3) {
            for (int j = 2; j < gameBoard[i].length - 2; j++) {
                gameBoard[i][j] = '-';
            }
        }
        for (int i = 1; i < gameBoard.length - 1; i ++) {
            for (int j = 1; j < gameBoard[i].length; j += gameBoard[i].length - 3) {
                gameBoard[i][j] = '|';
            }
        }
        for (int i = 2; i < gameBoard.length - 2; i++) {
            for (int j = 0; j <= gameBoard[i].length; j += gameBoard[i].length - 1) {
                gameBoard[i][j] = (char) (i + 63);
            }
        }
        return gameBoard;
    }

    public static void gameBoardPrint(char[][] gameBoard) {

        for (int i = 0; i < gameBoard.length; i++) {

            for (int j = 0; j < gameBoard[i].length; j++) {
                if (j < gameBoard[i].length - 1) {
                    if (gameBoard[i][j] == 'P'){
                        System.out.print("@ ");
                    } else if (gameBoard[i][j] == 'Z') {
                        System.out.print("  ");
                    } else {
                        System.out.print(gameBoard[i][j] + " ");
                        }
                } else {
                    System.out.println(gameBoard[i][j]);
                }
            }
        }
        System.out.println("");
    }

    public static void scoreBoardPrint () {

        System.out.println(" ________________________________ \n" +
                "|                                |\n" +
                "| Player Ships " + playerShips + " - " + enemyShips + " Enemy Ships |\n" +
                "|________________________________|\n");
    }

    public static void userDeployment() {

        System.out.println("You must now place your fleet of 5 ships" +
                "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Please enter a Y coordinate for your ship (A - J) ");
            int y = getY();
            System.out.print("Please enter an X coordinate for your ship (0 - 9) ");
            int x = getX();
            while (gameBoard[y][x] == 'P') {
                System.out.println("You already have a ship placed at that location" +
                        "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
                System.out.print("Please enter a Y coordinate for your ship (A - J) ");
                y = getY();
                System.out.print("Please enter an X coordinate for your ship (0 - 9) ");
                x = getX();
            }
            gameBoard[y][x] = 'P';
            gameBoardPrint(gameBoard);
        }
        playerShips = 5;
        System.out.println("Orders received. All ships in position" +
                "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

    public static void compDeployment () {

        for (int i = 1; i <= 5; i++) {
            int y = rand.nextInt(10) + 2;
            int x = rand.nextInt(10) + 2;
            while (gameBoard[y][x] != ' ') {
                y = rand.nextInt(10) + 2;
                x = rand.nextInt(10) + 2;
                //System.out.println("Ships on collision course");
            }
            gameBoard[y][x] = 'Z';
            enemyStrikes[y - 2][x - 2] = 'O';
            //System.out.println("Computer has successfully placed ship " + i);
        }
        enemyShips = 5;
        //System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        scoreBoardPrint();
    }

    public static int getX() {

        int x = input.nextInt() + 2;
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        while ((x < 2) || (x > 11)) {
            System.out.print("Try again, but this time between 0 and 9 you fool!");
            x = input.nextInt() + 2;
        }
        return x;
    }

    public static int getY() {

        int y = (int) Character.toUpperCase(input.next().charAt(0)) - 63;
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        while ((y < 2) || (y > 11)) {
            System.out.print("Try again, but this time between A and J you fool!");
            y = (int) Character.toUpperCase(input.next().charAt(0)) - 63;
        }
        return y;
    }

    public static void battle() {

        System.out.println("You will now take it in turns to launch strikes\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        while (isGameOver() == false) {
            userStrike();
            if (isGameOver()) {
                break;
            } else {
                enemyStrike();
            }
        }
        if (playerShips == 0) {
            System.out.println("***********************************************\n" +
                               "******GAME OVER - You have been defeated!******\n" +
                               "***********************************************\n");
        } else {
            System.out.println("***********************************************\n" +
                               "****Congratulations - The enemy is defeated****\n" +
                               "***********************************************\n");
        }
    }

    public static void userStrike(){

        System.out.print("Please enter Y coordinate (A - J) ");
        int y = getY();
        System.out.print("Please enter X coordinate (0 - 9) ");
        int x = getX();

        while ((gameBoard[y][x] == 'X') || (gameBoard[y][x] == '-') || (gameBoard[y][x] == '!')) {
            System.out.println("You've already tried those coordinates");
            System.out.print("Please enter Y coordinate (A - J) ");
            y = getY();
            System.out.print("Please enter X coordinate (0 - 9) ");
            x = getX();
        }
        if (gameBoard[y][x] == 'P') {
            System.out.println("Traitor! Thankfully all crew members perished and none will here of your treachery");
            gameBoard[y][x] = 'X';
            playerShips--;
        } else if (gameBoard[y][x] == 'Z') {
            System.out.println("You got the bastards! Fine shooting Sir");
            gameBoard[y][x] = '!';
            enemyShips--;
        } else {
            System.out.println("MISS");
            gameBoard[y][x] = '-';
        }
        gameBoardPrint(gameBoard);
    }

    public static void enemyStrike() {

        int y = rand.nextInt(10) + 2;
        int x = rand.nextInt(10) + 2;

        while (enemyStrikes[y - 2][x - 2] == 'O' ) {
            y = rand.nextInt(10) + 2;
            x = rand.nextInt(10) + 2;
        }
        enemyStrikes[y - 2][x - 2] = 'O';

        if (gameBoard[y][x] == 'P') {
            System.out.println("***********************************************\n" +
                               "****The enemy has hit and destroyed a ship!****\n" +
                               "***********************************************\n");
            gameBoard[y][x] = 'X';
            playerShips--;
        } else {
            System.out.println("***********************************************\n" +
                               "*************The enemy has MISSED!*************\n" +
                               "***********************************************\n");
        }
    }

    public static boolean isGameOver() {

        if ((playerShips > 0) && (enemyShips > 0)) {
            return false;
        }
        return true;
    }

}
