import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row =0; row<3; row++){
            for(int col =0; col<3; col++){
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" Enter: ");
            System.out.print("row: ");
            int row = scanner.nextInt();
            System.out.print(" column: ");
            int col = scanner.nextInt();

            if(board[row][col] == ' '){
                // place the value
                board[row][col] = player;
                gameOver = haveWon(board, player);

                if(gameOver){
                    System.out.println(player+" won the game!!");
                } else {
                    if (player == 'X'){
                        player = 'O';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("invalid move! Try again");
            }
        }
        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        // row
        for (int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        // column
        for (int col = 0; col < board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        // diagonal
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }else if(board[2][0] == player && board[1][1] == player && board[0][2] == player){
            return true;
        }

        return false;
    }

    public static void printBoard( char[][] board) {
        for(int row =0; row<3; row++){
            System.out.print("|");
            for(int col =0; col<3; col++){
                System.out.print(board[row][col]+"|");
            }
            System.out.println();
        }
    }
}
