package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private final MondeIG monde;

    public EcouteurBouton(MondeIG monde) {
        this.monde = monde;
    }


    //ne fonctionne pas nullpointer exception
    @Override
    public void handle(ActionEvent actionEvent) {
           EtapeIG e = new ActiviteIG("", 250, 100, 5, 3);
           monde.ajouterEtape(e);
    }
}
