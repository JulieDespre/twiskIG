package twisk.mondeGraphique.vues;

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
import twisk.mondeGraphique.Observateur;
import twisk.mondeGraphique.ecouteurs.*;
import twisk.mondeIG.MondeIG;

public class VueMenu extends HBox implements Observateur {
        private final MondeIG monde;

        private MenuItem setNomItem;
        private MenuItem supprimer;
        private MenuItem suppSelect;
        private MenuItem mondeEntree;
        private MenuItem annulerEntree;
        private MenuItem supprimerArc;
        private MenuItem mondeSortie;
        private MenuItem annulerSortie;
        private Button setNom;
        private Button setTps;
        private Button setDel;


    public VueMenu (MondeIG monde) {
            super();
            this.monde = monde;
            this.monde.ajouterObservateur(this);
            this.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");

            //creation des menubar, menus et items
            MenuBar menuBar = new MenuBar();
            menuBar.setStyle("-fx-border-color: slategrey; -fx-border-width: 1.5px;");
            Menu menu = new Menu("Menu Monde");
            menu.setStyle("-fx-font: 20 helvetica; -fx-font-color: grey ; -fx-background: lightgrey");

            Menu menuEd = new Menu("Edition");
            Menu menuAct = new Menu("Activités");
            //Menu menuGuichet = new Menu("guichets");
            Menu menuArc = new Menu("Arcs");
            Menu menuFich = new Menu("Fichier");
            Menu menuMonde = new Menu("Monde");


            MenuItem nouveau = new MenuItem("Nouveau");
            nouveau.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            nouveau.setOnAction(new EcouteurNouveau(monde));

            MenuItem quitter = new MenuItem("Quitter");
            quitter.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
            quitter.setOnAction(event -> Platform.exit());

            supprimer = new MenuItem("Supprimer");
            supprimer.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
            supprimer.setOnAction(new EcouteurSupprimerEtape(monde));

            suppSelect = new MenuItem("Désélectionner");
            suppSelect.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
            suppSelect.setOnAction(new EcouteurDeselectionner(monde));

            supprimerArc = new MenuItem("Supprimer");
            supprimerArc.setOnAction(new EcouteurSupprimerArc(monde));

            setNomItem = new MenuItem("Renomer la sélection");
            setNomItem.setOnAction(new EcouteurSetNom(monde));

            Menu entree = new Menu("Entrée");
            mondeEntree = new MenuItem("est une entrée");
            mondeEntree.setOnAction(new EcouteurEntree(monde));
            annulerEntree = new MenuItem("n'est plus une entrée");
            //annulerEntree.setOnAction(new EcouteurAnnulerEntree(monde));
            entree.getItems().addAll(mondeEntree, annulerEntree);

            Menu sortie = new Menu("Sortie");
            mondeSortie = new Menu("est une sortie");
            setNomItem.setOnAction(new EcouteurSetNom(monde));
            annulerSortie = new MenuItem("n'est plus une sortie");
            //annulerEntree.setOnAction(new EcouteurAnnulerEntree(monde));
            sortie.getItems().addAll(mondeSortie, annulerSortie);

            //creation des boutons
            setNom = new Button();
            setTps = new Button();
            setDel = new Button();
            Button bQuit = new Button();
            Button bNew = new Button();
            Pane spacer = new Pane();

            //espaceur pour mise en place des boutons
            spacer.setMinSize(532, 1);
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
            //menuGuichet.getItems().addAll();
            addTool("Destruction du Monde", bNew);


            //ajouter menu dans menuBar ajoutée à HBox
            menu.getItems().addAll(menuFich, menuEd, menuMonde);
            menuEd.getItems().addAll(menuAct, menuArc, suppSelect);
            menuArc.getItems().add(supprimerArc);
            menuMonde.getItems().addAll(entree, sortie);
            menuBar.getMenus().addAll(menu);
            this.getChildren().addAll(menuBar, setNom, setTps, setDel, spacer, bNew, bQuit);
            reagir();
        }

        @Override
        public void reagir() {
                setNomItem.setDisable(monde.nbEtapeSelec() != 1);
                supprimer.setDisable(monde.nbEtapeSelec() != 1);
                mondeEntree.setDisable(monde.nbEtapeSelec() != 1);

                //disable suppression arc
                boolean disable = true;
                for (int i = 0; i < monde.getLignes().size(); i++) {
                        if (monde.getLignes().get(i).getSelect()) {
                                disable = false;
                        }
                }
                supprimerArc.setDisable(disable);

                //disable  nom, suppression, entree
                if (monde.getEtapesClicked().size() != 1) {
                        setNom.setDisable(true);
                        supprimer.setDisable(true);
                        mondeEntree.setDisable(true);

                } else {
                        setNom.setDisable(false);
                        supprimer.setDisable(false);
                        mondeEntree.setDisable(false);
                }

                boolean disable2 = true;
                for (int i = 0; i < monde.getLignes().size(); i++) {
                        if (monde.getEtapesClicked().size() != 1) {
                                disable2 = false;
                        } else if (monde.getLignes().get(i).getSelect()) {
                                disable2 = false;
                        }
                }
                suppSelect.setDisable(disable2);

        }

        public void addTool(String nom, Button bouton){
            Tooltip tool1 = new Tooltip(nom);
            tool1.setFont(Font.font("Verdana", FontPosture.REGULAR, 13));
            tool1.setTextAlignment(TextAlignment.CENTER);
            bouton.setTooltip(tool1);
        }


    }


