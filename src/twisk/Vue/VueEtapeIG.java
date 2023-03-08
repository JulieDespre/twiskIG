package twisk.Vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueEtapeIG extends VBox implements Observateur {
    private MondeIG monde;
    private EtapeIG etape;


    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;
        this.monde.ajouterObservateur(this);



    }

    @Override
    public void reagir() {
        //for (EtapeIG e : monde.getEtapes().values()) {
            //VueEtapeIG vEt = new VueEtapeIG(this.monde, e);
        //}
    }
}
