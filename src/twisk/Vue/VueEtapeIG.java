package twisk.Vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueEtapeIG extends VBox implements Observateur{
    private MondeIG monde;
    private EtapeIG etape;


    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;
        this.monde.ajouterObservateur(this);

        Label labNom = new Label(etape.getNom() + etape.getIdentifiant());
        VBox zoneClient = new VBox();
        this.getChildren().addAll(labNom, zoneClient);


    }

    @Override
    public void reagir() {

    }
}
