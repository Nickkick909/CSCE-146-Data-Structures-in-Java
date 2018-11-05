/*
 * Written by JJ Shepherd
 * This is a driver for a tic tac toe game.  Players take turns picking out coordinates and
 * placing markers.  The first player to get 3 in a row wins!
 * 
 */
import java.util.Scanner;
public class TicTacToeGame {

	public static void main(String[] args) {
		//Constructs the tic tac toe board
		TicTacToeBoard board = new TicTacToeBoard();
		//Sets up the scanner for user input
		Scanner keyboard = new Scanner(System.in);
		
		//These hold the coordinates that the user will enter to put their marker
		//X's are player 1 and O's are player two
		int xVal = 0;
		int yVal = 0;
		
		//Runs the game loop
		boolean gameOver = false; 
		//Determines if it is player 1 or player 2
		boolean player1Turn = true; 
		
		System.out.println("Welcome to Tic Tac Toe");		
		
		while(gameOver == false)//Game loop
		{
			board.drawBoard();
			
			System.out.println("Enter coordinates player "+(player1Turn?"1":"2"));
			xVal = keyboard.nextInt();
			yVal = keyboard.nextInt();
			
			//Using the x and y val it attempts to set that space to an X or O based on whose turn it is.
			if(board.setSpace(xVal, yVal, player1Turn?TicTacToeBoard.X_SPACE:TicTacToeBoard.O_SPACE))
			{
				//After the marker is placed a winning configuration is searched
				if(board.checkVictory())
				{
					board.drawBoard();
					
					//Depending who put the marker down determines the winner
					System.out.println("Player "+ (player1Turn?"1":"2")+ " wins!");
					
					//Determines whether or not to repeat the game
					System.out.println("Would you like to play again? Enter \"yes\" or \"no\"");
					String decision = keyboard.next();
					if(decision.equalsIgnoreCase("no"))//ends the game
					{
						System.out.println("Goodbye");
						break;
					}
					
					//Clears the board and starts over with player 1
					board.clearBoard();
					player1Turn = true;
				}
				//Checks if the board is completely filled
				else if(board.checkFilledBoard())
				{
					System.out.println("Board is filled!");
					
					//Determines whether or not to repeat the game
					System.out.println("Would you like to play again? Enter \"yes\" or \"no\"");
					String decision = keyboard.next();
					if(decision.equalsIgnoreCase("no"))//ends the game
					{
						System.out.println("Goodbye");
						break;
					}
					
					//Clears the board and starts over with player 1
					board.clearBoard();
					player1Turn = true;
				}
				else
				{
					//Changes the player's turn
					player1Turn = !player1Turn;
				}
			}
			else
			{
				//If a space wasn't empty or was out of the board range then prompt with an error
				System.out.println("That's an invalid space.  Try again.");
			}
		}
	}
}