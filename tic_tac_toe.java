import java.util.Scanner;

class tic_tac_toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        int turns = 0;

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + ", enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Validate input
            if (isValidMove(board, row, col)) {
                board[row][col] = player;
                turns++;
                gameOver = haveWon(board, player);

                if (gameOver) {
                    printBoard(board);
                    System.out.println("Player " + player + " has won!");
                } else if (turns == 9) {
                    // Check for draw (board is full)
                    printBoard(board);
                    System.out.println("The game is a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            } else {
                System.out.println("Invalid move. Please try again!");
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false; // Invalid row/col
        }
        return board[row][col] == ' '; // Check if the cell is empty
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Diagonal
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) { // Diagonal
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
}
