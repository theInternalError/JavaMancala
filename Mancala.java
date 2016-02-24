import java.util.Scanner;


public class Mancala {
	
	public static void main(String[] args){
		System.out.println("Starting Mancala...");
		// create the board
		MancalaBoard board = new MancalaBoard();
		
		// game variables
		int side = 1, choice = 0, last;
		String input;
		boolean won = false;
		
		// main game loop
		while (!won) {
			// prompt player for input
			System.out.println("Player " + side + "'s turn:");
			board.printBoard();
		    System.out.println("What is your move?");
		    Scanner in = new Scanner(System.in);
		    input = in.nextLine();
			choice = Integer.parseInt(input);
			choice--;
			if (side == 2) choice += 7;
			
			// play the selected move
			last = board.pick(choice, side);
			if (last == (side*7 - 1)) continue;
			else {
				board.checkCapture(last, side);
				
				// print board and switch sides
				System.out.println();
				side = (side == 1) ? 2 : 1;
			}
		}
		
		//in.close();
		return;
	}

}
