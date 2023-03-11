package twisk.Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur{
    private EtapeIG etape;
    private PointDeControleIG pdc;

    public VuePointDeControleIG(EtapeIG etape){
        this.etape = etape;
        this.pdc = etape.getPdc(etape.getIdentifiant());
        Circle vPdc = new Circle (pdc.getPosX(), pdc.getPosY(), 5);
        vPdc.setStyle("-fx-border-color: grey; -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0);");
        vPdc.setFill(Color.PINK);
        System.out.println("bonjour");
    }

    @Override
    public void reagir() {

    }
}
