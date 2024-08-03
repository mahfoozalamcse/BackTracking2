//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        // safe condition check

        // row
        for(int i=0; i<=8; i++){
           if(sudoku[i][col] == digit){
               return false;
           }
        }
        // col
        for(int j=0; j<=8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }
        // grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        // base case
        if(row == 9 && col == 0){
            return true;
        }
        // recursion

        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit<=9; digit++){
            if(isSafe(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){ // solution exist
                    return true;
                }
                sudoku[row][col] = 0;

            }
        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
     int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
                      {4, 9, 0 , 1, 5, 7, 0, 0, 2},
                       {0, 0, 3, 0, 0, 4, 1, 9, 0},
             {1, 8, 5, 0, 6, 0, 0, 2, 0},
             {0, 0 , 0 , 0, 2, 0, 0, 6, 0},
             {9, 6, 0, 4, 0, 5, 3, 0, 0},
             {0, 3, 0, 0, 7, 2, 0, 0, 4},
             {0, 4, 9, 0, 3, 0, 0, 5, 7},
             {8, 2, 7, 0, 0, 9, 0, 1, 3}};
     if(sudokuSolver(sudoku, 0, 0)){
         System.out.println("Solution Exist");
         printSudoku(sudoku);
     }else {
         System.out.println("Solution does not Exist");
     }
    }
}
    /*
      // t.c = O(n+m)  when back than Optamize code in linear using  Hints: permutation

    public static int printGridWay(int i, int j, int m, int n){
        // Base  case
        if(i == n-1 && j == m-1){  // last cell
            return 1;
        }else if(i == n || j == m){ // boundary cell
            return 0;
        }
       int w1 = printGridWay(i+1, j, n, m);
        int w2 = printGridWay(i, j+1, n, m);
        return w1+w2;
    }
    public static void main(String[] args) {
       int n =3, m = 3;
        System.out.println(printGridWay(0, 0, n, m));
    }
}

    /*

     // N Queen Problem please re visit check and more optimal make

    public static void nQueen(char board[][], int row){
        // base case
        if(row == board.length){
            printBoard(board);
            return;
        }
        // Kam
        for(int j=0; j< board.length; j++){
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueen(board, row + 1); // fn call
                board[row][j] = 'x';       // back Track
            }
        }
    }
    public static boolean isSafe(char board[][], int row, int col){
        // vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // diagonal left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // diagonal right
        for(int i =row-1, j = col+1; i>=0 && j< board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("----Chess Board------");
        for (int i=0; i< board.length; i++){
            for (int j=0; j< board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
      int n = 5;
      char board[][] = new char[n][n];
      for(int i=0; i< n; i++){
          for (int j=0; j< n; j++){
              board[i][j] = '.';
          }
      }
      nQueen(board, 0 );
    }
}
*/