import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    private static int count = 1;
    public int ID;
    public boolean checked;
    public int solution;
    public ArrayList<Integer> possibilities = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    public int cluster;
    public int horz;
    public int vert;

    public Sudoku() {
        this.checked = false;
        this.solution = 0;
        this.possibilities = possibilities;
        this.cluster = 0;
        this.horz = 0;
        this.vert = 0;
        this.ID = count;
        count++;
    }

    public void printID() {
        System.out.print(" " + this.ID + " ");
    }

    public void printSolution() {
        if (solution == 0) {
            System.out.print(" ~ ");
        } else System.out.print(" " + solution + " ");
    }

    public void confirmSolution(int s) {
        this.solution = s;
        while(possibilities.size() > 0) {
            possibilities.remove(0);
        }
    }

    public void printPossibilities() {
        System.out.print(" " + this.possibilities.size() + " ");
    }

    public int numberOfPossibilites() {
        return possibilities.size();
    }
}
