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
    public void startSession() {
        view.initialDisplay(model);
        view.displayBoard(model);
        while (turn<=2 || !model.Winner) {
            move();
            turn++;
            view.switchPlayers(model);

        if(model.Winner || turn>2) {
            break;
        }
        }
    }
    public void move(){
        int rowMove=view.makeMoveRow();
        int columnMove=view.makeMoveColumn();
        validPlay=model.isMoveValid(rowMove-1,columnMove-1);
        while(!validPlay){
            System.out.println("again");
            rowMove=view.makeMoveRow();
            columnMove=view.makeMoveColumn();
            validPlay=model.isMoveValid(rowMove-1,columnMove-1);
        }
        model.makeMove(rowMove-1,columnMove-1);
        view.displayBoard(model);

    }
}
