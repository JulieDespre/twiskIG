package twisk.mondeGraphique.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ArcIG;
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

