package Logic.Modes;

import Logic.Helper.Helper;
import Structure.Models.Board;
import Structure.Models.Node;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class DFS extends GeneralLogic {

    private Stack<Node> stackNodes = new Stack<Node>();

   Node SolveDFS(Node node)
    {
        stackNodes.push(node);
        while (stackNodes.size() > 0)
        {
            Node node1 = stackNodes.pop();
            visitedList.add(node1);
            if (Helper.isFinal(node1))
                return node1;
            for (Node child : Helper.getNextBoards (node1)) {
                 if (!isVisited(child)) {
                    stackNodes.push(child);
                }
            }
        }
        return null;
    }

    public DFS(Board board)
    {
        System.out.println("Solving ...");
        Node sol = SolveDFS (new Node (null, board));
        this.Play(sol);
    }
}

