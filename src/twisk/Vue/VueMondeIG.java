package twisk.Vue;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import java.util.HashMap;

public class VueMondeIG extends Pane implements Observateur {

    private MondeIG monde;



    public VueMondeIG (MondeIG monMonde){
        this.monde = monMonde;

        monMonde.ajouterObservateur(this) ;
        Background bg = new Background(new BackgroundFill(Color.web("#D8D8D9"), null, null));
        this.setBackground(bg);



    }
    @Override
    public void reagir() {
        for (EtapeIG e : monde.getEtapes().values()) {
            VueEtapeIG activite = new VueActiviteIG(monde, e);
            this.getChildren().add(activite);
            System.out.println("hello");
        }
    }

}
