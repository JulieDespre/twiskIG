package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSupprimer implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurSupprimer(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        monde.supprimerEtapes();
    }
}
