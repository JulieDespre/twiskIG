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

import java.util.ArrayList;
import java.util.Iterator;

public class VueEtapeIG extends VBox implements Observateur, Iterable<VuePointDeControleIG> {
    private MondeIG monde;
    private EtapeIG etape;
    private ArrayList<VuePointDeControleIG> vuePointDeControleIG = new ArrayList<VuePointDeControleIG>();

    public VueEtapeIG(MondeIG monde, EtapeIG etape){
        this.monde = monde;
        this.etape = etape;

            TailleComposants taille = TailleComposants.getInstance();
            this.setPrefSize(taille.getLargeur(etape),taille.getHauteur(etape));
            this.setStyle("-fx-border-color: #4eadfe; -fx-padding: 10px;  -fx-border-width: 2px; ");
            Background bg3 = new Background(new BackgroundFill(Color.web("#F5FFFA"), new CornerRadii(2), null));
            this.setBackground(bg3);

            Label labNom = new Label();
            labNom.setText("Activité " + etape.getIdentifiant() + " :    " + etape.getTemps() + (" sec +/- ") + etape.getDelais() + (" sec"));
            labNom.setStyle("-fx-font: 13 Lucida; -fx-font-weight: bold; -fx-padding: 2px;");
            labNom.setTextAlignment(TextAlignment.CENTER);

            VBox zoneClient = new VBox();
            zoneClient.setPrefSize(70, 90);
            zoneClient.setStyle("-fx-alignment: down");
            zoneClient.setStyle("-fx-background-color: #e3e3e3; -fx-padding: 10px; -fx-border-color: #1fd6fe; -fx-border-width: 2px");

            this.setLayoutX(etape.getPosX());
            this.setLayoutY(etape.getPosY());
            this.getChildren().addAll(labNom, zoneClient);

            //pour setNom d'une activité
            //this.setOnMouseClicked(new EcouteurVueActiviteIG(monde, this, etape));
            this.setOnMouseDragged(new EcouteurVueActiviteIG(monde, this, etape));
            this.setOnMouseReleased(new EcouteurMouseRelease(monde, this));
        }
    public void moveCouleur(){
        this.setStyle("-fx-border-color: darkgrey; -fx-padding: 10px;  -fx-border-width: 2px;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#6f6f6f"), new CornerRadii(2), null));
        this.setBackground(bg3);
        this.setOpacity(0.25);
    }
    public void clicCouleur(){
        this.setStyle("-fx-border-color: darkgrey; -fx-padding: 10px;  -fx-border-width: 2px;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#6f6f6f"), new CornerRadii(2), null));
        this.setBackground(bg3);
    }
    public void retourCouleur(){
        this.setStyle("-fx-border-color: slategrey; -fx-padding: 10px;  -fx-border-width: 2px;");
        Background bg4 = new Background(new BackgroundFill(Color.web("#A8CDD3"), new CornerRadii(2), null));
        this.setBackground(bg4);
        this.setOpacity(1.0);
    }

    public void setPosX(double newPosX){
        this.setLayoutX(newPosX);
    }

    public void setPosY(double newPosY){
        this.setLayoutY(newPosY);
    }

    public ArrayList<VuePointDeControleIG> getVuePdc(){
        return vuePointDeControleIG;
    }

    @Override
    public void reagir() {
    }

    @Override
    public Iterator<VuePointDeControleIG> iterator() {
        return vuePointDeControleIG.iterator();
    }
}
