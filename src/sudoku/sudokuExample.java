package sudoku;

public class sudokuExample {
    
    public static void main (String[] args) 
    {
        sudoku.setGrid(sudoku.parseProblem(args));
        System.out.println("Solving for grid...");
        sudoku.writeGrid(sudoku.getGrid());
        if (sudoku.solveGrid())
        {
            System.out.println("Found a solution..");
            sudoku.writeGrid(sudoku.getGrid());
        }
        else
        {
            System.out.println("No solution found!");
        }
    }

}
