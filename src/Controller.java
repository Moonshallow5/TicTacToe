import java.util.Scanner;

public final class Controller {
    private final Model model;
    private final TextView view;
    public Controller(Model model, TextView view) {

        this.model = model;
        this.view = view;
    }
    boolean validPlay;
    int turn=1;
    boolean playAgain=false;
    public void startSession() {
        view.initialDisplay(model);
        view.displayBoard(model);
        view.bottom();
        while (turn<=9 || !model.Winner) {
            move();
            turn++;
            view.switchPlayers(model);

        if(model.Winner || turn>9) {
            view.switchPlayers(model);
            break;
        }
        }
        view.winner(model);
        playAgain();

    }
    public void move(){
        int rowMove=view.makeMoveRow();
        int columnMove=view.makeMoveColumn();
        validPlay=model.isMoveValid(rowMove-1,columnMove-1);
        while(!validPlay){
            rowMove=view.makeMoveRow();
            columnMove=view.makeMoveColumn();
            validPlay=model.isMoveValid(rowMove-1,columnMove-1);
        }
        model.makeMove(rowMove-1,columnMove-1);
        view.displayBoard(model);
        view.bottom();

    }public void playAgain(){
        System.out.println("Would play?");
        if(view.again()=='Y'){
            playAgain=true;
        }else {
            playAgain=false;
        }
        while (playAgain){
            turn=1;
            model.Winner=false;
            startSession();

        }
    }
}
