package GameOfLife.view;

import GameOfLife.model.Dot;

public class ConsoleView {

    public void ConsolleView(Dot[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    System.out.print("   ");
                } else {
                    System.out.print(" * ");
                }
            }
        }
    }
}
