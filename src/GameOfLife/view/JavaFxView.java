package GameOfLife.view;

import GameOfLife.controler.EventsHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import GameOfLife.model.Board;

public class JavaFxView {

    private GridPane boardJavaFX = new GridPane();
    private Rectangle[][] boardFX;

    public void startWindow(Stage primaryStage, Board board) {
        VBox root = new VBox();
        Button startButton = new Button();
        Button pauseButton = new Button();
        startButton.setText("Start");
        pauseButton.setText("pause");
        root.getChildren().add(pauseButton);
        root.getChildren().add(startButton);

        Scene scene = new Scene(root, 800, 800);

        boardJavaFX.setHgap(2);
        boardJavaFX.setVgap(2);
        boardJavaFX.setGridLinesVisible(true);

        root.getChildren().add(boardJavaFX);

        update(board);
        simLoop(board, startButton,pauseButton);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of Life");
        primaryStage.show();

    }

//    private void drawBoard(Board board, GridPane boardJavaFX) {
//        board.setBoard(board.board);
//        for (int i = 0; i < board.board.length; i++) {
//            for (int j = 0; j < board.board[i].length; j++) {
//                boardJavaFX.add(board.board[i][j], i, j);
//
//            }
//        }
//        for (int i = 0; i < board.board.length; i++) {
//            System.out.println();
//            for (int j = 0; j < board.board[i].length; j++) {
////                System.out.println(board.board[i][j].isALive());
//            }
//        }
//    }

    private void update(Board board){
        board.setBoard(board.board);
        setJavaFXBoard(board);
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if(board.board[i][j].isALive()) {
                boardJavaFX.add(boardFX[i][j], i, j);
                boardFX[i][j].setFill(Color.BLACK);
                }
                else{
                    boardJavaFX.add( boardFX[i][j], i, j);
                    boardFX[i][j].setFill(Color.WHITE);
                }
            }
        }
    }
    private void setJavaFXBoard(Board board) {
        boardFX = new Rectangle[board.getSizeX()][board.getSizeY()];
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                boardFX[i][j] = new Rectangle(0, 0, 12, 12);
                EventsHandler eventsHandler = new EventsHandler();
                eventsHandler.eventHandleMouseClick(boardFX[i][j], board.board[i][j]);
            }
        }
    }

    private void simLoop(Board board, Button startButton,Button pause) {
        Timeline simLoop;
        simLoop = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            board.nextGen();
            for (int i = 0; i < board.board.length ; i++) {
                for (int j = 0; j < board.board[i].length ; j++) {
                    if(board.board[i][j].isALive()) {
                        boardFX[i][j].setFill(Color.BLACK);
                    }
                    else{
                        boardFX[i][j].setFill(Color.WHITE);
                    }
                }
            }

//            System.out.println("BOARD");
//            for (int i = 0; i < board.board.length; i++) {
//                System.out.println();
//                for (int j = 0; j < board.board[i].length; j++) {
//                    System.out.print(board.board[i][j].isALive()+" ");
//                }
//            }
        }));

        simLoop.setCycleCount(Timeline.INDEFINITE);
        click(startButton, simLoop);
        stopEventHanlder(pause,simLoop);
    }

    private void click(Button statrtButton, Timeline simLoop) {
        EventHandler<MouseEvent> Click = event -> simLoop.play();
        statrtButton.addEventHandler(MouseEvent.MOUSE_CLICKED, Click);
    }
    private void stopEventHanlder(Button statrtButton, Timeline simLoop) {
        EventHandler<MouseEvent> Click = event -> simLoop.stop();
        statrtButton.addEventHandler(MouseEvent.MOUSE_CLICKED, Click);
    }


}
