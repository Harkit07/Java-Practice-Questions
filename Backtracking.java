public class Backtracking {

    public static void changeArr(int arr[], int i, int val) {
        if (i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;

        return;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    // find subsets
    public static void subsets(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // yes
        subsets(str, ans + str.charAt(i), i + 1);
        // no
        subsets(str, ans, i + 1);
    }

    public static void findPermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newVal = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newVal, ans + curr);
        }
    }

    // N Queens
    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static boolean isQueenSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // daigonal left up\
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // daigonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            System.out.println("---- chess board ----");
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isQueenSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = '.';
            }

        }
    }

    // grid ways
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    // Soduko Solver
    public static void printSoduko(int soduko[][]) {
        for (int i = 0; i < soduko.length; i++) {
            for (int j = 0; j < soduko.length; j++) {
                System.out.print(soduko[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static boolean isSudokuSafe(int soduko[][], int row, int col, int digit) {
        // column
        for (int i = 0; i <= 8; i++) {
            if (soduko[i][col] == digit) {
                return false;
            }
        }

        // row
        for (int i = 0; i <= 8; i++) {
            if (soduko[row][i] == digit) {
                return false;
            }
        }

        // grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (soduko[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int soduko[][], int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }

        int nextrow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextCol = 0;
        }

        if (soduko[row][col] != 0) {
            return sudokuSolver(soduko, nextrow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSudokuSafe(soduko, row, col, digit)) {
                soduko[row][col] = digit;
                if (sudokuSolver(soduko, nextrow, nextCol)) {
                    return true;
                }
                soduko[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // subsets(str, "", 0);
        // findPermutation(str, "");

        // int n = 4;
        // char board[][] = new char[n][n];

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = '.';
        // }
        // }

        // printBoard(board);
        // nQueens(board, 0);

        // System.out.println(gridWays(0, 0, 3, 3));

        // Sudoku
        int sudoku[][] = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };

        sudokuSolver(sudoku, 0, 0);
        printSoduko(sudoku);
    }

}
