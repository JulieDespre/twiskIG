package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurVuePdc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private VuePointDeControleIG vPdc;
    private PointDeControleIG pdc;



    public EcouteurVuePdc(MondeIG monde, VuePointDeControleIG vPdc, PointDeControleIG pdc) {

        this.monde = monde;
        this.vPdc = vPdc;
        this.pdc = pdc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        //pb avec compteur ne s'incrémenye pas

        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println(monde.getCpt());
            vPdc.setFill(Color.gray(0.25));
            monde.setPdcCentPosX(vPdc.getCenterX());
            monde.setPdcCentPosY(vPdc.getCenterY());
            pdc.increCpt();
            if (pdc.getCpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.SLATEGRAY);
            }
        }
        System.out.println(pdc.getCpt());
        mouseEvent.consume();
    }

}

