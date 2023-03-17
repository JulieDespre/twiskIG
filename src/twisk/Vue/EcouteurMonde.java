package twisk.Vue;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.CourbeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurMonde {
    private final MondeIG monde;
    private CourbeIG courbe;


    public EcouteurMonde(MondeIG monde, CourbeIG courbe) {

        this.monde = monde;
    }

    //continue a mettre la creation d'une courbe sous l'action d'un bouton
    //@Override
    //public void handle(MouseEvent mouseEvent) {
       /* if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
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
                monde.ajouterLigne(monde.getPdcClick(),this.pdc);
                monde.setPdcClick(null);
            }
        }
        mouseEvent.consume();
    }*/

}


