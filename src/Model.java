public final class Model {
    char player='X';
    boolean Winner=false;

    public char[][] board;
    public Model() {
        int DEFAULT_NR_ROWS = 3;
        int DEFAULT_NR_COLS = 3;
        this.board=new char[DEFAULT_NR_ROWS][DEFAULT_NR_COLS];
        // Initialise the board size to its default values.
}
    public boolean isMoveValid(int x,int y){
        if((x>3||x<0) || (y>3||y<0) || board[x][y]!=' ' ){
            System.out.println("ed");
            return false;

        }return true;
    }
    public void makeMove(int x,int y){
      boolean validPlay=isMoveValid(x,y);
      if (board[x][y]!=' '){
          System.out.println("Not valid");

      }

        else if(board[x][y]==' '){
            board[x][y]=player;
        }
            Winner=isWinnerHorizontal(player,board)||isWinnerVertical(player,board);

    }
    public boolean isWinnerHorizontal(char player,char[][] board){
        for (int row = 0; row < board.length; row++) {
            int rowCount=0;
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col]==player){
                    rowCount++;
                }else {
                    rowCount=0;
                }if(rowCount>=3){
                    System.out.println("cool");
                    return true;
                }

            }

        }return false;
    }

    public boolean isWinnerVertical(char player,char[][] board){
        for (int col = 0; col < board[0].length; col++) {
            int columnCount=0;
            for (int row = 0; row < board.length; row++) {
                if(board[row][col]==player){
                    columnCount++;
                }else {
                    columnCount=0;
                }if(columnCount>=3){
                    return true;
                }


            }

        }return false;
    }

}
