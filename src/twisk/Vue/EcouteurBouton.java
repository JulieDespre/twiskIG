package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.awt.*;
import java.util.HashMap;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private final MondeIG monde;

    public EcouteurBouton(MondeIG monde) {
        this.monde = monde;

    }


    //ne fonctionne pas nullpointer exception
    @Override
    public void handle(ActionEvent actionEvent) {
           EtapeIG e = new ActiviteIG("", 300, 150);
           monde.ajouterEtape(e);


    }
}
