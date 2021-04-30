public final class Model {
    char player='X';
    boolean Winner=false;
    boolean concedeNow;

    public char[][] board;
    public Model() {
        int DEFAULT_NR_ROWS = 3;
        int DEFAULT_NR_COLS = 3;
        this.board=new char[DEFAULT_NR_ROWS][DEFAULT_NR_COLS];
        // Initialise the board size to its default values.
}
    public boolean isMoveValid(int x,int y){
        if(x!=-2 && y!=-2){
            return x < 3 && x >= 0 && y < 3 && y >= 0 && board[x][y] == ' ';

        }
        return true;
    }
    public void computer(){
        int  row=(int)(Math.random()*3);
        int  column=(int)(Math.random()*3);
        while (!isMoveValid(row,column)){
            row=(int)(Math.random()*3);
            column=(int)(Math.random()*3);
            isMoveValid(row,column);
        }makeMove(row,column);
        System.out.println("Computer moved to row "+(row+1)+" and moved to column "+(column+1));
    }
    public void makeMove(int x,int y){
        //concedeNow=concede(x);
        board[x][y]=player;
            Winner=isWinnerVertical(player,board)|| isWinnerUpwardDiagonal(player,board) || isWinnerDownwardDiagonal(player,board) || isWinnerHorizontal(player,board);

    }


    public boolean isWinnerHorizontal(char player,char[][] board){
        /*for (int row = 0; row < board.length; row++) {
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

        }return false;*/

        for (int i = 0; i < 1; i++) {
            if((board[0][0]==player && board[0][i+1]==player && board[0][i+2]==player)||(board[1][i]==player && board[1][i+1]==player && board[1][i+2]==player)|| (board[2][i]==player && board[2][i+1]==player && board[2][i+2]==player) ){
                return true;

            }

        }return false;
    }
    public boolean isWinnerDownwardDiagonal(char player,char[][] board){
        return board[0][0] == player && board[1][1] == player && board[2][2] == player;
    }
    public boolean isWinnerUpwardDiagonal(char player,char[][] board){
        return board[2][0] == player && board[1][1] == player && board[0][2] == player;
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
