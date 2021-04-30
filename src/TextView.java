public final class TextView {
    public TextView() {
    }
    public void displayBoard(Model model){
        String rowDivider = "-".repeat(4 * model.board[0].length + 1);
        System.out.println(" "+rowDivider);
        for (int row = 0; row < model.board.length; row++) {
            System.out.print(row+1);
            System.out.print("| ");
            for (int col = 0; col <model.board[0].length; col++) {
                System.out.print(model.board[row][col]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println(rowDivider);

        }
    }
    public void bottom(){
        for (int i = 0; i < 3; i++) {
            System.out.print("   "+(i+1));
        }
        System.out.println();
    }
    public int start(){
        return InputUtil.readIntFromUser();
    }
    public void first(){
        System.out.println("-------------------------------------");
        System.out.println("1. If you want to play with computer");
        System.out.println("2. If you want to play with human");
        System.out.println("-------------------------------------");
    }
    public void switchPlayers(Model model){
        if(model.player=='X'){
            model.player='O';
        }else {
            model.player='X';
        }
    }
    public String check(){
        return "Make sure you entered a correct value";
    }
    public String correct(){
        return "Put correct value";
    }
    public final void initialDisplay(Model model){
        for (int row = 0; row < model.board.length; row++) {
            for (int col = 0; col < model.board[0].length; col++) {
                model.board[row][col]=' ';
            }
            
        }
    }
    public char again(){
        System.out.println("Would you want to play again type Y to play again and N to stop");
        return InputUtil.readCharFromUser();
    }
    public int makeMoveRow(Model model){
        System.out.println( model.player+" Please enter a row");
        return InputUtil.readIntFromUser();
    }
    public void winner(Model model){

            if (model.isWinnerDownwardDiagonal(model.player, model.board) && !model.concedeNow ) {
                System.out.println("Downward diagonal win from " + model.player);
            } else if (model.isWinnerVertical(model.player, model.board) && !model.concedeNow) {
                System.out.println("Vertical win from " + model.player);
            } else if (model.isWinnerUpwardDiagonal(model.player, model.board)&& !model.concedeNow) {
                System.out.println("Upward diagonal win from " + model.player);
            } else if (model.isWinnerHorizontal(model.player, model.board)&& !model.concedeNow) {
                System.out.println("Horizontal win from " + model.player);
            }
        else if(!model.concedeNow){
            System.out.println("Tie game");
        }
        if(model.concedeNow){
            System.out.print(model.player+" concedes ");
            switchPlayers(model);
            System.out.println(model.player+" won");
        }

    }
    public String end(){
        return "Good game";
    }
    public int makeMoveColumn(Model model){
        System.out.println(model.player+" Please enter a column");
        return InputUtil.readIntFromUser();
    }
}