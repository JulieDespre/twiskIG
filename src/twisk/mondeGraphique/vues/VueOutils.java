package twisk.mondeGraphique.vues;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import twisk.mondeGraphique.Observateur;
import twisk.mondeGraphique.ecouteurs.*;
import twisk.mondeIG.MondeIG;

public class VueOutils extends HBox implements Observateur {
    private final MondeIG monde;
    private Button suppArc = new Button();
    private Button suppEtp = new Button();

    public VueOutils(MondeIG monde) {
        this.monde = monde;
        this.monde.ajouterObservateur(this);

        Background bg = new Background(new BackgroundFill(Color.web("#D8D8D9"), null, null));
        this.setBackground(bg);
        this.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");

        Button addAct = new Button();
        Button selectLine = new Button();
        Button selectCourbe = new Button();
        Button addGui = new Button();
        Button modifCourbe = new Button();


        //bouton ajouter une activité
        addAct.setStyle("-fx-border-color: #1fd6fe; -fx-border-width: 1px;");
        Image image = new Image(getClass().getResourceAsStream("/addAct.png"), 36, 36, true, true);
        ImageView icon = new ImageView(image);
        addAct.setGraphic(icon);
        addAct.setOnAction(new EcouteurBouton(monde));
        addTool("Ajouter une activité", addAct);

        //bouton ajouter un guichet
        addGui.setStyle("-fx-border-color: limegreen; -fx-border-width: 1px;-fx-content-display: center;");
        Image image3 = new Image(getClass().getResourceAsStream("/addGui2.png"), 36, 36, false, false);
        ImageView icon3 = new ImageView(image3);
        addGui.setGraphic(icon3);
        addGui.setOnAction(new EcouteurBouton(monde));
        addTool("Ajouter un guichet", addGui);

        //bouton pour sélectionner arc ligne droite
        selectLine.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");
        Image image1 = new Image(getClass().getResourceAsStream("/ligne.png"), 36, 36, true, true);
        ImageView icon1 = new ImageView(image1);
        selectLine.setGraphic(icon1);
        selectLine.setOnMouseClicked(new EcouteurLigneBouton(monde));
        addTool("selectionner l'outil créateur de lignes", selectLine);

        //bouton pour sélectionner coubes
        selectCourbe.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");
        Image image2 = new Image(getClass().getResourceAsStream("/courbe.png"), 36, 36, true, true);
        ImageView icon2 = new ImageView(image2);
        selectCourbe.setGraphic(icon2);
        selectCourbe.setOnMouseClicked(new EcouteurCourbeBouton(monde));
        addTool("sélectionner l'outil créateur de courbes", selectCourbe);

        //bouton pour sélectionner arc ligne droite
        modifCourbe.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");
        Image image4 = new Image(getClass().getResourceAsStream("/modifCourbe.png"), 36, 36, true, true);
        ImageView icon4 = new ImageView(image4);
        modifCourbe.setGraphic(icon4);
        modifCourbe.setOnMouseClicked(new EcouteurLigneBouton(monde));
        addTool("Modifier les arcs courbes", modifCourbe);

        //bouton pour supprimer arc
        suppArc.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");
        Image image5 = new Image(getClass().getResourceAsStream("/ligne.png"), 36, 36, true, true);
        ImageView icon5 = new ImageView(image5);
        suppArc.setGraphic(icon5);
        suppArc.setOnAction(new EcouteurSupprimerArc(monde));
        addTool("Supprimer le/les arc(s) sélectionné(s)", suppArc);

        //bouton pour supprimer étapes
        suppEtp.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px;");
        Image image6 = new Image(getClass().getResourceAsStream("/act.png"), 36, 36, true, true);
        ImageView icon6 = new ImageView(image6);
        suppEtp.setGraphic(icon6);
        suppEtp.setOnAction(new EcouteurSupprimerEtape(monde));
        addTool("Supprimer le/les étapes(s) sélectionné(s)", suppEtp);

        Label arcNom = new Label("Dessiner les arcs :");
        arcNom.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px; -fx-font: 11 helvetica; -fx-font-weight: bold; -fx-max-width: 250; -fx-max-height: 46; -fx-text-alignment: center");
        arcNom.setPadding(new Insets(5, 5, 5, 5));

        Label supArc = new Label("Suppression Arc :");
        supArc.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px; -fx-font: 11 helvetica; -fx-font-weight: bold; -fx-max-width: 250; -fx-max-height: 46; -fx-text-alignment: center");
        supArc.setPadding(new Insets(5, 5, 5, 5));

        Label supEtape = new Label("Suppression Etape :");
        supEtape.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px; -fx-font: 11 helvetica; -fx-font-weight: bold; -fx-max-width: 250; -fx-max-height: 46; -fx-text-alignment: center");
        supEtape.setPadding(new Insets(5, 5, 5, 5));


        Label courbeModif = new Label("Modifier les arcs courbes :");
        courbeModif.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px; -fx-font: 11 helvetica; -fx-font-weight: bold; -fx-max-width: 250; -fx-max-height: 46; -fx-text-alignment: center");
        courbeModif.setPadding(new Insets(5, 5, 5, 5));

        Pane spacer = new Pane();
        spacer.setMinSize(40, 1);

        this.getChildren().addAll(addAct, addGui,spacer, arcNom, selectLine, selectCourbe, supEtape, suppEtp, supArc, suppArc, courbeModif, modifCourbe);
        reagir();
    }

    @Override
    public void reagir() {
        boolean disable3 = true;
        if (monde.getEtapesClicked().size() > 0) {
            disable3 = false;
        }
        suppEtp.setDisable(disable3);

        if (monde.getLignes() != null || monde.getCourbes() != null ){
            boolean disable = true;
            for (int i = 0; i < monde.getLignes().size(); i++) {
                if (monde.getLignes().get(i).getSelect()) {
                    disable = false;
                }
            }
            for (int i = 0; i < monde.getCourbes().size(); i++) {
                if (monde.getCourbes().get(i).getSelect()) {
                    disable = false;
                }
            }
            suppArc.setDisable(disable);
        }
    }

    public void addTool(String nom, Button bouton){
        Tooltip tool1 = new Tooltip(nom);
        tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
        tool1.setTextAlignment(TextAlignment.CENTER);
        bouton.setTooltip(tool1);
    }
}
