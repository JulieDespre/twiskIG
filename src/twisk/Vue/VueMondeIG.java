package twisk.Vue;


import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.awt.*;


public class VueMondeIG extends Pane implements Observateur {
    private final MondeIG monde;

    public VueMondeIG(MondeIG monMonde) {
        this.monde = monMonde;
        this.monde.ajouterObservateur(this);
        Background bg = new Background(new BackgroundFill(Color.web("F8F8FF"), null, null));
        this.setBackground(bg);
    }

    @Override
    public void reagir() {
        //this.getChildren().clear();
        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG vueActivite = new VueActiviteIG(monde, e);
            this.getChildren().add(vueActivite);
            System.out.println("hello");

            //deplacer une vueActivite
        }
    }
}