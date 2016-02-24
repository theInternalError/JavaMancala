/** MancalaBoard.java
 * 
 * The base setup for a game of Mancala
 * There are 14 total spaces, which are composed of the 2 player "stores" and 12 "slots" arranged as so:
 * 
 * Space names:
 * 		  	B6 B5 B4 B3 B2 B1
 * 		PB				PA
 * 			A1 A2 A3 A4 A5 A6
 * 
 * Space numbers:
 * 		13 12 11 10  9  8
 * 	     14			    7
 *  		 1  2  3  4  5  6
 * 
 * Space indexes:
 * 		12 11 10  9  8  7
 * 	     13			    6
 *  		 0  1  2  3  4  5
 * 
 * @author Jacob Rardin/theInternalError
 *
 */

public class MancalaBoard {
	
	private int[] board;
	
	public MancalaBoard() {
		// initialize and fill the starting board
		board = new int[14];
		int i = 0;
		while (i < board.length) {
			board[i] = i;
			if (i == 6 || i == 13)
				board[i] = 0;
			else
				board[i] = 4;				
			i++;
		}
	}
	
	/** getValues: returns the board array for viewing the values
	 * 
	 * @return the board array
	 */
	public int[] getValues() {
		return board;
	}
	
	/** getBoardCopy: returns a copy of the board
	 * 
	 * @return an integer array representation of the board
	 */
	public int[] getBoardCopy() {
		int[] copy = new int[14];
		System.arraycopy(board, 0, copy, 0, board.length);
		return copy;
	}
	
	/** pick: allows the game to request a particular move.
	 * 
	 * @param slot the slot to pick from
	 * @param side the player's ID; either 1 or 2
	 * @return the last slot deposited into; or 0 if invalid
	 */
	public int pick(int slot, int side) {
		int myStore = side*7 - 1;
		/* return your store if pick was invalid
		 * it should give another turn
		 */
		if (slot > myStore || slot < myStore-6 || board[slot] == 0)
			return side*7 - 1;
		else {
			// "grab" all of the pieces in the slot
			int pos = slot;
			int grab = board[slot];
			board[slot] = 0;
			
			// place the pieces one by one into each slot ccw, skipping the opponent's store
			while (grab > 0) {
				pos++;;
				if ((side == 1 && pos == 13)||(side == 2 && pos == 6)||(pos == slot))
					pos++;
				pos = pos % 14;
				grab--;
				board[pos]++;
			}
			
			return pos;
		}
	}
	
	/** checkCapture: attempt a capture on the given slot
	 * 
	 * @param slot the slot to check for a possible capture
	 * @param side the player's ID; either 1 or 2
	 * @return if a capture is (was) possible
	 */
	public boolean checkCapture(int slot, int side) {
		int opposite, captured = 0, myStore = side*7 - 1;
		// checks if this slot was previously empty, and if it is on the player's side
		if (board[slot] == 1 && slot < myStore && slot > myStore-6) {
			if (slot < 6)
				opposite = slot + (6-slot)*2;
			else
				opposite = slot - (slot-6)*2;
			captured += board[slot];
			captured += board[opposite];
			board[slot] = 0;
			board[opposite] = 0;
			board[myStore] += captured;
			
			return true;
		}
		else return false;
	}
	
	/** checkEnd: detects a win or stalemate
	 * 
	 * @return 0 if nothing, 1 if P1 won, 2 if P2 won, -1 if stalemate
	 */
	public int checkEnd() {
		boolean win1 = true, win2 = true;
		int i;
		// check if a player won by default
		if (board[6] == 25) return 1;
		if (board[13] == 25) return 2;
		
		// check if one player is out of moves
		for (i = 0; i < 6; i++) {
			if (board[i] != 0) win2 = false;
		}
		if (win2) return 2;
		for (i = 7; i < 13; i++) {
			if (board[i] != 0) win1 = false;
		}
		if (win1) return 1;
		
		// check for stalemate
		if (board[6] == 24 && board[13] == 24)
			return -1;
		
		// no win or stalemate detected
		return 0;
	}
	
	/** printBoard: prints a representation of the board state to console
	 * 
	 */
	public void printBoard() {
		int i;
		// top row
		System.out.print("---- ");
		for (i = 12; i > 6; i--)
			System.out.printf("%02d ", board[i]);
		System.out.println("----");
		// middle row
		System.out.printf(" %02d ", board[13]);
		for (i = 0; i < 18; i++)
			System.out.printf("=");
		System.out.printf("  %02d\n", board[6]);
		// bottom row
		System.out.print("---- ");
		for(i = 0; i < 6; i++)
			System.out.printf("%02d ", board[i]);
		System.out.println("----");
	}

}
