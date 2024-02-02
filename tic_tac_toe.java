import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean wasend = false;
        char player = 'X';
        char[][] board = new char[3][3];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }

        System.out.println();
        int count = 0;

        while(!wasend){
            printboard(board);
            System.out.println();
            int r,c;
            System.out.println("player "+player+" enter r & c:");
            r = sc.nextInt();
            c = sc.nextInt();
            if(board[r][c] == ' '){
                count++;
                board[r][c] = player;
                if(haswon(board,player)){
                    printboard(board);
                    System.out.print("player "+player+ " won!!");
                    break;
                }
                else{
                    player = (player == 'X')? 'O':'X';
                }
            }
            else{
                System.out.println("invalid move");
            }
            if(count == 9){
                 printboard(board);
                 System.out.print("Match Draw");
                 wasend = true;
            }
    
        }
    }

    public static boolean haswon(char[][] board, int player){
        //check the row
        for(int i=0; i<3; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player){
                return true;
            }
        }
        //check for col
         for(int i=0; i<3; i++){
             if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                 return true;
             }
         }
         //diagonal
         if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
             return true;
         }
         if(board[0][2] == player &&board[1][1] == player &&board[2][0] == player){
             return true;
         }
         return false;
    }

    public static void printboard(char[][] board){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
}
