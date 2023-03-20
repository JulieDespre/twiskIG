package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurSupprimerEtape implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurSupprimerEtape(MondeIG monde) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        monde.supprimerEtapes();
    }
}
