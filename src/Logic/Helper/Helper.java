package Logic.Helper;

import Structure.Models.Actions;
import Structure.Moves.MoveCheck;
import Structure.Models.Board;
import Structure.Models.Node;
import Structure.Moves.MoveEgg;
import Structure.Moves.MoveResult;

import java.util.ArrayList;

public class Helper {


    public static boolean isFinal(Node node){

            node.getBoard().getNewGame ()[node.getBoard().getPosition ().getY ()][node.getBoard().getPosition ().getX ()]='.';
            boolean result = equal (node.getBoard (),Node.getGOAL ());
            node.getBoard().getNewGame ()[node.getBoard().getPosition ().getY ()][node.getBoard().getPosition ().getX ()]='B';
            return result;

    }
    public static boolean isFinall(Board board){

        board.getNewGame ()[board.getPosition ().getY ()][board.getPosition ().getX ()]='.';
        boolean result = equal (board,Node.getGOAL ());
        board.getNewGame ()[board.getPosition ().getY ()][board.getPosition ().getX ()]='B';
        return result;

    }
    public static   boolean equal(Board board1 ,char[][] goal){


        for (int i = 0 ; i < board1.getNewGame ().length; i++){
            for(int j = 0 ; j < board1.getNewGame ()[0].length ; j++){
                if(goal[i][j] != board1.getNewGame ()[i][j])
                    return false;
            }
        }

        return true;
    }


    public static ArrayList<Node> getNextBoards(Node node){
        ArrayList<Node> result =new ArrayList<> ();

        ArrayList<Actions> actions = MoveCheck.getMoves (node.getBoard ());

        for (Actions action : actions){
            Board newBoard = MoveEgg.moveEgg (node.getBoard (),action);
            newBoard = MoveResult.move (newBoard,action);
            Node newNode = new Node (node,newBoard,node.getDepth ()+1,node.getCost ()+1,action);
            result.add (newNode);
        }

        return result;
    }

    public static boolean Equals(Node node1, Node node2) {
        return node1.equal(node2);
    }


}
