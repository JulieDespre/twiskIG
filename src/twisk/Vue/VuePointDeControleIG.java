package twisk.Vue;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.awt.image.ColorModel;


public class VuePointDeControleIG extends Circle implements Observateur{
    private EtapeIG etape;
    private MondeIG monde;

    public VuePointDeControleIG(Double posX, Double posY, int radius, EtapeIG etape, MondeIG monde){
        super(posX,posY,radius);
        this.monde = monde;
        this.etape = etape;

        this.setStyle("-fx-border-color: lightgrey;");
        this.setFill(Color.web("C0C0C0"));

        this.setOnMouseClicked(new EcouteurVuePdc(monde, this));
    }

    @Override
    public void reagir() {

    }
    public void couleurOnClicPair(){
        this.setFill(Color.PINK);
    }
    public void couleurOnClicImpair(){
        this.setFill(Color.LIGHTGRAY);
    }
}
