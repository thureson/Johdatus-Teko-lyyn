import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TicTacToe implements AlphaBetaNode {
    boolean crossesTurn;
    private String state;

    /**
     * Tic-tac-toe implementation
     * @param state String that represents the state of the board. May only contain characters: 'o', 'x' or '?'.
     */
    public TicTacToe(String state, boolean crossesTurn) {
        this.state = state;
        this.crossesTurn = crossesTurn;
    }
    
    public boolean getCrossesturn(){
        return this.crossesTurn;
    }

    @Override
    public int value() {
//        if (row()){
//            return 1;
//        } else if (!state.contains("?")){
//            return 0;
//        }
        return -1; // Implement this
    }
    
    public TicTacToePosition getAsPosition(){
        return new TicTacToePosition(state, null, crossesTurn);
    }

    @Override
    public ArrayList<AlphaBetaNode> generateChildren() {
//        TicTacToePosition root = new TicTacToePosition(state, null);
//        generateStates(root);
//        printTree(root);
        return new ArrayList<>(); // Implement this
    }
    
    public void testArea(){
        TicTacToePosition root = new TicTacToePosition(state, null, crossesTurn);
        generateStates(root);
        printTree(root);
    }
    
    public void printTree(TicTacToePosition t){
        System.out.println(t + "   " + row(t.getState()));
        if (row(t.getState())){
            return;
        }
        List<TicTacToePosition> pos = t.getChildren();
        for (int i = 0; i < pos.size(); i++){
            printTree(pos.get(i));
        }
    }
    
    public void generateStates(TicTacToePosition t){
        String stateT = t.getState();
        if (crossesTurn){
            for (int i = 0; i < 9; i++){
                if (stateT.charAt(i) == '?'){
                    StringBuilder replacement = new StringBuilder(stateT);
                    replacement.setCharAt(i, 'x');
                    TicTacToePosition child = new TicTacToePosition(replacement.toString(), t, crossesTurn);
                    t.addChild(child);
                }
            }         
            crossesTurn = false;
        } else {
            for (int i = 0; i < 9; i++){
                if (stateT.charAt(i) == '?'){
                    StringBuilder replacement = new StringBuilder(stateT);
                    replacement.setCharAt(i, 'o');
                    TicTacToePosition child = new TicTacToePosition(replacement.toString(), t, crossesTurn);
                    t.addChild(child);
                }
            }
            crossesTurn = true;
        }
        
        List<TicTacToePosition> children = t.getChildren();
        for (int i = 0; i < children.size(); i++){
            generateStates(children.get(i));
        }
    }

    @Override
    public boolean isEndState() {
        return state.indexOf('?') < 0 || won('x') || won('o');
    }

    public boolean won(char c) {
        String s = "" + c + c + c;
        return (state.substring(0, 3).equals(s)
                || state.substring(3, 6).equals(s)
                || state.substring(6, 9).equals(s)
                || ("" + state.charAt(0) + state.charAt(3) + state.charAt(6)).equals(s)
                || ("" + state.charAt(1) + state.charAt(4) + state.charAt(7)).equals(s)
                || ("" + state.charAt(2) + state.charAt(5) + state.charAt(8)).equals(s)
                || ("" + state.charAt(0) + state.charAt(4) + state.charAt(8)).equals(s)
                || ("" + state.charAt(6) + state.charAt(4) + state.charAt(2)).equals(s));
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

    @Override
    public boolean isMaxNode() {
        return crossesTurn;
    }
    
    public boolean row(String state){
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
}
