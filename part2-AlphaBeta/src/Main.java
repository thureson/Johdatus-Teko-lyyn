public class Main {

    public static void main(String[] args) {
        String emptyBoard = "???" + "???" + "???";
        TicTacToe r = new TicTacToe(emptyBoard, true);
        System.out.println(r);
        play(r);
    }

    private static void play(TicTacToe r) {
        // Implement this
    }
}
