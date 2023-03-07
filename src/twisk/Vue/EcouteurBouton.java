package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.awt.*;
import java.util.HashMap;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurBouton(MondeIG monde) {
        this.monde = monde;

    }


    //ne fonctionne pas nullpointer exception
    @Override
    public void handle(ActionEvent actionEvent) {
           EtapeIG e = new ActiviteIG("nom", 300, 150);
           monde.ajouterEtape(e);


    /*public void afficherPosAct(){
        double posX= ActiviteIG.getPosX();
        double posY= ActiviteIG.getPosY();
        Point posAct = new Point(posX, posY);
        System.out.println(posAct);
    }*/

    }
}
