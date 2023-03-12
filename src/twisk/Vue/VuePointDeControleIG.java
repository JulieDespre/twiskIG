package twisk.Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;


public class VuePointDeControleIG extends Circle implements Observateur{
    private EtapeIG etape;
    private MondeIG monde;

    public VuePointDeControleIG(Double posX, Double posY, int radius, EtapeIG etape, MondeIG monde){
        super(posX,posY,radius);
        this.monde = monde;
        this.etape = etape;

        this.setStyle("-fx-border-color: grey; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0)");
        this.setFill(Color.web("C0C0C0"));
        System.out.println("bonjour");
    }

    @Override
    public void reagir() {

    }
    public void vpdcMove(VuePointDeControleIG vuePointDeControleIG){
        vuePointDeControleIG.setStyle("-fx-border-color: grey; -fx-effect: dropshadow( one-pass-box , grey, 0 , 0.0 , 0 , 0)");
        vuePointDeControleIG.setOpacity(0);
    }
}
