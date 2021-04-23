public final class TextView {
    public TextView() {
    }
    public void displayBoard(Model model){
        String rowDivider = "-".repeat(4 * model.board[0].length + 1);
        System.out.println(rowDivider);
        for (int row = 0; row < model.board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col <model.board[0].length; col++) {
                System.out.print(model.board[row][col]);
                System.out.print(" | ");

            }
            System.out.println();
            System.out.println(rowDivider);

        }
    }
    public void switchPlayers(Model model){
        if(model.player=='X'){
            model.player='O';
        }else {
            model.player='X';
        }
    }
    public final void initialDisplay(Model model){
        for (int row = 0; row < model.board.length; row++) {
            for (int col = 0; col < model.board[0].length; col++) {
                model.board[row][col]=' ';

            }
            
        }
    }
}