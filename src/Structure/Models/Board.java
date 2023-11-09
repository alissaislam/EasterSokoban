package Structure.Models;


public class Board {
    int rows;
    int columns;
    char [][] initGame;
    char [][] newGame;
    Position position ;
    Egg [] eggs;
    Position [] goals;


    public Board() {
    }

    public Board(int rows, int columns, char[][] initGame, Position position, Egg[] eggs, Position [] goals) {
        this.rows = rows;
        this.columns = columns;
        this.initGame = initGame;
        this.position = position;
        this.eggs = eggs;
        this.newGame = new char [rows][columns];
        this.goals = goals;
        drawPosition ();
    }



    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public char[][] getInitGame() {
        return initGame;
    }

    public void setInitGame(char[][] initGame) {
        this.initGame = initGame;
    }

    public char[][] getNewGame() {
        return newGame;
    }

    public void setNewGame(char[][] newGame) {
      this.newGame=newGame;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Egg[] getEggs() {
        return eggs;
    }

    public void setEggs(Egg[] eggs) {
        this.eggs = eggs;
    }

    public Position[] getGoals() {
        return goals;
    }

    public void setGoals(Position[] goals) {
        this.goals = goals;
    }

    private void drawPosition(){


        for (int i = 0 ; i < rows ; i++){

            for(int j = 0 ; j < columns ; j++){
                newGame[i][j]=initGame[i][j];
            }
        }

        for (int i = 0 ; i < eggs.length ; i++ ){

            newGame[eggs[i].getY ()][eggs[i].getX ()] = 'E';


        }
        newGame[this.position.y][this.position.x] = 'B' ;




    }

    public  boolean equal(Board board){

        for (int i = 0 ; i < board.getNewGame().length; i++){
            for(int j = 0 ; j < board.getNewGame()[0].length ; j++){
                if( board.getNewGame()[i][j] != this.getNewGame ()[i][j] )
                    return false;
            }
        }

        return true;
    }

    public void drawBoard( ){

        for (int i = 0 ; i < rows ; i++){

            for(int j = 0 ; j < columns ; j++){
                System.out.print (newGame[i][j]+" ");
            }
            System.out.print ('\n');
        }
    }
}
