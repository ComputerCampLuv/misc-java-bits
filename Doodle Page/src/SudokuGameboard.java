public class SudokuGameboard {

    public Sudoku[][] gameboard = new Sudoku[9][9];

    public SudokuGameboard() {

        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                gameboard[i][j] = new Sudoku();
            }
        }

    }
}
