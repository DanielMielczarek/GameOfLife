package GameOfLife.controler;

import GameOfLife.GameOfLife;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import GameOfLife.model.Dot;


public class EventsHandler {

    public void eventHandleMouseClick(Rectangle dot, Dot dotIsLive) {
        EventHandler<MouseEvent> eventEventHandler = event -> {
            dot.setFill(Color.BLACK);
            dotIsLive.setALive(true);

            System.out.println("działam");
            System.out.println(dotIsLive.isALive());
        };
        dot.addEventHandler(MouseEvent.MOUSE_CLICKED,eventEventHandler);
    }
}
