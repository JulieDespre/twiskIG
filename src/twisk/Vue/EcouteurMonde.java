package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

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
                System.out.println("zerijzeor");
        }
        mouseEvent.consume();
    }

}


