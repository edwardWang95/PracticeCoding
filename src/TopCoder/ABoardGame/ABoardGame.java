package TopCoder.ABoardGame;

/**
 Your friends Alice and Bob are playing a board game. They have asked you to help them to determine the winner.
 The game is played on a square board with 2N rows and 2N columns. The exact rules of the game itself are not important
 for this problem. Once the game is over, each cell of the board is either empty or contains a single piece that belongs
 to either Alice or Bob. You are given board, where the j-th character in i-th element (0-based indices) describes the
 contents of the cell in row i, column j: '.' represents an empty cell, 'A' a cell with Alice's piece and 'B' a cell
 with Bob's piece.

 The entire board is divided into N regions. Region 1 occupies the 4 central cells of the board. Each next region
 contains all cells that are horizontally, vertically or diagonally adjacent to cells of the immediately previous
 region and do not belong to any of the previous regions. For example, when N = 4, here is how the regions look:
 44444444
 43333334
 43222234
 43211234
 43211234
 43222234
 43333334
 44444444
 The winner is determined as follows. Consider the lowest numbered region that contains a different number of Alice's
 and Bob's pieces. The player who has more pieces in this region is the winner. If all regions contain the same number
 of Alice's and Bob's pieces, the game ends in a draw.

 Return "Alice" if Alice wins the given game, "Bob" if Bob wins and "Draw" if the game ends in a draw. Note that return
 values are case-sensitive.

 Definition
 Class: ABoardGame
 Method: whoWins
 Parameters: String[]
 Returns: String
 Method signature: String whoWins(String[] board)
 (be sure your method is public)
 Limits
 Time limit (s): 2.000
 Memory limit (MB): 256

 Constraints
 - board will contain between 2 and 50 elements, inclusive.
 - The number of elements in board will be even.
 - Each element of board will contain the same number of characters as the number of elements in board.
 - Each character in board will be 'A', 'B' or '.'.

 Examples
 0)
 {".....A", "......", "..A...", "...B..", "......", "......"}
 Returns: "Alice"
 Both Alice and Bob have 1 piece in region 1, so they are tied there. In region 2, they have no pieces at all, so a
 tie again. Finally, in region 3 Alice has 1 piece, while Bob has none. So Alice is the winner of this game.

 1)
 {"AAAA", "A.BA", "A..A", "AAAA"}
 Returns: "Bob"
 Even though Alice has 12 pieces and Bob just one, this one piece is enough for him to win.

 2)
 {"..", ".."}
 Returns: "Draw"
 The board can be entirely empty.

 3)
 {"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."}
 Returns: "Alice"

 4)
 {"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"}
 Returns: "Bob"

 5)
 {"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"}
 Returns: "Draw"

 * Created by edwardwang on 10/13/16.
 */
public class ABoardGame {
    private final String INVALID = "Invalid board";
    private final String ALICE = "Alice";
    private final String BOB = "BOB";

    private Board board;
    public static void main(String[]args){
        ABoardGame aBoardGame = new ABoardGame();
        String[] currBoard = {".....A", "......", "..A...", "...B..", "......", "......"};
    }

    private String whoWon(String[] currBoard){
        if(isScoreBoardValid(currBoard)){
            board = new Board(currBoard.length,currBoard.length);

        }
    }

    /**
     *  Constraints
     - board will contain between 2 and 50 elements, inclusive.
     - The number of elements in board will be even.
     - Each element of board will contain the same number of characters as the number of elements in board.
     - Each character in board will be 'A', 'B' or '.'.
     * @param board
     * @return
     */
    private boolean isScoreBoardValid(String[] board){
        return (2.0 <= (board.length * board.length)) &&
                ((board.length * board.length) <= 50) &&
                (board.length%2==0) &&
                (isCharInArrayValid(board));
    }

    private boolean isCharInArrayValid(String[] board){
        for(String field : board){
            if(field != "A" && field != "B" && field !="."){
                return false;
            }
        }
        return true;
    }

    /**
     * Sets the owners of the given cells for a board
     */
    private void applyScoreBoard(){

    }

    private class Board{
        private Cell[][] board;
        private int n, sideLength;
        public Board(int row, int col){
            n = row;
            sideLength = row;
            board = new Cell[row][col];
            initBoard();
        }
        private void initBoard(){
            for(int i=n;i>=0;i--){
                initTop(i);
            }
        }
        private void genLoop(int n){
            initTop(n);
            initSides(n);
            initBottom(n);
        }

        //n represents the current number from the for loop
        private void initTop(int n){
            for(int i=0;i<2*n;i++){
                
            }
        }

        private void initSides(int n){
            for(int i=0;i<(2*n)-1;i++){

            }
        }

        private void initBottom(int n){
            for(int i=0;i<(2*n)-2;i++){

            }
        }

        public void setCellOwner(int row, int col, String owner){
            board[row][col].setOwner(owner);
        }
        public void setCellValue(int row, int col, int value){
            board[row][col].setValue(value);
        }

        private class Cell{
            private String owner = ".";
            private int value = 0;
            public void setOwner(String owner{
                this.owner = owner;
            }
            public void setValue(int value){
                this.value = value;
            }
            public String getOwner(){
                return owner;
            }
            public int getValue(){
                return value;
            }
        }

    }

}
