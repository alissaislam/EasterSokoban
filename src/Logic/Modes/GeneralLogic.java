package Logic.Modes;

import Logic.Helper.Helper;
import Structure.Models.Board;
import Structure.Models.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GeneralLogic {

    ArrayList<Node> visitedList = new ArrayList<> ();
    ArrayList<Node> solutions = new ArrayList<> ();

    public boolean isVisited(Node node){
        for (Node nodeIn : visitedList){

            if (Helper.Equals (nodeIn,node))
                return true;
        }
        return false;
    }

    protected void Play(Node solution)
    {
        int soD=0;
        int soC=0;

        if (solution != null) {
             soD =solution.getDepth ();
             soC =solution.getCost ();
            System.out.println ("------ << Successfully Solved >> -------");
        }        else
            System.out.println("NO SOLUTION FOUND.");

        if (solution!=null)
        while (solution.hasPrevious()) {
            solutions.add(solution);

            solution = solution.getParent();
        }

        // Printing Positions Moves (OR) Board state changed

        for (Node node : solutions) {
            System.out.println (node.getAction ());
        }
//
//        for (int i = solution.size() - 1; i >= 0; i--) {
//            System.out.print(solution.get(i).getLastPosition().name() + " - ");
//        }

        System.out.println();

        System.out.println("Visited Nodes Count: " + visitedList.size());
        System.out.println("Node Depth: " + solutions.size());
        System.out.println ("solution depth: "+ soD);
        System.out.println ("solution cost: "+ soC);
    }

}
