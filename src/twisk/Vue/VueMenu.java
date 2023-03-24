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

        private MenuItem setNomItem;
        private Button setNom;
        private MenuItem supprimer;

    public VueMenu (MondeIG monde) {
            super();
            this.monde = monde;
            this.monde.ajouterObservateur(this);
            this.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");

            //creation des menubar, menus et items
            MenuBar menuBar = new MenuBar();
            menuBar.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");
            Menu menu = new Menu("Menu");
            menu.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");

            Menu menuEd = new Menu("Edition");
            Menu menuAct = new Menu("Activités");
            Menu menuGuichet = new Menu("guichets");
            Menu menuArc = new Menu("Arcs");
            Menu menuFich = new Menu("Fichier");

            MenuItem nouveau = new MenuItem("Nouveau");
            nouveau.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            nouveau.setOnAction(new EcouteurNouveau(monde));

            MenuItem quitter = new MenuItem("Quitter");
            quitter.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
            quitter.setOnAction(event -> Platform.exit());

            supprimer = new MenuItem("Supprimer");
            setNomItem = new MenuItem("Renomer la sélection");

            supprimer.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
            supprimer.setOnAction(new EcouteurSupprimerEtape(monde));

            //creation des boutons
            setNom = new Button();
            Button setTps = new Button();
            Button setDel = new Button();
            Button bQuit = new Button();
            Button bNew = new Button();
            Pane spacer = new Pane();

            //espaceur pour mise en place des boutons
            spacer.setMinSize(606, 1);
            spacer.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;-fx-alignment: center");

            //bouton pour setNom
            setNom.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image = new Image(getClass().getResourceAsStream("/setNom.png"), 35, 35, true, true);
            ImageView icon = new ImageView(image);
            setNom.setGraphic(icon);
            setNom.setAlignment(Pos.CENTER_RIGHT);
            setNom.setOnAction(new EcouteurSetNom(monde));

            addTool("Modifier le nom de l'activité", setNom);

            //bouton pour setTemps
            setTps.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image1 = new Image(getClass().getResourceAsStream("/setTps.png"), 35, 35, true, true);
            ImageView icon1 = new ImageView(image1);
            setTps.setGraphic(icon1);
            setTps.setAlignment(Pos.CENTER_RIGHT);
            setTps.setOnAction(new EcouteurBouton(monde));

            addTool("Modifier le durée de l'activité", setTps);


            //bouton pour setDel
            setDel.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image2 = new Image(getClass().getResourceAsStream("/setDel.png"), 35, 35, true, true);
            ImageView icon2 = new ImageView(image2);
            setDel.setGraphic(icon2);
            setDel.setAlignment(Pos.CENTER_RIGHT);
            setDel.setOnAction(new EcouteurBouton(monde));

            addTool("Modifier le delais de l'activité", setDel);

            //bouton pour quitter
            bQuit.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image3 = new Image(getClass().getResourceAsStream("/quitMonde.png"), 35, 35, true, true);
            ImageView icon3 = new ImageView(image3);
            bQuit.setGraphic(icon3);
            bQuit.setAlignment(Pos.CENTER_RIGHT);
            bQuit.setOnAction(e-> Platform.exit());
            addTool("Quitter le créateur de Monde", bQuit);


            //bouton pour remettre à zéro
            bNew.setStyle("-fx-border-color: slategrey; -fx-border-width: 2px;");
            Image image4 = new Image(getClass().getResourceAsStream("/newMonde.png"), 35, 35, true, true);
            ImageView icon4 = new ImageView(image4);
            bNew.setGraphic(icon4);
            bNew.setAlignment(Pos.CENTER_RIGHT);
            bNew.setOnAction(new EcouteurNouveau(monde));

            //ajout des items au menu
            menuFich.getItems().addAll(nouveau, quitter);
            System.out.println(monde.nbEtapeSelec());
            menuAct.getItems().addAll(supprimer, setNomItem);
            menuGuichet.getItems().addAll();

            addTool("Destruction du Monde", bNew);


            //ajouter menu dans menuBar ajoutée à HBox
            menu.getItems().addAll(menuFich, menuEd);
            menuEd.getItems().addAll(menuAct, menuGuichet, menuArc);
            menuBar.getMenus().addAll(menu);
            this.getChildren().addAll(menuBar, setNom, setTps, setDel, spacer, bNew, bQuit);
            setNomItem.setDisable(monde.nbEtapeSelec() != 1);
            supprimer.setDisable(monde.nbEtapeSelec() != 1);
            setNom.setDisable(true);
        }

        @Override
        public void reagir() {
            setNomItem.setDisable(monde.nbEtapeSelec() != 1);
            supprimer.setDisable(monde.nbEtapeSelec() != 1);
                if (monde.getEtapesClicked().size() !=1) {
                        setNom.setDisable(true);

                } else {
                        setNom.setDisable(false);
                }
            }

        public void addTool(String nom, Button bouton){
            Tooltip tool1 = new Tooltip(nom);
            tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool1.setTextAlignment(TextAlignment.CENTER);
            bouton.setTooltip(tool1);
        }


    }


