package twisk.mondeGraphique.vues;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import twisk.mondeGraphique.ecouteurs.EcouteurVueArc;
import twisk.mondeGraphique.ecouteurs.EcouteurVuePdc;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public abstract class VueArcIG extends Pane{
    private final MondeIG monde;
    private final ArcIG ligneDroite;

    public VueArcIG(MondeIG monde, ArcIG ligneDroite) {
        this.monde = monde;
        this.ligneDroite = ligneDroite;
       // this.setOnMouseClicked(new EcouteurVueArc(monde, this,ligneDroite));
        /*this.creationArcLigne();
        if (monde.getcreationLigne() == true) {
            this.creationArcLigne();
        }*/
    }

    public ArcIG getArc(){
        return ligneDroite;
    }

    public MondeIG getMonde(){
        return monde;
    }

    public PointDeControleIG getPdcStart(){
        return this.getArc().getPdcStart();
    }
    public PointDeControleIG getPdcEnd(){
        return this.getArc().getPdcEnd();
    }

}

