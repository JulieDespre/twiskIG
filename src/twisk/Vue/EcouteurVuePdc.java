package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurVuePdc implements EventHandler<MouseEvent> {
    private final MondeIG monde;
    private final VuePointDeControleIG vPdc;
    private final PointDeControleIG pdc;



    public EcouteurVuePdc(MondeIG monde, VuePointDeControleIG vPdc, PointDeControleIG pdc) {

        this.monde = monde;
        this.vPdc = vPdc;
        this.pdc = pdc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println(monde.getPdcClick());
            vPdc.setFill(Color.gray(0.25));
            monde.setPdcCentPosX(vPdc.getCenterX());
            monde.setPdcCentPosY(vPdc.getCenterY());
            pdc.increCpt();
            if (pdc.getCpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.SLATEGRAY);
            }
            System.out.println(monde.getPdcClick());
            if (monde.getPdcClick() == null){
                monde.setPdcClick(this.pdc);
            } else if (monde.getPdcClick() != this.pdc){
                monde.ajouterArc(monde.getPdcClick(),this.pdc);
                monde.setPdcClick(null);
            }
        }
        mouseEvent.consume();
    }

}

