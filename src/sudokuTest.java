import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.sudoku;


public class sudokuTest {

    @Test
    public void goodTest() {
        String good1 = "014 043 051 067 " +
                        "152 173 186 " + 
                        "215 223 237 271 " +
                        "325 348 382 " +
                        "404 466 " +
                        "502 521 553 578 " +
                        "638 655 " +
                        "728 754 " +
                        "841 885";
       sudoku myPuzzle = new sudoku();
       myPuzzle.setGrid(myPuzzle.parseProblem(good1.split(" ")));
       myPuzzle.writeGrid();
       if(myPuzzle.solveGrid())
       {
           myPuzzle.writeGrid();
           //pass("We passed!");
       }
       else
       {
           fail("We failed");
       }
    }
    
    @Test
    public void badTest()
    {
        String bad1 = "019 049 059 069 " +
                        "159 179 189 " + 
                        "219 229 239 279 " +
                        "329 349 389 " +
                        "409 469 " +
                        "509 529 559 579 " +
                        "639 659 " +
                        "729 759 " +
                        "849 879";
        sudoku myPuzzle = new sudoku();
        myPuzzle.setGrid(myPuzzle.parseProblem(bad1.split(" ")));
        myPuzzle.writeGrid();
        if(myPuzzle.solveGrid())
        {
            fail("We failed");
        }
        else
        {
            //We passed! 
        }
    }

}
