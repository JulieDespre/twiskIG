package twisk.mondeGraphique.ecouteurs;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeGraphique.vues.VuePointDeControleIG;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;
import java.awt.*;

public class EcouteurMonde implements EventHandler<MouseEvent>  {
    private final MondeIG monde;
    private CourbeIG courbe;

    private VuePointDeControleIG vPdc;

    public EcouteurMonde(MondeIG monde) {

        this.monde = monde;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
       if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                 monde.ajouterPointClicked(new Point((int)mouseEvent.getX(),(int)mouseEvent.getY()));
        }
        mouseEvent.consume();
    }

}


