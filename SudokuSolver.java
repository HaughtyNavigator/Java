public class SudokuSolver {
    private static final int GRID_SIZE=9;
    public static void main(String[]args){

        //basically enter your board here and place 0 for any spaces left blank
        int[][]board={
                {5,1,4,0,0,2,3,0,8},
                {0,6,7,0,0,5,0,2,9},
                {8,0,9,7,0,4,5,0,1},
                {0,0,0,3,5,1,0,0,0},
                {0,3,8,0,0,0,0,0,0},
                {9,4,5,2,0,7,0,0,0},
                {0,8,2,0,0,0,0,9,0},
                {0,5,0,9,4,0,0,3,0},
                {6,9,0,1,0,0,0,4,0}
        };

        if(solveBoard(board)){
            System.out.println("Solved Successfully");
        }
        else{
            System.out.println("I can't solve it F");
        }

        printBoard(board);
    }

    //below method prints the board when solved
    private static void printBoard(int[][]board){
        for(int row=0; row<GRID_SIZE; row++){
            if(row==3||row==6){
                System.out.println();
            }
            for(int col=0; col<GRID_SIZE; col++){

                if(col==3||col==6){
                    System.out.print("   ");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    //below method checks if any number can be placed in row
    private static boolean numberInRow(int[][]board, int number, int row){
        for(int i=0; i<GRID_SIZE; i++){
            if(board[row][i]==number){
                return true;
            }
        }
        return false;
    }

    //same checks with column
    private static boolean numberInColumn(int[][]board, int number, int column){
        for(int i=0; i<GRID_SIZE; i++){
            if(board[i][column]==number){
                return true;
            }
        }
        return false;
    }

    //same checks with the 3x3 grid
    private static boolean numberInBox(int[][]board, int number, int row, int column){
        int localRow= row-row%3;
        int localColumn= column-column%3;

        for(int i=localRow; i<localRow+3; i++){
            for(int j=localColumn; j<localColumn+3; j++){
                if(board[i][j]==number){
                    return true;
                }
            }
        }
        return false;
    }

    //checks if the number is valid in the row,column and the grid(3x3)
    private static boolean isValid(int [][]board, int number, int row, int column){
        return !numberInRow(board, number, row) && !numberInColumn(board, number, column) && !numberInBox(board, number, row, column);
    }

    /*the method below runs the show, goes on recursively to solve the board, backtracking if once
    placed value was wrong and refixes the value then continues. Goes on row by row, column by column*/

    private static boolean solveBoard(int[][]board){
        for(int row=0; row<GRID_SIZE; row++){
            for(int column=0; column<GRID_SIZE; column++){
                if(board[row][column]==0){
                    for(int num=1; num<=GRID_SIZE; num++){
                        if(isValid(board, num, row, column)){
                            board[row][column]=num;

                            //recursive call to the function
                            if(solveBoard(board)){
                                return true; //the value placed is valid
                            }
                            else{
                                board[row][column]=0;
                            }
                        }
                    }
                    return false; //meaning the board is un-solve-able
                }
            }
        }
        return true; //returns true once solved
    }
}