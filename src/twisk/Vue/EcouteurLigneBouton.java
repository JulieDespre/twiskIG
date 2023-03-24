package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

public class EcouteurLigneBouton implements EventHandler<MouseEvent> {
    private MondeIG monde;


    public EcouteurLigneBouton(MondeIG monde){
        this.monde = monde;

    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            monde.setCreationLigne(true);
            //monde.setCreationCourbe(false);
        }
    }
}
