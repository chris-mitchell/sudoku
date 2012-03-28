package sudoku;

public class sudoku {
    
    //Multi-dimensional array to hold our grid
    private static int[][] sudokuGrid;
    
    public static void setGrid(int[][] grid)
    {
        sudokuGrid = grid;
    }
    
    public static int[][] getGrid()
    {
        return sudokuGrid;
    }
    
    public static boolean solveGrid()
    {
        return solveCell(0,0);
    }
    
    private static boolean solveCell(int i, int j)
    {
        //Have we solved for everything on the row?
        if (i == 9)
        {
            //Move counters to next row
            i = 0;
            if (++j == 9)
            {
                return true;
            }
        }
        //Already been solved/provided? 
        if (sudokuGrid[i][j] != 0)
        {
            //Move to next column
            return solveCell(i+1,j);
        }
        
        //Take a guess!
        for (int guess = 1; guess <= 9; ++guess)
        {
            if (legalGuess(i, j, guess))
            {
                sudokuGrid[i][j] = guess;
                if (solveCell(i+1,j))
                {
                    //Should reach here if valid grid was provided.
                    return true;
                }
            }
        }
        
        //We will only return false if an invalid grid was provided. 
        sudokuGrid[i][j] = 0; 
        return false;
    }
    
    private static boolean legalGuess(int i, int j, int guess)
    {
        //First check the row to see if our guess has been used
        for (int k=0; k< 9; ++k)
        {
            if (guess == sudokuGrid[i][j])
            {
                return false;
            }
        }
        
        //Next check our column
        for (int k = 0; k < 9; ++k)
        {
            if (guess == sudokuGrid[i][j])
            {
                return false;
            }
        }
        
        //Ensure it hasn't been used in the box either...
        //Use integer arithmetic to figure out appropriate spot
        //ie: if i = 4, i/3 = 1, 1 * 3 = 3. 
        int boxRowOffset = (i/3)*3;
        int boxColOffset = (j/3)*3;
        for (int k = 0; k < 3; ++k)
        {
            for (int m = 0; m < 3; ++m)
            {
                if (guess == sudokuGrid[boxRowOffset+k][boxColOffset+m])
                {
                    return false;
                }
            }
        }
        
        //We haven't violated any rule yet...we can use our guess.
        return true;
    }
    
    public static int[][] parseProblem(String[] args) 
    {
        /*
         * We assume we will be given data formed in the following way:
         * ijX
         * Where i,j indicate the coordinates on the grid, and X will be the value to place
         * We do not check for values, and will overwrite if given two values for the same
         * coordinate
         */
        
        int[][] problem = new int[9][9]; // default 0 vals
        for (int n = 0; n < args.length; ++n) 
        {
            int i = Integer.parseInt(args[n].substring(0,1));   
            int j = Integer.parseInt(args[n].substring(1,2));   
            int val = Integer.parseInt(args[n].substring(2,3)); 
            problem[i][j] = val;
        }
        
        return problem;
    }

    public static void writeGrid()
    {
        //Assume we want to use the default grid...
        writeGrid(getGrid());
    }
    
    public static void writeGrid(int[][] solution) 
    {
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
            System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
            if (j % 3 == 0) System.out.print("| ");
            System.out.print(solution[i][j] == 0
                     ? " "
                     : Integer.toString(solution[i][j]));
            
            System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

}
