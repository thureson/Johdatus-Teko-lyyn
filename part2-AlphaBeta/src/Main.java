
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String startPosition = "???" + "???" + "???";
        TicTacToe r = new TicTacToe(startPosition, true);
        System.out.println(r);
        TicTacToePosition orig = r.getAsPosition();
        r.generateStates(orig);
        System.out.println(minimax(orig, true));
   
    }

    private static void play(TicTacToe r) {
        // Implement this
        r.testArea();
    }
    
    private static int minimax(TicTacToePosition t, boolean cross){
        if (t.isLeaf()){
            if (!cross){
                return t.value();
            }
            return 0 - t.value();
        }
        List<TicTacToePosition> pos = t.getChildren();
        if (cross){
            int value = -2;
            for (int i = 0; i < pos.size(); i++){
                int temp = minimax(pos.get(i), false);
                value = max(value, temp);
            }
            return value;
        } else {
            int value = 2;
            for (int i = 0; i < pos.size(); i++){
                int temp = minimax(pos.get(i), true);
                value = min(value, temp);
            }
            return value;
        }
    }
}
