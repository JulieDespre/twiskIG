package twisk.Vue;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import javax.swing.border.EtchedBorder;
import java.util.HashMap;

public class VueMondeIG extends Pane implements Observateur {

    private MondeIG monde;

    public VueMondeIG (MondeIG monMonde){
        this.monde = monMonde;
        monMonde.ajouterObservateur(this) ;

        Background bg = new Background(new BackgroundFill(Color.web("#F0F0F2"), null, null));
        this.setBackground(bg);



    }
    @Override
    public void reagir() {

    }
}
