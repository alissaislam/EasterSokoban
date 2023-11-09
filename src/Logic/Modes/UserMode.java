package Logic.Modes;

import Logic.Helper.Helper;
import Structure.Models.Actions;
import Structure.Models.Board;
import Structure.Moves.MoveCheck;
import Structure.Moves.MoveEgg;
import Structure.Moves.MoveResult;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UserMode {
    Board initBoard;
    boolean up,down,right,left;
    Stack<Board> stack = new Stack<> ();


    public UserMode(Board initBoard) {
        this.initBoard = initBoard;
        play ();
    }

    void play(){


        initBoard.drawBoard ();

        Board previousBoard =new Board (
                initBoard.getRows (),
                initBoard.getColumns (),
                initBoard.getInitGame (),
                initBoard.getPosition (),
                initBoard.getEggs (),
                initBoard.getGoals ());
        Scanner input = new Scanner(System.in);


        while (true) {

            if (Helper.isFinall (previousBoard)){
                System.out.println ("you WIN!!!");
                return;
            }

            System.out.println ("Chose a move");

            ArrayList<Actions> moves = MoveCheck.getMoves (previousBoard);

            for(Actions movePosition : moves)
            {
                System.out.println (movePosition);
            }


            char key = input.next ().charAt (0);

            if(key == 'e')
            {
                System.out.println("\n ============ EXIT =============\n");
                break;
            }
            if(key == 'w')
            {
                if(MoveCheck.checkUp (previousBoard)) {
                    stack.add (previousBoard);
                 Board newBoard = MoveEgg.up (previousBoard);
                     newBoard = MoveResult.move (newBoard,Actions.UP);
                     previousBoard=newBoard;
                     newBoard.drawBoard ();
                }else {
                    System.out.println ("can not move this way!" );
                }
            }

            if(key == 's')
            {
                if(MoveCheck.checkDown (previousBoard)) {
                    stack.add (previousBoard);
                    Board newBoard = MoveEgg.down(previousBoard);
                    newBoard = MoveResult.move (newBoard,Actions.DOWN);
                    previousBoard=newBoard;
                    newBoard.drawBoard ();
                }else {
                    System.out.println ("can not move this way!" );
                }
            }

            if(key == 'd')
            {
                if(MoveCheck.checkRight (previousBoard)) {
                    stack.add (previousBoard);

                    Board newBoard = MoveEgg.right (previousBoard);
                    newBoard = MoveResult.move (newBoard,Actions.RIGHT);
                    previousBoard=newBoard;
                    newBoard.drawBoard ();
                }else {
                    System.out.println ("can not move this way!" );
                }
            }

            if(key == 'a')
            {
                if(MoveCheck.checkLeft (previousBoard)) {
                    stack.add (previousBoard);
                    Board newBoard = MoveEgg.left (previousBoard);
                    newBoard = MoveResult.move (newBoard,Actions.LEFT);
                    previousBoard=newBoard;
                    newBoard.drawBoard ();
                }else {
                    System.out.println ("can not move this way!" );
                }
            }
            if(key == 'u'){
                previousBoard = stack.pop ();
                previousBoard.drawBoard ();

            }

        }
    }
}
