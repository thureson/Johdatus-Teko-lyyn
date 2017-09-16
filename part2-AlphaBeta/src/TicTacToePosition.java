
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomppa
 */
public class TicTacToePosition {
    private String state;
    private TicTacToePosition parent;
    private List<TicTacToePosition> children;
    private boolean cross;
    
    public TicTacToePosition(String state, TicTacToePosition parent, boolean cross){
        this.state = state;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.cross = cross;
    }
    
    public TicTacToePosition getParent(){
        return this.parent;
    }
    
    public boolean cross(){
        return this.cross;
    }
    
    public String getState(){
        return this.state;
    }
    
    public List<TicTacToePosition> getChildren(){
        return this.children;
    }
    
    public void markStateProcessed(){
        this.state = this.state.replaceFirst("?", "-");
    }
    
    public void addChild(TicTacToePosition p){
        children.add(p);
    }
    
    public int value(){
        if (row()){
            return 1;
        } else {
            return 0;
        }
    }
    
    public boolean isLeaf(){
        return this.children.isEmpty() || row();
    }
    
    public boolean row(){
        if (state.matches("xxx......") || state.matches("ooo......")){
            return true;
        } else if (state.matches("...xxx...") || state.matches("...ooo...")){
            return true;
        } else if (state.matches("......xxx") || state.matches("......ooo")){
            return true;
        } else if (state.matches("x...x...x") || state.matches("o...o...o")){
            return true;
        } else if (state.matches("..x.x.x..") || state.matches("..o.o.o..")){
            return true;
        } else if (state.matches("x..x..x..") || state.matches("o..o..o..")){
            return true;
        } else if (state.matches(".x..x..x.") || state.matches(".o..o..o.")){
            return true;
        } else if (state.matches("..x..x..x") || state.matches("..o..o..o")){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        char[] arr = state.toCharArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret.append("|").append(arr[3 * i + j]);
            }
            ret.append("|\n");
        }
        return ret.toString();
    }
}
