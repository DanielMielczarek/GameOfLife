package GameOfLife;

import GameOfLife.view.JavaFxView;
import javafx.application.Application;
import javafx.stage.Stage;
import GameOfLife.model.Board;


public class GameOfLife extends Application {

    public static void main(String[] args) {
//        ApplicationController startApplication = new ApplicationController();
//        startApplication.start();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        JavaFxView view = new JavaFxView();
        Board playBoard = new Board();
        view.startWindow(primaryStage,playBoard);

    }
}

