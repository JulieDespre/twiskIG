package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

public class EcouteurCourbe implements EventHandler<MouseEvent> {
    private MondeIG monde;


    public EcouteurCourbe (MondeIG monde){
        this.monde = monde;

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) monde.setCreationCourbe(true);
    }
}


