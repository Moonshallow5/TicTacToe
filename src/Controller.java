
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

        //long endTime   = System.nanoTime();
        //long totalTime = endTime - startTime;
        //System.out.println(totalTime);
        view.first();
        System.out.print("Integer: ");
        int x = view.start();
        if (x == 1) {
            first();
        } else if (x == 2) {
            second();


        }else {
            System.out.println(view.correct());
            startSession();
        }
    }
    public void first(){
        view.initialDisplay(model);
        view.bottom();
        view.displayBoard(model);
        while (turn <= 9 || !model.Winner || !model.concedeNow) {
            model.computer();
            view.bottom();
            view.displayBoard(model);
            turn++;
            if (model.Winner || turn > 9) {
                break;
            }view.switchPlayers(model);
            move();
            if (model.Winner || turn > 9) {
                break;
            }
            turn++;
            view.switchPlayers(model);
        }view.winner(model);
        playAgain();
    }
    public void second(){
        view.initialDisplay(model);
        view.bottom();
        view.displayBoard(model);
        while (turn <= 9 || !model.Winner || !model.concedeNow) {
            move();
            turn++;
            view.switchPlayers(model);

            if (model.Winner || turn > 9) {
                view.switchPlayers(model);
                break;
            }
        }view.winner(model);
        playAgain();
    }


    public void move(){

    int rowMove = view.makeMoveRow(model);
    if(rowMove==-1){
        model.Winner=true;
        model.concedeNow=true;
    }else {
        int columnMove = view.makeMoveColumn(model);
        if (columnMove == -1) {
            model.Winner = true;
            model.concedeNow = true;
        }else {
            validPlay = model.isMoveValid(rowMove - 1, columnMove - 1);
            while (!validPlay) {
                System.out.println(view.check());
                rowMove = view.makeMoveRow(model);
                if(rowMove==-1){
                    model.Winner=true;
                    model.concedeNow=true;
                    validPlay=true;
                }else {
                    columnMove = view.makeMoveColumn(model);
                    if(columnMove==-1){
                        model.Winner=true;
                        model.concedeNow=true;
                        validPlay=true;
                    }
                    validPlay = model.isMoveValid(rowMove - 1, columnMove - 1);
                }
            }

             if (columnMove!=-1 && rowMove!=-1){
                model.makeMove(rowMove - 1, columnMove - 1);
                view.bottom();
                view.displayBoard(model);
            }
        }
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
