import java.util.Scanner;

public class TicTacToe
 {
    public static void main(String[] args)
     {

        Scanner sc = new Scanner(System.in);

        char[][] board = 
        {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
        }; //double bracket because it is a 2 dimensional array

        char player = 'X'; //player can use either X or O but it would start with X
        int choice; //to store which position the user chose
        int count = 0; //total positions are 9 so count will store the number of moves, less than 10
        boolean win = false;

        System.out.println("TWO PLAYER TIC TAC TOE GAME ");

        while (count < 9 && !win)
         {

            // Original board of the game with the positions
            for (int i = 0; i < 3; i++)
             {
                System.out.println(" " + board[i][0] + " | "
                        + board[i][1] + " | " + board[i][2]);
                System.out.println("---|---|---");
             }

            System.out.println("Player " + player + ", enter position (1-9):");
            choice = sc.nextInt();

            if (choice < 1 || choice > 9)
             {
                System.out.println("Invalid choice!");
                continue;
             }

            int row = (choice - 1) / 3;
            int col = (choice - 1) % 3;

            if (board[row][col] == 'X' || board[row][col] == 'O')
             {
                System.out.println("Position already taken!");
                continue;  //goes to the starting of the loop again
            }

            board[row][col] = player;
            count++;

            //This control structure part checks who is the winner
            for (int i = 0; i < 3; i++)
             {
                if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) 
                    {
                      win = true;
                    }

                if (board[0][i] == player &&
                    board[1][i] == player &&
                    board[2][i] == player)
                     {
                       win = true;
                     }
            }

            if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) 
                {
                  win = true;
                }

            if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) 
                {
                  win = true;
                }

            if (win)
             {
                System.out.println("Player " + player + " wins!"); //who won?
             } 
            else if (count == 9)
             {
                System.out.println("Match Draw!"); //if the match is draw
             } 
            else 
                {
                   if (player == 'X')
                    {
                      player = 'O';
                    } 
                   else
                     {
                      player = 'X';
                     }
                }
        }

        //This part would display the final board
        for (int i = 0; i < 3; i++)  
         {
            System.out.println(" " + board[i][0] + " | "
                    + board[i][1] + " | " + board[i][2]);
            System.out.println("---|---|---");
         }
    }
}
