package twisk.Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import java.util.HashMap;

import static javafx.geometry.Pos.CENTER;

public class VueMondeIG extends Pane implements Observateur {

    private final MondeIG monde;



    public VueMondeIG (MondeIG monMonde){
        this.monde = monMonde;
        this.monde.ajouterObservateur(this);
        Background bg = new Background(new BackgroundFill(Color.web("#D8D8D9"), null, null));
        this.setBackground(bg);

    }
    @Override
    public void reagir() {
        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG vueActivite = new VueActiviteIG(monde, e);
            this.getChildren().add(vueActivite);
            System.out.println("hello");
        }
    }

}
