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
import twisk.mondeIG.TailleComposants;

public class VueEtapeIG extends VBox implements Observateur {
    private MondeIG monde;
    private EtapeIG etape;

    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;

            TailleComposants taille=TailleComposants.getInstance();
            this.setPrefSize(taille.getLargeur(etape),taille.getHauteur(etape));
            this.setStyle("-fx-border-color: slategrey; -fx-padding: 10px;  -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0); -fx-border-radius: 10;");
            Background bg3 = new Background(new BackgroundFill(Color.web("#A8CDD3"), new CornerRadii(10), null));
            this.setBackground(bg3);

            Label labNom = new Label();
            labNom.setText("Activité " + etape.getIdentifiant() + " :    " + etape.getTemps() + (" sec +/- ") + etape.getDelais() + (" sec"));
            labNom.setStyle("-fx-font: 13 Lucida; -fx-font-weight: bold; -fx-padding: 2px;");
            labNom.setTextAlignment(TextAlignment.CENTER);

            VBox zoneClient = new VBox();
            zoneClient.setPrefSize(70, 90);
            zoneClient.setStyle("-fx-alignment: down");
            zoneClient.setStyle("-fx-background-color: lightgrey; -fx-padding: 20px; -fx-border-color: #228b96; -fx-border-width: 2px");

            this.setLayoutX(etape.getPosX());
            this.setLayoutY(etape.getPosY());
            this.getChildren().addAll(labNom, zoneClient);

        this.setOnMouseDragged(new EcouteurVueActiviteIG(monde, this, etape));
        this.setOnMouseReleased(new EcouteurMouseRelease(monde, this));
        }
    public void moveCouleur(){
        this.setStyle("-fx-border-color: darkgrey; -fx-padding: 10px;  -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0); -fx-border-radius: 10;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#6f6f6f"), new CornerRadii(10), null));
        this.setBackground(bg3);
        this.setOpacity(0.25);
    }
    public void retourCouleur(){
        this.setStyle("-fx-border-color: slategrey; -fx-padding: 10px;  -fx-border-width: 2px; -fx-effect: dropshadow( one-pass-box , grey, 8 , 0.0 , 2 , 0); -fx-border-radius: 10;");
        Background bg4 = new Background(new BackgroundFill(Color.web("#A8CDD3"), new CornerRadii(10), null));
        this.setBackground(bg4);
        this.setOpacity(1.0);
    }

    public void setPosX(double newPosX){
        this.setLayoutX(newPosX);
    }

    public void setPosY(double newPosY){
        this.setLayoutY(newPosY);
    }

    @Override
    public void reagir() {
    }

}
