package Structure.Moves;

import Structure.Models.Actions;
import Structure.Models.Board;

import java.util.*;

public class MoveCheck {

    static List<Character> block = new ArrayList<> (Arrays.asList ('-', '|', '*'));


    public static boolean checkUp(Board board){

        char upChar = board.getNewGame()[board.getPosition ().getY ()-1][board.getPosition ().getX ()];
        if(block.contains (upChar))
        return false;
        char upUpChar = board.getNewGame()[board.getPosition ().getY ()-2][board.getPosition ().getX ()];
        if(upChar == 'E'){
            if (upUpChar == 'E' || block.contains (upUpChar))
                return false;
        }
        return true;
    }

    public static boolean checkDown(Board board){
        char downChar = board.getNewGame()[board.getPosition ().getY ()+1][board.getPosition ().getX ()];
        if(block.contains (downChar))
            return false;
        char downDownChar = board.getNewGame()[board.getPosition ().getY ()+2][board.getPosition ().getX ()];
        if(downChar == 'E'){
            if (downDownChar == 'E' || block.contains (downDownChar))
                return false;
        }
        return true;
    }

    public static boolean checkRight(Board board){
        char rightChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()+1];
        if(block.contains (rightChar))
            return false;
        char rightRightChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()+2];
        if(rightChar == 'E'){
            if (rightRightChar == 'E' || block.contains (rightRightChar))
                return false;
        }
        return true;
    }

    public static boolean checkLeft(Board board){
        char liftChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()-1];
        if(block.contains (liftChar))
            return false;
        char liftLiftChar = board.getNewGame()[board.getPosition ().getY ()][board.getPosition ().getX ()-2];
        if(liftChar == 'E'){
            if (liftLiftChar == 'E' || block.contains (liftLiftChar))
                return false;
        }
        return true;
    }

    public static ArrayList<Actions> getMoves(Board board){

        ArrayList<Actions> result = new ArrayList<> ();
        if (checkUp (board))
            result.add (Actions.UP);
        if (checkDown (board))
            result.add (Actions.DOWN);
        if (checkRight (board))
            result.add (Actions.RIGHT );
        if (checkLeft (board))
            result.add (Actions.LEFT);

        return result;
    }


}
