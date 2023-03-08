package twisk.Vue;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueEtapeIG extends VBox implements Observateur {
    private final MondeIG monde;
    private final EtapeIG etape;

    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;


        this.setPrefSize(monde.getEtape(1).getLargeur(), monde.getEtape(1).getHauteur());
        this.setStyle("-fx-border-color: slategrey; -fx-padding: 10px;  -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0); -fx-border-radius: 10;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#A8CDD3"), new CornerRadii(10), null));
        this.setBackground(bg3);

        Label labNom = new Label();
        labNom.setText("Activité "+etape.getIdentifiant());
        labNom.setStyle("-fx-font: 13 Lucida; -fx-font-weight: bold; -fx-padding: 2px;");
        labNom.setTextAlignment(TextAlignment.CENTER);

        VBox zoneClient = new VBox();
        zoneClient.setPrefSize(70, 90);
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
