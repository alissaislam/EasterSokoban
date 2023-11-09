package Structure.Moves;

import Structure.Models.Actions;
import Structure.Models.Board;
import Structure.Models.Position;

public class MoveResult {

    public static Board move(Board board,Actions action){
        Position newPosition = new Position (board.getPosition ().getX (),board.getPosition ().getY ());
        switch (action){
            case UP:
                newPosition.setY (newPosition.getY ()- 1);
                break;
            case DOWN:
                newPosition.setY (newPosition.getY ()+ 1);
                break;
            case RIGHT:
                newPosition.setX (newPosition.getX ()+ 1);
                break;
            case LEFT:
                newPosition.setX (newPosition.getX ()- 1);
                break;
            default:
                break;
        }

        Board newBoard = new Board (board.getRows (),
                board.getColumns (),
                board.getInitGame (),
                newPosition ,
                board.getEggs (),
                board.getGoals ());
        return newBoard;
    }
}
