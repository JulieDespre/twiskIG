package twisk.Vue;

import javafx.scene.control.Button;
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
        this.setStyle("-fx-border-color: slategrey; -fx-border-width: 0.5px;");

        Button addAct = new Button();
        Button selectArc = new Button();
        Button selectCourbe = new Button();

        //tooltip pour le bouton add
        Tooltip tool = new Tooltip("ajouter une activité");
        tool.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
        tool.setTextAlignment(TextAlignment.CENTER);
        addAct.setTooltip(tool);

        //tooltip pour le bouton arc
        Tooltip tool1 = new Tooltip("selectionner l'outils créateur de lignes");
        tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
        tool1.setTextAlignment(TextAlignment.CENTER);
        selectArc.setTooltip(tool1);

        //tooltip pour le bouton courbe
        Tooltip tool2 = new Tooltip("selectionner l'outils créateur de courbe");
        tool2.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
        tool2.setTextAlignment(TextAlignment.CENTER);
        selectCourbe.setTooltip(tool2);

        addAct.setStyle("-fx-border-color: #1fd6fe; -fx-border-width: 0.5px;");
        Image image = new Image(getClass().getResourceAsStream("/addAct.png"), 35, 35, true, true);
        ImageView icon = new ImageView(image);
        addAct.setGraphic(icon);
        addAct.setOnAction(new EcouteurBouton(monde));

        selectArc.setStyle("-fx-border-color: slategrey; -fx-border-width: 0.5px;");
        Image image1 = new Image(getClass().getResourceAsStream("/ligne.png"), 35, 35, true, true);
        ImageView icon1 = new ImageView(image1);
        selectArc.setGraphic(icon1);
        //addAct.setOnAction(new EcouteurBouton(monde));

        selectCourbe.setStyle("-fx-border-color: slategrey; -fx-border-width: 0.5px;");
        Image image2 = new Image(getClass().getResourceAsStream("/courbe.png"), 35, 35, true, true);
        ImageView icon2 = new ImageView(image2);
        selectCourbe.setGraphic(icon2);
        //addAct.setOnAction(new EcouteurBouton(monde));

        Pane spacer = new Pane();
        spacer.setMinSize(835, 1);

        this.getChildren().addAll(addAct, spacer, selectArc, selectCourbe);
    }

    @Override
    public void reagir() {
    }
}
