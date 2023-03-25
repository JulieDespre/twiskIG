package twisk.mondeGraphique.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeGraphique.Observateur;
import twisk.mondeGraphique.ecouteurs.EcouteurVuePdc;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur {
    private final EtapeIG etape;
    private final MondeIG monde;
    private final PointDeControleIG pdc;

    public VuePointDeControleIG(Double posX, Double posY, int radius, EtapeIG etape, MondeIG monde, PointDeControleIG pdc) {
        super(posX, posY, radius);
        this.monde = monde;
        this.etape = etape;
        this.pdc = pdc;

        this.setStroke(Color.SLATEGRAY);
        this.setFill(Color.web("#C0C0C0"));



        this.setOnMouseClicked(new EcouteurVuePdc(monde, this, pdc));
    }

    @Override
    public void reagir() {

    }

}
