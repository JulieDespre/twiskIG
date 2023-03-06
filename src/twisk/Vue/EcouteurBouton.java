package twisk.Vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.MondeIG;

import java.awt.*;

public class EcouteurBouton implements EventHandler<ActionEvent> {
    private MondeIG monde;





    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println(this.monde.iterator());
    }

    /*public void afficherPosAct(){
        double posX= ActiviteIG.getPosX();
        double posY= ActiviteIG.getPosY();
        Point posAct = new Point(posX, posY);
        System.out.println(posAct);
    }*/

}
