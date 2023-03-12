package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurNouveau implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurNouveau(MondeIG monde) {
        this.monde = monde;
    }

    public void handle(ActionEvent event) {
        this.monde.destructeurDeMonde();
    }
}
