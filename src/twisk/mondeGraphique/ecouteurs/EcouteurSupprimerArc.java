package twisk.mondeGraphique.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurSupprimerArc implements EventHandler<ActionEvent> {

private MondeIG monde;

public EcouteurSupprimerArc(MondeIG monde){
    this.monde=monde;
}
    @Override
    public void handle(ActionEvent actionEvent) {
        monde.suppArcs();
    }
}
