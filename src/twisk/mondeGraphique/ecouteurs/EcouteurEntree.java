package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler<ActionEvent> {
        private MondeIG monde;
        private EtapeIG etape;

    public EcouteurEntree(MondeIG monde, EtapeIG etape) {
            this.etape = etape;
            this.monde = monde;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        monde.ajouterEntree(etape);

    }
}
