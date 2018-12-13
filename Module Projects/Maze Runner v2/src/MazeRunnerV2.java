import java.util.Scanner;

public class MazeRunnerV2 {

    static Maze myMap = new Maze();
    static Scanner input = new Scanner(System.in);
    static String movementKeys = "WASDwasd";
    static String nextMove;

    public static void main(String[] args){

        stateOfPlay();
        //System.out.println("Did you win? " + myMap.didIWin());
        whereNext();
        for (int turn = 1; turn <= 10; turn++){
            userMover(userInput());
            stateOfPlay();
            if (myMap.didIWin()){
                System.out.println("Congratulations, you made it out alive!\n" +
                        "You did it in " + turn++ +" moves.");
                break;
            }
            if (turn == 5){
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
            } else if (turn == 7){
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
            } else if (turn == 9){
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
            } else if (turn == 10){
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;
            } else System.out.println("You have had " + turn + " moves");

            whereNext();
        }

    }

    public static void stateOfPlay(){

        System.out.println("\nHere is the current map. You are at 'x'.\n");
        myMap.printMap();

    }

    public static void whereNext(){

        System.out.print("Where would you like to move next? (W,A,S,D)");
    }

    public static String userInput() {

        nextMove = input.next();

        if(nextMove.length() != 1) {
            System.out.print("You can only enter one move at a time");
            userInput();
        } else if (movementKeys.contains(nextMove)) {
            //intentionally empty. Skip to return
        } else {
            System.out.print("Use the 'W,A,S,D' keys to move");
            userInput();
        }
        return nextMove.toLowerCase();
    }

    public static void userMover(String nextMove){

        if (nextMove.equals("w")) {
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else if (myMap.isThereAPit("U")){
                String dir = "U";
                navigatePit(dir);
            } else {
                System.out.print("Sorry, you've hit a wall. Where next? ");
                userMover(userInput());
            }
        } else if (nextMove.equals("a")) {
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else if (myMap.isThereAPit("L")){
                String dir = "L";
                navigatePit(dir);
            } else {
                System.out.print("Sorry, you've hit a wall. Where next? ");
                userMover(userInput());
            }
        } else if (nextMove.equals("s")) {
            if (myMap.canIMoveDown()) {
                myMap.moveDown();
            } else if (myMap.isThereAPit("D")){
                String dir = "D";
                navigatePit(dir);
            } else {
                System.out.print("Sorry, you've hit a wall. Where next? ");
                userMover(userInput());
            }
        } else
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else if (myMap.isThereAPit("R")){
                    String dir = "R";
                    navigatePit(dir);
            } else {
                System.out.print("Sorry, you've hit a wall. Where next? ");
                userMover(userInput());
            }
    }

    public static void navigatePit(String dir){

        System.out.println("Crap, there's a great big fucking hole!\nDo you wan't to Jump over? ");
        if (input.next().toUpperCase().startsWith("Y")) {
            myMap.jumpOverPit(dir);
        } else {
            System.out.println("I guess we'll just stay here then!!!");
        }

    }
}

