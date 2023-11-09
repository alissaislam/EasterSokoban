package Structure.Models;

public class Node {
    Node parent;
    Board board;
    int depth;
    int cost;
    Actions action;
    static char [][] GOAL;

    public Node(Node parent, Board board, int depth, int cost, Actions action) {
        this.parent = parent;
        this.board = board;
        this.depth = depth;
        this.cost = cost;
        this.action = action;
    }

    public Node(Node parent, Board board) {
        this.parent = parent;
        this.board = board;
    }

    public Node(Board board) {
        this.board = board;
        this.depth = 0;
        this.cost=0;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Actions getAction() {
        return action;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public static char[][] getGOAL() {
        return GOAL;
    }

    public static void setGOAL(char[][] GOAL) {
        Node.GOAL = GOAL;
    }

    public  boolean equal(Node node){
        for (int i = 0 ; i < node.getBoard ().getNewGame ().length; i++){
            for(int j = 0 ; j < node.getBoard ().getNewGame ()[0].length ; j++){
               if(node.getBoard ().getNewGame ()[i][j] != this.board.getNewGame ()[i][j])
                   return false;
            }
        }
        return true;
    }

    public  boolean e(char array [][]){
        for (int i = 0 ; i < array.length; i++){
            for(int j = 0 ; j < array.length ; j++){
                if(array[i][j] != this.board.getNewGame ()[i][j])
                    return false;
            }
        }
        return true;
    }

    public boolean hasPrevious()
    {
        if (parent==null)
            return false;
        return true;
    }

    public boolean isFinish(){
        board.getNewGame ()[board.getPosition ().getY ()][board.getPosition ().getX ()]='.';
        boolean result = e (GOAL);
        board.getNewGame ()[board.getPosition ().getY ()][board.getPosition ().getX ()]='B';
        return result;
    }
}

