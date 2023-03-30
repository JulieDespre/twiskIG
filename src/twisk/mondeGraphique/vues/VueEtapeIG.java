package twisk.mondeGraphique.vues;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import twisk.mondeGraphique.Observateur;
import twisk.mondeGraphique.ecouteurs.EcouteurMouseRelease;
import twisk.mondeGraphique.ecouteurs.EcouteurVueEtapeIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class VueEtapeIG extends VBox implements Observateur, Iterable<VuePointDeControleIG> {
    private MondeIG monde;
    private EtapeIG etape;
    private ArrayList<VuePointDeControleIG> vuePointDeControleIG = new ArrayList<VuePointDeControleIG>();

    private boolean wasDragged=false;

    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etape = etape;

        HBox top = new HBox();
        TailleComposants taille = TailleComposants.getInstance();
        this.setPrefSize(taille.getLargeur(etape), taille.getHauteur(etape));
        this.setStyle("-fx-border-color: #4eadfe; -fx-padding: 10px;  -fx-border-width: 2px; ");
        Background bg3 = new Background(new BackgroundFill(Color.web("#F5FFFA"), new CornerRadii(2), null));
        this.setBackground(bg3);

        Label labNom = new Label();
        labNom.setText(etape.getNom() + " :    " + etape.getTemps() + (" sec +/- ") + etape.getDelais() + (" sec"));
        labNom.setStyle("-fx-font: 13 Lucida; -fx-font-weight: bold; -fx-padding: 2px;");
        labNom.setAlignment(Pos.TOP_CENTER);

        VBox zoneClient = new VBox();
        zoneClient.setPrefSize(80, 90);
        zoneClient.setStyle("-fx-alignment: down");
        zoneClient.setStyle("-fx-background-color: #e3e3e3; -fx-padding: 10px; -fx-border-color: #1fd6fe; -fx-border-width: 2px");

        this.setLayoutX(etape.getPosX());
        this.setLayoutY(etape.getPosY());

        //pour setNom d'une activité
        this.setOnMouseDragged(new EcouteurVueEtapeIG(monde, this, etape));
        this.setOnMouseReleased(new EcouteurMouseRelease(monde, this, etape));

        if (etape.estEntree() && !etape.estSortie()) {
            for (int i = 0; i < monde.aCommeEntree().size(); i++) {
                Circle cercleEnt = new Circle(15);
                cercleEnt.setStroke(Color.SPRINGGREEN);
                cercleEnt.setStrokeWidth(2);
                javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("/entree.png"), 45, 45, true, true);
                cercleEnt.setFill(new ImagePattern(image));
                top.getChildren().addAll(cercleEnt, labNom);
            }
            }else if (etape.estSortie() && !etape.estEntree()) {
                for (int i = 0; i < monde.aCommeSortie().size(); i++) {
                    Circle cercleSort = new Circle(15);
                    cercleSort.setStroke(Color.RED);
                    cercleSort.setStrokeWidth(2);
                    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("/sortie.png"), 45, 45, true, true);
                    cercleSort.setFill(new ImagePattern(image));
                    top.getChildren().addAll(labNom, cercleSort);
                    System.out.println("hello");
                }
            }else if (etape.estEntree() && etape.estSortie()){
                for (int i = 0; i < monde.aCommeEntree().size(); i++) {
                    Circle cercleEnt = new Circle(15);
                    cercleEnt.setStroke(Color.SPRINGGREEN);
                    cercleEnt.setStrokeWidth(2);
                    javafx.scene.image.Image image = new javafx.scene.image.Image(getClass().getResourceAsStream("/entree.png"), 45, 45, true, true);
                    cercleEnt.setFill(new ImagePattern(image));
                    top.getChildren().addAll(cercleEnt);
                    for (int j = 0; j < monde.aCommeSortie().size(); j++) {
                        Circle cercleSort = new Circle(15);
                        cercleSort.setStroke(Color.RED);
                        cercleSort.setStrokeWidth(2);
                        javafx.scene.image.Image image2 = new javafx.scene.image.Image(getClass().getResourceAsStream("/sortie.png"), 45, 45, true, true);
                        cercleSort.setFill(new ImagePattern(image2));
                        top.getChildren().addAll(labNom, cercleSort);
                    }
                }
        } else if (!etape.estEntree() && !etape.estSortie()) {
            if (etape.wasExit() || etape.wasEntry()){
                this.retourCouleur();
            }
            top.getChildren().add(labNom);
        }
        this.getChildren().addAll(top, zoneClient);
}

    public void moveCouleur(){
        this.setStyle("-fx-border-color: darkgrey; -fx-padding: 10px;  -fx-border-width: 2px;");
        Background bg3 = new Background(new BackgroundFill(Color.web("#6f6f6f"), new CornerRadii(2), null));
        this.setBackground(bg3);
        this.setOpacity(0.25);
    }
    public void clicCouleur(){
        this.setStyle("-fx-border-color: darkgrey; -fx-padding: 10px;  -fx-border-width: 2px;-fx-opacity: 0.5");
        Background bg3 = new Background(new BackgroundFill(Color.web("#6f6f6f"), new CornerRadii(2), null));
        this.setBackground(bg3);
    }
    public void retourCouleur(){
        this.setStyle("-fx-border-color: #4eadfe; -fx-padding: 10px;  -fx-border-width: 2px; ");
        Background bg3 = new Background(new BackgroundFill(Color.web("#F5FFFA"), new CornerRadii(2), null));
        this.setBackground(bg3);
        this.setOpacity(1);
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

    public boolean getWasDragged(){
        monde.getPointCliked().clear();
        return wasDragged;
    }

    public void setWasDragged(boolean wasDragged){
        this.wasDragged=wasDragged;
    }

    @Override
    public void reagir() {
    }

    @Override
    public Iterator<VuePointDeControleIG> iterator() {
        return vuePointDeControleIG.iterator();
    }
}
