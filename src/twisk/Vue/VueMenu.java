package twisk.Vue;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import twisk.mondeIG.MondeIG;

public class VueMenu extends HBox implements Observateur {
        private final MondeIG monde;


        public VueMenu (MondeIG monde) {
            super();
            this.monde = monde;
            this.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");
            MenuBar menuBar = new MenuBar();
            menuBar.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");
            Menu menu = new Menu("Menu");
            menu.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");

            Menu menuFich = new Menu("Fichier");
            MenuItem nouveau = new MenuItem("Nouveau");
            nouveau.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            nouveau.setOnAction(new EcouteurNouveau(monde));

            MenuItem quitter = new MenuItem("Quitter");
            quitter.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
            quitter.setOnAction(event -> Platform.exit());

            Menu menuEd = new Menu("Edition");
            MenuItem supprimer = new MenuItem("Supprimer");
            supprimer.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
            supprimer.setOnAction(new EcouteurSupprimer(monde));

            Button setNom = new Button();
            Button setTps = new Button();
            Button setDel = new Button();
            Button bQuit = new Button();
            Button bNew = new Button();
            Pane spacer = new Pane();
            spacer.setMinSize(606, 1);
            spacer.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;-fx-alignment: center");

            //bouton pour setNom
            setNom.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image = new Image(getClass().getResourceAsStream("/setNom.png"), 35, 35, true, true);
            ImageView icon = new ImageView(image);
            setNom.setGraphic(icon);
            setNom.setAlignment(Pos.CENTER_RIGHT);
            setNom.setOnAction(new EcouteurBouton(monde));

            Tooltip tool = new Tooltip("Modifier le nom de l'activité");
            tool.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool.setTextAlignment(TextAlignment.CENTER);
            setNom.setTooltip(tool);

            //bouton pour setTemps
            setTps.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image1 = new Image(getClass().getResourceAsStream("/setTps.png"), 35, 35, true, true);
            ImageView icon1 = new ImageView(image1);
            setTps.setGraphic(icon1);
            setTps.setAlignment(Pos.CENTER_RIGHT);
            setTps.setOnAction(new EcouteurBouton(monde));

            Tooltip tool1 = new Tooltip("Modifier la durée de l'activité");
            tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool1.setTextAlignment(TextAlignment.CENTER);
            setTps.setTooltip(tool1);

            //bouton pour setDel
            setDel.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image2 = new Image(getClass().getResourceAsStream("/setDel.png"), 35, 35, true, true);
            ImageView icon2 = new ImageView(image2);
            setDel.setGraphic(icon2);
            setDel.setAlignment(Pos.CENTER_RIGHT);
            setDel.setOnAction(new EcouteurBouton(monde));

            Tooltip tool2 = new Tooltip("Modifier le delais de l'activité");
            tool2.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool2.setTextAlignment(TextAlignment.CENTER);
            setDel.setTooltip(tool2);

            //bouton pour quitter
            bQuit.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image3 = new Image(getClass().getResourceAsStream("/quitMonde.png"), 35, 35, true, true);
            ImageView icon3 = new ImageView(image3);
            bQuit.setGraphic(icon3);
            bQuit.setAlignment(Pos.CENTER_RIGHT);
            bQuit.setOnAction(e-> Platform.exit());

            Tooltip tool3 = new Tooltip("Quitter le créateur de Monde");
            tool3.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool3.setTextAlignment(TextAlignment.CENTER);
            bQuit.setTooltip(tool3);

            //bouton pour quitter
            bNew.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image4 = new Image(getClass().getResourceAsStream("/newMonde.png"), 35, 35, true, true);
            ImageView icon4 = new ImageView(image4);
            bNew.setGraphic(icon4);
            bNew.setAlignment(Pos.CENTER_RIGHT);
            bNew.setOnAction(new EcouteurNouveau(monde));

            //ajout des items a vueMenu
            menuFich.getItems().addAll(nouveau, quitter);
            menuEd.getItems().add(supprimer);

            Tooltip tool4 = new Tooltip("Destruction du Monde");
            tool4.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool4.setTextAlignment(TextAlignment.CENTER);
            bNew.setTooltip(tool4);
            menu.getItems().addAll(menuFich, menuEd);
            menuBar.getMenus().addAll(menu);
            this.getChildren().addAll(menuBar, setNom, setTps, setDel, spacer, bNew, bQuit);

        }

        @Override
        public void reagir() {

        }
    }


