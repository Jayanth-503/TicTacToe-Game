import java.util.*;
class TicTacToe{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
        };
        printBoard(board);
        while(true){
            playerTurn(board,sc);
            if(isGameFinished(board)){
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
    }
    private static boolean isGameFinished(char[][] board) {
        if(hasWon(board,'X')){
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }
        if(hasWon(board,'O')) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == ' ')  return false;
            }
        }
        printBoard(board);
        System.out.println("Tie game");
        return true;
    }
    
    private static boolean hasWon(char[][] board, char symbol){
        if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
           (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
           (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
           
          (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
          (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
          (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
           
          (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
          (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol)) {
            return true;
        }
        return false;
    }
    
    private static void computerTurn(char[][] board){
        Random r = new Random();
        int cMove;
        while(true){
            cMove = r.nextInt(9)+1;
            if(isValidMove(board, Integer.toString(cMove))){
                break;
            }
        }
        System.out.println("Computer has chosen "+cMove);
        placeMove(board, Integer.toString(cMove), 'O');
    }
    
    private static boolean isValidMove(char[][] board, String pos){
        switch(pos){
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }
    
    private static void playerTurn(char[][] board, Scanner sc){
        String input;
        while(true){
            System.out.println("Enter the box number to play (1-9)");
            input = sc.nextLine();
            if(isValidMove(board,input))   break;
            else    System.out.println(input+" is an invalid move");
        }
        placeMove(board,input,'X');
    }
    
    private static void placeMove(char[][] board, String pos,char symbol){
        switch(pos){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }
    
    private static void printBoard(char[][] board){
        System.out.println(board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
    }
}