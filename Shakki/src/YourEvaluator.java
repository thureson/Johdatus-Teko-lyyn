public class YourEvaluator extends Evaluator {

    // Implement your heuristic evaluation function here!
    // The below default function prefers:
    //  * not to lose (white king is worth at lot)
    //  * to win (black not having a king is worth a lot)
    //  * to have more white pieces (+1) and less black pieces (-1)

	public double eval(Position p) {
		double ret = 0;
		for(int x = 0; x < p.board.length; ++x) {
			for(int y = 0; y < p.board[x].length; ++y) {
				if(p.board[x][y] == Position.Empty) continue;
//				Basic values
                                if(p.board[x][y] == Position.WKing) ret += 1e9;
				if(p.board[x][y] == Position.WQueen) ret += 9;
				if(p.board[x][y] == Position.WRook) ret += 5;
				if(p.board[x][y] == Position.WBishop) ret += 3.3;
				if(p.board[x][y] == Position.WKnight) ret += 3.2;
				if(p.board[x][y] == Position.WPawn) ret += 0.7;
				if(p.board[x][y] == Position.BKing) ret -= 1e9;
				if(p.board[x][y] == Position.BQueen) ret -= 9;
				if(p.board[x][y] == Position.BRook) ret -= 5;
				if(p.board[x][y] == Position.BBishop) ret -= 3.3;
				if(p.board[x][y] == Position.BKnight) ret -= 3.2;
				if(p.board[x][y] == Position.BPawn) ret -= 0.7;

//                                Pawn-positions W
                                if(p.board[0][1] == Position.WPawn) ret += 0.05;
                                if(p.board[1][1] == Position.WPawn) ret += 0.1;
                                if(p.board[2][1] == Position.WPawn) ret -= 0.2;
                                if(p.board[3][1] == Position.WPawn) ret -= 0.2;
                                if(p.board[4][1] == Position.WPawn) ret += 0.1;
                                if(p.board[5][1] == Position.WPawn) ret += 0.05;
                                if(p.board[0][2] == Position.WPawn) ret += 0.05;
                                if(p.board[1][2] == Position.WPawn) ret -= 0.1;
                                if(p.board[2][2] == Position.WPawn) ret += 0.2;
                                if(p.board[3][2] == Position.WPawn) ret += 0.3;
                                if(p.board[4][2] == Position.WPawn) ret -= 0.1;
                                if(p.board[5][2] == Position.WPawn) ret += 0.05;
                                
//                                Knight-positions W
                                if(p.board[0][0] == Position.WKnight) ret -= 0.5;
                                if(p.board[1][0] == Position.WKnight) ret -= 0.35;
                                if(p.board[2][0] == Position.WKnight) ret -= 0.3;
                                if(p.board[3][0] == Position.WKnight) ret -= 0.3;
                                if(p.board[4][0] == Position.WKnight) ret -= 0.35;
                                if(p.board[5][0] == Position.WKnight) ret -= 0.5;
                                
                                if(p.board[0][1] == Position.WKnight) ret -= 0.4;
                                if(p.board[1][1] == Position.WKnight) ret -= 0.1;
                                if(p.board[2][1] == Position.WKnight) ret += 0.05;
                                if(p.board[3][1] == Position.WKnight) ret += 0.05;
                                if(p.board[4][1] == Position.WKnight) ret -= 0.1;
                                if(p.board[5][1] == Position.WKnight) ret -= 0.4;
                                
                                if(p.board[0][2] == Position.WKnight) ret -= 0.3;
                                if(p.board[1][2] == Position.WKnight) ret += 0.1;
                                if(p.board[2][2] == Position.WKnight) ret += 0.2;
                                if(p.board[3][2] == Position.WKnight) ret += 0.2;
                                if(p.board[4][2] == Position.WKnight) ret += 0.1;
                                if(p.board[5][2] == Position.WKnight) ret -= 0.3;
                                
                                if(p.board[0][3] == Position.WKnight) ret -= 0.3;
                                if(p.board[1][3] == Position.WKnight) ret += 0.1;
                                if(p.board[2][3] == Position.WKnight) ret += 0.2;
                                if(p.board[3][3] == Position.WKnight) ret += 0.2;
                                if(p.board[4][3] == Position.WKnight) ret += 0.1;
                                if(p.board[5][3] == Position.WKnight) ret -= 0.3;
                                
                                if(p.board[0][4] == Position.WKnight) ret -= 0.4;
                                if(p.board[1][4] == Position.WKnight) ret -= 0.1;
                                if(p.board[2][4] == Position.WKnight) ret += 0.05;
                                if(p.board[3][4] == Position.WKnight) ret += 0.05;
                                if(p.board[4][4] == Position.WKnight) ret -= 0.1;
                                if(p.board[5][4] == Position.WKnight) ret -= 0.4;
                                
                                if(p.board[0][5] == Position.WKnight) ret -= 0.5;
                                if(p.board[1][5] == Position.WKnight) ret -= 0.35;
                                if(p.board[2][5] == Position.WKnight) ret -= 0.3;
                                if(p.board[3][5] == Position.WKnight) ret -= 0.3;
                                if(p.board[4][5] == Position.WKnight) ret -= 0.35;
                                if(p.board[5][5] == Position.WKnight) ret -= 0.5;

//                                Queen-positions W
                                if(p.board[0][y] == Position.WQueen) ret -= 0.1;
                                if(p.board[5][y] == Position.WQueen) ret -= 0.1;
                                if(p.board[x][0] == Position.WQueen) ret -= 0.1;
                                if(p.board[x][5] == Position.WQueen) ret -= 0.1;
                                
//                                Pawn-positions B
                                if(p.board[0][4] == Position.BPawn) ret -= 0.05;
                                if(p.board[1][4] == Position.BPawn) ret -= 0.1;
                                if(p.board[2][4] == Position.BPawn) ret += 0.2;
                                if(p.board[3][4] == Position.BPawn) ret += 0.2;
                                if(p.board[4][4] == Position.BPawn) ret -= 0.1;
                                if(p.board[5][4] == Position.BPawn) ret -= 0.05;
                                if(p.board[0][3] == Position.BPawn) ret -= 0.05;
                                if(p.board[1][3] == Position.BPawn) ret += 0.1;
                                if(p.board[2][3] == Position.BPawn) ret -= 0.2;
                                if(p.board[3][3] == Position.BPawn) ret -= 0.2;
                                if(p.board[4][3] == Position.BPawn) ret += 0.1;
                                if(p.board[5][3] == Position.BPawn) ret -= 0.05;
                                
//                                Knight-positions B
                                if(p.board[0][0] == Position.BKnight) ret += 0.5;
                                if(p.board[1][0] == Position.BKnight) ret += 0.35;
                                if(p.board[2][0] == Position.BKnight) ret += 0.3;
                                if(p.board[3][0] == Position.BKnight) ret += 0.3;
                                if(p.board[4][0] == Position.BKnight) ret += 0.35;
                                if(p.board[5][0] == Position.BKnight) ret += 0.5;
                                
                                if(p.board[0][1] == Position.BKnight) ret += 0.4;
                                if(p.board[1][1] == Position.BKnight) ret += 0.1;
                                if(p.board[2][1] == Position.BKnight) ret -= 0.05;
                                if(p.board[3][1] == Position.BKnight) ret -= 0.05;
                                if(p.board[4][1] == Position.BKnight) ret += 0.1;
                                if(p.board[5][1] == Position.BKnight) ret += 0.4;
                                
                                if(p.board[0][2] == Position.BKnight) ret += 0.3;
                                if(p.board[1][2] == Position.BKnight) ret -= 0.1;
                                if(p.board[2][2] == Position.BKnight) ret -= 0.2;
                                if(p.board[3][2] == Position.BKnight) ret -= 0.2;
                                if(p.board[4][2] == Position.BKnight) ret -= 0.1;
                                if(p.board[5][2] == Position.BKnight) ret += 0.3;
                                
                                if(p.board[0][3] == Position.BKnight) ret += 0.3;
                                if(p.board[1][3] == Position.BKnight) ret -= 0.1;
                                if(p.board[2][3] == Position.BKnight) ret -= 0.2;
                                if(p.board[3][3] == Position.BKnight) ret -= 0.2;
                                if(p.board[4][3] == Position.BKnight) ret -= 0.1;
                                if(p.board[5][3] == Position.BKnight) ret += 0.3;
                                
                                if(p.board[0][4] == Position.BKnight) ret += 0.4;
                                if(p.board[1][4] == Position.BKnight) ret += 0.1;
                                if(p.board[2][4] == Position.BKnight) ret -= 0.05;
                                if(p.board[3][4] == Position.BKnight) ret -= 0.05;
                                if(p.board[4][4] == Position.BKnight) ret += 0.1;
                                if(p.board[5][4] == Position.BKnight) ret += 0.4;
                                
                                if(p.board[0][5] == Position.BKnight) ret += 0.5;
                                if(p.board[1][5] == Position.BKnight) ret += 0.35;
                                if(p.board[2][5] == Position.BKnight) ret += 0.3;
                                if(p.board[3][5] == Position.BKnight) ret += 0.3;
                                if(p.board[4][5] == Position.BKnight) ret += 0.35;
                                if(p.board[5][5] == Position.BKnight) ret += 0.5;

//                                Queen-positions B
                                if(p.board[0][y] == Position.BQueen) ret += 0.1;
                                if(p.board[5][y] == Position.BQueen) ret += 0.1;
                                if(p.board[x][0] == Position.BQueen) ret += 0.1;
                                if(p.board[x][5] == Position.BQueen) ret += 0.1;
			}
		}
		return ret;
	}
}
