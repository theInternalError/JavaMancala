# JavaMancala
A game built in less than 12 hours for the Sigma Phi Delta Coding Challenge during Cal Poly's e-Week 2016. It has a simple console interface with text-graphic representations.

USAGE:
Run the Mancala class, which is the 2-player console-based driver for MancalaBoard.

HOW TO PLAY:
After starting the game, you will be presented with a textual representation of the board, which includes indicators for each space to the top and bottom of the board. There are 14 total spaces, divided into two rows of 6 ("slots") and one large space ("store") on either side of the board. Player 2 owns the store as well as the top row of slots, while Player 1 owns the right store and the bottom row.

The game will tell you whose turn it is and prompt for a selection. The game will accept an integer value from 1-6 as input, which corresponds to a slot IN YOUR ROW.

RULES:
The goal of the game is to move as the most points out of the horizontal rows and into your store on the side of the board.

--To play, you select a slot (1-6) IN YOUR ROW to empty. Its contents are then deposited, one by one, into each successive space moving counterclockwise. Your opponent's store is skipped.

--If the last space deposited into is your store, you get to go again.

--If the last space deposited into is an empty slot IN YOUR ROW, you "capture" the contents of that slot as well as the slot directly on the other side to your store.

--The game is won by the first player to reach 25 points, or when your opponent's slots are all empty.


SAMPLE SETUP:

 P2  (6) (5) (4) (3) (2) (1)          <--- P2's guide row
---- 06  06  07  07  00  01 ----      <--- P2's slots
 01 ======================== 03       <--- store row
---- 00  06  01  01  01  08 ----      <--- P1's slots
     (1) (2) (3) (4) (5) (6) P1       <--- P1's guide row
Player 2: What is your move?

It is Player 2's turn. P1 has 3 points, and P2 has 1 point.
If P2 picks his 6th slot (which holds 6 points), it will increment his store and P1's 1st-5th slots. Alternatively, he can pick his 1st slot, which will move the single point over to the empty 2nd slot. This triggers a capture, which takes the just-placed point in P2's 2nd slot and all the points in P1's 5th slot, and places them in P2's store.
