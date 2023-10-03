import java.util.*;
public class node {
    private ArrayList<Integer> start_points;
    private int level;
    private ArrayList<node> leaves;
    private node parent;
    private boolean visited;

    public node(ArrayList<Integer> s, int row_index){
        start_points = s;
        level = row_index;
        leaves = null;
        parent = null;
        visited = false;
    }

    public ArrayList<Integer> getPoints(){
        return start_points;
    }
    public int getLevel(){
        return level;
    }
    public ArrayList<node> getLeaves(){
        return leaves;
    }
    public node getParent(){
        return parent;
    }
    public boolean getVisited(){
        return visited;
    }

    public void setLeaves(ArrayList<node> l){
        leaves = l;
    }
    public void setParent(node p){
        parent = p;
    }
    public void setVisited(boolean v){
        visited = v;
    }
    public void setLevel(int l){
        level = l;
    }

}


