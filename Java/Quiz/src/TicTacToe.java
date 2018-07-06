import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		int player = 0;
		int winner = 0;
		int choice = 0;
		int row = 0;
		int column = 0;
		
		char board[][] = {
			{ '1', '2', '3'},
			{ '4', '5', '6'},
			{ '7', '8', '9'}
		};
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 9; && winner == 0; i++)
		{
			System.out.println();
			System.out.println();
			System.out.printf(" %C | %C | %C\n", board[0][0], board[0][1], board[0][2]);
			System.out.printf("---|---|---\n");
			System.out.printf(" %C | %C | %C\n", board[1][0], board[1][1], board[1][2]);
			System.out.printf("---|---|---\n");
			System.out.printf(" %C | %C | %C\n", board[2][0], board[2][1], board[2][2]);
			
			player = i % 2 +1;
			
			
		}
		
		

	}

}
