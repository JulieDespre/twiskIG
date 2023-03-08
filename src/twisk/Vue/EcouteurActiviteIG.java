package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

public class EcouteurActiviteIG implements  EventHandler<MouseEvent>  {
    private final MondeIG monde;

    public EcouteurActiviteIG(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

    }
}
