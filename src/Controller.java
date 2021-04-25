
public final class Controller {
    private final Model model;
    private final TextView view;
    public Controller(Model model, TextView view) {

        this.model = model;
        this.view = view;
    }
    boolean validPlay;
    int turn=1;
    long startTime = System.nanoTime();
    public void startSession() {
        view.initialDisplay(model);
        view.bottom();
        view.displayBoard(model);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
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
        int rowMove=view.makeMoveRow(model);
        int columnMove=view.makeMoveColumn(model);
        if(rowMove==-1 || columnMove==-1){
            model.Winner=true;
            model.concedeNow=true;
        }

        validPlay = model.isMoveValid(rowMove - 1, columnMove - 1);
        while (!validPlay) {
            rowMove = view.makeMoveRow(model);

            columnMove = view.makeMoveColumn(model);
            validPlay = model.isMoveValid(rowMove - 1, columnMove - 1);
        }if(rowMove==-1 || columnMove==-1){
            model.Winner=true;
            model.concedeNow=true;
        }else {


            model.makeMove(rowMove - 1, columnMove - 1);
            view.bottom();
            view.displayBoard(model);
        }

    }public void playAgain(){
        boolean playAgain;
        if(view.again()=='Y'){
            playAgain=true;
        }else {
            playAgain=false;
            System.out.println(view.end());
        }
        while (playAgain){
            turn=1;
            model.Winner=false;
            model.concedeNow=false;
            model.player='X';
            startSession();
            playAgain=false;

        }
    }
}
