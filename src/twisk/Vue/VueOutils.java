package twisk.Vue;

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
import twisk.mondeIG.MondeIG;

public class VueOutils extends HBox implements Observateur {
    private final MondeIG monde;

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

        Label arcNom = new Label("Dessiner les arcs :");
        arcNom.setStyle("-fx-border-color: slategrey; -fx-border-width: 1px; -fx-font: 13 helvetica; -fx-font-weight: bold; -fx-max-width: 250; -fx-max-height: 45; -fx-text-alignment: center");
        arcNom.setPadding(new Insets(5, 5, 5, 5));

        Pane spacer = new Pane();
        spacer.setMinSize(623, 1);


        this.getChildren().addAll(addAct, addGui, spacer, arcNom, selectLine, selectCourbe);
    }

    @Override
    public void reagir() {
    }

    public void addTool(String nom, Button bouton){
        Tooltip tool1 = new Tooltip(nom);
        tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
        tool1.setTextAlignment(TextAlignment.CENTER);
        bouton.setTooltip(tool1);
    }
}
