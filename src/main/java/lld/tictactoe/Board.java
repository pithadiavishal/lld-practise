package lld.tictactoe;

public class Board {
    int size;
    PlayingPiece[][] board;
    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean set(int r, int c, PlayingPiece playingPiece){
        if(board[r][c]!=null){
            return false;
        }
        board[r][c]=playingPiece;
        return true;
    }

    public void printBoard() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print("| " + (board[i][j]!=null?board[i][j].pieceType.toString() + " ":"  ") );
            }
            System.out.println();
            System.out.println("------------");
        }
    }

    public boolean isBoardFull(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isWinner(PlayingPiece playingPiece) {
        //checking only row and col for now
        //check rows
        for(int i=0;i<board.length;i++){
            boolean flag = true;
            for(int j=0;j<board[0].length;j++){
                flag=flag&&(board[i][j]==playingPiece);
                if(!flag){
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        //check cols
        for(int j=0;j<board[0].length;j++){
            boolean flag = true;
            for(int i=0;i<board.length;i++){
                flag=flag&&(board[i][j]==playingPiece);
                if(!flag){
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}
