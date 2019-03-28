package GameOfLife.controler;

import GameOfLife.model.Board;
import GameOfLife.view.ConsoleView;

public class ApplicationController {

    public void start() {
        Board playBoard = new Board();
        ConsoleView view = new ConsoleView();

        while(true){
            view.ConsolleView(playBoard.board);
            System.out.println();
            playBoard.nextGen();
            System.out.println();
        }
    }
}
