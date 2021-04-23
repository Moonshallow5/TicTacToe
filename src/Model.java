public final class Model {
    char player='X';

    public char[][] board;
    public Model() {
        int DEFAULT_NR_ROWS = 3;
        int DEFAULT_NR_COLS = 3;
        this.board=new char[DEFAULT_NR_ROWS][DEFAULT_NR_COLS];
        // Initialise the board size to its default values.
}
    public boolean isMoveValid(int x,int y){
        if((x>3||x<0) || (y>3||y<0) ){
            return false;

        }return true;
    }
    public void makeMove(int x,int y){
      boolean validPlay=isMoveValid(x,y);

        if(board[x][y]==' '){
            board[x][y]=player;
        }


    }

}
