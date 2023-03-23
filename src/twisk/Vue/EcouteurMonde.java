package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurMonde implements EventHandler<MouseEvent>  {
    private final MondeIG monde;
    private CourbeIG courbe;

    private VuePointDeControleIG vPdc;
    private PointDeControleIG pdc;

    public EcouteurMonde(MondeIG monde, CourbeIG courbe) {

        this.monde = monde;
        this.courbe = courbe;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
       if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            monde.setPdcCentPosX(vPdc.getCenterX());
            monde.setPdcCentPosY(vPdc.getCenterY());
            monde.increCptPt();
            if (monde.getCptpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.SLATEGRAY);
            }
            System.out.println(monde.getPdcClick());
            if (monde.getPdcClick() == null){
                monde.setPdcClick(this.pdc);
            } else if (monde.getPdcClick() != this.pdc){
                monde.ajouterCourbe(monde.getPdcClick(),this.pdc);
                monde.setPdcClick(null);
            }
        }
        mouseEvent.consume();
    }
    }

}


