import java.util.*;

public class DoodlePage {

    private static Scanner input = new Scanner(System.in);
    private static Sudoku[][] sudoku = new Sudoku[9][9];

    public static void main(String[] args) {

        populateGameboard();
        //easy();
        medium();
        simpleSolve();
        addSolutions();
        checkForUniques();
        simpleSolve();
        addSolutions();
        printBoardPossibilites();
        checkForUniquesOnHorizontal(6,5);
        printBoard();



    }

    public static void populateGameboard() {

        for (int i = 0; i <sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++){
                sudoku[i][j] = new Sudoku();
                sudoku[i][j].horz = i + 1;
                sudoku[i][j].vert = j + 1;
                sudoku[i][j].cluster = (int) Math.floor(j/3) + (int) Math.floor(i/3) * 3 + 1;
            }
        }
    }

    public static void printBoard() {

        System.out.println("    1  2  3   4  5  6   7  8  9 \n");

        for (int i = 0; i <sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++){
                char c = (char)(i + 65);
                if (j == 0){ System.out.print(c + "  ");}
                sudoku[i][j].printSolution();
                if ((j + 1) % 3 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static void printBoardPossibilites() {

        System.out.println("    1  2  3   4  5  6   7  8  9 \n");

        for (int i = 0; i <sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++){
                char c = (char)(i + 65);
                if (j == 0){ System.out.print(c + "  ");}
                sudoku[i][j].printPossibilities();
                if ((j + 1) % 3 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static String status() {

        int canBeSolved = 0;

        for (int i = 0; i < sudoku.length; i++){
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j].possibilities.size() == 1) {
                    canBeSolved ++;
                }
            }
        }

        return canBeSolved + " squares have only one solution left and therefore can be solved.";
    }

    public static void manualInput() {
        System.out.print("Please enter coordinates of a known solution (example \"d3\") ");
        String coord = input.next();
        while (!coord.matches("^\\w\\d$")) {
            System.out.print("Please enter using the correct format ");
            coord = input.next();
        }
        char xChar = coord.toUpperCase().charAt(0);
        System.out.println(xChar);
        int x = (xChar - 65);
        System.out.println(x);
        int y = (coord.charAt(1) - 49);
        System.out.println(y);
        System.out.print("Solution = ");
        int s = input.nextInt();
        System.out.println(sudoku[x].length);
        sudoku[x][y].confirmSolution(s);
    }

    //https://www.websudoku.com/?level=1&set_id=3992853250
    public static void easy() {

        sudoku[0][0].confirmSolution(5);
        sudoku[0][3].confirmSolution(1);
        sudoku[0][7].confirmSolution(6);
        sudoku[0][8].confirmSolution(8);

        sudoku[1][3].confirmSolution(6);
        sudoku[1][5].confirmSolution(8);
        sudoku[1][6].confirmSolution(4);
        sudoku[1][8].confirmSolution(2);

        sudoku[2][0].confirmSolution(8);
        sudoku[2][1].confirmSolution(6);
        sudoku[2][2].confirmSolution(7);
        sudoku[2][3].confirmSolution(2);
        sudoku[2][4].confirmSolution(4);
        sudoku[2][6].confirmSolution(5);

        sudoku[3][0].confirmSolution(3);
        sudoku[3][2].confirmSolution(6);
        sudoku[3][6].confirmSolution(9);

        sudoku[4][1].confirmSolution(8);
        sudoku[4][7].confirmSolution(5);

        sudoku[5][2].confirmSolution(1);
        sudoku[5][6].confirmSolution(2);
        sudoku[5][8].confirmSolution(6);

        sudoku[6][2].confirmSolution(5);
        sudoku[6][4].confirmSolution(7);
        sudoku[6][5].confirmSolution(4);
        sudoku[6][6].confirmSolution(1);
        sudoku[6][7].confirmSolution(2);
        sudoku[6][8].confirmSolution(9);

        sudoku[7][0].confirmSolution(7);
        sudoku[7][2].confirmSolution(8);
        sudoku[7][3].confirmSolution(3);
        sudoku[7][5].confirmSolution(9);

        sudoku[8][0].confirmSolution(9);
        sudoku[8][1].confirmSolution(2);
        sudoku[8][5].confirmSolution(6);
        sudoku[8][8].confirmSolution(7);
    }

    //https://www.websudoku.com/?level=2&set_id=2417648914
    public static void medium() {

        sudoku[0][7].confirmSolution(4);
        sudoku[0][8].confirmSolution(8);

        sudoku[1][1].confirmSolution(4);
        sudoku[1][3].confirmSolution(6);
        sudoku[1][6].confirmSolution(7);
        sudoku[1][7].confirmSolution(9);

        sudoku[2][0].confirmSolution(9);
        sudoku[2][2].confirmSolution(8);
        sudoku[2][4].confirmSolution(7);
        sudoku[2][6].confirmSolution(2);

        sudoku[3][1].confirmSolution(7);
        sudoku[3][3].confirmSolution(9);
        sudoku[3][6].confirmSolution(3);

        sudoku[4][1].confirmSolution(9);
        sudoku[4][2].confirmSolution(4);
        sudoku[4][4].confirmSolution(3);
        sudoku[4][6].confirmSolution(5);
        sudoku[4][7].confirmSolution(7);

        sudoku[5][2].confirmSolution(3);
        sudoku[5][5].confirmSolution(1);
        sudoku[5][7].confirmSolution(8);

        sudoku[6][2].confirmSolution(5);
        sudoku[6][4].confirmSolution(1);
        sudoku[6][6].confirmSolution(9);
        sudoku[6][8].confirmSolution(6);

        sudoku[7][1].confirmSolution(1);
        sudoku[7][2].confirmSolution(7);
        sudoku[7][5].confirmSolution(6);
        sudoku[7][7].confirmSolution(5);

        sudoku[8][0].confirmSolution(4);
        sudoku[8][1].confirmSolution(6);

    }

    public static void simpleSolve() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (!sudoku[i][j].checked && sudoku[i][j].solution != 0) {
                    for (int k = 0; k < sudoku.length; k++) {
                        for (int l = 0; l < sudoku[k].length; l++){
                            if (sudoku[i][j].horz == sudoku[k][l].horz ||
                                    sudoku[i][j].vert == sudoku[k][l].vert ||
                                    sudoku[i][j].cluster == sudoku[k][l].cluster) {
                                if (sudoku[k][l].possibilities.contains(sudoku[i][j].solution)) {
                                    sudoku[k][l].possibilities.remove(sudoku[k][l].possibilities.indexOf(sudoku[i][j].solution));
                                }
                            }
                        }
                    }
                    sudoku[i][j].checked = true;
                }
            }
        }
    }

    public static void addSolutions() {
        for (int i = 0; i < sudoku.length; i ++) {
            for (int j = 0; j < sudoku[i].length; j++){
                if (sudoku[i][j].possibilities.size() == 1) {
                    sudoku[i][j].confirmSolution(sudoku[i][j].possibilities.get(0));
                }
            }
        }
    }

    public static void checkForUniquesWithinCluster(int x, int y) {

        boolean unique;

        for (int i = 0; i < sudoku[x][y].possibilities.size(); i++) {
            unique = true;
            for (int j = 0; j < sudoku.length; j++) {
                for (int k = 0; k < sudoku[j].length; k++) {
                    if (sudoku[j][k] != sudoku[x][y] &&
                            sudoku[j][k].cluster == sudoku[x][y].cluster &&
                            sudoku[j][k].possibilities.contains(sudoku[x][y].possibilities.get(i))) {
                        unique = false;
                    }
                }
            }
            if (unique) {
                sudoku[x][y].confirmSolution(sudoku[x][y].possibilities.get(i));
                System.out.println("bing!");
            }
        }
    }

    public static void checkForUniquesOnHorizontal(int x, int y) {

        boolean unique;

        for (int i = 0; i < sudoku[x][y].possibilities.size(); i++) {
            unique = true;
            System.out.println("Looking for " + sudoku[x][y].possibilities.get(i));
            for (int j = 0; j < sudoku[x].length; j++) {
                System.out.print("[" + x +"][" + j + "] - ");
                if (j != y && sudoku[x][j].possibilities.contains(sudoku[x][y].possibilities.get(i))) {
                        unique = false;
                        System.out.println(" found one!" );
                        break;
                    }
                }
            if (unique) {
                sudoku[x][y].confirmSolution(sudoku[x][y].possibilities.get(i));
                System.out.println(" Can't find!");
            }
            System.out.println();
        }
    }



    public static void checkForUniquesOnVertical(int x, int y) {

        boolean unique;

        for (int i = 0; i < sudoku[x][y].possibilities.size(); i++) {
            unique = true;
            for (int j = 0; j < sudoku.length; j++) {
                for (int k = 0; k < sudoku[j].length; k++) {
                    if (sudoku[j][k] != sudoku[x][y] &&
                            sudoku[j][k].vert == sudoku[x][y].vert &&
                            sudoku[j][k].possibilities.contains(sudoku[x][y].possibilities.get(i))) {
                        unique = false;
                    }
                }
            }
            if (unique) {
                sudoku[x][y].confirmSolution(sudoku[x][y].possibilities.get(i));
                System.out.println("bing!");
            }
        }

    }

    public static void checkForUniques() {

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j].solution == 0) {
                    checkForUniquesWithinCluster(i, j);
                   // if (sudoku[i][j].solution == 0) {
                     //   checkForUniquesOnHorizontal(i, j);
                        /*if (sudoku[i][j].solution == 0) {
                            checkForUniquesOnVertical(i,j);
                        }*/
                    }
                }
            }
        }
 //   }


    public static int canBeSolved() {

        int solvable = 0;

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                if (sudoku[i][j].numberOfPossibilites() == 1) {
                    solvable++;
                }
            }
        }
        return solvable;
    }

    public static void solve() {

        boolean moreToSolve = true;

        while (moreToSolve) {
            simpleSolve();
            if (canBeSolved() == 0) {
                moreToSolve = false;
            } else addSolutions();
        }
    }
}



