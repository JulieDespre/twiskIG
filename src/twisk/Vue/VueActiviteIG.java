package twisk.Vue;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements Observateur{

    public VueActiviteIG(MondeIG monde, EtapeIG etapeIG) {
        super(monde, etapeIG);
        this.setPrefSize(monde.getEtape(1).getLargeur(), monde.getEtape(1).getHauteur());
        this.setStyle("-fx-border-color: slategrey; -fx-padding: 10px;  -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0); -fx-border-radius: 10;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#A8CDD3"), new CornerRadii(10), null));
        this.setBackground(bg3);

        Label labNom = new Label(etapeIG.getNom());
        labNom.setText("Activité "+etapeIG.getIdentifiant());
        labNom.setAlignment(Pos.CENTER);
        VBox zoneClient = new VBox();
        zoneClient.setPrefSize(80, 100);
        zoneClient.setStyle("-fx-alignment: down");
        zoneClient.setStyle("-fx-background-color: lightgrey; -fx-padding: 20px; -fx-border-color: #228b96; -fx-border-width: 2px");

        this.setLayoutX(350);
        this.setLayoutY(350);
        this.getChildren().addAll(labNom, zoneClient);
    }

    @Override
    public void reagir() {

    }
}
