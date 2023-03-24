package twisk.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.LigneDroiteIG;
import twisk.mondeIG.MondeIG;

public abstract class VueArcIG extends Pane {
    private final MondeIG monde;
    private final ArcIG ligneDroite;

    public VueArcIG(MondeIG monde, ArcIG ligneDroite) {
        this.monde = monde;
        this.ligneDroite = ligneDroite;

        /*this.creationArcLigne();
        if (monde.getcreationLigne() == true) {
            this.creationArcLigne();
        }*/
    }

    public ArcIG getArc(){
        return ligneDroite;
    }


}

