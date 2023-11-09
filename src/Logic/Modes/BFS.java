package Logic.Modes;

import Logic.Helper.Helper;
import Structure.Models.Board;
import Structure.Models.Node;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends GeneralLogic {

    private Queue<Node> queueNodes = new LinkedList<> ();

    Node SolveBFS(Node node)
    {
        queueNodes.add(node);
        if (Helper.isFinal(node))
            return node;
        while (queueNodes.size() > 0)
        {
            Node nodeIn = queueNodes.poll();
            visitedList.add(nodeIn);
            for (Node child : Helper.getNextBoards (nodeIn)) {
                if (!isVisited(child)) {
                    if (!Helper.isFinal(child))
                        queueNodes.add(child);
                    else
                        return child;
                }
            }
        }

        return null;
    }

    public BFS(Board board)
    {
        System.out.println("Solving ...");
        Node sol = SolveBFS(new Node(null, board,0,0,null));
        this.Play(sol);
    }
}
