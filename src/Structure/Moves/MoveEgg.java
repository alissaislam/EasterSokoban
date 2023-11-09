package Structure.Moves;

import Structure.Models.Actions;
import Structure.Models.Board;
import Structure.Models.Egg;
import Structure.Models.Position;
import com.company.Main;

public class MoveEgg {
    public static Board up(Board board){

        char upChar = board.getNewGame()[board.getPosition ().getY ()-1][board.getPosition ().getX ()];

        Egg [] eggs = new Egg [board.getEggs ().length] ;

        for (int i =0 ; i < eggs.length ; i++){

            eggs[i] = new Egg (board.getEggs ()[i].getX (), board.getEggs ()[i].getY ());

        }

        if(upChar == 'E'){


            Position position = board.getPosition ();
                       for (int i = 0 ; i < eggs.length ; i++){

                if(eggs[i].getY () == position.getY ()-1 && eggs[i].getX () == position.getX ())

                eggs[i].setY (eggs[i].getY ()-1);
            }
        }
        return new Board (
                board.getRows (),
                board.getColumns (),
                board.getInitGame (),
                board.getPosition (),
                eggs,
                board.getGoals ());
    }
    public static Board down(Board board){

        char downChar = board.getNewGame()[board.getPosition ().getY ()+1][board.getPosition ().getX ()];
        Egg [] eggs = new Egg[board.getEggs ().length];
        for (int i =0 ; i < eggs.length ; i++){
            eggs[i] = new Egg (board.getEggs ()[i].getX (), board.getEggs ()[i].getY ());
        }
        if(downChar == 'E'){

            Position position = board.getPosition ();
            for (int i = 0 ; i < eggs.length ; i++){

                if(eggs[i].getY () == position.getY ()+1 && eggs[i].getX () == position.getX ())

                    eggs[i].setY (eggs[i].getY ()+1);
            }
        }
        return new Board (
                board.getRows (),
                board.getColumns (),
                board.getInitGame (),
                board.getPosition (),
                eggs,
                board.getGoals ());
    }
    public static Board right(Board board){
        char upChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()+1];
        Egg [] eggs = new Egg[board.getEggs ().length];
        for (int i =0 ; i < eggs.length ; i++){
            eggs[i] = new Egg (board.getEggs ()[i].getX (), board.getEggs ()[i].getY ());
        }
        if(upChar == 'E'){

            Position position = board.getPosition ();
            for (int i = 0 ; i < eggs.length ; i++){

                if(eggs[i].getY () == position.getY () && eggs[i].getX () == position.getX ()+1)

                    eggs[i].setX (eggs[i].getX ()+1);
            }
        }
        return new Board (
                board.getRows (),
                board.getColumns (),
                board.getInitGame (),
                board.getPosition (),
                eggs,
                board.getGoals ());
    }

    public static Board left(Board board){
        char upChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()-1];
        Egg [] eggs = new Egg[board.getEggs ().length];
        for (int i =0 ; i < eggs.length ; i++){
            eggs[i] = new Egg (board.getEggs ()[i].getX (), board.getEggs ()[i].getY ());

        }
        if(upChar == 'E'){

            Position position = board.getPosition ();
            for (int i = 0 ; i < eggs.length ; i++){

                if(eggs[i].getY () == position.getY () && eggs[i].getX () == position.getX ()-1)

                    eggs[i].setX (eggs[i].getX ()-1);
            }
        }
        return new Board (
                board.getRows (),
                board.getColumns (),
                board.getInitGame (),
                board.getPosition (),
                eggs,
                board.getGoals ());
    }

    public static Board moveEgg(Board board, Actions action){
        Board board1;

        switch (action){
            case UP:
                board1 = up (board);
                break;
            case DOWN:
                board1 = down (board);
                break;
            case RIGHT:
                board1 = right (board);
                break;
            case LEFT:
                board1 = left (board);
                break;
            default:
                board1=new Board ();
                break;
        }
        return board1;
    }
}
