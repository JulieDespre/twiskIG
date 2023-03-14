package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import twisk.mondeIG.MondeIG;

public class EcouteurVuePdc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private VuePointDeControleIG vPdc;



    public EcouteurVuePdc(MondeIG monde, VuePointDeControleIG vPdc) {

        this.monde = monde;
        this.vPdc = vPdc;
    }

    @Override

    public void handle(MouseEvent mouseEvent) {
        //pb avec compteur ne s'incrémenye pas

        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
            System.out.println(monde.getCpt());
            vPdc.setFill(Color.gray(0.25));
            monde.setPdcCentPosX(vPdc.getCenterX());
            monde.setPdcCentPosY(vPdc.getCenterY());
            monde.increCpt();
            if (monde.getCpt() % 2 == 0) {
                vPdc.setFill(Color.web("C0C0C0"));
            } else {
                vPdc.setFill(Color.gray(0.25));
            }
        }
        System.out.println(monde.getCpt());
        mouseEvent.consume();
    }

}

