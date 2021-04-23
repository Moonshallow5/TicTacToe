import java.util.Scanner;

public final class Controller {
    private final Model model;
    private final TextView view;
    public Controller(Model model, TextView view) {

        this.model = model;
        this.view = view;
    }
    int turn;
    Scanner value=new Scanner(System.in);
    public void startSession() {
        view.initialDisplay(model);
        view.displayBoard(model);
            model.makeMove(1, 2);
            view.displayBoard(model);
            view.switchPlayers(model);
            turn++;

    }
}
