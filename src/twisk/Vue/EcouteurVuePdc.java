package twisk.Vue;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;

public class EcouteurVuePdc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private VuePointDeControleIG vPdc;

    private int cpt;

    public EcouteurVuePdc (MondeIG monde, VuePointDeControleIG vPdc) {

        this.monde = monde;
        this.vPdc = vPdc;
    }
    @Override

    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED){
            vPdc.couleurOnClicImpair();
            cpt++;
        }
if (cpt%2 == 0){
    vPdc.couleurOnClicImpair();
}else{
    vPdc.couleurOnClicPair();
}
        mouseEvent.consume();
    }
}

